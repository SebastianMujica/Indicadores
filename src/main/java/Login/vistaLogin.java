package Login;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class vistaLogin extends JDialog implements KeyListener {
	
	JLabel     lblstrusuario   = new JLabel("Usuario:");
	JTextField txtstrusuario   = new JTextField(10);
	JLabel     lblstrpassword   = new JLabel("Password:");
	JPasswordField txtstrpassword = new JPasswordField(10);
	JButton btnaceptar = new JButton("Aceptar");
	JButton btncancelar = new JButton("Cancelar");
	GridBagConstraints c = new GridBagConstraints();
	controladorLogin ctrl;
	
	public vistaLogin(ActionListener controlador){
		
		this.ctrl = (controladorLogin)controlador;
		this.txtstrusuario.addActionListener(controlador);
		this.txtstrpassword.addActionListener(controlador);
		this.btnaceptar.addActionListener(controlador);
		this.btncancelar.addActionListener(controlador);
		
		this.txtstrusuario.addKeyListener(this);
		this.txtstrpassword.addKeyListener(this);
		
		this.setLayout(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 0;
		c.anchor=c.EAST;
		this.add(lblstrusuario, c);
		c.gridx = 1;
		c.gridy = 0;
		c.anchor=c.WEST;
		this.add(txtstrusuario, c);
		c.gridx = 0;
		c.gridy = 1;
		c.anchor=c.EAST;
		this.add(lblstrpassword, c);
		c.gridx = 1;
		c.gridy = 1;
		c.anchor=c.WEST;
		this.add(txtstrpassword, c);
		c.gridx = 1;
		c.gridy = 2;
		c.anchor=c.CENTER;
		this.add(btnaceptar, c);
		c.gridx = 2;
		c.gridy = 2;
		c.anchor=c.CENTER;
		this.add(btncancelar, c);
		
		
		this.setTitle("Acceso");		
		this.setSize(350,150);
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setModal(true);
	}

	public JLabel getLblstrusuario() {
		return lblstrusuario;
	}

	public void setLblstrusuario(JLabel lblstrusuario) {
		this.lblstrusuario = lblstrusuario;
	}

	public JTextField getTxtstrusuario() {
		return txtstrusuario;
	}

	public void setTxtstrusuario(JTextField txtstrusuario) {
		this.txtstrusuario = txtstrusuario;
	}

	public JLabel getLblstrpassword() {
		return lblstrpassword;
	}

	public void setLblstrpassword(JLabel lblstrpassword) {
		this.lblstrpassword = lblstrpassword;
	}

	public JPasswordField getTxtstrpassword() {
		return txtstrpassword;
	}

	public void setTxtstrpassword(JPasswordField txtstrpassword) {
		this.txtstrpassword = txtstrpassword;
	}

	public JButton getBtnaceptar() {
		return btnaceptar;
	}

	public void setBtnaceptar(JButton btnaceptar) {
		this.btnaceptar = btnaceptar;
	}

	public JButton getBtncancelar() {
		return btncancelar;
	}

	public void setBtncancelar(JButton btncancelar) {
		this.btncancelar = btncancelar;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if( (e.getSource().getClass() == JPasswordField.class) && (e.getKeyCode() ==10) ){
			this.ctrl.aceptar();
		}else if( (e.getSource().getClass() == JTextField.class) && (e.getKeyCode() ==10) ){
			if(this.getTxtstrusuario().getText().compareTo("") != 0 )
				this.getTxtstrusuario().requestFocus(true);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
