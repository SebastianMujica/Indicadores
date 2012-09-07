package SwingBernate;

import groovy.ui.ConsoleTextEditor;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.OverlayLayout;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import net.miginfocom.swing.MigLayout;

import org.hibernate.collection.PersistentBag;

import SwingBernate.ayudantes.ComboBox;
import SwingBernate.ayudantes.ComponenteUbicacion;
import SwingBernate.ayudantes.Imprimir;
import SwingBernate.ayudantes.ListaDoble;
import SwingBernate.ayudantes.SimpleGrid;
import SwingBernate.ayudantes.SimpleGridModel;
import Usuario.Usuario;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.bind.v2.TODO;
import com.toedter.calendar.JDateChooser;

public class VistaBase extends JInternalFrame {
	
	// Action Listener
    static int openFrameCount = 0;
    static final int xOffset = 10, yOffset = 10;
    // Paneles del Menu y Toolbar
    public JMenuBar menuBar= new JMenuBar();
    public JToolBar toolBar= new JToolBar();
    // Paneles
    JPanel arriba = new JPanel();
    MigLayout form=new MigLayout();
    JPanel centro = new JPanel(form);
    JPanel centrov = new JPanel();
    JPanel abajo  = new JPanel();
    JScrollPane scrol=new JScrollPane(); 
    JTabbedPane tabbedPane = new JTabbedPane();
   // ImageIcon icon = createImageIcon("images/middle.gif");

    

    // Menu
    JMenu  menu = new JMenu("Acciones");
    public JMenuItem getMenuItemNuevo() {
		return menuItemNuevo;
	}	
    public void setMenuItemNuevo(JMenuItem menuItemNuevo) {
		this.menuItemNuevo = menuItemNuevo;
	}

	// Formulario
	//Formulario form=new Formulario(centro);
    
	// Simple Grid
	SimpleGridModel modelo=new SimpleGridModel();
	SimpleGrid simpleGrid=new SimpleGrid(modelo);
	JScrollPane jscrgrid=new JScrollPane(simpleGrid);
	JPanel centro2 = new JPanel();
	
	// Tamaño 
    int ancho=500;
    int alto=400;
    

	// Items del menu
    JMenuItem menuItemNuevo  = new JMenuItem("nuevo");
    JMenuItem menuItemGuardar  = new JMenuItem("grabar");
    JMenuItem menuItemEliminar = new JMenuItem("eliminar");
    JMenuItem menuItemBuscar   = new JMenuItem("buscar");
    JMenuItem menuItemSalir   = new JMenuItem("Salir");
    // Botones de la barra
    JButton   buttonNuevo       = new JButton("");
	JButton   buttonGuardar     = new JButton("");
    JButton   buttonEliminar    = new JButton("");
    JButton   buttonBuscar      = new JButton("");
    JButton   buttonVistaR      = new JButton("");
   // JButton   buttonImprimir      = new JButton("imprimir");
    JButton   buttonRefrescar      = new JButton("refrescar");
    JButton   buttonAnterior    = new JButton("anterior");
    JButton   buttonSiguiente   = new JButton("siguiente");
    JButton   buttonPrimero    = new JButton("primero");
    JButton   buttonUltimo   = new JButton("utlimo");
    Imprimir  imprimir= new Imprimir();
    //
    JButton   buttonHecho = new JButton("ok");
    JButton   buttonCancelar = new JButton("cancelar");
    
    //
    JPopupMenu menuContextual = new JPopupMenu();
    JMenuItem acercar = new JMenuItem("Acercar");
    
    //
    InternalFrameMonitor iflm=new InternalFrameMonitor();
  
