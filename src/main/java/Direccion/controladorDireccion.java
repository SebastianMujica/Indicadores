package Direccion;

import java.util.List;

import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ControladorBase;
import SwingBernate.ayudantes.ComboBox;
import SwingBernate.ayudantes.ComboBoxSelect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import Pais.modeloPais;
import Estado.modeloEstado;
import Municipio.modeloMunicipio;
import Parroquia.modeloParroquia;
import Telefono.modeloTelefono;

public class controladorDireccion extends ControladorBase implements ActionListener, MouseListener {
	int perf = 0;
	
  public controladorDireccion(){
    vistaDireccion vista=new vistaDireccion(this);
    Direccion dto=new Direccion();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);
  }
  public void actualizarVista(){
    vistaDireccion vista=(vistaDireccion)this.getSession().getVista();
    Direccion dto=new Direccion();
    modeloDireccion modDireccion=new modeloDireccion();
    this.getSession().setListaDto(modDireccion.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Direccion").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    modeloPais modeloPais=new modeloPais();
    javax.swing.DefaultComboBoxModel modeloComboPais=new javax.swing.DefaultComboBoxModel(modeloPais.buscarPaiss());
    vista.getCmbdtopais().setModelo(modeloComboPais);
    modeloEstado modeloEstado=new modeloEstado();
    javax.swing.DefaultComboBoxModel modeloComboEstado=new javax.swing.DefaultComboBoxModel(modeloEstado.buscarEstados());
    vista.getCmbdtoestado().setModelo(modeloComboEstado);
    modeloMunicipio modeloMunicipio=new modeloMunicipio();
    javax.swing.DefaultComboBoxModel modeloComboMunicipio=new javax.swing.DefaultComboBoxModel(modeloMunicipio.buscarMunicipios());
    vista.getCmbdtomunicipio().setModelo(modeloComboMunicipio);
    modeloParroquia modeloParroquia=new modeloParroquia();
    javax.swing.DefaultComboBoxModel modeloComboParroquia=new javax.swing.DefaultComboBoxModel(modeloParroquia.buscarParroquias());
    vista.getCmbdtoparroquia().setModelo(modeloComboParroquia);
    modeloTelefono modeloTelefono=new modeloTelefono();
    vista.getLstdtotelefono().setModelDes(modeloTelefono.buscarTelefonos());
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
    vistaDireccion vista=new vistaDireccion(this);
    vista=(vistaDireccion)this.getSession().getVista();
    vista.setDto(new Direccion());
    //vista.getCmpcmbubicacion().LimpiarCombos();
  }
  public void grabar(){
    vistaDireccion vista=new vistaDireccion(this);
    vista=(vistaDireccion)this.getSession().getVista();
    Direccion dto=new Direccion();
    dto.setHash(vista.getDto(dto));
    List<String> lsError=this.testValidacion(dto);
    //List<DtoBase> lsUbicacion = vista.getCmpcmbubicacion().getSeleccionados();
    //if (lsError.isEmpty() && !lsUbicacion.isEmpty()) {
    if ( lsError.isEmpty() ) {
      modeloDireccion modelo=new modeloDireccion();
      /*dto.setDtopais((Pais) lsUbicacion.get(0));
      dto.setDtoestado((Estado) lsUbicacion.get(1));
      dto.setDtomunicipio((Municipio) lsUbicacion.get(2));
      dto.setDtoparroquia((Parroquia) lsUbicacion.get(3));*/
      modelo.grabar(dto);
    }
 else {
      vista.mensageDialogo("error","Por favor verifíque los datos. Debe ingresarlos correctamente!","Error en datos");
      vista.marcarError(lsError);
    }
  }
  public void eliminar(){
    vistaDireccion vista=new vistaDireccion(this);
    vista=(vistaDireccion)this.getSession().getVista();
    modeloDireccion modelo=new modeloDireccion();
    if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?","Confirmar Eliminación") == 0) {
      modelo.eliminar(vista.getTxtlngid().getText());
    }
  }
  public void buscar(){
    vistaDireccion vista=new vistaDireccion(this);
    vista=(vistaDireccion)this.getSession().getVista();
    modeloDireccion modelo=new modeloDireccion();
    Direccion dto=new Direccion();
    dto=modelo.buscarDireccion(new Direccion(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new Direccion());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new Direccion());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new Direccion());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Direccion());
  }
  public void actionPerformed(  ActionEvent ae){	  
    if ("nuevo".equals(ae.getActionCommand()))     this.nuevo();
    if ("cambiarVista".equals(ae.getActionCommand()))     this.cambiarVista() ;
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
    
    if(ae.getSource().getClass().getName().equals("SwingBernate.ayudantes.ComboBox")){
    	ComboBox cmbox = (ComboBox)ae.getSource();
    	String nombreCombo = cmbox.getName().toString();
    	    	
    	if( nombreCombo.contains("cmpDtopais") || nombreCombo.contains("cmpDtoestado")
    			 || nombreCombo.contains("cmpDtomunicipio")  || nombreCombo.contains("cmpDtoparroquia")){
    		
    		ComboBoxSelect cmbselect = new ComboBoxSelect();
    		vistaDireccion vista=(vistaDireccion)this.getSession().getVista();
    		
    		if(nombreCombo.contains("cmpDtopais")){    			
    			cmbselect.LlenarEstado(vista.getCmbdtopais(), vista.getCmbdtoestado());
    		}else if( nombreCombo.contains("cmpDtoestado") ){
    			cmbselect.LlenarMunicipio(vista.getCmbdtoestado(), vista.getCmbdtomunicipio());
    		}else if( nombreCombo.contains("cmpDtomunicipio") ){
    			cmbselect.LlenarParroquia(vista.getCmbdtomunicipio(), vista.getCmbdtoparroquia());
    		}
    	}    	
    }
    
  }
  
  @Override
  public void mouseClicked(MouseEvent e) {
  	if (e.getClickCount() == 2) {
          JTable target = (JTable)e.getSource();
          int row = target.getSelectedRow();
          this.getSession().setDtoActual(row,new Direccion());
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

