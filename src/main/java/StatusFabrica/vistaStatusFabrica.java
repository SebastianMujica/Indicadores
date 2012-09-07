package StatusFabrica;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import net.miginfocom.swing.MigLayout;


import com.sun.org.apache.bcel.internal.generic.NEW;
import com.toedter.calendar.JDateChooser;

import eu.hansolo.steelseries.gauges.LinearBargraph;
import eu.hansolo.steelseries.gauges.Radial1Square;
import eu.hansolo.steelseries.gauges.RadialBargraph;

import Maestro.Maestro;
import Productor.Productor;
import SwingBernate.VistaBase;
import SwingBernate.ayudantes.ComboBox;
import SwingBernate.ayudantes.ListaDoble;
import Variable.Variable;
import eu.hansolo.steelseries.tools.BackgroundColor;

public class vistaStatusFabrica extends VistaBase {
	JLabel lbldesde=new JLabel("desde");
	JDateChooser dchdesde=new JDateChooser();
	JLabel lblhasta=new JLabel("hasta");
	JDateChooser dchhasta=new JDateChooser();
	JLabel lblorganizacion=new JLabel("Central Azucarero");
	//ComboBox cmbdtoorganizacion=new ComboBox(new Organizacion());
	JComboBox cmbdtoorganizacion=new JComboBox();
	JLabel lblturno=new JLabel("Turno");
	ListaDoble lstdtomaestro=new ListaDoble("Turnos",new Maestro());
	//ComboBox cmbdtozafra=new ComboBox(new Zafra());
	JLabel lblzafra=new JLabel("Zafra");
	JComboBox cmbdtozafra=new JComboBox();
	JButton btnaplicar=new JButton("Aplicar");
	JLabel lblparam=new JLabel("Parametros del Grafico");
	JLabel lbltipo=new JLabel("Tipo:");
	JComboBox cmbtipo=new JComboBox();
	JDesktopPane deskGraficos=new JDesktopPane();
	ComboBox cmbdtovariable=new ComboBox(new Variable());
	ListaDoble lstdtovariable=new ListaDoble("Variables",new Maestro());
	ComboBox cmbdtovariablevalor=new ComboBox(new Variable());
	ListaDoble lstdtovariablevalor=new ListaDoble("Variables",new Maestro());
	ListaDoble lstdtocolumnas=new ListaDoble("Columnas" ,new Maestro());
	JTabbedPane tblpane=new JTabbedPane();
	
public vistaStatusFabrica(ActionListener controlador){
	
	JScrollPane scrollPrincipal=new JScrollPane(this.getCentro());
	this.add(scrollPrincipal);
	
	
	// -------
	this.cmbtipo.addItem("Torta");
	this.cmbtipo.addItem("Barras");
	this.cmbtipo.addItem("Lineas");
	// -------
	cmbtipo.addActionListener(controlador);
	lstdtovariable.setVisible(false);
	
	//this.setResizable(false);
	this.setSize(800, 800);
	this.getCentro2().hide();
	this.setTitle("Status de Fabrica");
    
	//this.getForm().setLayoutConstraints("debug");
	
	this.agregar(lstdtomaestro,"wrap,span 2");
	this.agregar(lbldesde,dchdesde,"","wrap");
    this.agregar(lblhasta,dchhasta,"","wrap");
    this.agregar(lblorganizacion,cmbdtoorganizacion,"","wrap");
    this.agregar(lblzafra,cmbdtozafra,"","wrap");
    this.agregar(new JLabel("Parametros del Grafico"),"split 2 ,span 2");
    JSeparator separador1=new JSeparator();
    this.agregar(separador1,"growx,wrap");
    this.agregar(lbltipo,cmbtipo);
    this.btnaplicar.addActionListener(controlador);
    
    JPanel varpan=new JPanel();
    varpan.add(cmbdtovariablevalor);
    varpan.add(lstdtovariable);
    varpan.setMaximumSize(new Dimension(100,100));
    JPanel colpan=new JPanel();
    colpan.add(lstdtocolumnas);
    colpan.setMaximumSize(new Dimension(100,100));

    
    
    
    
    
    tblpane.addTab("Variables",varpan);
 
    tblpane.addTab("Columnas",colpan);
    this.agregar(new JLabel("Categoria"),"wrap, span 2");
    this.agregar(cmbdtovariable,"wrap, span 2");
    
    this.agregar(tblpane,"width 100px,height 100px,wrap,span 2");
    
//    this.agregar(new JLabel("Variables a Analizar"),"split 2 ,span 2");
//    JSeparator separador2=new JSeparator();
//    this.agregar(separador2,"growx,wrap");
//    this.agregar(cmbdtovariable,"wrap");
//    this.agregar(lstdtovariable,"span 2,hidemode 1,wrap");
//    
//    
//    
//    
//    this.agregar(new JLabel("Columna a Analizar"),"split 2 ,span 2");
//    JSeparator separador3=new JSeparator();
//    this.agregar(separador3,"growx,wrap");
    
    this.agregar(btnaplicar);
    MigLayout lay=new MigLayout();
    JPanel indicadores=new JPanel(lay);
    
    indicadores.setSize(800,180);
    indicadores.setBorder(BorderFactory.createBevelBorder(1));
    
    Radial1Square rendimiento=new Radial1Square();
    rendimiento.setTitle("Rendimiento");
    indicadores.add(rendimiento,"grow,width 160px,height 160px,gap 10 10,align center");
    rendimiento.setFrameVisible(false);
    rendimiento.setBackgroundColor(BackgroundColor.TRANSPARENT);
    
    Radial1Square canarecibida=new Radial1Square();
    canarecibida.setTitle("Caña Recibida");
    indicadores.add(canarecibida,"grow,width 160px,height 160px,gap 10 10,align center");
    canarecibida.setFrameVisible(false);
    canarecibida.setBackgroundColor(BackgroundColor.TRANSPARENT);
    
    Radial1Square canamolida=new Radial1Square();
    canamolida.setTitle("Caña Molida");
    indicadores.add(canamolida,"grow,width 160px,height 160px,gap 10 10,align center");
    canamolida.setFrameVisible(false);
    canamolida.setBackgroundColor(BackgroundColor.TRANSPARENT);
    
    Radial1Square azucar=new Radial1Square();
    azucar.setTitle("Azucar");
    indicadores.add(azucar,"grow,width 160px,height 160px,gap 10 10,align center");
    azucar.setFrameVisible(false);
    azucar.setBackgroundColor(BackgroundColor.TRANSPARENT);
    
    Radial1Square melaza=new Radial1Square();
    melaza.setTitle("Melaza");
    indicadores.add(melaza,"grow,width 160px,height 160px,gap 10 10,align center");
    melaza.setFrameVisible(false);
    melaza.setBackgroundColor(BackgroundColor.TRANSPARENT);
    /*
    LinearBargraph canarecibida= new Radial1Square();
    canarecibida.setTitle("Caña Recibida");
    indicadores.add(canarecibida,"grow,width 400px,height 160px,gap 10 10,align center");
    canarecibida.setUnitString("Tons x Miles");
    canarecibida.setFrameVisible(false);
      
    LinearBargraph CanaMolida= new LinearBargraph();
    CanaMolida.setTitle("Caña Molida");
    indicadores.add(CanaMolida,"grow,width 400px,height 160px,gap 10 10,align center");
    CanaMolida.setUnitString("Tons x Miles");
    CanaMolida.setFrameVisible(false);
    
    LinearBargraph azucar= new LinearBargraph();
    azucar.setTitle("Azucar");
    indicadores.add(azucar,"grow,width 400px,height 160px,gap 10 10,align center");
    azucar.setUnitString("Tons x Miles");
    azucar.setFrameVisible(false);
    
    LinearBargraph melaza= new LinearBargraph();
    melaza.setTitle("Melaza");
    melaza.setUnitString("Lts x Mills");
    indicadores.add(melaza,"grow,width 400px,height 160px,gap 10 10,align center");
    melaza.setFrameVisible(false);
    */
    
    JScrollPane scrollIndicadores=new JScrollPane(indicadores);
    this.agregar(scrollIndicadores,"cell 2 0,width 700px,height 180px, gapleft 20px");
    
    this.agregar(this.deskGraficos,"cell 2 1,span 2 11,width 720px,height 500px");
}
public void agregarCategoria(){
    JPanel varvalpan=new JPanel();
    varvalpan.add(cmbdtovariablevalor);
    varvalpan.setMaximumSize(new Dimension(100,100));
	tblpane.addTab("Valor", varvalpan);
}
public void removerCategoria(){
	tblpane.remove(2);
}
public JLabel getLbldesde() {
	return lbldesde;
}

public void setLbldesde(JLabel lbldesde) {
	this.lbldesde = lbldesde;
}

public JDateChooser getDchdesde() {
	return dchdesde;
}

public void setDchdesde(JDateChooser dchdesde) {
	this.dchdesde = dchdesde;
}

public JLabel getLblhasta() {
	return lblhasta;
}

public void setLblhasta(JLabel lblhasta) {
	this.lblhasta = lblhasta;
}

public JDateChooser getDchhasta() {
	return dchhasta;
}

public void setDchhasta(JDateChooser dchhasta) {
	this.dchhasta = dchhasta;
}

public JLabel getLblorganizacion() {
	return lblorganizacion;
}

public void setLblorganizacion(JLabel lblorganizacion) {
	this.lblorganizacion = lblorganizacion;
}

public JComboBox getCmbdtoorganizacion() {
	return cmbdtoorganizacion;
}

public void setCmbdtoorganizacion(JComboBox cmbdtoorganizacion) {
	this.cmbdtoorganizacion = cmbdtoorganizacion;
}

public JLabel getLblturno() {
	return lblturno;
}

public void setLblturno(JLabel lblturno) {
	this.lblturno = lblturno;
}

public ListaDoble getLstdtomaestro() {
	return lstdtomaestro;
}

public void setLstdtomaestro(ListaDoble lstdtomaestro) {
	this.lstdtomaestro = lstdtomaestro;
}

public JLabel getLblzafra() {
	return lblzafra;
}

public void setLblzafra(JLabel lblzafra) {
	this.lblzafra = lblzafra;
}

public JComboBox getCmbdtozafra() {
	return cmbdtozafra;
}

public void setCmbdtozafra(JComboBox cmbdtozafra) {
	this.cmbdtozafra = cmbdtozafra;
}

public JButton getBtnaplicar() {
	return btnaplicar;
}

public void setBtnaplicar(JButton btnaplicar) {
	this.btnaplicar = btnaplicar;
}

public JLabel getLblparam() {
	return lblparam;
}

public void setLblparam(JLabel lblparam) {
	this.lblparam = lblparam;
}

public JLabel getLbltipo() {
	return lbltipo;
}

public void setLbltipo(JLabel lbltipo) {
	this.lbltipo = lbltipo;
}

public JComboBox getCmbtipo() {
	return cmbtipo;
}

public void setCmbtipo(JComboBox cmbtipo) {
	this.cmbtipo = cmbtipo;
}

public JDesktopPane getDeskGraficos() {
	return deskGraficos;
}

public void setDeskGraficos(JDesktopPane deskGraficos) {
	this.deskGraficos = deskGraficos;
}

public ComboBox getCmbdtovariable() {
	return cmbdtovariable;
}

public void setCmbdtovariable(ComboBox cmbdtovariable) {
	this.cmbdtovariable = cmbdtovariable;
}

public ListaDoble getLstdtovariable() {
	return lstdtovariable;
}

public void setLstdtovariable(ListaDoble lstdtovariable) {
	this.lstdtovariable = lstdtovariable;
}
public ComboBox getCmbdtovariablevalor() {
	return cmbdtovariablevalor;
}
public void setCmbdtovariablevalor(ComboBox cmbdtovariablevalor) {
	this.cmbdtovariablevalor = cmbdtovariablevalor;
}
public ListaDoble getLstdtovariablevalor() {
	return lstdtovariablevalor;
}
public void setLstdtovariablevalor(ListaDoble lstdtovariablevalor) {
	this.lstdtovariablevalor = lstdtovariablevalor;
}
public ListaDoble getLstdtocolumnas() {
	return lstdtocolumnas;
}
public void setLstdtocolumnas(ListaDoble lstdtocolumnas) {
	this.lstdtocolumnas = lstdtocolumnas;
}
public JTabbedPane getTblpane() {
	return tblpane;
}
public void setTblpane(JTabbedPane tblpane) {
	this.tblpane = tblpane;
}
}
