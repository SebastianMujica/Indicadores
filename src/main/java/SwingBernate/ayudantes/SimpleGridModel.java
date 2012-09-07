package SwingBernate.ayudantes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import SwingBernate.*;

import javax.swing.table.AbstractTableModel;



public class SimpleGridModel extends AbstractTableModel {
	private List <DtoBase> lista=new ArrayList<DtoBase>();
	
	
	private String[] columnNames = {"Tabla Sin Datos"};
	private Object[][] datanml = {
	        {"Kathy", "Smith",
	         "Snowboarding", new Integer(5), new Boolean(false)},
	        {"John", "Doe",
	         "Rowing", new Integer(3), new Boolean(true)},
	        {"Sue", "Black",
	         "Knitting", new Integer(2), new Boolean(false)},
	        {"Jane", "White",
	         "Speed reading", new Integer(20), new Boolean(true)},
	        {"Joe", "Brown",
	         "Pool", new Integer(10), new Boolean(false)}
	        };
   private List <DtoBase> data =new Vector<DtoBase>(); 

	public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
    	DtoBase value = data.get(row);
    	
    
    	
    	Field campos[]=value.getClass().getDeclaredFields();

   
    	
    	Class clase=value.getClass();
		
    	
    	try {
			Method getter = clase.getMethod("get" + String.valueOf(campos[col].getName().toString().charAt(0)).toUpperCase()+campos[col].getName().toString().substring(1,campos[col].getName().toString().length()));
			Object valor = getter.invoke(value, new Object[0]);
			if (valor!=null)
			{
				//System.out.println("Valor"+ valor.toString());
			return valor;
			}else{
			return " ";	
				
			}
    	} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error en datos";
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error en datos";
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error en datos";
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error en datos";
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return "error en datos";
		}
		
    	//
    	
    	
    } 
	public List<DtoBase> getData() {
		return data;
	}

	public void setData(List<DtoBase> data) {

		this.data = data;
		
		DtoBase value = data.get(0);
		
    	Field campos[]=value.getClass().getDeclaredFields();
    	String[] nombres=new String[campos.length];
		for (int i = 0; i < campos.length; i++) {
		nombres[i]=campos[i].getName().toString();	
		}
		this.columnNames=nombres;
		//System.out.println(this.columnNames.length);
		this.fireTableStructureChanged();
	}
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

}
