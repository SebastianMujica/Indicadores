package OrdenDeArrime;
import java.util.ArrayList;
import java.util.List;

import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
import SwingBernate.ControladorBase;
import SwingBernate.dtoVacio;
//import SwingBernate.dtoVacio;
import SwingBernate.ayudantes.ComboBox;
import SwingBernate.ayudantes.ListaDoble;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import Productor.Productor;
import Productor.modeloProductor;
import Hacienda.Hacienda;
import Hacienda.modeloHacienda;
import Tablon.Tablon;
import Tablon.modeloTablon;
import Nucleo.Nucleo;
import Nucleo.modeloNucleo;
import Tecnico.Tecnico;
import Tecnico.modeloTecnico;
public class controladorOrdenDeArrime extends ControladorBase implements ActionListener, MouseListener {
  public controladorOrdenDeArrime(){
    vistaOrdenDeArrime vista=new vistaOrdenDeArrime(this);
    OrdenDeArrime dto=new OrdenDeArrime();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);

  }
  public void actualizarVista(){
    vistaOrdenDeArrime vista=(vistaOrdenDeArrime)this.getSession().getVista();
    OrdenDeArrime dto=new OrdenDeArrime();
    modeloOrdenDeArrime modOrdenDeArrime=new modeloOrdenDeArrime();
    this.getSession().setListaDto(modOrdenDeArrime.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","OrdenDeArrime").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    modeloProductor modeloProductor=new modeloProductor();
    javax.swing.DefaultComboBoxModel modeloComboProductor=new javax.swing.DefaultComboBoxModel(modeloProductor.buscarProductors());
    vista.getCmbdtoproductor().setModelo(modeloComboProductor);

    modeloNucleo modeloNucleo=new modeloNucleo();
    javax.swing.DefaultComboBoxModel modeloComboNucleo=new javax.swing.DefaultComboBoxModel(modeloNucleo.buscarNucleos());
    vista.getCmbdtonucleo().setModelo(modeloComboNucleo);
    modeloTecnico modeloTecnico=new modeloTecnico();
    javax.swing.DefaultComboBoxModel modeloComboTecnico=new javax.swing.DefaultComboBoxModel(modeloTecnico.buscarTecnicos());
    vista.getCmbdtoingazucarero().setModelo(modeloComboTecnico);
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();

  }
  public void nuevo(){
    vistaOrdenDeArrime vista=new vistaOrdenDeArrime(this);
    vista=(vistaOrdenDeArrime)this.getSession().getVista();
    vista.setDto(new OrdenDeArrime());
  }
  public void grabar(){
    vistaOrdenDeArrime vista=new vistaOrdenDeArrime(this);
    vista=(vistaOrdenDeArrime)this.getSession().getVista();
    OrdenDeArrime dto=new OrdenDeArrime();
    dto.setHash(vista.getDto(dto));
    List<String> lsError=this.testValidacion(dto);
    if (lsError.isEmpty()) {
      modeloOrdenDeArrime modelo=new modeloOrdenDeArrime();
      modelo.grabar(dto);
    }
 else {
      vista.mensageDialogo("error","Por favor verifíque los datos. Debe ingresarlos correctamente!","Error en datos");
      vista.marcarError(lsError);
    }
  }
  public void eliminar(){
    vistaOrdenDeArrime vista=new vistaOrdenDeArrime(this);
    vista=(vistaOrdenDeArrime)this.getSession().getVista();
    modeloOrdenDeArrime modelo=new modeloOrdenDeArrime();
    if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?","Confirmar Eliminación") == 0) {
      modelo.eliminar(vista.getTxtlngid().getText());
    }
  }
  public void buscar(){
    vistaOrdenDeArrime vista=new vistaOrdenDeArrime(this);
    vista=(vistaOrdenDeArrime)this.getSession().getVista();
    modeloOrdenDeArrime modelo=new modeloOrdenDeArrime();
    OrdenDeArrime dto=new OrdenDeArrime();
    dto=modelo.buscarOrdenDeArrime(new OrdenDeArrime(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new OrdenDeArrime());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new OrdenDeArrime());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new OrdenDeArrime());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new OrdenDeArrime());
  }
  public void actionPerformed(  ActionEvent ae){
	
	  if("SwingBernate.ayudantes.ComboBox".equals(ae.getSource().getClass().getCanonicalName()))
	  {
		  ComboBox combo1=(ComboBox) ae.getSource();
		  vistaOrdenDeArrime vista=new vistaOrdenDeArrime(this);
		  vista=(vistaOrdenDeArrime)this.getSession().getVista();
	
		  if (combo1.getTipo().getClass().equals(new Productor().getClass())){
			  
			  if (!combo1.getSelectedItem().getClass().equals(new dtoVacio().getClass())){
			  Productor productor=(Productor) combo1.getSelectedItem();
			  javax.swing.DefaultComboBoxModel modeloComboHacienda=new javax.swing.DefaultComboBoxModel(productor.getHaciendas().toArray());
			  vista.getCmbdtohacienda().setModelo(modeloComboHacienda);
			  }
			  
			  
		  }
		  if (combo1.getTipo().getClass().equals(new Hacienda().getClass())){
			  System.out.println(combo1.getSelectedItem().getClass().getCanonicalName());
			  if (!combo1.getSelectedItem().getClass().equals(new dtoVacio().getClass())){
				 
				  Hacienda hacienda=(Hacienda) combo1.getSelectedItem();
				  modeloTablon modelotablon=new modeloTablon();
				  if (modelotablon.buscarTablonesLibres(hacienda.getLngid()).equals(null)){
					  vista.getLsttablonesacosechar().limpiar();  
				  }else{
					  vista.getLsttablonesacosechar().setModelDes(modelotablon.buscarTablonesLibres(hacienda.getLngid()));
				  }
			  }else{
				  
				  vista.getLsttablonesacosechar().limpiar();
			  }

		  }
	  
	  }
    if ("nuevo".equals(ae.getActionCommand()))     this.nuevo();
    if ("grabar".equals(ae.getActionCommand()))     this.grabar();
    if ("buscar".equals(ae.getActionCommand()))     this.buscar();
    if ("eliminar".equals(ae.getActionCommand()))     this.eliminar();
    if ("siguiente".equals(ae.getActionCommand()))     this.siguiente();
    if ("anterior".equals(ae.getActionCommand()))     this.anterior();
    if ("refrescar".equals(ae.getActionCommand()))     this.actualizarVista();
    if ("primero".equals(ae.getActionCommand()))     this.primero();
    if ("ultimo".equals(ae.getActionCommand()))     this.ultimo();
    if ("Salir".equals(ae.getActionCommand()))     this.terminarVista();
    if ("Lista".equals(ae.getActionCommand()))     this.imprimir(ae.getActionCommand());
    if ("Actual".equals(ae.getActionCommand()))     this.imprimir(ae.getActionCommand());
    if ("cambiarVista".equals(ae.getActionCommand()))     this.cambiarVista() ;

  }
  @Override
  public void mouseClicked(MouseEvent e) {
  	if (e.getClickCount() == 2) {
          JTable target = (JTable)e.getSource();
          int row = target.getSelectedRow();
          this.getSession().setDtoActual(row,new OrdenDeArrime());
          this.cambiarVista();       
         }	
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
  	
  }
  @Override
  public void mouseReleased(MouseEvent e) {
  	// TODO Auto-generated method stub
  	
  }
}

