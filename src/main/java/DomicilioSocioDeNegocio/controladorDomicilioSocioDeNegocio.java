package DomicilioSocioDeNegocio;
import java.util.Date;
import java.util.List;

import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ControladorBase;
import SwingBernate.dtoVacio;
import SwingBernate.ayudantes.ComboBox;
import SwingBernate.ayudantes.ComboBoxSelect;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import SocioDeNegocio.modeloSocioDeNegocio;
import Maestro.modeloMaestro;
import Pais.modeloPais;
import Estado.modeloEstado;
import Municipio.modeloMunicipio;
import Parroquia.modeloParroquia;

public class controladorDomicilioSocioDeNegocio extends ControladorBase implements ActionListener, MouseListener,KeyListener {
	int perf = 0;
  public controladorDomicilioSocioDeNegocio(){
    vistaDomicilioSocioDeNegocio vista=new vistaDomicilioSocioDeNegocio(this);
    DomicilioSocioDeNegocio dto=new DomicilioSocioDeNegocio();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    if (this.getSession().getListaDto().size()==0){
    	vista.getCentro2().setVisible(false);
    	vista.getCentro().setVisible(true);
    }else{
    	this.cambiarVista();
    }
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);
  }
  public void actualizarVista(){
    vistaDomicilioSocioDeNegocio vista=(vistaDomicilioSocioDeNegocio)this.getSession().getVista();
    DomicilioSocioDeNegocio dto=new DomicilioSocioDeNegocio();
    modeloDomicilioSocioDeNegocio modDomicilioSocioDeNegocio=new modeloDomicilioSocioDeNegocio();
    this.getSession().setListaDto(modDomicilioSocioDeNegocio.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","DomicilioSocioDeNegocio").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    modeloSocioDeNegocio modeloSocioDeNegocio=new modeloSocioDeNegocio();
    javax.swing.DefaultComboBoxModel modeloComboSocioDeNegocio=new javax.swing.DefaultComboBoxModel(modeloSocioDeNegocio.buscarSocioDeNegocios());
    vista.getCmbdto_sociodenegocio().setModel(modeloComboSocioDeNegocio);
    modeloMaestro modeloMaestro=new modeloMaestro();
    javax.swing.DefaultComboBoxModel modeloComboMaestro=new javax.swing.DefaultComboBoxModel(modeloMaestro.hijosPorMaestro("TIPO_DOM_PER"));
    vista.getCmbdto_tipo_direccion().setModel(modeloComboMaestro);
    modeloPais modeloPais=new modeloPais();
    javax.swing.DefaultComboBoxModel modeloComboPais=new javax.swing.DefaultComboBoxModel(modeloPais.buscarPaiss());
    //javax.swing.DefaultComboBoxModel modeloComboPais=new javax.swing.DefaultComboBoxModel();
    vista.getCmbdto_pais().setModelo(modeloComboPais);
    modeloEstado modeloEstado=new modeloEstado();
    //javax.swing.DefaultComboBoxModel modeloComboEstado=new javax.swing.DefaultComboBoxModel(modeloEstado.buscarEstados());
    javax.swing.DefaultComboBoxModel modeloComboEstado=new javax.swing.DefaultComboBoxModel();
    vista.getCmbdto_estado().setModelo(modeloComboEstado);
    modeloMunicipio modeloMunicipio=new modeloMunicipio();
    //javax.swing.DefaultComboBoxModel modeloComboMunicipio=new javax.swing.DefaultComboBoxModel(modeloMunicipio.buscarMunicipios());
    javax.swing.DefaultComboBoxModel modeloComboMunicipio=new javax.swing.DefaultComboBoxModel();
    vista.getCmbdto_municipio().setModelo(modeloComboMunicipio);
    modeloParroquia modeloParroquia=new modeloParroquia();
    //javax.swing.DefaultComboBoxModel modeloComboParroquia=new javax.swing.DefaultComboBoxModel(modeloParroquia.buscarParroquias());
    javax.swing.DefaultComboBoxModel modeloComboParroquia=new javax.swing.DefaultComboBoxModel();
    vista.getCmbdto_parroquia().setModelo(modeloComboParroquia);
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
    vistaDomicilioSocioDeNegocio vista=new vistaDomicilioSocioDeNegocio(this);
    vista=(vistaDomicilioSocioDeNegocio)this.getSession().getVista();
    vista.setDto(new DomicilioSocioDeNegocio());
    if (vista.getCentro2().isVisible()){
    	this.cambiarVista();
    }
    vista.limpiarError();
    vista.getChkbolactivo().setSelected(true);
  }
  public void grabar(){
    vistaDomicilioSocioDeNegocio vista=new vistaDomicilioSocioDeNegocio(this);
    vista=(vistaDomicilioSocioDeNegocio)this.getSession().getVista();
    DomicilioSocioDeNegocio dto=new DomicilioSocioDeNegocio();
    dto.setHash(vista.getDto(dto));
    if(dto.getLngid() ==0){
    	dto.setLngseg_usuario_creacion(this.getSession().getLngusr());
    	dto.setDtmfecha_creacion(new Date());
		dto.setStrip_creacion(this.obtenerIpHost());
		dto.setStrhost_creacion(this.obtenerNombreHost());
		dto.setLngseg_usuario_modificacion(this.getSession().getLngusr());
		dto.setDtmfecha_modificacion(new Date());
		dto.setStrip_modificacion(this.obtenerIpHost());
		dto.setStrhost_modificacion(this.obtenerNombreHost());
		dto.setDtmvalido_desde(new Date());
		dto.setDtmvalido_hasta(this.sumarAnios(20));
		dto.setBolborrado(false);
		
	}else{
		dto.setStrip_modificacion(this.obtenerIpHost());
		dto.setStrhost_modificacion(this.obtenerNombreHost());
		dto.setDtmfecha_modificacion(new Date());
		dto.setLngseg_usuario_modificacion(this.getSession().getLngusr());
	}
    List<String> lsError=this.testValidacion(dto);
    if (lsError.isEmpty()) {
 	   int intDialogo = vista.mensageDialogo("confirmar","¿Desea grabar los cambios?" , vista.getTitle());
 	   if (JOptionPane.YES_OPTION == intDialogo){
           modeloDomicilioSocioDeNegocio modelo=new modeloDomicilioSocioDeNegocio();
           modelo.grabar(dto);
           vista.mensageDialogo("informacion","Datos Grabados." , vista.getTitle());
           vista.limpiarError();
 	   }
    }
    else {
       //vista.mensageDialogo("error","Por favor verifíque los datos. Debe ingresarlos correctamente!","Error en datos");
       vista.marcarError(lsError);
     }
  }
  public void eliminar(){
    vistaDomicilioSocioDeNegocio vista=new vistaDomicilioSocioDeNegocio(this);
    vista=(vistaDomicilioSocioDeNegocio)this.getSession().getVista();
    modeloDomicilioSocioDeNegocio modelo=new modeloDomicilioSocioDeNegocio();
    String strlngid=vista.getTxtlngid().getText();
    if (strlngid.isEmpty() || strlngid.length()==0 || strlngid.trim().contentEquals("0")){
    	vista.mensageDialogo("error","Identificador de Registro No Válido." , vista.getTitle());
    }else{
       if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?",vista.getTitle()) == 0) {
         modelo.eliminar(vista.getTxtlngid().getText().trim());
       }
    }
  }
  public void buscar(){
    vistaDomicilioSocioDeNegocio vista=new vistaDomicilioSocioDeNegocio(this);
    vista=(vistaDomicilioSocioDeNegocio)this.getSession().getVista();
    modeloDomicilioSocioDeNegocio modelo=new modeloDomicilioSocioDeNegocio();
    DomicilioSocioDeNegocio dto=new DomicilioSocioDeNegocio();
    dto=modelo.buscarDomicilioSocioDeNegocio(new DomicilioSocioDeNegocio(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void refrescar(){
	  vistaDomicilioSocioDeNegocio vista=new vistaDomicilioSocioDeNegocio(this);
	  vista=(vistaDomicilioSocioDeNegocio)this.getSession().getVista();
	  vista.limpiarError();
	  this.actualizarVista();
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new DomicilioSocioDeNegocio());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new DomicilioSocioDeNegocio());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new DomicilioSocioDeNegocio());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new DomicilioSocioDeNegocio());
  }
  public void actionPerformed(  ActionEvent ae){
    if ("nuevo".equals(ae.getActionCommand()))     this.nuevo();
    if ("grabar".equals(ae.getActionCommand()))     this.grabar();
    if ("buscar".equals(ae.getActionCommand()))     this.buscar();
    if ("eliminar".equals(ae.getActionCommand()))     this.eliminar();
    if ("siguiente".equals(ae.getActionCommand()))     this.siguiente();
    if ("anterior".equals(ae.getActionCommand()))     this.anterior();
    if ("refrescar".equals(ae.getActionCommand()))     this.refrescar();
    if ("primero".equals(ae.getActionCommand()))     this.primero();
    if ("ultimo".equals(ae.getActionCommand()))     this.ultimo();
    if ("Salir".equals(ae.getActionCommand()))     this.terminarVista();
    if ("Lista".equals(ae.getActionCommand()))     this.imprimir(ae.getActionCommand());
    if ("Actual".equals(ae.getActionCommand()))     this.imprimir(ae.getActionCommand());
    if ("cambiarVista".equals(ae.getActionCommand()))     this.cambiarVista();
    
    if(ae.getSource().getClass().getName().equals("SwingBernate.ayudantes.ComboBox")){
    	ComboBox cmbox = (ComboBox)ae.getSource();
    	String nombreCombo = cmbox.getName().toString();
    	
    	if( nombreCombo.contains("cmbdto_pais") || nombreCombo.contains("cmbdto_estado")
    			 || nombreCombo.contains("cmbdto_municipio")  || nombreCombo.contains("cmbdto_parroquia")){
    		
    		ComboBoxSelect cmbselect = new ComboBoxSelect();
    		vistaDomicilioSocioDeNegocio vista=(vistaDomicilioSocioDeNegocio)this.getSession().getVista();
    		
    		if(nombreCombo.contains("cmbdto_pais")){    			
    			cmbselect.LlenarEstado(vista.getCmbdto_pais(), vista.getCmbdto_estado());
    		}else if( nombreCombo.contains("cmbdto_estado") ){
    			cmbselect.LlenarMunicipio(vista.getCmbdto_estado(), vista.getCmbdto_municipio());
    		}else if( nombreCombo.contains("cmbdto_municipio") ){
    			cmbselect.LlenarParroquia(vista.getCmbdto_municipio(), vista.getCmbdto_parroquia());
    		}
    	}    	
    }
  }
  public void mouseClicked(  MouseEvent e){
    if (e.getClickCount() == 2) {
      JTable target=(JTable)e.getSource();
      int row=target.getSelectedRow();
      this.getSession().setDtoActual(row,new DomicilioSocioDeNegocio());
      this.cambiarVista();
    }
  }
  public void mouseEntered(  MouseEvent e){
  }
  public void mouseExited(  MouseEvent e){
  }
  public void mousePressed(  MouseEvent e){
  }
  public void mouseReleased(  MouseEvent e){
  }
}

