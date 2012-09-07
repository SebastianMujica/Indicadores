package Indicador;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import net.miginfocom.swing.MigLayout;

import com.toedter.calendar.JDateChooser;

import Maestro.Maestro;
import Organizacion.Organizacion;
import Periodo.Periodo;
import RegistroVariable.RegistroVariable;
import SwingBernate.DtoBase;
import SwingBernate.VistaBase;
import SwingBernate.ayudantes.ComboBox;
import Variable.Variable;

public class captura extends VistaBase{
	JLabel lbldto_org=new JLabel("Organización: ");
	ComboBox cmbdto_org=new ComboBox(new Organizacion());
	JLabel lbldto_periodo=new JLabel("Período: ");
	ComboBox cmbdto_periodo=new ComboBox(new Periodo());
	JLabel lbldtmfecha_valor=new JLabel("Fecha de Operación: ");
	JDateChooser  dchdtmfecha_valor   = new JDateChooser();
	JLabel lbldtocategoria=new JLabel("Categoria: ");
	ComboBox cmbdtocategoria=new ComboBox(new Maestro());
	//ComboBox cmbdtovariable=new ComboBox(new Variable());
	JPanel panelContenedor=new JPanel();
    
    JScrollPane scroll=new JScrollPane(panelContenedor);
    JLabel lblPaginacion=new JLabel();
    //int actualpag=0;
    //int actualreg=0;
    //int totalpag=0;
    //boolean paginacion=false;
    //int paginacionN=3;
    //List <Component> variablesInd=new ArrayList<Component>();
    List <Component> lstComponent=new ArrayList<Component>();
    
    
	public captura(ActionListener controlador){
		this.setTitle("Captura de Valores");
		//this.getForm().setLayoutConstraints("debug");
		this.cmbdto_org.setName("cmbdto_org");
		this.cmbdto_org.addActionListener(controlador);
	    this.agregar(lbldto_org,cmbdto_org,"","growx,width 250px,wrap 1");
	    
	    this.cmbdto_periodo.setName("cmbdto_periodo");
	    this.cmbdto_periodo.addActionListener(controlador);
	    this.agregar(lbldto_periodo,cmbdto_periodo,"","growx,width 250px,wrap 1");
	    
	    this.agregar(lbldtmfecha_valor,dchdtmfecha_valor,"","width 180px, wrap 1");
	    
	    this.cmbdtocategoria.setName("cmbdtocategoria");
		this.cmbdtocategoria.addActionListener(controlador);
		this.agregar(lbldtocategoria,cmbdtocategoria," ","growx,width 250px,wrap 3");
	
		// dependiendo de lo que sea necesario se agrega cierto campo

	    this.getButtonNuevo().addActionListener(controlador);
	    this.getButtonBuscar().addActionListener(controlador);
	    this.getButtonBuscar().setEnabled(false);
	    this.getButtonBuscar().setVisible(false);
	    this.getButtonEliminar().addActionListener(controlador);
	    this.getButtonEliminar().setEnabled(false);
	    this.getButtonEliminar().setVisible(false);
	    this.getImprimir().addActionListener(controlador);
	    this.getImprimir().setEnabled(false);
	    this.getImprimir().setVisible(false);
	    this.getButtonGuardar().addActionListener(controlador);
	    this.getButtonCancelar().addActionListener(controlador);
	    this.getButtonSiguiente().addActionListener(controlador);
	    this.getButtonAnterior().addActionListener(controlador);
	    this.getButtonPrimero().addActionListener(controlador);
	    this.getButtonUltimo().addActionListener(controlador);
	    this.getButtonRefrescar().addActionListener(controlador);
	    this.getMenuItemNuevo().addActionListener(controlador);
	    this.getMenuItemBuscar().addActionListener(controlador);
	    this.getMenuItemBuscar().setEnabled(false);
	    this.getMenuItemBuscar().setVisible(false);
	    this.getMenuItemEliminar().addActionListener(controlador);
	    this.getMenuItemEliminar().setEnabled(false);
	    this.getMenuItemEliminar().setVisible(false);
	    this.getMenuItemGuardar().addActionListener(controlador);
	    this.getMenuItemSalir().addActionListener(controlador);
	    this.getButtonVistaR().addActionListener(controlador);
	    this.getButtonVistaR().setEnabled(false);
	    this.getButtonVistaR().setVisible(false);
	    MigLayout migpanel=new MigLayout("insets 1");
	    panelContenedor.setLayout(migpanel);
	    //migpanel.setLayoutConstraints("debug");
		this.agregar(scroll,"span 2,width 800px,height 600px,growx, wrap 2px");
		lblPaginacion.setFont(new java.awt.Font(lblPaginacion.getFont().getFontName(), 1, 12));
		this.agregar(lblPaginacion,"span 2,align right,width 800px,height 18px, wrap 0px");
		this.setSize(650,550);
	}
	
