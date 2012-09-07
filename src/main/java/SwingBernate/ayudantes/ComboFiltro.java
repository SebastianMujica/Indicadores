package SwingBernate.ayudantes;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class ComboFiltro<T> extends JComboBox implements ActionListener, KeyListener{
	
	private DefaultComboBoxModel modelCombo = new DefaultComboBoxModel();
	private DefaultComboBoxModel modelComboFiltro = new DefaultComboBoxModel();
	List<T> lsModelCombo = new ArrayList<T>();
	List<T> lsModelComboFiltro = new ArrayList<T>();
	
	public ComboFiltro(){
		this.setEditable(true);
		this.setMaximumRowCount(4);
		this.addActionListener(this);
		this.getEditor().getEditorComponent().addKeyListener(this);
	}
	
	public ComboFiltro(List<T> lista){
		this.setEditable(true);
		this.setMaximumRowCount(4);
		this.setModelCombo(lista);
		this.addActionListener(this);
	}
	
	public void setModelCombo(List<T> lista){
		for (T t : lista) {
			this.modelCombo.addElement(t);
		}
		this.setModel(modelCombo);
	}
	
	public void setModelComboFiltro(List<T> lista){
		this.modelComboFiltro.removeAllElements();
		for (T t : lista) {
			this.modelComboFiltro.addElement(t);
		}
		this.setModel(modelComboFiltro);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent ev) {
		// TODO Auto-generated method stub
		 
		if((ev.getKeyCode() == 10) && (this.getEditor().getItem().toString().length()>=3)){
			String strBuscar = this.getEditor().getItem().toString().toLowerCase();
			this.lsModelComboFiltro.clear();			
			if(this.modelCombo.getSize()>0){				
				for (int i = 0; i < this.modelCombo.getSize(); i++) {
					String strBase = this.modelCombo.getElementAt(i).toString().toLowerCase();
					if(strBase.indexOf(strBuscar) != -1){
						lsModelComboFiltro.add((T)this.modelCombo.getElementAt(i));
					}
				}
				this.setModelComboFiltro(lsModelComboFiltro);
				this.setPopupVisible(true);
			}
		}else{
			this.setModel(this.modelCombo);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