    public VistaBase(){
        super("Sin Nombre",
          	  true, //resizable
                true, //closable
                true, //maximizable
                true);//iconifiable
          //setSize(this.ancho,this.alto);
          //setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
          this.menuBar.add(this.menu);
          this.menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));

          this.menuItemNuevo.setMnemonic(KeyEvent.VK_N);
          this.menuItemNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
          this.menuItemBuscar.setMnemonic(KeyEvent.VK_B);
          this.menuItemBuscar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
          this.menuItemEliminar.setMnemonic(KeyEvent.VK_E);
          this.menuItemEliminar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
          this.menuItemGuardar.setMnemonic(KeyEvent.VK_G);
          this.menuItemGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.ALT_MASK));
          this.menuItemSalir.setMnemonic(KeyEvent.VK_S);
          this.menuItemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
          
          // Agregamos los iconos
          
          this.toolBar.setBorder(new EtchedBorder());
          
          this.buttonBuscar.setIcon(new ImageIcon(getClass().getResource("/media/iconos/find.png")));
          this.buttonGuardar.setIcon(new ImageIcon(getClass().getResource("/media/iconos/document-save.png")));
          this.buttonNuevo.setIcon(new ImageIcon(getClass().getResource("/media/iconos/document-new.png")));
          this.buttonVistaR.setIcon(new ImageIcon(getClass().getResource("/media/iconos/document-properties.png")));
          this.buttonEliminar.setIcon(new ImageIcon(getClass().getResource("/media/iconos/gtk-no.png")));
          //this.buttonImprimir.setIcon(new ImageIcon(getClass().getResource("/media/iconos/fileprint.png")));
          this.buttonRefrescar.setIcon(new ImageIcon(getClass().getResource("/media/iconos/gtk-refresh.png")));
          this.buttonAnterior.setIcon(new ImageIcon(getClass().getResource("/media/iconos/back.png")));
          this.buttonSiguiente.setIcon(new ImageIcon(getClass().getResource("/media/iconos/forward.png")));
          this.buttonPrimero.setIcon(new ImageIcon(getClass().getResource("/media/iconos/gtk-goto-first-ltr.png")));
          this.buttonUltimo.setIcon(new ImageIcon(getClass().getResource("/media/iconos/gtk-goto-last-ltr.png")));
          
          //this.buttonImprimir.setText("");
          //this.buttonImprimir.setActionCommand("imprimir");
          this.buttonRefrescar.setText("");
          this.buttonRefrescar.setActionCommand("refrescar");
          this.buttonAnterior.setText("");
          this.buttonAnterior.setActionCommand("anterior");          
          this.buttonSiguiente.setText("");
          this.buttonSiguiente.setActionCommand("siguiente");
          this.buttonPrimero.setText("");
          this.buttonPrimero.setActionCommand("primero");
          this.buttonUltimo.setText("");
          this.buttonUltimo.setActionCommand("ultimo");
          
          this.buttonVistaR.setActionCommand("cambiarVista");

          
          this.buttonNuevo.setActionCommand("nuevo");
          this.buttonNuevo.setToolTipText("Crear un Nuevo Registro");
          this.buttonGuardar.setActionCommand("grabar");
          this.buttonGuardar.setToolTipText("Grabar el Registro Actual");
          this.buttonEliminar.setActionCommand("eliminar");
          this.buttonEliminar.setToolTipText("Eliminar el Registro Actual");
          this.buttonBuscar.setActionCommand("buscar");
          this.buttonBuscar.setToolTipText("Buscar un Registro");
          this.buttonVistaR.setToolTipText("Cambia la Vista");
          
          
      	  JButton   buttonGuardar     = new JButton("grabar");
          JButton   buttonEliminar    = new JButton("eliminar");
          JButton   buttonBuscar      = new JButton("buscar");
          
          
          
          
          
          
          
          
          this.menuItemNuevo.setIcon(new ImageIcon(getClass().getResource("/media/iconos/document-new.png")));
          this.menuItemGuardar.setIcon(new ImageIcon(getClass().getResource("/media/iconos/document-save.png")));
          this.menuItemEliminar.setIcon(new ImageIcon(getClass().getResource("/media/iconos/gtk-no.png")));
          this.menuItemBuscar.setIcon(new ImageIcon(getClass().getResource("/media/iconos/find.png")));
          this.menuItemSalir.setIcon(new ImageIcon(getClass().getResource("/media/iconos/window-close.png")));

          this.menu.add(this.menuItemNuevo);
          this.menu.add(this.menuItemGuardar);
          this.menu.add(this.menuItemEliminar);
          this.menu.add(this.menuItemBuscar);
          this.menu.add(this.menuItemSalir);
         
          this.toolBar.add(this.buttonNuevo);
          this.toolBar.add(this.buttonGuardar);
          this.toolBar.add(this.buttonEliminar);
          this.toolBar.add(this.buttonBuscar);
          this.toolBar.add(this.buttonVistaR);
          this.toolBar.add(this.imprimir);
          this.toolBar.add(this.buttonRefrescar);
          this.toolBar.add(this.buttonPrimero);
          this.toolBar.add(this.buttonAnterior);
          this.toolBar.add(this.buttonSiguiente);
          this.toolBar.add(this.buttonUltimo);        
          
          
          /*this.abajo.setLayout(new BoxLayout(this.abajo, BoxLayout.LINE_AXIS));
          this.abajo.add(Box.createHorizontalGlue()); // botones alineados a la derecha
          this.abajo.add(this.buttonHecho);
          this.abajo.add(this.buttonCancelar);
          this.abajo.add(Box.createRigidArea(new Dimension(10, 0))); // separación entre botones
          this.abajo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
          */
          this.arriba.add(this.toolBar,BorderLayout.NORTH);
          this.arriba.setBorder(BorderFactory.createEtchedBorder());
          this.addInternalFrameListener(this.iflm);
          
          
          //Menú Acercar
          this.menuContextual.add(this.acercar);
          //this.centro.setVisible(false);
          //this.centro2.setSize(width, height)
          this.simpleGrid.setFillsViewportHeight(true);
          this.simpleGrid.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
          
          this.centro2.setLayout(new BorderLayout());
          this.centro2.add(jscrgrid,BorderLayout.CENTER);
          
          this.centrov.setLayout(new OverlayLayout(this.centrov));
          

          
          this.getContentPane().add(this.centrov,BorderLayout.CENTER);

          this.centro.setVisible(false);
          this.centro2.setVisible(false);
          this.centrov.add(centro2);
          this.centrov.add(centro);

          //this.getContentPane().add(this.tabbedPane,BorderLayout.CENTER);
          this.getContentPane().add(this.abajo, BorderLayout.SOUTH);
          this.getContentPane().add(this.arriba, BorderLayout.NORTH);
          this.setJMenuBar(this.menuBar);
          this.pack();
          
          SwingUtilities.updateComponentTreeUI(this);
          this.revalidate();
    }
    public static int getOpenFrameCount() {
		return openFrameCount;
	}

	public static void setOpenFrameCount(int openFrameCount) {
		VistaBase.openFrameCount = openFrameCount;
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JToolBar getToolBar() {
		return toolBar;
	}

	public void setToolBar(JToolBar toolBar) {
		this.toolBar = toolBar;
	}

	public JPanel getArriba() {
		return arriba;
	}

	public void setArriba(JPanel arriba) {
		this.arriba = arriba;
	}

	public JPanel getCentro() {
		return centro;
	}

	public void setCentro(JPanel centro) {
		this.centro = centro;
	}

	public JPanel getAbajo() {
		return abajo;
	}

	public void setAbajo(JPanel abajo) {
		this.abajo = abajo;
	}

	public JMenu getMenu() {
		return menu;
	}

	public void setMenu(JMenu menu) {
		this.menu = menu;
	}

	public MigLayout getForm() {
		return form;
	}

	public void setForm(MigLayout form) {
		this.form = form;
	}

	
	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}
	

	public JButton getButtonAnterior() {
		return buttonAnterior;
	}
	public void setButtonAnterior(JButton buttonAnterior) {
		this.buttonAnterior = buttonAnterior;
	}
	public JButton getButtonSiguiente() {
		return buttonSiguiente;
	}
	public void setButtonSiguiente(JButton buttonSiguiente) {
		this.buttonSiguiente = buttonSiguiente;
	}

	public JMenuItem getMenuItemGuardar() {
		return menuItemGuardar;
	}

	public void setMenuItemGuardar(JMenuItem menuItemGuardar) {
		this.menuItemGuardar = menuItemGuardar;
	}

	public JMenuItem getMenuItemEliminar() {
		return menuItemEliminar;
	}

	public void setMenuItemEliminar(JMenuItem menuItemEliminar) {
		this.menuItemEliminar = menuItemEliminar;
	}

	public JMenuItem getMenuItemBuscar() {
		return menuItemBuscar;
	}

	public void setMenuItemBuscar(JMenuItem menuItemBuscar) {
		this.menuItemBuscar = menuItemBuscar;
	}

	public JMenuItem getMenuItemSalir() {
		return menuItemSalir;
	}
    public JButton getButtonCancelar() {
		return buttonCancelar;
	}
	public void setButtonCancelar(JButton buttonCancelar) {
		this.buttonCancelar = buttonCancelar;
	}
	public void setMenuItemSalir(JMenuItem menuItemSalir) {
		this.menuItemSalir = menuItemSalir;
	}

	public JButton getButtonNuevo() {
		return buttonNuevo;
	}

	public void setButtonNuevo(JButton buttonNuevo) {
		this.buttonNuevo = buttonNuevo;
	}

	public JButton getButtonGuardar() {
		return buttonGuardar;
	}

	public void setButtonGuardar(JButton buttonGuardar) {
		this.buttonGuardar = buttonGuardar;
	}

	public JButton getButtonEliminar() {
		return buttonEliminar;
	}

	public void setButtonEliminar(JButton buttonEliminar) {
		this.buttonEliminar = buttonEliminar;
	}

	public JButton getButtonBuscar() {
		return buttonBuscar;
	}

	public void setButtonBuscar(JButton buttonBuscar) {
		this.buttonBuscar = buttonBuscar;
	}

	public JButton getButtonRefrescar() {
		return buttonRefrescar;
	}

	public void setButtonRefrescar(JButton buttonRefrescar) {
		this.buttonRefrescar = buttonRefrescar;
	}
	
	public JButton getButtonPrimero() {
		return buttonPrimero;
	}
	
	public void setButtonPrimero(JButton buttonPrimero) {
		this.buttonPrimero = buttonPrimero;
	}
	
	public JButton getButtonUltimo() {
		return buttonUltimo;
	}
	
	public void setButtonUltimo(JButton buttonUltimo) {
		this.buttonUltimo = buttonUltimo;
	}
	
	public Imprimir getImprimir() {
		return imprimir;
	}
	public void setButtonImprimir(Imprimir buttonImprimir) {
		this.imprimir = buttonImprimir;
	}
	public JButton getButtonHecho() {
		return buttonHecho;
	}

	public void setButtonHecho(JButton buttonHecho) {
		this.buttonHecho = buttonHecho;
	}

	public JPopupMenu getMenuContextual() {
		return menuContextual;
	}

	public void setMenuContextual(JPopupMenu menuContextual) {
		this.menuContextual = menuContextual;
	}
	
	public InternalFrameMonitor getIflm() {
		return iflm;
	}

	public void setIflm(InternalFrameMonitor iflm) {
		this.iflm = iflm;
	}

	public static int getXoffset() {
		return xOffset;
	}

	public static int getYoffset() {
		return yOffset;
	}

	public void setFoco(Component componente){
		componente.requestFocus();
		
	}
	public void agregar(JLabel label,JComponent component){
		//this.form.addField(label,component);
		this.centro.add(label,"");
		this.centro.add(component,"wrap");
		}
	public void agregar(JComponent component){
		//this.form.addField(label,component);
	
		this.centro.add(component," ");
		}
	public void agregar(JComponent component,String a){
		//this.form.addField(label,component);
	
		this.centro.add(component,a);
		}
	public void agregar(JLabel label,JComponent component,String labelOp,String compoOps){
	//this.form.addField(label,component);
	this.centro.add(label,labelOp);
	this.centro.add(component,compoOps);
	}
	public void remover(){
	
	}
	
	public int confirmar(String tipo){
		if (tipo.equals("confirmar")){
		return 	JOptionPane.showConfirmDialog(this,"¿Esta Seguro?","Confirmar Accion",JOptionPane.YES_NO_OPTION);
		}
		if (tipo.equals("informacion")){
			JOptionPane.showMessageDialog(this,"¿Esta Seguro?","Confirmar Accion",JOptionPane.YES_NO_OPTION);
		return 1;	
		}
		return JOptionPane.showConfirmDialog(this,"Mensaje no Valido");
	}
	public int confirmar(String tipo,String mensaje){
		if (tipo.equals("informacion")){
			JOptionPane.showMessageDialog(this,mensaje);
		return 1;	
		}
		return JOptionPane.showConfirmDialog(this,"Mensaje no Valido");
	}
	
	public int mensageDialogo(String tipo,String mensaje,String titulo){
		int i = 9999;
		
		if (tipo.equals("informacion")){
			JOptionPane.showMessageDialog(this,mensaje,titulo,JOptionPane.INFORMATION_MESSAGE);
			i =  1;
		}else if (tipo.equals("confirmar")){
			i =	JOptionPane.showConfirmDialog(this,mensaje,titulo,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		}else if (tipo.equals("error")){
			JOptionPane.showMessageDialog(this,mensaje,titulo,JOptionPane.ERROR_MESSAGE);
			i =  1;
		}else if (tipo.equals("advertencia")){
			JOptionPane.showMessageDialog(this,mensaje,titulo,JOptionPane.WARNING_MESSAGE);
			i =  1;
		}
		
		return i;
	}
	
	public void setDto(DtoBase dto){
				
		String campoDto = "";
		String campoVta = "";
		String valString = null;
		Long valLong = new Long(-9999);
		float valFloat = -9999;
		short valShort = -1;
		DtoBase dtoCombo;
		Object valor;
		Object lst[];
		List<DtoBase> Ldto=null;
		Field camposVista[] = this.getClass().getDeclaredFields();
		Field camposDto[] = dto.getClass().getDeclaredFields();		
		
		for (int i = 0; i < camposDto.length; i++) {
			
			for (int j = 0; j < camposVista.length; j++) {
						
				if( (!camposVista[j].getName().contains("lbl") && camposVista[j].getName().contains(camposDto[i].getName()))
						|| camposVista[j].getType().getCanonicalName().equals("SwingBernate.ayudantes.ComponenteUbicacion") ){
					
					campoDto = camposDto[i].getName();
					campoVta = camposVista[j].getName();
					
					String canonical = camposVista[j].getType().getCanonicalName();					
					
					if("javax.swing.JTextField"==canonical || "javax.swing.JPasswordField"==canonical ){
					//if( (campoDto.substring(0,3).compareTo("str")==0) || (campoDto.substring(0,3).compareTo("lng")==0)){
						
						try {
							Method getter = dto.getClass().getMethod("get"+String.valueOf(campoDto.charAt(0)).toUpperCase()+campoDto.substring(1));
							if(campoDto.substring(0,3).compareTo("str")==0){
								valString = (String)getter.invoke(dto, new Object[0]);
								valLong = Long.parseLong("-9999");
								valFloat = -9999;
								valShort=-1;
							}else if(campoDto.substring(0,3).compareTo("lng")==0){
								valLong = (Long)getter.invoke(dto, new Object[0]);
								valString = null;
								valFloat = -9999;
								valShort=-1;
							}else if(campoDto.substring(0,3).compareTo("flo")==0){
								valFloat = (Float)getter.invoke(dto, new Object[0]);
								valString = null;
								valLong = Long.parseLong("-9999");
								valShort=-1;
							}else if(campoDto.substring(0,3).compareTo("int")==0){
								valShort = (Short)getter.invoke(dto, new Object[0]);
								valString = null;
								valLong = Long.parseLong("-9999");
								valFloat = -9999;
							}
							
							
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error al invocar el getter: " + e.getMessage());
						}
				
						try {
							Method getterVta = this.getClass().getMethod("getTxt"+campoDto);
							JTextField txtVista = (JTextField)getterVta.invoke(this, new Object[0]);
							if(valString != null)
								txtVista.setText(valString);
							else if(valLong != Long.parseLong("-9999"))
								txtVista.setText(""+valLong);
							else if(valFloat != -9999)
								txtVista.setText(""+valFloat);
							else if(valShort != -1)
								txtVista.setText(""+valShort);
							else if(valString == null && valLong == Long.parseLong("-9999") && valFloat==-9999 && valShort==-1)
								txtVista.setText("");
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error al invocar el getterVta: " + e.getMessage());
						}
					
					}else if("groovy.ui.ConsoleTextEditor"==canonical){
						String codigo="";
						try {
							Method getter = dto.getClass().getMethod("get"+String.valueOf(campoDto.charAt(0)).toUpperCase()+campoDto.substring(1));
							codigo = (String)getter.invoke(dto, new Object[0]);							
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error al invocar el getterCmb: " + e.getMessage());
						}
						
						try {
							Method getterVta = this.getClass().getMethod("get"+String.valueOf(campoVta.charAt(0)).toUpperCase()+campoVta.substring(1));
							ConsoleTextEditor consoleText = (ConsoleTextEditor)getterVta.invoke(this, new Object[0]);
							consoleText.getTextEditor().setText(codigo);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error al invocar el getterVta: " + e.getMessage());
						}
						
					}else if("javax.swing.JTextArea"==canonical){
						String texto="";
						try {
							Method getter = dto.getClass().getMethod("get"+String.valueOf(campoDto.charAt(0)).toUpperCase()+campoDto.substring(1));
							texto = (String)getter.invoke(dto, new Object[0]);							
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error al invocar el getterCmb: " + e.getMessage());
						}
						
						try {
							Method getterVta = this.getClass().getMethod("get"+String.valueOf(campoVta.charAt(0)).toUpperCase()+campoVta.substring(1));
							JTextArea textArea = (JTextArea)getterVta.invoke(this, new Object[0]);
							textArea.setText(texto);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error al invocar el getterVta: " + e.getMessage());
						}
					
					}
					else if("SwingBernate.ayudantes.ComboBox"==canonical){
					//}else if(campoVta.substring(0,3).compareTo("cmb")==0){
						
						dtoCombo = null;
						
						try {
							Method getter = dto.getClass().getMethod("get"+String.valueOf(campoDto.charAt(0)).toUpperCase()+campoDto.substring(1));
							dtoCombo = (DtoBase)getter.invoke(dto, new Object[0]);							
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error al invocar el getterCmb: " + e.getMessage());
						}
						
						try {
							Method getterVta = this.getClass().getMethod("get"+String.valueOf(campoVta.charAt(0)).toUpperCase()+campoVta.substring(1));
							JComboBox cmbVista = (JComboBox)getterVta.invoke(this, new Object[0]);
							if(dtoCombo != null){								
								if(cmbVista.getItemCount()>0)
									cmbVista.setSelectedItem(dtoCombo);
								cmbVista.setVisible(true);
							}else{
								if(cmbVista.getItemCount()>0)
									cmbVista.setSelectedIndex(0);
							}
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error al invocar el getterVta: " + e.getMessage());
						}
						
					}else if("javax.swing.JComboBox"==canonical){
					//}else if(campoVta.substring(0,3).compareTo("cmb")==0){
						
						dtoCombo = null;
						
						try {
							Method getter = dto.getClass().getMethod("get"+String.valueOf(campoDto.charAt(0)).toUpperCase()+campoDto.substring(1));
							dtoCombo = (DtoBase)getter.invoke(dto, new Object[0]);							
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error al invocar el getterCmb: " + e.getMessage());
						}
						
						try {
							Method getterVta = this.getClass().getMethod("get"+String.valueOf(campoVta.charAt(0)).toUpperCase()+campoVta.substring(1));
							ComboBox cmbVista = (ComboBox)getterVta.invoke(this, new Object[0]);
							if(dtoCombo != null){								
								if(cmbVista.getItemCount()>0)
									cmbVista.setSelectedItem(dtoCombo);
								cmbVista.setVisible(true);
							}else{
								if(cmbVista.getItemCount()>0)
									cmbVista.setSelectedIndex(0);
							}
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error al invocar el getterVta: " + e.getMessage());
						}
						
					}else if("javax.swing.JCheckBox"==canonical){
					//}else if(campoVta.substring(0,3).compareTo("chk")==0){
						
						valor = null;
						
						try {
							Method getter = dto.getClass().getMethod("is"+String.valueOf(campoDto.charAt(0)).toUpperCase()+campoDto.substring(1));
							valor = getter.invoke(dto, new Object[0]);							
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error al invocar el getterChk: " + e.getMessage());
						}
						
						try {
							Method getterVta = this.getClass().getMethod("getChk"+campoDto);
							JCheckBox chkVista = (JCheckBox)getterVta.invoke(this, new Object[0]);
							chkVista.setSelected((Boolean)valor);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error al invocar el getterVta: " + e.getMessage());
						}
						
					}else if("com.toedter.calendar.JDateChooser"==canonical){
					//}else if(campoVta.substring(0,3).compareTo("dch")==0){
						
						valor = null;
						
						try {
							Method getter = dto.getClass().getMethod("get"+String.valueOf(campoDto.charAt(0)).toUpperCase()+campoDto.substring(1));
							//fecha = (Date)getter.invoke(dto, new Object[0]);
							valor = (Object)getter.invoke(dto, new Object[0]);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error al invocar el getterChk: " + e.getMessage());
						}
						
						if(valor == null)
							valor = new Date();			
						
						if(valor != null){
							try {
								Method getterVta = this.getClass().getMethod("getDch"+campoDto);
								JDateChooser chkVista = (JDateChooser)getterVta.invoke(this, new Object[0]);
								chkVista.setDate((Date)valor);
							} catch (Exception e) {
								// TODO: handle exception
								System.out.println("Error al invocar el getterVta(getDch" + campoDto + "): " + e.getMessage());
							}
						}
						
					}else if("SwingBernate.ayudantes.ListaDoble"==canonical){
					//}else if(campoVta.substring(0,3).compareTo("lst")==0){
						
						lst = null;
						
						try {
							Method getter = dto.getClass().getMethod("get"+String.valueOf(campoDto.charAt(0)).toUpperCase()+campoDto.substring(1));
							//Ldto = (List<DtoBase>)getter.invoke(dto, new Object[0]);
							PersistentBag bag=(PersistentBag)getter.invoke(dto, new Object[0]);
							if (bag!=null){
								lst = bag.toArray();	
							}else{
								lst=new Object[0];
							}
			
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error al invocar el getterLst: " + e.getMessage());
						}
						
						if(lst != null){
							try {
								Method getterVta = this.getClass().getMethod("getLst"+campoDto);
								ListaDoble listaDoble=(ListaDoble)getterVta.invoke(this, new Object[0]);
								listaDoble.setModelA(lst);
								//System.out.println(valor);
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						}
						
					}else if("SwingBernate.ayudantes.ComponenteUbicacion"==canonical){
						Ldto = null;
						Field field = (Field)camposVista[j];
						String nombreMetodoVista="get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1,field.getName().length());
															
						try{
							Method metodoVista=this.getClass().getMethod(nombreMetodoVista,null);
							ComponenteUbicacion cmpUbic = (ComponenteUbicacion)metodoVista.invoke(this, new Object[0]);
							Field camposUbic[] = cmpUbic.getClass().getDeclaredFields();
							for (Field field2 : camposUbic) {
								if(field2.getName().contains("cmb") && field2.getName().contains(campoDto)
										&& !field2.getName().contains("lbl")){									
									dtoCombo = null;
									
									try {
										Method getter = dto.getClass().getMethod("get"+String.valueOf(campoDto.charAt(0)).toUpperCase()+campoDto.substring(1));
										dtoCombo = (DtoBase)getter.invoke(dto, new Object[0]);
									} catch (Exception e) {
										// TODO: handle exception
										System.out.println("Error al invocar el getterCmb Ubicacion: " + e.getMessage());
									}
									
									try {
										Method getterVta = cmpUbic.getClass().getMethod("get"+String.valueOf(field2.getName().charAt(0)).toUpperCase()+field2.getName().substring(1));
										JComboBox cmbVista = (JComboBox)getterVta.invoke(cmpUbic, new Object[0]);
										if(dtoCombo != null){								
											if(cmbVista.getItemCount()>0)
												cmbVista.setSelectedItem(dtoCombo);
											cmbVista.setVisible(true);
										}else{
											if(cmbVista.getItemCount()>0)
												cmbVista.setSelectedIndex(0);
										}
									} catch (Exception e) {
										// TODO: handle exception
										//System.out.println("Error al invocar el getterVta: " + e.getMessage());
										e.printStackTrace();
									}
									
								}
							}
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				}	
			}
			
		}
		
	}
	
	public Hashtable getDto(DtoBase dtoB){

		System.out.println(this.getClass().getCanonicalName());

		Hashtable hash= new Hashtable(); 
		hash.put("tipo", dtoB.getClass().getCanonicalName());
		try {
			//String nombreClase=this.getClass().getPackage().getName().toString()+"."+this.getClass().getPackage().getName().toString();
			String nombreClase=this.getClass().getCanonicalName();
			Class dto=Class.forName(nombreClase);

			Field camposDto[]=this.getClass().getDeclaredFields();
			Method metodosDto[]=dto.getMethods();
			//System.out.println(camposDto.length);

			for (Method metDto : metodosDto) {
				
				//System.out.println(" DTO ********  "+metDto.getName());
				
				if (metDto.getDeclaringClass().getCanonicalName().toString().equals(nombreClase)&&
						(metDto.getName()!="toString")&&(metDto.getName().startsWith("set") || metDto.getName().startsWith("setDch") )&&
						//(!metDto.getName().startsWith("setDtm"))&& 
						(!metDto.getName().startsWith("lbl")) ){

					//System.out.println(" DTO ******** PASOOOOOOOOOOOOOOO "+metDto.getName());

					for (Field field : camposDto) {

						if (true)/*(((field.getName().startsWith("txt"))&&(field.getName().endsWith(metDto.getName().substring(2).toLowerCase())))||
						    ((field.getName().startsWith("cmb"))&&(field.getName().endsWith(metDto.getName().substring(2).toLowerCase()))))
						 */{

							//System.out.println(" ==========  "+field.getName());
							//Component comp;
							//Class comp=Class.forName(field.getClass().getCanonicalName());

							Object param[]={};
							//Object comp=new Object();

							//metDto.invoke(comp, args)
							String nombreMetodoVista="get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1,field.getName().length());
							//System.out.println("get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1,field.getName().length()));


							Method metodoVista=this.getClass().getMethod(nombreMetodoVista,null);

							Object comp=new Object();

							//System.out.println("Canonical: "+field.getType().getCanonicalName());
							//System.out.println("");
							
							if (field.getType().getCanonicalName()=="javax.swing.JTextField"){
								Method getterVta = this.getClass().getMethod(metodoVista.getName());
								JTextField txtVista = (JTextField)getterVta.invoke(this, new Object[0]);
								//System.out.println("*******************"+txtVista.getText());
								hash.put(field.getName().replace("txt",""), txtVista.getText());
							}
							if (field.getType().getCanonicalName()=="groovy.ui.ConsoleTextEditor"){
								Method getterVta = this.getClass().getMethod(metodoVista.getName());
								ConsoleTextEditor txtVista = (ConsoleTextEditor)getterVta.invoke(this, new Object[0]);
								//System.out.println("*******************"+txtVista.getText());
								hash.put(field.getName().replace("txt",""), txtVista.getTextEditor().getText());
							}
							if (field.getType().getCanonicalName()=="javax.swing.JPasswordField"){
								Method getterVta = this.getClass().getMethod(metodoVista.getName());
								JTextField txtVista = (JPasswordField)getterVta.invoke(this, new Object[0]);
								//System.out.println("*******************"+txtVista.getText());
								hash.put(field.getName().replace("txt",""), txtVista.getText());
							}
							if (field.getType().getCanonicalName()=="javax.swing.JTextArea"){
								Method getterVta = this.getClass().getMethod(metodoVista.getName());
								JTextArea txtVista = (JTextArea)getterVta.invoke(this, new Object[0]);
								//System.out.println("*******************"+txtVista.getText());
								hash.put(field.getName().replace("txt",""), txtVista.getText());
							}
							if (field.getType().getCanonicalName()=="javax.swing.JComboBox"){
								Method getterVta = this.getClass().getMethod(metodoVista.getName());
								JComboBox cmbVista = (JComboBox)getterVta.invoke(this, new Object[0]);
								if(cmbVista.getItemCount()>0){
	//								System.out.println("*******************"+cmbVista.getSelectedItem());
									hash.put(field.getName().replace("cmb",""), cmbVista.getSelectedItem());
								}else{
//									System.out.println("******************* comboVacio");
								}
							}
							if (field.getType().getCanonicalName()=="SwingBernate.ayudantes.ComboBox"){
								Method getterVta = this.getClass().getMethod(metodoVista.getName());
								ComboBox cmbVista = (ComboBox)getterVta.invoke(this, new Object[0]);
								if(cmbVista.getItemCount()>0){
	//								System.out.println("*******************"+cmbVista.getSelectedItem());
									hash.put(field.getName().replace("cmb",""), cmbVista.getSelectedItem());
								}else{
//									System.out.println("******************* comboVacio");
								}
							}
							if (field.getType().getCanonicalName()=="com.toedter.calendar.JDateChooser"){
								Method getterVta = this.getClass().getMethod(metodoVista.getName());
								JDateChooser dchVista = (JDateChooser)getterVta.invoke(this, new Object[0]);
							
								if( dchVista.getDate() != null){
	//								System.out.println("fecha.......... "+dchVista.getDate());
									hash.put(field.getName().replace("dch",""), dchVista.getDate());
								}
							}
							if (field.getType().getCanonicalName()=="SwingBernate.ayudantes.ListaDoble"){
								Method getterVta = this.getClass().getMethod(metodoVista.getName());
								ListaDoble lstVista = (ListaDoble)getterVta.invoke(this, new Object[0]);
//								System.out.println("*******************"+txtVista.getText());
								hash.put(field.getName().replaceFirst("lst",""), lstVista.getSelected());
							}
							if (field.getType().getCanonicalName()=="javax.swing.JCheckBox"){
								nombreMetodoVista.replaceFirst("get", "is");
								metodoVista=this.getClass().getMethod(nombreMetodoVista,null);
								Method getterVta = this.getClass().getMethod(metodoVista.getName());
								JCheckBox chkVista = (JCheckBox)getterVta.invoke(this, new Object[0]);
								//System.out.println("*******************"+chkVista.isSelected());
								hash.put(field.getName().replace("chk",""), chkVista.isSelected());
							}
							if (field.getType().getCanonicalName()=="SwingBernate.ayudantes.ComponenteUbicacion"){
								Method getterVta = this.getClass().getMethod(metodoVista.getName());
								ComponenteUbicacion cmpUbic = (ComponenteUbicacion)getterVta.invoke(this, new Object[0]);
//								System.out.println("*******************"+txtVista.getText());
								Field camposUbic[] = cmpUbic.getClass().getDeclaredFields();								
								for (Field field2 : camposUbic) {
									if(field2.getName().contains("cmb") && field2.getName().contains(metDto.getName())
											&& !field2.getName().contains("lbl")){
											// TODO PEndiente si se va a usar el componete Ubicacion
											// que por ahora esta descartado
										}
									}
							}
						}

					}
				}

			}



		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			System.out.println("Acaaa");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return hash;		
	}
	
	public void limpiar()
	{
		Component[] elementos;
		elementos=this.getCentro().getComponents();
		for (int i = 0; i < elementos.length; i++) {
			Class<?> clazz = elementos[i].getClass();
			if (JTextField.class == clazz){
				JTextField a =(JTextField)elementos[i];
				a.setText("");
		     }else if(JDateChooser.class == clazz){
		    	 JDateChooser a = (JDateChooser)elementos[i];
		    	 a.setDate(new Date());
		     }else if(JComboBox.class == clazz){
		    	 JComboBox a = (JComboBox)elementos[i];
		    	 a.setSelectedIndex(0);		    	 
		     }else if(JTextArea.class == clazz){
		    	 JTextArea a = (JTextArea)elementos[i];
		    	 a.setText("");	
		     }
		}
	}
	
	/**
	 * Setea el Esquema a cargar de la Vista 
	 */
	//public boolean setEsquema
	
	public void marcarError(List<String> lsErrores){
		String campo = "";
		String lblcampo="";
		String listaerror="";
		int idx = 0;
		for (String val : lsErrores) {
			idx = val.lastIndexOf("||");
			campo = val.substring(0, idx);
			try{
				Method getterlbl = this.getClass().getMethod("getLbl"+campo);
				JLabel objlbl = (JLabel)getterlbl.invoke(this, new Object[0]);
				lblcampo = objlbl.getText().toString();
				listaerror = listaerror + lblcampo + val.substring(idx+2,val.length()) + "\n";
				//System.out.println("LISTA DE ERRORES:\n"+listaerror);
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error al invocar el getter: " + e.getMessage());
			}	
			System.out.println(val);
			if(campo.substring(0, 3).compareTo("str")==0){
				try {
					Method getter = this.getClass().getMethod("getTxt"+campo);
					JTextField obj = (JTextField)getter.invoke(this, new Object[0]);
					obj.setBackground(Color.pink);
					obj.setToolTipText(val.substring(idx+2,val.length()));
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al invocar el getter: " + e.getMessage());
				}				
			}else if(campo.substring(0, 3).compareTo("cmb")==0){
				try {
					Method getter = this.getClass().getMethod("getCmb"+campo);
					JComboBox obj = (JComboBox)getter.invoke(this, new Object[0]);
					obj.setBackground(Color.pink);
					obj.setToolTipText(val.substring(idx+2,val.length()));
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al invocar el getter: " + e.getMessage());
				}
			}else if(campo.substring(0, 3).compareTo("flo")==0){
				try {
					Method getter = this.getClass().getMethod("getTxt"+campo);
					JTextField obj = (JTextField)getter.invoke(this, new Object[0]);
					obj.setBackground(Color.pink);
					obj.setToolTipText(val.substring(idx+2,val.length()));
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al invocar el getter: " + e.getMessage());
				}				
			} 
		}
		this.mensageDialogo("error","Ocurrieron los siguientes errores:\n" + listaerror, this.getTitle());
	}
	
	public void limpiarError(){
		
		Field campos[] = this.getClass().getDeclaredFields();
		
		for (int i = 0; i < campos.length; i++) {
			if( campos[i].getName().substring(0, 3).compareTo("txt")==0 ){
				try {
					Method getter = this.getClass().getMethod("getTxt"+campos[i].getName().substring(3));
					if (campos[i].getType().getCanonicalName()=="groovy.ui.ConsoleTextEditor"){
						ConsoleTextEditor obj = (ConsoleTextEditor)getter.invoke(this, new Object[0]);
						if(obj.getBackground().equals(Color.pink)){
							obj.setBackground(Color.white);
							obj.setToolTipText(null);	
						}
					}else if(campos[i].getType().getCanonicalName()=="javax.swing.JTextField"){
						JTextField obj = (JTextField)getter.invoke(this, new Object[0]);
						if(obj.getBackground().equals(Color.pink)){
							obj.setBackground(Color.white);
							obj.setToolTipText(null);	
						}
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("limpiarError --> Error al invocar el getter: " + e.getMessage());
				}
			}else if(campos[i].getName().substring(0, 3).compareTo("cmb")==0){
				try {
					Method getter = this.getClass().getMethod("getCmb"+campos[i].getName().substring(3));
					JComboBox obj = (JComboBox)getter.invoke(this, new Object[0]);
					if(obj.getBackground().equals(Color.pink)){
						obj.setBackground(Color.white);
						obj.setToolTipText(null);	
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("limpiarError --> Error al invocar el getter: " + e.getMessage());
				}
			}else if( campos[i].getName().substring(0, 3).compareTo("flo")==0 ){
				try {
					Method getter = this.getClass().getMethod("getTxt"+campos[i].getName().substring(3));
					JTextField obj = (JTextField)getter.invoke(this, new Object[0]);
					if(obj.getBackground().equals(Color.pink)){
						obj.setBackground(Color.white);
						obj.setToolTipText(null);	
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("limpiarError --> Error al invocar el getter: " + e.getMessage());
				}
			} 
		}		
	}
	public JButton getButtonVistaR() {
		return buttonVistaR;
	}
	public void setButtonVistaR(JButton buttonVistaR) {
		this.buttonVistaR = buttonVistaR;
	}
	public SimpleGridModel getModelo() {
		return modelo;
	}
	public void setModelo(SimpleGridModel modelo) {
		this.modelo = modelo;
	}
	public SimpleGrid getSimpleGrid() {
		return simpleGrid;
	}
	public void setSimpleGrid(SimpleGrid simpleGrid) {
		this.simpleGrid = simpleGrid;
	}
	public JScrollPane getJscrgrid() {
		return jscrgrid;
	}
	public void setJscrgrid(JScrollPane jscrgrid) {
		this.jscrgrid = jscrgrid;
	}
	public JPanel getCentro2() {
		return centro2;
	}
	public void setCentro2(JPanel centro2) {
		this.centro2 = centro2;
	}
	
}
