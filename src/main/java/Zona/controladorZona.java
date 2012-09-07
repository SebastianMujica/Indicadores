package Zona;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Zona.Zona;
import Zona.modeloZona;
import Zona.vistaZona;
import Zona.Zona;
import Zona.modeloZona;
import Zona.vistaZona;
import Estado.modeloEstado;
import Municipio.modeloMunicipio;
import Organizacion.modeloOrganizacion;
import Pais.modeloPais;
import Parroquia.modeloParroquia;
import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ControladorBase;
import SwingBernate.DtoBase;
import SwingBernate.ayudantes.ComboBox;
import SwingBernate.ayudantes.ComboBoxSelect;

public class controladorZona extends ControladorBase implements ActionListener, MouseListener,KeyListener{
	public controladorZona(){
		vistaZona vista = new vistaZona(this);
		Zona dto = new Zona();
		this.iniciarSesion(vista, dto);
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
		vistaZona vista = (vistaZona)this.getSession().getVista();
		Zona dto = new Zona();
		modeloZona modelZona=new modeloZona();
		List <DtoBase> listaZonas = modelZona.buscar(dto);
		this.getSession().setListaDto(listaZonas);		
		
		modeloReporte modeloReporte=new modeloReporte();
	    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Direccion").toArray());
	    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
	    modeloOrganizacion modeloOrganizacion=new modeloOrganizacion();
	    javax.swing.DefaultComboBoxModel modeloComboOrganizacion=new javax.swing.DefaultComboBoxModel(modeloOrganizacion.buscarOrganizacions());
	    vista.getCmbdto_org().setModelo(modeloComboOrganizacion);
	    modeloPais modeloPais=new modeloPais();
	    javax.swing.DefaultComboBoxModel modeloComboPais=new javax.swing.DefaultComboBoxModel(modeloPais.buscarPaiss());
	    vista.getCmbdtopais().setModelo(modeloComboPais);
	    //modeloEstado modeloEstado=new modeloEstado();
	    javax.swing.DefaultComboBoxModel modeloComboEstado=new javax.swing.DefaultComboBoxModel();
	    //javax.swing.DefaultComboBoxModel modeloComboEstado=new javax.swing.DefaultComboBoxModel(modeloEstado.buscarEstados());
	    vista.getCmbdtoestado().setModelo(modeloComboEstado);
	    //modeloMunicipio modeloMunicipio=new modeloMunicipio();
	    //javax.swing.DefaultComboBoxModel modeloComboMunicipio=new javax.swing.DefaultComboBoxModel(modeloMunicipio.buscarMunicipios());
	    javax.swing.DefaultComboBoxModel modeloComboMunicipio=new javax.swing.DefaultComboBoxModel();
	    vista.getCmbdtomunicipio().setModelo(modeloComboMunicipio);
	    //modeloParroquia modeloParroquia=new modeloParroquia();
	    javax.swing.DefaultComboBoxModel modeloComboParroquia=new javax.swing.DefaultComboBoxModel();
	    //javax.swing.DefaultComboBoxModel modeloComboParroquia=new javax.swing.DefaultComboBoxModel(modeloParroquia.buscarParroquias());
	    vista.getCmbdtoparroquia().setModelo(modeloComboParroquia);
	    
	    if(!listaZonas.isEmpty()){
			this.getSession().setActual(0);
			vista.setDto((Zona)listaZonas.get(0));			
		}
	    this.cargarGrid();
	}
	
	public void nuevo(){
		vistaZona vista = new vistaZona(this);
		vista = (vistaZona)this.getSession().getVista();	
		vista.setDto(new Zona());
		if (vista.getCentro2().isVisible()){
	    	this.cambiarVista();
	    }
	    vista.limpiarError();
	    vista.getChkbolactivo().setSelected(true);
	}
	
	public void buscar(){
		vistaZona vista=new vistaZona(this);
	    vista=(vistaZona)this.getSession().getVista();
	    String str=vista.getTxtlngid().getText().trim();
	    if (str.isEmpty() || str.length()==0 || str.contentEquals("0")){
	       vista.mensageDialogo("error","Valor de búsqueda vacío o inválido.\nIntroduzca un número mayor que cero." , vista.getTitle());
	    }else{
	    	modeloZona modelo=new modeloZona();
	        Zona dto=new Zona();
	        dto=modelo.buscar(new Zona(),"lngid",str);
	        vista.setDto(dto);		
	    }
	}
	
