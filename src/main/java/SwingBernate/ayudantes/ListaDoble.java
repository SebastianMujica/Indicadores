package SwingBernate.ayudantes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

import SwingBernate.ControladorBase;
import SwingBernate.DtoBase;
import SwingBernate.Sesion;
import SwingBernate.VistaBase;

import com.sun.java.swing.plaf.nimbus.LoweredBorder;

public class ListaDoble <T> extends JPanel implements ActionListener,MouseListener{

	String titulo="Sin-Titulo";
	int vez=0;
	JButton Bagregar=new JButton("agregar");
	JButton Bquitar =new JButton("quitar");
	DefaultListModel modeloLstA = new DefaultListModel();
	DefaultListModel modeloLstDes = new DefaultListModel();
	DefaultListModel modeloLstDesR = new DefaultListModel();
	JList asociados=new JList(modeloLstA);
	JList desasociados=new JList(modeloLstDes);
	Object buffer[];
	GridBagConstraints c = new GridBagConstraints();
	DtoBase tipo;
	JPopupMenu menuContextual = new JPopupMenu();
	JMenuItem acercar = new JMenuItem("acercar");

	public ListaDoble(String titulo, DtoBase t){
		MigLayout mig=new MigLayout();
		this.setLayout(mig);
		
//		this.asociados.setMinimumSize(new Dimension(50, 60));
//		this.asociados.setPreferredSize(new Dimension(50, 60));
//		this.asociados.setMaximumSize(new Dimension(50, 60));
//		this.desasociados.setMinimumSize(new Dimension(50, 60));
//		this.desasociados.setPreferredSize(new Dimension(50, 60));
//		this.desasociados.setMaximumSize(new Dimension(50, 60));
		this.acercar.addActionListener(this);
		this.menuContextual.add(this.acercar);

		this.asociados.add(menuContextual);
		this.desasociados.add(menuContextual);
		//this.add(menuContextual);

		this.setTipo(t);
		this.asociados.setBorder(new TitledBorder("Incluidos"));
		this.desasociados.setBorder(new TitledBorder("Disponibles"));

		JScrollPane barraA = new javax.swing.JScrollPane(asociados);

		JScrollPane barraD = new javax.swing.JScrollPane(desasociados);
		
		barraA.setMinimumSize(new Dimension(160,130));
		barraD.setMinimumSize(new Dimension(160,130));
		barraA.setMaximumSize(new Dimension(160,130));
		barraD.setMaximumSize(new Dimension(160,130));
		
		
		this.add(Bquitar ,"grow");

		this.add(Bagregar,"grow,wrap 1");

		this.add(barraA,  "grow");

		this.add(barraD,  "grow");

		this.setBorder(new TitledBorder(titulo));
		this.Bagregar.addActionListener(this);
		this.Bquitar.addActionListener(this);
		this.Bagregar.addMouseListener(this);
		this.Bquitar.addMouseListener(this);
		/*this.add(agregar,BorderLayout.NORTH);
	this.add(quitar,BorderLayout.NORTH);
	this.add(asociados,BorderLayout.CENTER);
	this.add(desasociados,BorderLayout.CENTER);*/
		/*
	this.setPreferredSize(new java.awt.Dimension(300,200));
	JList lista = desasociados;
	lista.setPreferredSize(new java.awt.Dimension(100,100));
	//lista.setLocation(new java.awt.Point(3,3));
	lista.setSize(new java.awt.Dimension(221,292));
	JList lista2 = asociados;
	lista2.setPreferredSize(new java.awt.Dimension(100,100));
	//lista2.setLocation(new java.awt.Point(4,4));


	javax.swing.JScrollPane barra = new javax.swing.JScrollPane(lista);

	javax.swing.JScrollPane barra2 = new javax.swing.JScrollPane(lista2);


	barra.getViewport().add(lista);
	barra2.getViewport().add(lista2);

	this.add(barra, null);
	this.add(barra2, null);*/ 
		this.status();
	};


	/*	public synchronized void addMouseListener(MouseListener l) {
		super.addMouseListener(l);
		asociados.addMouseListener(l);
		desasociados.addMouseListener(l);
		Bagregar.addMouseListener(l);
		Bquitar.addMouseListener(l);
	};*/
	public void agregar(){
		Object agregar[]=desasociados.getSelectedValues();

		for (int i = 0; i < agregar.length; i++) {
			//System.out.println("Se quiere Agregar: "+agregar[i]+"cuyo indice es:"+i);
			modeloLstA.addElement(agregar[i]);

			//modeloLstDes.get(agregar[i]);
			//asoc.addElement(modeloLstDes.get(agregar[i]));
			modeloLstDes.removeElement(agregar[i]);

		}



		this.asociados.clearSelection();
		this.desasociados.clearSelection();
		//	actualizar();
		//	this.asociados.setModel(asoc);
		//this.desasociados.setModel(modeloLstDes);
		this.status();
	}
	public void limpiar(){
		modeloLstA.removeAllElements();
		modeloLstDes.removeAllElements();
		modeloLstDesR.removeAllElements();
		this.buffer=new Object[0];

	}

