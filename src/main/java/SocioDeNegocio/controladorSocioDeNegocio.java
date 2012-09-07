package SocioDeNegocio;
import java.util.Date;
import java.util.List;

import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ControladorBase;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import Maestro.modeloMaestro;

public class controladorSocioDeNegocio extends ControladorBase implements ActionListener, MouseListener, KeyListener {
  public controladorSocioDeNegocio(){
    vistaSocioDeNegocio vista=new vistaSocioDeNegocio(this);
    SocioDeNegocio dto=new SocioDeNegocio();
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
    vistaSocioDeNegocio vista=(vistaSocioDeNegocio)this.getSession().getVista();
    SocioDeNegocio dto=new SocioDeNegocio();
    modeloSocioDeNegocio modSocioDeNegocio=new modeloSocioDeNegocio();
    this.getSession().setListaDto(modSocioDeNegocio.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","SocioDeNegocio").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    
    modeloMaestro modeloMaestro=new modeloMaestro();
    
    javax.swing.DefaultComboBoxModel modeloComboTipoPersonalidad=new javax.swing.DefaultComboBoxModel(modeloMaestro.hijosPorMaestro("TIPO_PER"));
    vista.getCmbdto_tipo_personalidad().setModel(modeloComboTipoPersonalidad);
    
    //modeloMaestro modeloTipoDocumento=new modeloMaestro();
    javax.swing.DefaultComboBoxModel modeloComboTipoDocumento=new javax.swing.DefaultComboBoxModel(modeloMaestro.hijosPorMaestro("TIPO_DOC_PER"));
    vista.getCmbdto_tipo_documento().setModel(modeloComboTipoDocumento);
    
    //modeloMaestro modeloClasificacionPersona=new modeloMaestro();
    javax.swing.DefaultComboBoxModel modeloComboClasificacionPersona=new javax.swing.DefaultComboBoxModel(modeloMaestro.hijosPorMaestro("CLS_PER"));
    vista.getCmbdto_tipo_clasificacion().setModel(modeloComboClasificacionPersona);
    
    //modeloMaestro modeloTipoGenero=new modeloMaestro();
    javax.swing.DefaultComboBoxModel modeloComboTipoGenero=new javax.swing.DefaultComboBoxModel(modeloMaestro.hijosPorMaestro("GEN_PER"));
    vista.getCmbdto_genero_persona().setModel(modeloComboTipoGenero);
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
    vistaSocioDeNegocio vista=new vistaSocioDeNegocio(this);
    vista=(vistaSocioDeNegocio)this.getSession().getVista();
    vista.setDto(new SocioDeNegocio());
    if (vista.getCentro2().isVisible()){
    	this.cambiarVista();
    }
    vista.limpiarError();
    vista.getChkbolactivo().setSelected(true);
  }
  public void grabar(){
    vistaSocioDeNegocio vista=new vistaSocioDeNegocio(this);
    vista=(vistaSocioDeNegocio)this.getSession().getVista();
    SocioDeNegocio dto=new SocioDeNegocio();
    dto.setHash(vista.getDto(dto));
    this.getSession().setUsuarioInicio(vista);
    if(dto.getLngid() ==0){
    	//dto.setLngseg_usuario_creacion(this.getSession().getLngusr());
    	dto.setLngseg_usuario_creacion(1);
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
              modeloSocioDeNegocio modelo=new modeloSocioDeNegocio();
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
    vistaSocioDeNegocio vista=new vistaSocioDeNegocio(this);
    vista=(vistaSocioDeNegocio)this.getSession().getVista();
    modeloSocioDeNegocio modelo=new modeloSocioDeNegocio();
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
    vistaSocioDeNegocio vista=new vistaSocioDeNegocio(this);
    vista=(vistaSocioDeNegocio)this.getSession().getVista();
    modeloSocioDeNegocio modelo=new modeloSocioDeNegocio();
    SocioDeNegocio dto=new SocioDeNegocio();
    dto=modelo.buscarSocioDeNegocio(new SocioDeNegocio(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void refrescar(){
	  vistaSocioDeNegocio vista=new vistaSocioDeNegocio(this);
	  vista=(vistaSocioDeNegocio)this.getSession().getVista();
	  vista.limpiarError();
	  this.actualizarVista();
  }
  
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new SocioDeNegocio());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new SocioDeNegocio());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new SocioDeNegocio());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new SocioDeNegocio());
  }
  public void actionPerformed(  ActionEvent ae){
    if ("nuevo".equals(ae.getActionCommand()))     this.nuevo();
    if ("grabar".equals(ae.getActionCommand()))     this.grabar();
    if ("buscar".equals(ae.getActionCommand()))     this.buscar();
    if ("eliminar".equals(ae.getActionCommand()))     this.eliminar();
    if ("siguiente".equals(ae.getActionCommand()))     this.siguiente();
    if ("anterior".equals(ae.getActionCommand()))     this.anterior();
    if ("refrescar".equals(ae.getActionCommand()))    this.refrescar();
    if ("primero".equals(ae.getActionCommand()))     this.primero();
    if ("ultimo".equals(ae.getActionCommand()))     this.ultimo();
    if ("Salir".equals(ae.getActionCommand()))     this.terminarVista();
    if ("Lista".equals(ae.getActionCommand()))     this.imprimir(ae.getActionCommand());
    if ("Actual".equals(ae.getActionCommand()))     this.imprimir(ae.getActionCommand());
    if ("cambiarVista".equals(ae.getActionCommand()))     this.cambiarVista();
  }
  public void mouseClicked(  MouseEvent e){
    if (e.getClickCount() == 2) {
      JTable target=(JTable)e.getSource();
      int row=target.getSelectedRow();
      this.getSession().setDtoActual(row,new SocioDeNegocio());
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
