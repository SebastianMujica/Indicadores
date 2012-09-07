package Perfil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ControladorBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Perfil.Perfil;
import Perfil.modeloPerfil;
import Perfil.vistaPerfil;
import Menu.Menu;
import Menu.modeloMenu;
import Organizacion.modeloOrganizacion;

public class controladorPerfil extends ControladorBase implements ActionListener, MouseListener,KeyListener {

	public List<Menu> listaMenu = new ArrayList<Menu>();

	public controladorPerfil(){
		vistaPerfil vista=new vistaPerfil(this);
		Perfil dto=new Perfil();
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
		vistaPerfil vista=(vistaPerfil)this.getSession().getVista();
		Perfil dto=new Perfil();
		modeloPerfil modPerfil=new modeloPerfil();
		this.getSession().setListaDto(modPerfil.buscar(dto));
		modeloReporte modeloReporte=new modeloReporte();
		javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Perfil").toArray());
		vista.getImprimir().getTemplate().setModel(modeloComboReporte);
		modeloOrganizacion modeloOrganizacion=new modeloOrganizacion();
		javax.swing.DefaultComboBoxModel modeloComboOrganizacion=new javax.swing.DefaultComboBoxModel(modeloOrganizacion.buscarOrganizacions());
		vista.getCmbdto_org().setModel(modeloComboOrganizacion);
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
		vistaPerfil vista=new vistaPerfil(this);
		vista=(vistaPerfil)this.getSession().getVista();
		vista.setDto(new Perfil());
		if (vista.getCentro2().isVisible()){
			this.cambiarVista();
		}
		vista.limpiarError();
		vista.getChkbolactivo().setSelected(true);
		vista.getTbldto_menu().desactivarTodos();
	}
	public void grabar(){
		vistaPerfil vista=new vistaPerfil(this);
		vista=(vistaPerfil)this.getSession().getVista();
		String strlngid=vista.getTxtlngid().getText();

		if (strlngid.isEmpty() || strlngid.length()==0){
			vista.mensageDialogo("error","Identificador vacío o inválido.\nÉste debe ser mayor o igual a cero." , vista.getTitle());
		}else{
			Perfil dto=new Perfil();
			dto.setHash(vista.getDto(dto));
			
			dto.setDto_menu(this.lstSeleccion(vista));
			vista.getLstdto_menu().setSelected(dto.getDto_menu());
			
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
					modeloPerfil modelo=new modeloPerfil();
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
		vistaPerfil vista=new vistaPerfil(this);
		vista=(vistaPerfil)this.getSession().getVista();
		String strlngid=vista.getTxtlngid().getText();
		if (strlngid.isEmpty() || strlngid.length()==0 || strlngid.trim().contentEquals("0")){
			vista.mensageDialogo("error","Identificador de Registro No Válido." , vista.getTitle());
		}else{
			if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?",vista.getTitle()) == 0) {
				modeloPerfil modelo=new modeloPerfil();
				modelo.eliminar(vista.getTxtlngid().getText().trim());
			}
		}
	}
	public void buscar(){
		vistaPerfil vista=new vistaPerfil(this);
		vista=(vistaPerfil)this.getSession().getVista();
		String str=vista.getTxtlngid().getText().trim();
		if (str.isEmpty() || str.length()==0 || str.contentEquals("0")){
			vista.mensageDialogo("error","Valor de búsqueda vacío o inválido.\nIntroduzca un número mayor que cero." , vista.getTitle());
		}else{
			modeloPerfil modelo=new modeloPerfil();
			Perfil dto=new Perfil();
			dto=modelo.buscarPerfil(new Perfil(),"lngid",str);
			vista.setDto(dto);		
		}
	}
	public void refrescar(){
		vistaPerfil vista=new vistaPerfil(this);
		vista=(vistaPerfil)this.getSession().getVista();
		vista.limpiarError();
		if (this.getSession().getListaDto().size()>0){
			this.actualizarVista();
		}else{
			vista.mensageDialogo("error","No Existen Datos que actualizar." , vista.getTitle());
		}
	}
	public void siguiente(){
		if (this.getSession().getListaDto().size()>0){
			this.getSession().setDtoActual(this.getSession().getActual() + 1,new Perfil());
			vistaPerfil vista=(vistaPerfil)this.getSession().getVista();
			vista.marcarItemsMenu();
		}else{
			vistaPerfil vista=new vistaPerfil(this);
			vista=(vistaPerfil)this.getSession().getVista();
			vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
		}
	}
	public void anterior(){
		if (this.getSession().getListaDto().size()>0){
			this.getSession().setDtoActual(this.getSession().getActual() - 1,new Perfil());
			vistaPerfil vista=(vistaPerfil)this.getSession().getVista();
			vista.marcarItemsMenu();
		}else{
			vistaPerfil vista=new vistaPerfil(this);
			vista=(vistaPerfil)this.getSession().getVista();
			vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
		}
	}
	public void primero(){
		if (this.getSession().getListaDto().size()>0){
			this.getSession().setDtoActual(0,new Perfil());
			vistaPerfil vista=(vistaPerfil)this.getSession().getVista();
			vista.marcarItemsMenu();
		}else{
			vistaPerfil vista=new vistaPerfil(this);
			vista=(vistaPerfil)this.getSession().getVista();
			vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
		}
	}
	public void ultimo(){
		if (this.getSession().getListaDto().size()>0){
			this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Perfil());
			vistaPerfil vista=(vistaPerfil)this.getSession().getVista();
			vista.marcarItemsMenu();
		}else{
			vistaPerfil vista=new vistaPerfil(this);
			vista=(vistaPerfil)this.getSession().getVista();
			vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
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
	}
	public void mouseClicked(  MouseEvent e){
		if (e.getClickCount() == 2) {
			JTable target=(JTable)e.getSource();
			int row=target.getSelectedRow();
			this.getSession().setDtoActual(row,new Perfil());
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
	
	public void ordenarLstMenu(Menu menu){
		this.listaMenu.add(menu);
		List<Menu> hijoMn = menu.getDtonodo();
		Collections.sort(hijoMn, Menu.ComparaNivelMenu);
		for (Menu dtoM : menu.getDtonodo()) {
			ordenarLstMenu(dtoM);
		}
	}

	public List<Menu> lstSeleccion(vistaPerfil vista){
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
}
