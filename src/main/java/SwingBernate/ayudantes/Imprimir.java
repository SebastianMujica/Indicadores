package SwingBernate.ayudantes;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Reporte.Reporte;

public class Imprimir extends JPanel {
	JComboBox template= new JComboBox();
	JButton	  imprimir= new JButton();
	JMenuBar  barra= new JMenuBar();
	JMenu	  seleccion=new JMenu();
	JMenuItem actual=new JMenuItem("Actual");
	JMenuItem lista=new JMenuItem("Lista");
	public Imprimir() {
		
		seleccion.add(actual);
		seleccion.add(lista);
		seleccion.setIcon(new ImageIcon(getClass().getResource("/media/iconos/fileprint.png")));
		seleccion.setBorder(BorderFactory.createRaisedBevelBorder());
		barra.add(seleccion);
		this.add(template);
		this.add(barra);
	}
	public void addActionListener(ActionListener a){
		actual.addActionListener(a);
		lista.addActionListener(a);
	}
	public Reporte getTemplateSelected(){
		return (Reporte)template.getSelectedItem();
	}
	public JButton getImprimir() {
		return imprimir;
	}
	public void setImprimir(JButton imprimir) {
		this.imprimir = imprimir;
	}
	public JMenu getSeleccion() {
		return seleccion;
	}
	public void setSeleccion(JMenu seleccion) {
		this.seleccion = seleccion;
	}
	public JMenuItem getActual() {
		return actual;
	}
	public void setActual(JMenuItem actual) {
		this.actual = actual;
	}
	public JMenuItem getLista() {
		return lista;
	}
	public void setLista(JMenuItem lista) {
		this.lista = lista;
	}
	public void setTemplate(JComboBox template) {
		this.template = template;
	}
	public JComboBox getTemplate() {
		return this.template;
	}
	
}
