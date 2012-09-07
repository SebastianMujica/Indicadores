package SwingBernate.ayudantes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import SwingBernate.ControladorBase;
import SwingBernate.DtoBase;
import SwingBernate.Sesion;

/*
 * Componente que contiene un texto y una lista
 * la cual se va filtrando a medida que se va
 * colocando el valor a buscar
 *  
 */

public class ListaFiltro <T> extends JComponent implements ActionListener, KeyListener, MouseListener{
	
	private JLabel lblBusqueda = new JLabel("Buscar: ");
	private JTextField txtBusqueda =  new JTextField("", 15);
	private DefaultListModel modeloLst = new DefaultListModel();
	private DefaultListModel modeloLstFiltro = new DefaultListModel();
	private JList listaDatos=new JList(modeloLst);
	private List<T> lstAux = new ArrayList<T>();
	
	private DtoBase tipo;
	private JPopupMenu menuContextual = new JPopupMenu();
	private JMenuItem acercar = new JMenuItem("Acercar");
	
	GridBagConstraints c = new GridBagConstraints();
	
	public ListaFiltro(String titulo, DtoBase t){
		//this.listaDatos.setBorder(new TitledBorder("Datos a Mostrar"));
		JScrollPane barraScroll = new javax.swing.JScrollPane(listaDatos);
		
		this.setLayout(new GridBagLayout());
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;		
		this.add(lblBusqueda, c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;		
		this.add(txtBusqueda, c);
		txtBusqueda.addKeyListener(this);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 2;
		c.gridwidth = 2;
		this.add(barraScroll, c);
		
		this.setTipo(t);
		this.acercar.addActionListener(this);
		this.menuContextual.add(this.acercar);
		this.add(this.menuContextual);
		this.addMouseListener(this);
		this.listaDatos.add(this.menuContextual);
		this.listaDatos.addMouseListener(this);
		
		this.setBorder(new TitledBorder(titulo));
	}
	
	public DtoBase getTipo() {
		return tipo;
	}

	public void setTipo(DtoBase tipo) {
		this.tipo = tipo;
	}

	public JPopupMenu getMenuContextual() {
		return menuContextual;
	}

	public void setMenuContextual(JPopupMenu menuContextual) {
		this.menuContextual = menuContextual;
	}

	public void setModelLst(List<T> lista) {		
		for (int i = 0; i < lista.size(); i++) {
			modeloLst.add(i, lista.get(i));
		}
	}
	
	public void setModelFiltro(List<T> lista) {	
		modeloLstFiltro.clear();
		for (int i = 0; i < lista.size(); i++) {
			modeloLstFiltro.add(i, lista.get(i));
		}
		this.listaDatos.setModel(modeloLstFiltro);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Acercar"))
		{
			try {

				String paquete = this.tipo.getClass().getCanonicalName();
				int p = paquete.lastIndexOf(".");
				String nombClase = paquete.substring(p+1, paquete.length());
				paquete = paquete.substring(0, p);
				paquete = paquete.concat(".controlador").concat(nombClase);		
				Class _clase = Class.forName(paquete);		
				if(_clase!=null){
					JInternalFrame vista=(JInternalFrame)this.getParent().getParent().getParent().getParent().getParent();	
					if(vista.getDesktopPane()!=null){					
						ControladorBase ctrlBase = (ControladorBase)_clase.newInstance();
						Method getter = _clase.getMethod("getSession");
						Sesion s = (Sesion)getter.invoke(ctrlBase, new Object[0] );
						vista.getDesktopPane().add(s.getVista());
						s.getVista().setLocation(30,30);
						s.getVista().setVisible(true);
						s.getVista().moveToFront();
					}
				}	
			} catch (Throwable e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(this.txtBusqueda)){

			if(this.txtBusqueda.getText().length()>=3){
				lstAux.clear();
				if(!this.modeloLst.isEmpty()){
					opcionListaCombo opcion = new opcionListaCombo();
					for (int i = 0; i < this.modeloLst.getSize(); i++) {
						opcion = (opcionListaCombo)this.modeloLst.get(i);
						String strBase = opcion.getTexto().toLowerCase();
						String strBuscar =  this.txtBusqueda.getText().toLowerCase();
						if(strBase.indexOf(strBuscar) != -1 ){
							lstAux.add((T)opcion);
						}
					}
				}		
				this.setModelFiltro(lstAux);			
			}else{
				this.listaDatos.setModel(modeloLst);
			}	

		}			
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		/*Validar o Restringir entrada
		 *
		 *char caracter = e.getKeyChar();
		if( ((caracter < '0') || (caracter > '9')) &&				
				(caracter != e.VK_BACK_SPACE) )
		{
			e.consume();
		}
		*/
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		if (evt.isPopupTrigger()) {
			this.getMenuContextual().show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
