package SwingBernate.ayudantes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class AyudanteGrid <T> extends JComponent {
	
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tablaDatos=new JTable(modelo);
	GridBagConstraints c = new GridBagConstraints();
	private Field[] arrTitulos;
	
	
	public AyudanteGrid(String titulo, Object dto)
	{
		//this.tablaDatos.setPreferredScrollableViewportSize(new Dimension(450, 150));
		
		JScrollPane barraScroll = new javax.swing.JScrollPane(tablaDatos,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		this.setLayout(new BorderLayout());
		this.add(barraScroll, BorderLayout.NORTH);
		this.setBorder(new TitledBorder(titulo));
		crearTitulosGrid(dto);
		this.setSize(this.tablaDatos.getPreferredSize());
	}
	
	public void crearTitulosGrid(Object dto){
		Class<?> clase;
		int col = -1;	
		
		clase = dto.getClass();
		this.arrTitulos = clase.getDeclaredFields();
		col = arrTitulos.length;
		String campo = "";
		
		for (int i = 0; i < this.arrTitulos.length; i++) {
			campo = arrTitulos[i].getName().substring(3);
			campo = String.valueOf(campo.charAt(0)).toUpperCase() +	campo.substring(1);
			
			this.modelo.addColumn(campo);
		}
	}
	
	public void cargarGrid(List<T> lista, Object dto){
		Class<?> clase;
		int col = -1;	
		
		clase = dto.getClass();
		this.arrTitulos = clase.getDeclaredFields();
		col = arrTitulos.length;
		Object [] filas = new Object[col];
		String campo = "";
		
		List<Object[]> listaCombo = new ArrayList<Object[]>();
		int colCombo = -1;
		
		for (int i = 0; i < lista.size(); i++) {
			
			if(i==0){				
				
				for (int j = 0; j < col; j++) {
				
					campo = arrTitulos[j].getName();
					campo = String.valueOf(campo.charAt(0)).toUpperCase() +	campo.substring(1);
					
					//this.modelo.addColumn(campo);					
					
					try{
						//Obtener nombre de Metodo Getter
						Method getter = clase.getMethod("get" + campo);						
						Object value = getter.invoke(lista.get(i), new Object[0]);
						//filas[j] = value;
						if(value.getClass().toString().compareToIgnoreCase("class org.hibernate.collection.PersistentList") == 0){
							
							if(!((List)value).isEmpty()){
								filas[j] = ((List)value).get(0);
							}else{
								filas[j] = "";
							}
							
							if(colCombo < 0){
								colCombo = j;
							}
							listaCombo.add( ((List)value).toArray() );
							
						}else{
							filas[j] = value;
						}
					}catch(Exception ex){
						filas[j] = "";
						ex.printStackTrace();
		            }
					
				}
				
				this.modelo.addRow(filas);
				
			}else{
				
				for (int j = 0; j < col; j++) {
					
					campo = arrTitulos[j].getName();
					campo = String.valueOf(campo.charAt(0)).toUpperCase() +	campo.substring(1);
					
					try{
						//Obtener nombre de Metodo Getter
						Method getter = clase.getMethod("get" + campo);
						Object value = getter.invoke(lista.get(i), new Object[0]);
						
						//filas[j] = value;
						if(value.getClass().toString().compareToIgnoreCase("class org.hibernate.collection.PersistentList") == 0){
							
							if(!((List)value).isEmpty()){
								filas[j] = ((List)value).get(0);
							}else{
								filas[j] = "";
							}
							
							if(colCombo < 0){
								colCombo = j;
							}
							listaCombo.add( ((List)value).toArray() );
							
						}else{
							filas[j] = value;
						}
						
					}catch(Exception ex){
						filas[j] = "";
						ex.printStackTrace();
		            }
				}
				
				this.modelo.addRow(filas);
				
			}	
			
			if(colCombo>0){
				TableColumn colEdit = this.tablaDatos.getColumnModel().getColumn(colCombo);
				colEdit.setCellEditor(new ComboEditor(listaCombo));
			}
		}
		
		
	}
	
	public void agregarFila(Object dato){
		Class<?> clase;
		int col = -1;
		
		clase = dato.getClass();
		//this.arrTitulos = clase.getDeclaredFields();				
		col = arrTitulos.length;
		Object [] filas = new Object[col];
		String campo = "";
		
		List<Object[]> listaCombo = new ArrayList<Object[]>();
		int colCombo = -1;
		
		for (int j = 0; j < col; j++) {
			
			campo = arrTitulos[j].getName();
			campo = String.valueOf(campo.charAt(0)).toUpperCase() +	campo.substring(1);
			
			try{
				//Obtener nombre de Metodo Getter
				Method getter = clase.getMethod("get" + campo);
				Object value = getter.invoke(dato, new Object[0]);
				//filas[j] = value;
				if(value.getClass().toString().compareToIgnoreCase("class org.hibernate.collection.PersistentList") == 0){
					
					if(!((List)value).isEmpty()){
						filas[j] = ((List)value).get(0);
					}else{
						filas[j] = "";
					}
					
					if(colCombo < 0){
						colCombo = j;
					}
					listaCombo.add( ((List)value).toArray() );
				}else{
					filas[j] = value;
				}
			}catch(Exception ex){
				filas[j] = "";
				ex.printStackTrace();
            }
		}
		
		this.modelo.addRow(filas);
		
		if(colCombo>0){
			TableColumn colEdit = this.tablaDatos.getColumnModel().getColumn(colCombo);
			colEdit.setCellEditor(new ComboEditor(listaCombo));
		}
		
	}
	
}