package SwingBernate.ayudantes;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import SwingBernate.VistaBase;
import java.math.*;


public class Escritorio extends JDesktopPane implements MouseListener,ActionListener{
	JPopupMenu menuContextual = new JPopupMenu();
    JMenuItem minimizarTodo = new JMenuItem("Minimizar todo");
    JMenuItem cerrarTodo = new JMenuItem("Cerrar todo");
    JMenuItem mosaico = new JMenuItem("Mosaico");
	public Escritorio() {
		// TODO Auto-generated constructor stub
	
		super();
		this.addMouseListener(this);
		minimizarTodo.addActionListener(this);
		cerrarTodo.addActionListener(this);
		mosaico.addActionListener(this);

		this.menuContextual.add(this.minimizarTodo);
		this.menuContextual.add(this.cerrarTodo);
		this.menuContextual.add(this.mosaico);
	}
	public void minimizarTodo(){
		Component ventanas[]=this.getComponents();
		VistaBase vista=new VistaBase();
		for (Component component : ventanas) {
			
			
			if (component.getClass().getGenericSuperclass().equals(vista.getClass())){
				JInternalFrame ventana=(JInternalFrame)component;
				
				try {
					ventana.setIcon(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			}
		}
	}
	public void cerrarTodo(){
		Component ventanas[]=this.getComponents();
		VistaBase vista=new VistaBase();
		for (Component component : ventanas) {
			
			
			if (component.getClass().getGenericSuperclass().equals(vista.getClass())){
				JInternalFrame ventana=(JInternalFrame)component;
				//ventana.setIconifiable(true);
				ventana.dispose();
				
			}
		}
	}
	public void mosaico(){
		Component ventanas[]=this.getComponents();
		VistaBase vista=new VistaBase();
		System.out.println("hola");
		System.out.println(this.getSize().toString());
		long lado1=Math.round(this.getSize().height/ventanas.length);
		long lado2=Math.round(this.getSize().width/ventanas.length);
		
		for (Component component : ventanas) {
			if (component.getClass().getGenericSuperclass().equals(vista.getClass())){
	
				
				
				JInternalFrame ventana=(JInternalFrame)component;
				ventana.setSize((int)lado2, (int)lado1);
				
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="Minimizar todo"){
			this.minimizarTodo();
		}
		if (e.getActionCommand()=="Cerrar todo"){
			this.cerrarTodo();
		}if (e.getActionCommand()=="Mosaico"){
			this.mosaico();
		}
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.isPopupTrigger()) {
			this.menuContextual.show(e.getComponent(), e.getX(), e.getY());
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
