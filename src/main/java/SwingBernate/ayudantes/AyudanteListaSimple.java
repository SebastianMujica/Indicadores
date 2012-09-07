package SwingBernate.ayudantes;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import SwingBernate.DtoBase;
import SwingBernate.BasicWindowMonitor;
import java.util.List;

public class AyudanteListaSimple extends JPanel {
	String listaV[]={"elemento1","elemento2","elemento3"};
	JList list=new JList(listaV);
	public AyudanteListaSimple(){}

	public AyudanteListaSimple(ActionListener al,DtoBase lista[]) {
		this.setLayout(new BorderLayout());
		//this.list = new JList(this.listaV);
		JScrollPane pane = new JScrollPane(list);
		add(pane, BorderLayout.CENTER);
	
	}
	
}



