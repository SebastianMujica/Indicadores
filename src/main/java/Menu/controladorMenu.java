package Menu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Menu.Menu;
import Menu.modeloMenu;
import Menu.vistaMenu;
import Maestro.Maestro;
import Maestro.vistaMaestro;
import SwingBernate.DtoBase;
import SwingBernate.ControladorBase;
import SwingBernate.ayudantes.ComboBox;
import SwingBernate.ayudantes.opcionListaCombo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class controladorMenu extends ControladorBase implements ActionListener, MouseListener,KeyListener {
	
	JDesktopPane desk;
	
	public controladorMenu(){
		//this.desk = d;
		vistaMenu vista=new vistaMenu(this);
		Menu dto=new Menu();
		this.iniciarSesion(vista,dto);
		
		/*modeloMenu modelo = new modeloMenu();
		List<DtoBase> listaMenu = modelo.buscar(dto);
		this.getSession().setListaDto(listaMenu);
		if(!listaMenu.isEmpty()){
			this.getSession().setActual(0);
			vista.setDto((Menu)listaMenu.get(0));
		}
		
		DefaultComboBoxModel modeloSubMenu = new DefaultComboBoxModel(modelo.buscarSubMenu(dto, false));
		vista.getCmbdtomenu().setModel(modeloSubMenu);*/
		this.actualizarVista();
		if (this.getSession().getListaDto().size()==0){
	    	vista.getCentro2().setVisible(false);
	    	vista.getCentro().setVisible(true);
	    }else{
	    	this.cambiarVista();
	    }
		this.getSession().getVista().getSimpleGrid().addMouseListener(this);
		this.cargarCmbShort(vista.getCmbintnivel(), vista.getCmbdtomenu());
		this.cargarCmbShort(vista.getCmbintpos_rel(), vista.getCmbdtomenu());
	}
	
	public void nuevo(){
		//vistaMenu vista=new vistaMenu(this);
		vistaMenu vista=(vistaMenu)this.getSession().getVista();
		vista.setDto(new Menu());
		this.cargarCmbShort(vista.getCmbintnivel(), vista.getCmbdtomenu());
		this.cargarCmbShort(vista.getCmbintpos_rel(), vista.getCmbdtomenu());
		if (vista.getCentro2().isVisible()){
	    	this.cambiarVista();
	    }
	    vista.limpiarError();
	    vista.getChkbolactivo().setSelected(true);
	}
	
	public void grabar(){
		vistaMenu vista=new vistaMenu(this);
		vista=(vistaMenu)this.getSession().getVista();
		String strlngid=vista.getTxtlngid().getText();
	    if (strlngid.isEmpty() || strlngid.length()==0){
	    	vista.mensageDialogo("error","Identificador vacío o inválido.\nÉste debe ser mayor o igual a cero." , vista.getTitle());
	    }else{
	    	Menu dto = new Menu();		
			dto.setHash(vista.getDto(dto));
	        List<String> lsError=this.testValidacion(dto);
	        if (lsError.isEmpty()) {
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
	    		if( dto.getDtomenu().getLngid()==0 )
	    			dto.setDtomenu(null);		
	    		
	    		dto.setIntnivel(((opcionListaCombo)vista.getCmbintnivel().getSelectedItem()).getId());
	    		dto.setIntpos_rel(((opcionListaCombo)vista.getCmbintpos_rel().getSelectedItem()).getId());
	  	      int intDialogo = vista.mensageDialogo("confirmar","¿Desea grabar los cambios?" , vista.getTitle());
	  	      if (JOptionPane.YES_OPTION == intDialogo){
	               modeloMenu modelo=new modeloMenu();
	               modelo.grabar(dto);
	               vista.mensageDialogo("informacion","Datos Grabados." , vista.getTitle());
	               vista.limpiarError();
	  	      }
	        }
	        else {
	           vista.marcarError(lsError);
	        }
	    }
	}
	
	public void eliminar(){
	    vistaMenu vista=new vistaMenu(this);
	    vista=(vistaMenu)this.getSession().getVista();
	    String strlngid=vista.getTxtlngid().getText();
	    if (strlngid.isEmpty() || strlngid.length()==0 || strlngid.trim().contentEquals("0")){
	    	vista.mensageDialogo("error","Identificador de Registro No Válido." , vista.getTitle());
	    }else{
	       if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?",vista.getTitle()) == 0) {
	    	 modeloMenu modelo=new modeloMenu();
	         modelo.eliminar(vista.getTxtlngid().getText().trim());
	       }
	    }
	  }
	  public void buscar(){
	    vistaMenu vista=new vistaMenu(this);
	    vista=(vistaMenu)this.getSession().getVista();
	    String str=vista.getTxtlngid().getText().trim();
	    if (str.isEmpty() || str.length()==0 || str.contentEquals("0")){
	       vista.mensageDialogo("error","Valor de búsqueda vacío o inválido.\nIntroduzca un número mayor que cero." , vista.getTitle());
	    }else{
	    	modeloMenu modelo=new modeloMenu();
	        Menu dto=new Menu();
	        dto=modelo.buscar(new Menu(),"lngid",str);
	        vista.setDto(dto);		
	    }
	  }
	public void refrescar(){
		vistaMenu vista=new vistaMenu(this);
		vista=(vistaMenu)this.getSession().getVista();
		vista.limpiarError();
		  if (this.getSession().getListaDto().size()>0){
			  this.actualizarVista();
		 	}else{
		 		vista.mensageDialogo("error","No Existen Datos que actualizar." , vista.getTitle());
		 	}
	  }
	public void siguiente(){
		vistaMenu vista=new vistaMenu(this);
		vista=(vistaMenu)this.getSession().getVista();
		int sig = this.getSession().getActual() + 1;
		if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(sig,new Maestro());
	    	if(sig<=this.getSession().getListaDto().size()){
	    		Menu dto = (Menu)this.getSession().getDto(sig);
				vista.setDto(dto);
				this.setearCmbShort(dto);	
			}
	 	}else{
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
	}
	
	public void anterior(){
		int ant = this.getSession().getActual() - 1;
		if (this.getSession().getListaDto().size()>0){
			this.getSession().setDtoActual(ant,new Menu());
			if(ant >=0){
				Menu dto = (Menu)this.getSession().getDto(ant);
				this.setearCmbShort(dto);
			}
	 	}else{
	 		vistaMenu vista=new vistaMenu(this);
	 		vista=(vistaMenu)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}	
		/*
		vistaMenu vista=new vistaMenu(this);
		vista=(vistaMenu)this.getSession().getVista();
		//vista.setDto((Menu)this.getSession().getDtoById(this.getSession().getActual()-1));
		Menu dto = (Menu)this.getSession().getDtoById(this.getSession().getActual()-1);
		vista.setDto(dto);
		//System.out.println("--> "+dto.getDtomenu());
		 * 
		 */
	}
	
	public void primero(){
		if (this.getSession().getListaDto().size()>0){
			this.getSession().setDtoActual(0,new Menu());
			Menu dto = (Menu)this.getSession().getDto(0);
			this.setearCmbShort(dto);
	 	}else{
	 		vistaMaestro vista=new vistaMaestro(this);
	 		vista=(vistaMaestro)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}		
	}
	
	public void ultimo(){
		if (this.getSession().getListaDto().size()>0){
			int ult = this.getSession().getListaDto().size() - 1;
			this.getSession().setDtoActual(ult,new Maestro());
			Menu dto = (Menu)this.getSession().getDto(ult);
			this.setearCmbShort(dto);
		}else{
				vistaMenu vista=new vistaMenu(this);
				vista=(vistaMenu)this.getSession().getVista();
				vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
			}
	}
	
	public void actualizarVista(){
		vistaMenu vista=(vistaMenu)this.getSession().getVista();
		Menu dto=new Menu();
		
		int i = this.getSession().getActual();
		
		modeloMenu modelo = new modeloMenu();
		List<DtoBase> listaMenu = modelo.buscar(dto);
		
		DefaultComboBoxModel modeloSubMenu = new DefaultComboBoxModel(modelo.buscarSubMenu(dto, false));
		vista.getCmbdtomenu().setModel(modeloSubMenu);
		
		this.getSession().setListaDto(listaMenu);
		if(!listaMenu.isEmpty()){
			this.getSession().setActual(i);
			vista.setDto((Menu)listaMenu.get(i));
		}
		this.cargarCmbShort(vista.getCmbintnivel(), vista.getCmbdtomenu());
		this.cargarCmbShort(vista.getCmbintpos_rel(), vista.getCmbdtomenu());
		this.cargarGrid();
	}
	
	public void cargarCmbShort(JComboBox cmbShort, ComboBox cmbpadre){
		opcionListaCombo opcion = new opcionListaCombo();
		if(cmbShort.getName().equals("cmbshrnivel"))
			opcion = new opcionListaCombo((short)1, "Nivel: "+1);
		else
			opcion = new opcionListaCombo((short)1, "Pos: "+1);
		List<opcionListaCombo> lstopcion = new ArrayList<opcionListaCombo>();
		if(cmbpadre.getSelectedItem().getClass().getCanonicalName().equals("SwingBernate.dtoVacio")){
			lstopcion.add(opcion);
			DefaultComboBoxModel shrotModelo = new DefaultComboBoxModel(lstopcion.toArray());
			cmbShort.setModel(shrotModelo);  
		}
	}
	public void cargarCmbShort(JComboBox cmbShort, List<opcionListaCombo> lista){
		DefaultComboBoxModel shrotModelo = new DefaultComboBoxModel(lista.toArray());
		cmbShort.setModel(shrotModelo);
		cmbShort.setSelectedIndex(lista.size()-1);
	}	
	public void setearCmbShort(Menu dtoM){
		vistaMenu vista = (vistaMenu)this.getSession().getVista();
		if(dtoM.getDtomenu()==null){
			//TODO
			this.cargarCmbShort(vista.getCmbintnivel(), vista.getCmbdtomenu());
			this.cargarCmbShort(vista.getCmbintpos_rel(), vista.getCmbdtomenu());
		}else{
			opcionListaCombo opcion = new opcionListaCombo(dtoM.getIntpos_rel(), "Pos: "+dtoM.getIntpos_rel());
			vista.getCmbintpos_rel().setSelectedItem(opcion);
		}
	}
	
	public void actionPerformed(  ActionEvent ae){
		System.out.println("Controlador Ventana "+ae.getActionCommand());
		if ("nuevo".equals(ae.getActionCommand()))     this.nuevo();
		if ("cambiarVista".equals(ae.getActionCommand()))     this.cambiarVista() ;
		if ("grabar".equals(ae.getActionCommand()))     this.grabar();
		if ("buscar".equals(ae.getActionCommand()))     this.buscar();
		if ("refrescar".equals(ae.getActionCommand()))     this.refrescar();
		if ("eliminar".equals(ae.getActionCommand()))     this.eliminar();
		if ("siguiente".equals(ae.getActionCommand()))     this.siguiente();
		if ("anterior".equals(ae.getActionCommand()))     this.anterior();
		if ("primero".equals(ae.getActionCommand()))     this.primero();
		if ("ultimo".equals(ae.getActionCommand()))     this.ultimo();
		if ("Salir".equals(ae.getActionCommand()))     this.terminarVista();
		if(ae.getSource().getClass().getName().equals("SwingBernate.ayudantes.ComboBox")){
			ComboBox cmbox = (ComboBox)ae.getSource();
						
			try {
								
				Menu selectMenu = (Menu)cmbox.getSelectedItem();
				int intNivel = 1;
				int nuHijos = 0;
				if(selectMenu.getLngid()!=0){				
					intNivel = selectMenu.getIntnivel()+1;
					nuHijos = selectMenu.getDtonodo().size();
				}else{
					modeloMenu modelo = new modeloMenu();
					nuHijos = modelo.buscarSubMenu(new Menu(), true).length-1;
				}
				
				opcionListaCombo optNivel_Pos = new opcionListaCombo((short)intNivel, "Nivel: "+intNivel);
				List<opcionListaCombo> lst = new ArrayList<opcionListaCombo>();
				lst.add(optNivel_Pos);
				this.cargarCmbShort(((vistaMenu)this.getSession().getVista()).getCmbintnivel(), lst);
				
				lst.clear();
				int i = 0;
				while (i <= nuHijos) {
					i ++;
					optNivel_Pos = new opcionListaCombo((short)i, "Pos: "+i);
					lst.add(optNivel_Pos);
				}
				this.cargarCmbShort(((vistaMenu)this.getSession().getVista()).getCmbintpos_rel(), lst);

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("seleccionó Vacio "+e.getMessage());
				//mainPrototipo principal = (mainPrototipo)((vistaMenu)this.getSession().getVista()).getParent().getParent().getParent().getParent().getParent();
				//System.out.println("HIJOSSSS.... "+principal.getProcesos().getChildCount());
			}    	
		}
	}
	
	  @Override
	  public void mouseClicked(MouseEvent e) {
	  	if (e.getClickCount() == 2) {
	          JTable target = (JTable)e.getSource();
	          int row = target.getSelectedRow();
	          this.getSession().setDtoActual(row,new Menu());
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