	public NumberFormat setFormatNumber(int cant_enteros,int cant_decimales){
		NumberFormat aux=NumberFormat.getNumberInstance();
		aux.setMinimumFractionDigits(cant_decimales);
		aux.setMaximumFractionDigits(cant_decimales);
		aux.setMinimumIntegerDigits(1);
		aux.setMaximumIntegerDigits(cant_enteros);
		aux.setRoundingMode(RoundingMode.HALF_EVEN);
		return aux;
	}
	public NumberFormat setFormatNumber(int cant_enteros,int cant_decimales,Locale locale){
		NumberFormat aux=NumberFormat.getNumberInstance(locale);
		aux.setMinimumFractionDigits(cant_decimales);
		aux.setMaximumFractionDigits(cant_decimales);
		aux.setMinimumIntegerDigits(1);
		aux.setMaximumIntegerDigits(cant_enteros);
		aux.setRoundingMode(RoundingMode.HALF_EVEN);
		return aux;
	}
	public void cargarListaComponents(List<DtoBase> lstInd){
		int tam=lstInd.size();
		int i=0;
		this.lstComponent.clear();
		System.out.println("CARGANDO LISTA DE COMPONENTES\n");
		while (i<tam){
			Indicador indi=(Indicador)lstInd.get(i);
			List <Variable> vars=indi.getDtovariable();
			System.out.println(".....Procesando Indicador "+i+". "+indi.strcodigo+". Con "+vars.size()+" variables asociadas.");
			MigLayout mig=new MigLayout("insets 0");
			//mig.setLayoutConstraints("debug");
			JPanel contenedor=new JPanel(mig);
			contenedor.setAutoscrolls(true);
			ComboBox cmbIndicador = new ComboBox(new Indicador());
			Indicador[] arrIndi= new Indicador[1];
			arrIndi[0] = (Indicador)indi;
			javax.swing.DefaultComboBoxModel modeloCmbIndicador=new javax.swing.DefaultComboBoxModel(arrIndi);
			cmbIndicador.setModel(modeloCmbIndicador);
			cmbIndicador.setVisible(false);
			contenedor.putClientProperty("indicador",cmbIndicador);
			System.out.println("          Agregando ComboIndicador");
			JLabel titulo=new JLabel("[" + indi.getStrcodigo() + "] " + indi.getStrnombre());
			titulo.setForeground(java.awt.Color.white);
			titulo.setBackground(java.awt.Color.red);
			titulo.setOpaque(true);
			titulo.setFont(new java.awt.Font(titulo.getFont().getFontName(), 1, 12));
			//titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			contenedor.add(titulo,"span 2,align center,growx,width 500px,height 25px, wrap 2px");
			
		    if (i%2==0){
		    	 contenedor.setOpaque(true);
		    	 //contenedor.setBackground(new Color(0x4BDFCE));
		    	 contenedor.setBackground(java.awt.Color.lightGray);
			 }else{
		    	 contenedor.setOpaque(true);
		    	 //contenedor.setBackground(new Color(0xD81D43));
		    	 //contenedor.setBackground(java.awt.Color.white);
		    	 contenedor.setBackground(new java.awt.Color(101, 218, 237));
			 }
		    ComboBox cmbVariable = new ComboBox(new Variable());
		    Variable[] arrVar= new Variable[vars.size()];
		    int j=0;
		    for (j=0;j<vars.size();j++){
		    	Variable var_aux=vars.get(j);
		    	arrVar[j] = var_aux;
		    	System.out.println("          Procesando Variable "+j+". "+var_aux.getStrcodigo()+".");
				JLabel nombre=new JLabel(var_aux.getStrnombre()+": ");
				String strTipoDato=var_aux.getDtotipo_dato().getStrsigla().trim().toLowerCase();
				int Ent = (int)var_aux.getLngtamano();
				int Dec = (int)var_aux.getLngnum_decimales();
				JFormattedTextField strvalor=new JFormattedTextField();
				if (strTipoDato.equals("shr")|| strTipoDato.equals("int")
						||strTipoDato.equals("lng")||strTipoDato.equals("flo")||strTipoDato.equals("dbl")){
					//Formato de Visualización
					NumberFormat visFormat=this.setFormatNumber(Ent, Dec);
					//Formato de Edición
					NumberFormat editFormat=this.setFormatNumber(Ent, Dec,Locale.ENGLISH);
					// Para la edición, no queremos separadores de millares
					editFormat.setGroupingUsed(false);
					// Creamos los formateadores de números
					NumberFormatter vnFormat = new NumberFormatter(visFormat);
					NumberFormatter enFormat = new NumberFormatter(editFormat);
					// Creamos la factoría de formateadores especificando los
					// formateadores por defecto, de visualización y de edición
					DefaultFormatterFactory numFactory = new DefaultFormatterFactory(vnFormat, vnFormat, enFormat);
					// El formateador de edición admite caracteres incorrectos
					enFormat.setAllowsInvalid(true);
					// Asignamos la factoría al campo
					strvalor.setFormatterFactory(numFactory);
				}
				strvalor.setName(var_aux.getCodeName());
				String strValorMinimo=String.valueOf(var_aux.getFlovalor_minimo());
				//String strValorMaximo=String.valueOf(var_aux.getFlovalor_maximo());
				if (strTipoDato.equals("shr")) strvalor.setValue(new Short(Short.parseShort(strValorMinimo)));
				if (strTipoDato.equals("int")) strvalor.setValue(new Integer(Integer.parseInt(strValorMinimo)));
				if (strTipoDato.equals("lng")) strvalor.setValue(new Long(Long.parseLong(strValorMinimo)));
				if (strTipoDato.equals("flo")) strvalor.setValue(new Float(Float.parseFloat(strValorMinimo)));
				if (strTipoDato.equals("dbl")) strvalor.setValue(new Double(Double.parseDouble(strValorMinimo)));
				
				contenedor.add(nombre,"");
				contenedor.add(strvalor,""+var_aux.getStrformato_presente());
			}
		    javax.swing.DefaultComboBoxModel modeloCmbVariable=new javax.swing.DefaultComboBoxModel(arrVar);
			cmbVariable.setModel(modeloCmbVariable);
			cmbVariable.setVisible(false);
			contenedor.putClientProperty("variable",cmbVariable);
			System.out.println("          Agregando Combo de Variables con "+cmbVariable.getItemCount()+" items.");
		    this.lstComponent.add(i,contenedor);
		    i++;
		}
	}
	public void mostrar_panel_variable_indicador(int i){
		JPanel panel = (JPanel)this.lstComponent.get(i);
		panelContenedor.add(panel,"growx,width 500px,wrap 0px");
	}
	
	
	public List<RegistroVariable> getValorIndicador(int NroRegistro){
		int j=0;
		List<RegistroVariable> lista=new ArrayList<RegistroVariable>();
		JPanel panel = (JPanel)this.lstComponent.get(NroRegistro);
		System.out.println("\nPROCESANDO getValorIndicador. Nro Registro o Panel: "+NroRegistro);
		ComboBox cmbdto_variable=(ComboBox) panel.getClientProperty("variable");
		System.out.println("          Variables: "+cmbdto_variable.getItemCount());
		Component[] arrComp=panel.getComponents();
		for(j=0;j<cmbdto_variable.getItemCount();j++){
			RegistroVariable registro=new RegistroVariable();
			Variable var = (Variable)cmbdto_variable.getItemAt(j);
			System.out.println("               Variable: "+j+". "+var.getStrcodigo());
			registro.setLngid(0);
			registro.setDtoorganizacion((Organizacion) this.cmbdto_org.getSelectedItem());
			registro.setDtoperiodo((Periodo)this.cmbdto_periodo.getSelectedItem());
			ComboBox cmbdto_indicador=(ComboBox) panel.getClientProperty("indicador");
			registro.setDtoindicador((Indicador)cmbdto_indicador.getItemAt(0));
			registro.setDtmfecha_valor(this.dchdtmfecha_valor.getDate());
			registro.setBolactivo(true);
			registro.setBolborrado(false);
			registro.setDtovariable(var);
			for (Component comp : arrComp) {
				try{
					if (comp.getClass().getCanonicalName().equals("javax.swing.JFormattedTextField")){
					  if (comp.getName().equals(var.getCodeName())){
						JFormattedTextField campo=(JFormattedTextField)comp;
						registro.setStrvalor(campo.getValue().toString());
					  }
					}	
				}catch (Exception e) {
					System.out.println("***********\nError en getValorIndicador()\n************");
					e.printStackTrace();
				}
			}
			lista.add(j,registro);
		}//Fin del for que recorre las variables
		return lista;
	}
	
