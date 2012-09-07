package SwingBernate;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class MainDesktopSwingBernate extends JFrame {
   
	JDesktopPane desktop;
	JMenuBar barraPrincipal  =new JMenuBar();
	JMenu    menuAccion      =new JMenu("Acciones");
	JMenu    menuEdicion     =new JMenu("Edicion");
	JMenu    menuHerramientas=new JMenu("Herramientas");
	JMenu    menuAyuda		 =new JMenu("Ayuda");
	// Paneles
    JPanel arriba = new JPanel();
    JPanel centro = new JPanel();
    JPanel abajo  = new JPanel();
public JMenuItem crearItem(String Nombre,String mnemonic,ActionListener al){
	JMenuItem item=new JMenuItem();
	item.setText(Nombre);
	item.setActionCommand(Nombre);
	item.addActionListener(al);
	//item.setToolTipText(Nombre);
//	item.setMnemonic(KeyStroke.getKeyStroke(mnemonic).getKeyCode());
	return item;
}
public void refrescar(){
	this.repaint();
	
}
public JDesktopPane getDesktop() {
	return desktop;
}

public void setDesktop(JDesktopPane desktop) {
	this.desktop = desktop;
}

public JMenuBar getBarraPrincipal() {
	return barraPrincipal;
}
public void setBarraPrincipal(JMenuBar barraPrincipal) {
	this.barraPrincipal = barraPrincipal;
}
public JMenu getMenuAccion() {
	return menuAccion;
}
public void setMenuAccion(JMenu menuAccion) {
	this.menuAccion = menuAccion;
}
public JMenu getMenuEdicion() {
	return menuEdicion;
}
public void setMenuEdicion(JMenu menuEdicion) {
	this.menuEdicion = menuEdicion;
}
public JMenu getMenuHerramientas() {
	return menuHerramientas;
}
public void setMenuHerramientas(JMenu menuHerramientas) {
	this.menuHerramientas = menuHerramientas;
}
public JMenu getMenuAyuda() {
	return menuAyuda;
}
public void setMenuAyuda(JMenu menuAyuda) {
	this.menuAyuda = menuAyuda;
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
public class myInputStream {  
    private static final int _CR = 13;  
    private static final int _LF = 10;  
    private int _last=-1; // The last char we've read  
    private int _ch = -1;   // currently read char  
    private InputStream in;  
    public myInputStream(InputStream i)  
    {  
      in = i;  
    }  
    /** Read a line of data from the underlying inputstream 
     *  @return a line stripped of line terminators 
     */  
    public String readLine() throws IOException  
    {  
       StringBuffer sb = new StringBuffer("");  
       if (_last != -1) sb.append((char) _last);  
       _ch = in.read();  
       while(_ch != _CR && _ch != _LF)  
       {  
          sb.append((char) _ch);  
          _ch = in.read();  
       }  
       // Read the next byte and check if it's a LF  
       _last = in.read();  
       if (_last == _LF) {  
          _last = -1;  
       }  
       return(new String(sb));  
    }  
 }  

}

