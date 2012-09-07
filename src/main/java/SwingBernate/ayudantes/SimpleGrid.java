package SwingBernate.ayudantes;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import SwingBernate.DtoBase;

public class SimpleGrid extends JTable  {

public SimpleGrid(AbstractTableModel arg0){
	this.setModel(arg0);
}

public void setDatos(List<DtoBase> datos){
	for (Iterator iterator = datos.iterator(); iterator.hasNext();) {
		DtoBase dtoBase = (DtoBase) iterator.next();
		this.agregarDto(dtoBase);
	}
}
public void agregarDto(DtoBase dto){
SimpleGridModel modelo=(SimpleGridModel)this.getModel();

}
public void setSelected(int a){
	if (this.getRowCount()>0){
	if ((a<=this.getRowCount())&&(a>=0))
	{
		this.setRowSelectionInterval(a,a);
		}
	else{
		
	}
	}
}
public void setAnchoColumnas(){        
    JViewport scroll =  (JViewport) this.getParent(); 
    int ancho = scroll.getWidth(); 
    int anchoColumna = 0; 
    TableColumnModel modeloColumna = this.getColumnModel(); 
    TableColumn columnaTabla; 
    for (int i = 0; i < this.getColumnCount(); i++) { 
        columnaTabla = modeloColumna.getColumn(i); 
        switch(i){ 
            case 1: anchoColumna = (30*ancho)/100; 
                    break; 
            case 2: anchoColumna = (50*ancho)/100; 
                    break; 
            case 3: anchoColumna = (20*ancho)/100; 
                    break; 
        }                      
        columnaTabla.setPreferredWidth(anchoColumna);            
    } 
} 



}
