package Meta_Org;
import java.util.Date;
import java.util.List;

import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ControladorBase;
import SwingBernate.DtoBase;
import SwingBernate.dtoVacio;
import SwingBernate.ayudantes.ComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import Meta_Org.Meta_Org;
import Meta_Org.modeloMeta_Org;
import Meta_Org.vistaMeta_Org;
import Indicador.captura;
import Indicador.modeloIndicador;
import Organizacion.Organizacion;
import Organizacion.modeloOrganizacion;
import Periodo.Periodo;
import Periodo.modeloPeriodo;
public class controladorMeta_Org extends ControladorBase implements ActionListener, MouseListener {
	
	public controladorMeta_Org(){
		vistaMeta_Org vista=new vistaMeta_Org(this);
		Meta_Org dto=new Meta_Org();
		this.iniciarSesion(vista,dto);
		this.actualizarVista();
		this.getSession().getVista().getSimpleGrid().addMouseListener(this);
		if (this.getSession().getListaDto().size()==0){
	    	vista.getCentro2().setVisible(false);
	    	vista.getCentro().setVisible(true);
	    }else{
	    	this.cambiarVista();
	    }
	}
	public void actualizarVista(){
		vistaMeta_Org vista=(vistaMeta_Org)this.getSession().getVista();
		Meta_Org dto=new Meta_Org();
		modeloMeta_Org modMeta_Org=new modeloMeta_Org();
		this.getSession().setListaDto(modMeta_Org.buscar(dto));
		modeloReporte modeloReporte=new modeloReporte();
		javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Meta_Org").toArray());
		vista.getImprimir().getTemplate().setModel(modeloComboReporte);
		modeloOrganizacion modeloOrganizacion=new modeloOrganizacion();
		javax.swing.DefaultComboBoxModel modeloComboOrganizacion=new javax.swing.DefaultComboBoxModel(modeloOrganizacion.buscarOrganizacions());
		vista.getCmbdtoorganizacion().setModelo(modeloComboOrganizacion);
		modeloIndicador modeloIndicador=new modeloIndicador();
		javax.swing.DefaultComboBoxModel modeloComboIndicador=new javax.swing.DefaultComboBoxModel(modeloIndicador.buscarIndicadors());
		vista.getCmbdtoindicador().setModelo(modeloComboIndicador);
		//modeloPeriodo modeloPeriodo=new modeloPeriodo();
		//javax.swing.DefaultComboBoxModel modeloComboPeriodo=new javax.swing.DefaultComboBoxModel(modeloPeriodo.buscarPeriodos());
		//vista.getCmbdtoperiodo().setModelo(modeloComboPeriodo);
		this.getSession().setDtoActual(0,dto);
		this.cargarGrid();
	}
	public void nuevo(){
		vistaMeta_Org vista=new vistaMeta_Org(this);
		vista=(vistaMeta_Org)this.getSession().getVista();
		vista.setDto(new Meta_Org());
		if (vista.getCentro2().isVisible()){
	    	this.cambiarVista();
	    }
	    vista.limpiarError();
	    vista.getChkbolactivo().setSelected(true);
	}
	public void grabar(){
		vistaMeta_Org vista=new vistaMeta_Org(this);
		vista=(vistaMeta_Org)this.getSession().getVista();
		String strlngid=vista.getTxtlngid().getText();
	    if (strlngid.isEmpty() || strlngid.length()==0){
	    	vista.mensageDialogo("error","Identificador vacío o inválido.\nÉste debe ser mayor o igual a cero." , vista.getTitle());
	    }else{
	    	Meta_Org dto=new Meta_Org();
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
	               modeloMeta_Org modelo=new modeloMeta_Org();
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
		vistaMeta_Org vista=new vistaMeta_Org(this);
		vista=(vistaMeta_Org)this.getSession().getVista();
		String strlngid=vista.getTxtlngid().getText();
	    if (strlngid.isEmpty() || strlngid.length()==0 || strlngid.trim().contentEquals("0")){
	    	vista.mensageDialogo("error","Identificador de Registro No Válido." , vista.getTitle());
	    }else{
	       if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?",vista.getTitle()) == 0) {
	    	 modeloMeta_Org modelo=new modeloMeta_Org();
	         modelo.eliminar(vista.getTxtlngid().getText().trim());
	       }
	    }
	}
	public void buscar(){
		vistaMeta_Org vista=new vistaMeta_Org(this);
		vista=(vistaMeta_Org)this.getSession().getVista();
		String str=vista.getTxtlngid().getText().trim();
	    if (str.isEmpty() || str.length()==0 || str.contentEquals("0")){
	       vista.mensageDialogo("error","Valor de búsqueda vacío o inválido.\nIntroduzca un número mayor que cero." , vista.getTitle());
	    }else{
	    	modeloMeta_Org modelo=new modeloMeta_Org();
	        Meta_Org dto=new Meta_Org();
	        dto=modelo.buscarMeta_Org(new Meta_Org(),"lngid",str);
	        vista.setDto(dto);		
	    }
	}
	public void refrescar(){
		  vistaMeta_Org vista=new vistaMeta_Org(this);
		  vista=(vistaMeta_Org)this.getSession().getVista();
		  vista.limpiarError();
		  if (this.getSession().getListaDto().size()>0){
			  this.actualizarVista();
		 	}else{
		 		vista.mensageDialogo("error","No Existen Datos que actualizar." , vista.getTitle());
		 	}
	  }
	public void siguiente(){
		if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(this.getSession().getActual() + 1,new Meta_Org());
	 	}else{
	 		vistaMeta_Org vista=new vistaMeta_Org(this);
	 		vista=(vistaMeta_Org)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
	}
	public void anterior(){
		if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(this.getSession().getActual() - 1,new Meta_Org());
	 	}else{
	 		vistaMeta_Org vista=new vistaMeta_Org(this);
	 		vista=(vistaMeta_Org)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
	}
	public void primero(){
		if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(0,new Meta_Org());
	 	}else{
	 		vistaMeta_Org vista=new vistaMeta_Org(this);
	 		vista=(vistaMeta_Org)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
	}
	public void ultimo(){
		if (this.getSession().getListaDto().size()>0){
		       this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Meta_Org());
			}else{
				vistaMeta_Org vista=new vistaMeta_Org(this);
				vista=(vistaMeta_Org)this.getSession().getVista();
				vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
			}
	}
	public void procesarComboOrg(){
		vistaMeta_Org vista=(vistaMeta_Org)this.getSession().getVista();
	if (vista.isShowing()){
		if (vista.getCmbdtoorganizacion().getSelectedIndex()>0)
		{
			Organizacion org=(Organizacion)vista.getCmbdtoorganizacion().getSelectedItem();
			modeloPeriodo modeloperiodo=new modeloPeriodo();
			Criterion[] arrCriterios=new Criterion[1];
			arrCriterios[0]=Restrictions.eq("dtoorganizacion", org);
			//arrCriterios[1]=Restrictions.eq("bolactivo", true);
		    //List<DtoBase> lis=modeloperiodo.buscar(new Periodo(), "dto_org",org);
			List<DtoBase> lis=modeloperiodo.buscar(new Periodo(),arrCriterios);
		    if (lis.size()>0){
		    	Periodo[] arreglo=new Periodo[lis.size()];
		        for (int i=0; i < lis.size(); i++)     arreglo[i]=(Periodo)lis.get(i);
		        javax.swing.DefaultComboBoxModel modeloComboPeriodo=new javax.swing.DefaultComboBoxModel(arreglo);
		        vista.getCmbdtoperiodo().setModelo(modeloComboPeriodo);
		    }else{
		    	Periodo[] arreglo=new Periodo[0];
		    	javax.swing.DefaultComboBoxModel modeloComboPeriodo=new javax.swing.DefaultComboBoxModel(arreglo);
		        vista.getCmbdtoperiodo().setModelo(modeloComboPeriodo);
			    vista.mensageDialogo("informacion","No se encontraron periodos activos para: " + org.getStrnombre()+"." , vista.getTitle());
		    }
		}else{
			Periodo[] arreglo=new Periodo[0];
	    	javax.swing.DefaultComboBoxModel modeloComboPeriodo=new javax.swing.DefaultComboBoxModel(arreglo);
	        vista.getCmbdtoperiodo().setModelo(modeloComboPeriodo);
		}	
	}	
	}//Fin de procesarComboOrg()
	public void procesarcmb_periodo(){
		vistaMeta_Org vista=(vistaMeta_Org)this.getSession().getVista();
		if (vista.getCmbdtoperiodo().getItemCount()>1 && vista.getCmbdtoperiodo().getSelectedIndex()>0){
			Periodo periodo = (Periodo)vista.getCmbdtoperiodo().getSelectedItem();
			Date dtmini_periodo=periodo.getDtmvalido_desde();
			Date dtmfin_periodo=periodo.getDtmvalido_hasta();
			vista.getDchdtmvalido_desde().setMinSelectableDate(dtmini_periodo);
			vista.getDchdtmvalido_hasta().setMaxSelectableDate(dtmfin_periodo);
			//if (vista.getTxtlngid().getText().trim().equals("0")){
				vista.getDchdtmvalido_desde().setDate(dtmini_periodo);
				vista.getDchdtmvalido_hasta().setDate(dtmfin_periodo);
			//}
		}
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
	    	ComboBox objcmb = (ComboBox)ae.getSource();
	    	System.out.println("Nombre Combo "+objcmb.getName());
	    	if (objcmb.getName().equals("cmbdtoorganizacion")){
	    		procesarComboOrg();
	    	}else if (objcmb.getName().equals("cmbdtoperiodo")){
	    		procesarcmb_periodo();
	    	}
	    }
	}
	public void mouseClicked(  MouseEvent e){
		if (e.getClickCount() == 2) {
			JTable target=(JTable)e.getSource();
			int row=target.getSelectedRow();
			this.getSession().setDtoActual(row,new Meta_Org());
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

