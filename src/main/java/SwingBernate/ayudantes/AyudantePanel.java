package SwingBernate.ayudantes;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class AyudantePanel extends JPanel {
	
	String titulo="Sin-Titulo";
	GridBagConstraints c = new GridBagConstraints();
	TitledBorder miTitulo;
	Border blackline;
	
	public AyudantePanel(String titulo){
		blackline = BorderFactory.createLineBorder(Color.black);
		miTitulo = BorderFactory.createTitledBorder(blackline, titulo);
		this.setBorder(miTitulo);
		this.setLayout(new GridBagLayout());
		//this.setBounds(0, 0, 400, 400);		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		blackline = BorderFactory.createLineBorder(Color.black);
		miTitulo = BorderFactory.createTitledBorder(blackline, titulo);
		this.setBorder(miTitulo);
	}
	
	public void agergarComponete(List<Object> objetos){
		
		int contLabel = 0;
		int JTextField = 0;
		int JDateChooser = 0;
		int JTextArea = 0;
		int x  = 0;
		int y  = 0;
		
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		for (Object obj : objetos) {
			
			c.gridheight= 1;
			c.gridwidth = 1;
			
			Class<?> clazz = obj.getClass();
			
			if (clazz == JLabel.class){
				x = 0;
				c.gridx = x;
				c.gridy = y;
				this.add((JLabel)obj,c);
				x++;
			}else if (clazz == JTextField.class){
				c.gridx = x;
				c.gridy = y;
				this.add((JTextField)obj,c);
				x = 0;
				y++;
			}else if (clazz == JDateChooser.class){
				c.gridx = x;
				c.gridy = y;
				this.add((JDateChooser)obj,c);
				x = 0;
				y++;
			}else if (clazz == JTextArea.class){
				c.gridx = x;
				c.gridy = y;
				c.gridheight= 2;
				c.gridwidth = 2;
				this.add((JTextArea)obj,c);
				x = 0;
				y = y+2;
			}
			
		}		
	}
	
	public void removerAll(){
		this.removeAll();
	}

}