	public ComboBox getCmbdtocategoria() {
		return cmbdtocategoria;
	}
	public void setCmbdtocategoria(ComboBox cmbdtocategoria) {
		this.cmbdtocategoria = cmbdtocategoria;
	}
	public JLabel getLbldtocategoria() {
		return lbldtocategoria;
	}
	public void setLbldtocategoria(JLabel lbldtocategoria) {
		this.lbldtocategoria = lbldtocategoria;
	}
	public JPanel getPanelContenedor() {
		return panelContenedor;
	}
	public void setPanelContenedor(JPanel panelContenedor) {
		this.panelContenedor = panelContenedor;
	}
	public JScrollPane getScroll() {
		return scroll;
	}
	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
	/*public int getActualpag() {
		return actualpag;
	}
	public void setActualpag(int actualpag) {
		this.actualpag = actualpag;
	}
	public int getActualreg() {
		return actualreg;
	}
	public void setActualreg(int actualreg) {
		this.actualreg = actualreg;
	}
	public int getTotalpag() {
		return totalpag;
	}
	public void setTotalpag(int totalpag) {
		this.totalpag = totalpag;
	}
	public boolean isPaginacion() {
		return paginacion;
	}
	public void setPaginacion(boolean paginacion) {
		this.paginacion = paginacion;
	}*/
	public JLabel getLbldto_org() {
		return lbldto_org;
	}
	public void setLbldto_org(JLabel lbldtoOrg) {
		lbldto_org = lbldtoOrg;
	}
	public ComboBox getCmbdto_org() {
		return cmbdto_org;
	}
	public void setCmbdto_org(ComboBox cmbdtoOrg) {
		cmbdto_org = cmbdtoOrg;
	}
	public JLabel getLbldto_periodo() {
		return lbldto_periodo;
	}
	public void setLbldto_periodo(JLabel lbldtoPeriodo) {
		lbldto_periodo = lbldtoPeriodo;
	}
	public ComboBox getCmbdto_periodo() {
		return cmbdto_periodo;
	}
	public void setCmbdto_periodo(ComboBox cmbdtoPeriodo) {
		cmbdto_periodo = cmbdtoPeriodo;
	}

	public JLabel getLbldtmfecha_valor() {
		return lbldtmfecha_valor;
	}

	public void setLbldtmfecha_valor(JLabel lbldtmfechaValor) {
		lbldtmfecha_valor = lbldtmfechaValor;
	}

	public JDateChooser getDchdtmfecha_valor() {
		return dchdtmfecha_valor;
	}

	public void setDchdtmfecha_valor(JDateChooser dchdtmfechaValor) {
		dchdtmfecha_valor = dchdtmfechaValor;
	}
	public JLabel getLblPaginacion() {
		return lblPaginacion;
	}
	public void setLblPaginacion(JLabel lblPaginacion) {
		this.lblPaginacion = lblPaginacion;
	}

	public List<Component> getLstComponent() {
		return lstComponent;
	}

	public void setLstComponent(List<Component> lstComponent) {
		this.lstComponent = lstComponent;
	}
	
	
}