	public void grabar(){
	    vistaZona vista=new vistaZona(this);
	    vista=(vistaZona)this.getSession().getVista();
	    String strlngid=vista.getTxtlngid().getText();
	    
	    if (strlngid.isEmpty() || strlngid.length()==0){
	    	vista.mensageDialogo("error","Identificador vacío o inválido.\nÉste debe ser mayor o igual a cero." , vista.getTitle());
	    }else{
	    	Zona dto=new Zona();
	        dto.setHash(vista.getDto(dto));
	        this.getSession().setUsuarioInicio(vista);
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
	               modeloZona modelo=new modeloZona();
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
	  }
	
	public void eliminar(){
	    vistaZona vista=new vistaZona(this);
	    vista=(vistaZona)this.getSession().getVista();
	    String strlngid=vista.getTxtlngid().getText();
	    if (strlngid.isEmpty() || strlngid.length()==0 || strlngid.trim().contentEquals("0")){
	    	vista.mensageDialogo("error","Identificador de Registro No Válido." , vista.getTitle());
	    }else{
	       if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?",vista.getTitle()) == 0) {
	    	 modeloZona modelo=new modeloZona();
	         modelo.eliminar(Long.parseLong(vista.getTxtlngid().getText().trim()));
	       }
	    }
	  }
	  public void refrescar(){
		  vistaZona vista=new vistaZona(this);
		  vista=(vistaZona)this.getSession().getVista();
		  vista.limpiarError();
		  if (this.getSession().getListaDto().size()>0){
			  this.actualizarVista();
		 	}else{
		 		vista.mensageDialogo("error","No Existen Datos que actualizar." , vista.getTitle());
		 	}
	  }
	  public void siguiente(){
	    if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(this.getSession().getActual() + 1,new Zona());
	 	}else{
	 		vistaZona vista=new vistaZona(this);
	 		vista=(vistaZona)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
	  }
	  public void anterior(){
	    if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(this.getSession().getActual() - 1,new Zona());
	 	}else{
	 		vistaZona vista=new vistaZona(this);
	 		vista=(vistaZona)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
	  }
	  public void primero(){
	    if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(0,new Zona());
	 	}else{
	 		vistaZona vista=new vistaZona(this);
	 		vista=(vistaZona)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
	  }
	  public void ultimo(){
		if (this.getSession().getListaDto().size()>0){
	       this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Zona());
		}else{
			vistaZona vista=new vistaZona(this);
			vista=(vistaZona)this.getSession().getVista();
			vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
		}
	  }
	
	public void actionPerformed(ActionEvent ae) {
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
	    	    	
	    	if( nombreCombo.contains("cmbDtopais") || nombreCombo.contains("cmbDtoestado")
	    			 || nombreCombo.contains("cmbDtomunicipio")  || nombreCombo.contains("cmbDtoparroquia")){
	    		
	    		ComboBoxSelect cmbselect = new ComboBoxSelect();
	    		vistaZona vista=(vistaZona)this.getSession().getVista();
	    		
	    		if(nombreCombo.contains("cmbDtopais")){    			
	    			cmbselect.LlenarEstado(vista.getCmbdtopais(), vista.getCmbdtoestado());
	    		}else if( nombreCombo.contains("cmbDtoestado") ){
	    			cmbselect.LlenarMunicipio(vista.getCmbdtoestado(), vista.getCmbdtomunicipio());
	    		}else if( nombreCombo.contains("cmbDtomunicipio") ){
	    			cmbselect.LlenarParroquia(vista.getCmbdtomunicipio(), vista.getCmbdtoparroquia());
	    		}
	    	}    	
	    }
		
	  }

	@Override
	public String toString() {
		return "controladorZona";
	}
	
	  @Override
	  public void mouseClicked(MouseEvent e) {
	  	if (e.getClickCount() == 2) {
	          JTable target = (JTable)e.getSource();
	          int row = target.getSelectedRow();
	          this.getSession().setDtoActual(row,new Zona());
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