	public void status(){
		if (modeloLstA.size()==0){
			this.Bquitar.setEnabled(false);
		}
		if (modeloLstDes.size()==0){
			this.Bagregar.setEnabled(false);
		}
		if (modeloLstA.size()>0){
			this.Bquitar.setEnabled(true);
		}
		if (modeloLstDes.size()>0){
			this.Bagregar.setEnabled(true);
		}
	}
	
	public void quitar(){
		Object quitar[]=asociados.getSelectedValues();

		for (int i = 0; i < quitar.length; i++) {

			//System.out.println("se quiere quitar: "+quitar[i]+"cuyo indice es:"+i);
			modeloLstDes.addElement(quitar[i]);
			modeloLstA.removeElement(quitar[i]);

		}
		this.asociados.clearSelection();
		this.desasociados.clearSelection();
		//actualizar();
		//this.asociados.setModel(modeloLstA);
		//this.desasociados.setModel(modeloLstDes);
		this.status();
	}
	
	public List<T> getSelected(){

		List<T> lista=new ArrayList();
		Object arr[]=modeloLstA.toArray();
		for (int i = 0; i < arr.length; i++) {
			lista.add((T)arr[i]);
		}
		return lista;
	}
	
	public void setSelected(List <T>lista){

		if (lista.equals(null)){
			modeloLstA=new DefaultListModel();
		}else{
			for (int i = 0; i < lista.size(); i++) {
				modeloLstA.add(i,(Object)lista.get(i));
			}
		}
		this.status();
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public JList getAsociados() {
		return asociados;
	}
	public void setAsociados(JList asociados) {
		this.asociados = asociados;
	}
	public JList getDesasociados() {
		return desasociados;
	}
	public void setDesasociados(JList desasociados) {
		this.desasociados = desasociados;
	}
	public JButton getBagregar() {
		return Bagregar;
	}
	public void setBagregar(JButton agregar) {
		this.Bagregar = agregar;
	}
	public JButton getBquitar() {
		return Bquitar;
	}
	public void setBquitar(JButton quitar) {
		this.Bquitar = quitar;
	}
	public DefaultListModel getModeloLstA() {
		return modeloLstA;
	}
	public void setModeloLstA(DefaultListModel modeloLstA) {
		this.modeloLstA = modeloLstA;
	}
	public void setModelA(T arreglo[]) {
		setModelDes((T[]) buffer);
		if (arreglo.length<=0){
			//modeloLstA=new DefaultListModel();
			modeloLstA.removeAllElements();	
		}else{

			modeloLstA.removeAllElements();

			for (int i = 0; i < arreglo.length; i++) {

				modeloLstA.add(i, arreglo[i]);
				modeloLstDes.removeElement(arreglo[i]);	
			}
		}
		this.status();

	}
	public void setModelDes(T arreglo[]) {
		vez++;
		modeloLstDes.removeAllElements();
		for (int i = 0; i < arreglo.length; i++) {
			modeloLstDes.add(i, arreglo[i]);
			//this.desasociados.getModel().
		}

		//if ((vez==1)){
		buffer=new Object[arreglo.length];
		modeloLstDes.copyInto(buffer);
		//}
		this.status();
	}
	public void actualizarBuffer(T arreglo[]){
		buffer=new Object[arreglo.length];
		modeloLstDes.copyInto(buffer);
	}
	public DefaultListModel getModeloLstDes() {
		return modeloLstDes;
	}
	public void setModeloLstDes(DefaultListModel modeloLstDes) {
		this.modeloLstDes = modeloLstDes;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.status();
		//System.out.println(arg0.getActionCommand());
		if (arg0.getActionCommand().equals("agregar"))
		{
			this.agregar();
		}if (arg0.getActionCommand().equals("quitar"))
		{
			this.quitar();
		}
		if (arg0.getActionCommand().equals("acercar"))
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
			this.menuContextual.show(this, this.getX(), this.getY());
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public DtoBase getTipo() {
		return tipo;
	}

	public void setTipo(DtoBase tipo) {
		this.tipo = tipo;
	}

}
