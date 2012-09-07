package Menu_Perfil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
import SwingBernate.ControladorBase;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Organizacion.modeloOrganizacion;
import Perfil.modeloPerfil;
import Menu.Menu;
import Menu.modeloMenu;
public class controladorMenu_Perfil extends ControladorBase implements ActionListener, MouseListener,KeyListener {

	public List<Menu> listaMenu = new ArrayList<Menu>();

	public controladorMenu_Perfil(){
		vistaMenu_Perfil vista=new vistaMenu_Perfil(this);
		Menu_Perfil dto=new Menu_Perfil();
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
		vistaMenu_Perfil vista=(vistaMenu_Perfil)this.getSession().getVista();
		Menu_Perfil dto=new Menu_Perfil();
		modeloMenu_Perfil modMenu_Perfil=new modeloMenu_Perfil();
		this.getSession().setListaDto(modMenu_Perfil.buscar(dto));
		modeloReporte modeloReporte=new modeloReporte();
		javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Menu_Perfil").toArray());
		vista.getImprimir().getTemplate().setModel(modeloComboReporte);
		modeloOrganizacion modeloOrganizacion=new modeloOrganizacion();
		javax.swing.DefaultComboBoxModel modeloComboOrganizacion=new javax.swing.DefaultComboBoxModel(modeloOrganizacion.buscarOrganizacions());
		vista.getCmbdto_org().setModel(modeloComboOrganizacion);
		modeloPerfil modeloPerfil=new modeloPerfil();
		javax.swing.DefaultComboBoxModel modeloComboPerfil=new javax.swing.DefaultComboBoxModel(modeloPerfil.buscarPerfils());
		vista.getCmbdtoperfil().setModel(modeloComboPerfil);
		modeloMenu modeloMenu=new modeloMenu();
		vista.getLstdto_menu().setModelDes(modeloMenu.buscarMenu());
		Menu[] arreglo = modeloMenu.buscarSubMenu(new Menu(), true);

		this.listaMenu.clear();

		for (int i = 0; i < arreglo.length; i++) {
			ordenarLstMenu(arreglo[i]);
		}

		Menu[] arreglo2 = new Menu[this.listaMenu.size()];
		int j=0;
		for (Menu menu : this.listaMenu) {
			arreglo2[j] = menu;
			j++;
		}

		vista.getTbldto_menu().setModelo(arreglo2);
		this.getSession().setDtoActual(0,dto);
		vista.marcarItemsMenu();
		this.cargarGrid();
	}
	public void nuevo(){
		vistaMenu_Perfil vista=new vistaMenu_Perfil(this);
		vista=(vistaMenu_Perfil)this.getSession().getVista();
		vista.setDto(new Menu_Perfil());
		vista.getTbldto_menu().desactivarTodos();
		if (vista.getCentro2().isVisible()){
	    	this.cambiarVista();
	    }
		vista.limpiarError();
		vista.getChkbolactivo().setSelected(true);
	}
	public void grabar(){
		vistaMenu_Perfil vista=new vistaMenu_Perfil(this);
		vista=(vistaMenu_Perfil)this.getSession().getVista();
		String strlngid=vista.getTxtlngid().getText();
		if (strlngid.isEmpty() || strlngid.length()==0){
			vista.mensageDialogo("error","Identificador vacío o inválido.\nÉste debe ser mayor o igual a cero." , vista.getTitle());
		}else{
			Menu_Perfil dto=new Menu_Perfil();
			dto.setHash(vista.getDto(dto));
			this.getSession().setUsuarioInicio(vista);
			List<String> lsError=this.testValidacion(dto);
			dto.setDto_menu(this.lstSeleccion(vista));
			vista.getLstdto_menu().setSelected(dto.getDto_menu());
			
			if (lsError.isEmpty()) {
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
	        		dto.setBolactivo(true);
	        	}else{
	        		dto.setStrip_modificacion(this.obtenerIpHost());
	        		dto.setStrhost_modificacion(this.obtenerNombreHost());
	        		dto.setDtmfecha_modificacion(new Date());
	        		dto.setLngseg_usuario_modificacion(this.getSession().getLngusr());
	        	}
	            if(dto.getDto_menu().isEmpty()){
					vista.mensageDialogo("error","Por favor seleccione al menos Una opción de Menú",vista.getTitle());
				}else{
					int intDialogo = vista.mensageDialogo("confirmar","¿Desea grabar los cambios?" , vista.getTitle());
					if (JOptionPane.YES_OPTION == intDialogo){
						modeloMenu_Perfil modelo=new modeloMenu_Perfil();					
							modelo.grabar(dto);
							vista.mensageDialogo("informacion","Datos Grabados." , vista.getTitle());
							vista.limpiarError();
					}
				}
			}
			else {
				vista.marcarError(lsError);
			}
		}
	}
	public void eliminar(){
		vistaMenu_Perfil vista=new vistaMenu_Perfil(this);
		vista=(vistaMenu_Perfil)this.getSession().getVista();
		String strlngid=vista.getTxtlngid().getText();
		if (strlngid.isEmpty() || strlngid.length()==0 || strlngid.trim().contentEquals("0")){
			vista.mensageDialogo("error","Identificador de Registro No Válido." , vista.getTitle());
		}else{
			if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?",vista.getTitle()) == 0) {
				modeloMenu_Perfil modelo=new modeloMenu_Perfil();
				modelo.eliminar(vista.getTxtlngid().getText().trim());
			}
		}
	}
	public void buscar(){
		vistaMenu_Perfil vista=new vistaMenu_Perfil(this);
		vista=(vistaMenu_Perfil)this.getSession().getVista();
		String str=vista.getTxtlngid().getText().trim();
		if (str.isEmpty() || str.length()==0 || str.contentEquals("0")){
			vista.mensageDialogo("error","Valor de búsqueda vacío o inválido.\nIntroduzca un número mayor que cero." , vista.getTitle());
		}else{
			modeloMenu_Perfil modelo=new modeloMenu_Perfil();
			Menu_Perfil dto=new Menu_Perfil();
			dto=modelo.buscarMenu_Perfil(new Menu_Perfil(),"lngid",str);
			vista.setDto(dto);		
		}
	}
	public void refrescar(){
		vistaMenu_Perfil vista=new vistaMenu_Perfil(this);
		vista=(vistaMenu_Perfil)this.getSession().getVista();
		vista.limpiarError();
		if (this.getSession().getListaDto().size()>0){
			this.actualizarVista();
		}else{
			vista.mensageDialogo("error","No Existen Datos que actualizar." , vista.getTitle());
		}
	}
	public void siguiente(){
		if (this.getSession().getListaDto().size()>0){
			this.getSession().setDtoActual(this.getSession().getActual() + 1,new Menu_Perfil());
		}else{
			vistaMenu_Perfil vista=new vistaMenu_Perfil(this);
			vista=(vistaMenu_Perfil)this.getSession().getVista();
			vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
		}
	}
	public void anterior(){
		if (this.getSession().getListaDto().size()>0){
			this.getSession().setDtoActual(this.getSession().getActual() - 1,new Menu_Perfil());
		}else{
			vistaMenu_Perfil vista=new vistaMenu_Perfil(this);
			vista=(vistaMenu_Perfil)this.getSession().getVista();
			vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
		}
	}
	public void primero(){
		if (this.getSession().getListaDto().size()>0){
			this.getSession().setDtoActual(0,new Menu_Perfil());
		}else{
			vistaMenu_Perfil vista=new vistaMenu_Perfil(this);
			vista=(vistaMenu_Perfil)this.getSession().getVista();
			vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
		}
	}
	public void ultimo(){
		if (this.getSession().getListaDto().size()>0){
			this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Menu_Perfil());
		}else{
			vistaMenu_Perfil vista=new vistaMenu_Perfil(this);
			vista=(vistaMenu_Perfil)this.getSession().getVista();
			vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
		}
	}	public void actionPerformed(  ActionEvent ae){
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
	}

	public void ordenarLstMenu(Menu menu){
		this.listaMenu.add(menu);
		List<Menu> hijoMn = menu.getDtonodo();
		Collections.sort(hijoMn, Menu.ComparaNivelMenu);
		for (Menu dtoM : menu.getDtonodo()) {
			ordenarLstMenu(dtoM);
		}
	}

	public List<Menu> lstSeleccion(vistaMenu_Perfil vista){
		List<Menu> lst = new ArrayList<Menu>();
		JTable tabla = vista.getTbldto_menu().getTablaMenu();

		for (int i = 1; i < tabla.getRowCount(); i++) {
			boolean sel = (Boolean)tabla.getValueAt(i, 0);
			Menu menuSel = (Menu)tabla.getValueAt(i, 1);
			if(sel && (!menuSel.getStrpaquete().trim().isEmpty()))
				lst.add(menuSel);
		}

		return lst;
	}

	public void mouseClicked(  MouseEvent e){
		if (e.getClickCount() == 2) {
			JTable target=(JTable)e.getSource();
			int row=target.getSelectedRow();
			this.getSession().setDtoActual(row,new Menu_Perfil());
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

