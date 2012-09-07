package Login;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import SwingBernate.MainDesktopSwingBernate;
import SwingBernate.StringEncrypter;
import Usuario.Usuario;
import Usuario.modeloUsuario;


public class controladorLogin implements ActionListener{
	
	private Component padre;
	private vistaLogin vista = new vistaLogin(this);
	private int intentos = 0;
	private Usuario usr = new Usuario();
	
	public controladorLogin(Component p){
		try{
			//vistaLogin vista = new vistaLogin(this);
			padre = p;
			vista.setLocationRelativeTo(null);
			vista.setVisible(true);
		}catch(Exception e){
			System.out.println("error al iniciar login: "+e.getMessage());
		}
		
	}
	
	public vistaLogin getVista(){
		return this.vista;
	}
	
	public void aceptar(){
		String usuario = this.vista.getTxtstrusuario().getText();
		String passwd = this.vista.getTxtstrpassword().getText();
		String mensaje = "";
		String titulo = "";
		MainDesktopSwingBernate escritorio;
		
		//this.setUsr(null);
						
		if( usuario.isEmpty() || passwd.isEmpty() ){
			titulo = "Datos inválidos";
			mensaje = "Los datos de ingreso no pueden ser vacios";
			JOptionPane.showMessageDialog(this.vista,mensaje,titulo,JOptionPane.ERROR_MESSAGE);
		}else{
			
			Usuario usrLogin = compararUsuario1(usuario,passwd);
			//Usuario usrLogin = new Usuario();
			if( usrLogin != null ){
				this.vista.dispose();
				escritorio = (MainDesktopSwingBernate)this.padre;
				
				JLabel label = new JLabel();
				label = (JLabel)escritorio.getCentro().getComponent(0);
				label.setText("Usuario Conectado: "+ usrLogin.getDtosocio());
				this.setUsr(usrLogin);
				
			}else{
				this.intentos++;
				if(this.intentos>=3){
					titulo = "Salida del Sistema";
					mensaje = "Excedió el límite de intentos, del Sistema se cerrará inmediatamente!";
					JOptionPane.showMessageDialog(this.vista,mensaje,titulo,JOptionPane.ERROR_MESSAGE);
					this.cancelar();
				}else{
					titulo = "Datos Inválidos";
					mensaje = "Por favor verifíque su Usuario y/o Password. Le quedan "+(3-this.intentos)+" intentos";
					JOptionPane.showMessageDialog(this.vista,mensaje,titulo,JOptionPane.WARNING_MESSAGE);
					this.vista.getTxtstrusuario().requestFocus();
				}
			}	
		}
	}
	
	private Usuario compararUsuario(String login, String passwd){
		Usuario dtoUsuario = null;
		
		modeloUsuario modusuario = new modeloUsuario();
		Usuario[] arrUsuario = modusuario.buscarUsuarios();
		String clave = new String("");		
		SecretKey desKey;
		
		try {
			desKey = KeyGenerator.getInstance("DES").generateKey();
			StringEncrypter desEncrypter = new StringEncrypter(desKey, desKey.getAlgorithm());
			
			if(arrUsuario!=null){
				for (int i = 0; i < arrUsuario.length; i++) {
					
					String sEncrip = arrUsuario[i].getStrpassword();
					//System.out.println(arrUsuario[i].getStrusername()+ "  Passwd Encriptado  "+sEncrip);
					
					clave = desEncrypter.decrypt(sEncrip);
					if(login.equals(arrUsuario[i].getStrusername()) &&
							passwd.equals(clave)){
						dtoUsuario = arrUsuario[i];
						dtoUsuario.setDtmfecha_ultimologin(new Date());
						modusuario.grabar(dtoUsuario);
						i = arrUsuario.length;
					}
				}
			}			
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return dtoUsuario;
	}
	
	private Usuario compararUsuario1(String login, String passwd){
		Usuario dtoUsuario = null;
		
		modeloUsuario modusuario = new modeloUsuario();
		dtoUsuario = modusuario.buscarLogin1(login, passwd);
		if(dtoUsuario != null){
			dtoUsuario.setDtmfecha_ultimologin(new Date());
			modusuario.grabar(dtoUsuario);
		}
		return dtoUsuario;
	}
	
	public void cancelar(){
		this.vista.dispose();
		System.runFinalization();
		System.exit(0);
	}
	
	public Usuario getUsr() {
		return usr;
	}

	public void setUsr(Usuario usr) {
		this.usr = usr;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		System.out.println("Controlador Login ");
		if ("Cancelar".equals(ae.getActionCommand())){
			this.cancelar();
		}else if ("Aceptar".equals(ae.getActionCommand())){
			this.aceptar();
		}
	}

}
