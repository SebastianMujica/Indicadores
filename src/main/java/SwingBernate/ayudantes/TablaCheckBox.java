package SwingBernate.ayudantes;



import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import Menu.Menu;
import SwingBernate.DtoBase;

public class TablaCheckBox extends JComponent implements MouseListener {

	private JTable tablaMenu = new JTable();

	public TablaCheckBox(){

		this.setLayout(new BorderLayout());

		JScrollPane jsPanel = new JScrollPane(this.tablaMenu,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(jsPanel,BorderLayout.CENTER);

		jsPanel.setPreferredSize(new Dimension(325, 300));

		this.setBorder(new TitledBorder("Items Menú"));
	}

	public void setModelo(DtoBase[] arrMenu){
		this.tablaMenu.setModel(new DefaultTableModel());

		Object[][] data = new Object[arrMenu.length][2];

		for (int i = 0; i < arrMenu.length; i++) {
			data[i][0] = new Boolean(false);
			data[i][1] = arrMenu[i];
		}

		TablaModelo modeloTabla = new TablaModelo();
		modeloTabla.setData(data,
				new String []{"Asignar","Vista Menú"}
		);

		this.tablaMenu.setModel(modeloTabla);
		this.tablaMenu.addMouseListener(this);

		this.tablaMenu.getColumnModel().getColumn(0).setPreferredWidth(25*325/100);
		this.tablaMenu.getColumnModel().getColumn(0).setResizable(false);
		//this.tablaMenu.getColumnModel().getColumn(0)

		this.tablaMenu.getColumnModel().getColumn(1).setPreferredWidth(75*325/100);

		//this.jsPanel.setViewportView(this.tablaMenu);
		this.tablaMenu.setFillsViewportHeight(true);
	}

	public JTable getTablaMenu() {
		return tablaMenu;
	}

	public void setTablaMenu(JTable tablaMenu) {
		this.tablaMenu = tablaMenu;
	}

	class TablaModelo extends AbstractTableModel {
		private String[] columnNames = {"First Name"};
		private Object[][] data = {
				{"Kathy"}
		};

		public void setData(Object[][] datos, String[] titulos){
			this.data = datos;
			this.columnNames = titulos;
			this.fireTableStructureChanged();
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		public boolean isCellEditable (int row, int column)
		{
			// Aquí devolvemos true o false según queramos que una celda
			// identificada por fila,columna (row,column), sea o no editable
			if (column == 0)
				return true;
			return false;
		}

		/*
		 * JTable uses this method to determine the default renderer/
		 * editor for each cell.  If we didn't implement this method,
		 * then the last column would contain text ("true"/"false"),
		 * rather than a check box.
		 */
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		/*
		 * Don't need to implement this method unless your table's
		 * data can change.
		 */
		public void setValueAt(Object value, int row, int col) {

			data[row][col] = value;
			fireTableCellUpdated(row, col);

		}
	}
	public void desactivarTodos(){
		for(int i=0; i < this.tablaMenu.getRowCount(); i++){
			this.tablaMenu.setValueAt(new Boolean(false), i, 0);
		}
	}
	public void activarNodos(Menu dto, boolean act){
		if(dto.getDtonodo() != null){
			for (Menu dtoNodo : dto.getDtonodo()) {
				activarNodos(dtoNodo,act);
				int fila = buscarNodoTabla(dtoNodo);
				if(fila>0)
					this.tablaMenu.setValueAt(new Boolean(act), fila, 0);
			}
		}
	}
	public void activarPadres(Menu dto, boolean act, int f){
		//if(dto.getDtonodo() == null){
		this.tablaMenu.setValueAt(new Boolean(act), f, 0);
		Menu padre = dto.getDtomenu();
		if (padre!=null){
			if(padre.getLngid()!=0){
				int f1 = buscarNodoTabla(padre);
				if(!act){
					boolean hjActivo = false;
					List<Menu> lsth = padre.getDtonodo();
					for (int i = 0; i < lsth.size(); i++) {
						int fhijo = buscarNodoTabla(lsth.get(i));
						if(f!=fhijo){
							if((Boolean)this.tablaMenu.getValueAt(fhijo, 0)){
								hjActivo = true;
								i = lsth.size();
							}
						}
					}
					if(!hjActivo){
						this.tablaMenu.setValueAt(new Boolean(act), f1, 0);
						activarPadres(padre,act,f1);
					}
				}
				else{
					this.tablaMenu.setValueAt(new Boolean(act), f1, 0);
					activarPadres(padre,act,f1);
				}
			}
		}
		//}
	}
	public int buscarNodoTabla(Menu nodo){
		int f = 0;
		for (int i = 1; i < this.tablaMenu.getRowCount(); i++) {
			Menu nodoFila = (Menu)this.tablaMenu.getValueAt(i, 1);
			if(nodo.equals(nodoFila)){
				f = i;
				i=this.tablaMenu.getRowCount();
			}
		}
		return f;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub


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
		if (e.getClickCount() == 1) {
			JTable target = (JTable)e.getSource();
			int row = target.getSelectedRow();
			int column = target.getSelectedColumn();
			// do some action if appropriate column
			if(column == 0){

				if (row ==0){

					boolean selct = false;
					selct = !(Boolean)this.tablaMenu.getValueAt(row, column);
					//System.out.println("********* por fila Cero... "+selct);
					for (int i = 0; i < target.getRowCount(); i++) {
						target.setValueAt(new Boolean(selct), i, column);
					}
				}else{
					Menu menuSelect = (Menu)this.tablaMenu.getValueAt(row, 1);
					boolean selct = !(Boolean)this.tablaMenu.getValueAt(row, column);
					//System.out.println("/////////// por otra fila ... "+selct);
					activarNodos(menuSelect, selct);
					activarPadres(menuSelect, selct, row);
				}
			}
		}
	}

}