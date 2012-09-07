package SwingBernate.ayudantes;

import java.awt.Component;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class ComboEditor extends DefaultCellEditor{
    
    List<Object[]> values;
   
    public ComboEditor(List<Object[]> values){
            super(new JComboBox());
            this.values = values;
    }
   
    public Component getTableCellEditorComponent(JTable table, Object value,
              boolean isSelected, int row, int column) {
           
            JComboBox combo = (JComboBox)getComponent();
            combo.removeAllItems();
            Object[] valores = values.get(row);
           
            for(int i=0; i<valores.length; i++){
                    combo.addItem(valores[i]);
            }
            combo.setSelectedItem(value);
           
            return combo;
    }

}
