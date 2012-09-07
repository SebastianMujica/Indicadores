package SwingBernate.ayudantes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Method;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import SwingBernate.ControladorBase;
import SwingBernate.DtoBase;
import SwingBernate.Sesion;
import SwingBernate.dtoVacio;

public class ComboBox extends JComboBox implements ActionListener,MouseListener,KeyListener{

	DtoBase tipo;
	JPopupMenu menuContextual = new JPopupMenu();
	JMenuItem acercar = new JMenuItem("Acercar");
	DefaultComboBoxModel modelCombo = new DefaultComboBoxModel();
	String strBuscar = new String("");

	public ComboBox(DtoBase t){
		this.setTipo(t);
		this.getAcercar().addActionListener(this);
		this.menuContextual.add(this.getAcercar());
		this.add(this.getMenuContextual());
		this.addMouseListener(this);
		this.addKeyListener(this);
	}
	public void setModelo(DefaultComboBoxModel modelo){
		this.setModel(modelo);
		
		modelo.insertElementAt(new dtoVacio(), 0);
		this.setSelectedIndex(0);
		
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
	public JMenuItem getAcercar() {
		return acercar;
	}
	public void setAcercar(JMenuItem acercar) {
		this.acercar = acercar;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent arg0) {
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
	public void mouseReleased(MouseEvent evt) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub		
		if (arg0.getActionCommand().equals("Acercar"))
		{
			try {

				String paquete = this.tipo.getClass().getCanonicalName();
				int p = paquete.lastIndexOf(".");
				String nombClase = paquete.substring(p+1, paquete.length());
				paquete = paquete.substring(0, p);
				paquete = paquete.concat(".controlador").concat(nombClase);		
				Class _clase = Class.forName(paquete);		
				if(_clase!=null){
					JInternalFrame vista=(JInternalFrame)this.getParent().getParent().getParent().getParent().getParent().getParent();	
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
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent evt) {
		// TODO Auto-generated method stub
		this.modelCombo = (DefaultComboBoxModel) this.getModel();
		int pos = 0;
		int tecla = evt.getKeyCode();
		int tam = this.modelCombo.getSize();
		
		
		if ( (tecla < 37 || tecla >40) && (tecla >= 65 && tecla<=90 ) && (tam >0) ){
			for (int i = 1; i < tam ; i++) {
				DtoBase dto = (DtoBase)this.modelCombo.getElementAt(i);
				String datos[] = dto.toString().split(" ");
				if( datos[1].toString().startsWith(evt.getKeyText(tecla)) ){
					pos = i;
					i = this.modelCombo.getSize();
				}
			}
			this.setSelectedIndex(pos);	
		}
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
