package Indicador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import net.miginfocom.swing.MigLayout;


import com.lowagie.text.pdf.BaseFont;

import eu.hansolo.steelseries.gauges.Radial;
import eu.hansolo.steelseries.gauges.Radial1Square;
import eu.hansolo.steelseries.tools.BackgroundColor;

import Meta_Org.Meta_Org;
import Meta_Org.modeloMeta_Org;
import RegistroIndicador.RegistroIndicador;
import RegistroIndicador.modeloRegistroIndicador;
import SwingBernate.VistaBase;

public class analisisIndicadores extends VistaBase {

	
	public analisisIndicadores(ActionListener al){
		
		this.getImprimir().addActionListener(al);
		this.setSize(900, 600);
		JScrollPane scrollPrincipal=new JScrollPane(this.getCentro());
		this.add(scrollPrincipal);
		JLabel descrip=new JLabel("Descripcion de Indicadores");
		Font titulo=new Font("Dialog", Font.BOLD, 14);
		descrip.setFont(titulo);
		descrip.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		descrip.setOpaque(true);
		descrip.setBackground(Color.white);
		descrip.setMinimumSize(new Dimension(250, 40));
		descrip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); 
		this.agregar(descrip,"gapx 0px");
		
//		JLabel calc=new JLabel("Calculo");
//		calc.setFont(titulo);
//		calc.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//		calc.setOpaque(true);
//		calc.setBackground(Color.white);
//		calc.setMinimumSize(new Dimension(200, 40));
//		calc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); 
//		this.agregar(calc,"gap 0px");
	
		JLabel mes=new JLabel("Fecha de Captura");
		mes.setFont(titulo);
		mes.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mes.setOpaque(true);
		mes.setBackground(Color.white);
		mes.setMinimumSize(new Dimension(110, 40));
		mes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); 
		this.agregar(mes,"gap 0px");

		JLabel meta=new JLabel("Meta");
		meta.setFont(titulo);
		meta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		meta.setOpaque(true);
		meta.setBackground(Color.white);
		meta.setMinimumSize(new Dimension(80, 40));
		meta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); 
		this.agregar(meta,"gap 0px");
	
		JLabel desvio=new JLabel("Desvio");
		desvio.setFont(titulo);
		desvio.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		desvio.setOpaque(true);
		desvio.setBackground(Color.white);
		desvio.setMinimumSize(new Dimension(80, 40));
		desvio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); 
		this.agregar(desvio,"gap 0px");

		JLabel valor=new JLabel("Valor");
		valor.setFont(titulo);
		valor.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		valor.setOpaque(true);
		valor.setBackground(Color.white);
		valor.setMinimumSize(new Dimension(180, 40));
		valor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); 
		this.agregar(valor,"gap 0px,wrap");

//		JLabel gdc=new JLabel("Estatus");
//		gdc.setFont(titulo);
//		gdc.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//		gdc.setOpaque(true);
//		gdc.setBackground(Color.white);
//		gdc.setMinimumSize(new Dimension(80, 40));
//		gdc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); 
//		this.agregar(gdc,"gap 0px,wrap");
		
		
		
		
		

	
	}
public void cargarIndicadores(RegistroIndicador[] Indicadores,ActionListener al,modeloIndicador modInd){
	double metaInd=0;
	for (RegistroIndicador registroIndicador : Indicadores) {
		Indicador ind=registroIndicador.getDtoindicador();
		
		this.agregar(new JLabel(ind.getStrproposito()));
		
//		this.agregar(new JLabel(ind.getStrformula()));
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy h:mm a");
		this.agregar(new JLabel(formato.format(registroIndicador.getDtmfecha_creacion())));
		
		try {
//			this.agregar(new JLabel(ind.getDto_meta_org().getFlovalor()+""));	
			
			
			modeloMeta_Org modelometa=new modeloMeta_Org();
			
			Criterion[] arreglo=new Criterion[2];
			
			arreglo[0]=Restrictions.eq("dtoorganizacion",ind.getDto_org());
			arreglo[1]=Restrictions.eq("dtoindicador",ind);
			
			
			
			Meta_Org meta=(Meta_Org)modelometa.buscar(new Meta_Org(),arreglo).get(0);
			
			System.out.println(meta);
			this.agregar(new JLabel(meta.getFlovalor()+""));
			metaInd=meta.getFlovalor();
			
			
		} catch (Exception e) {
			System.out.println("Meta Nula");
			e.printStackTrace();
			this.agregar(new JLabel("sin meta"));
		}
		
		Float desvio=Float.parseFloat(registroIndicador.getStrvalor())-Float.parseFloat(metaInd+"");
		
		//this.agregar(new JLabel(""));
		this.agregar(new JLabel(desvio+""));
		
		Radial indicador=new Radial();
	    //rendimiento.setTitle("Rendimiento");
	    
	    //rendimiento.setFrameVisible(false);
	    //rendimiento.setBackgroundColor(BackgroundColor.TRANSPARENT);
		// Animacion
		System.out.println("STRVALOR "+registroIndicador.getStrvalor());
		indicador.setValue(0);
		indicador.setValueAnimated(Double.parseDouble(registroIndicador.getStrvalor()));
		// Animacion
		indicador.setMinValue(ind.getFlovalor_minimo());
		indicador.setMaxValue(ind.getFlovalor_maximo());
		
		//Marca de Meta
		indicador.setThreshold(metaInd);
		indicador.setThresholdVisible(true);
		indicador.setLedVisible(true);
		// Marca de meta
		//Estatus
		indicador.setTrackVisible(true);
		indicador.setTrackStart(0);
		indicador.setTrackStop(100);
		indicador.setTrackSection(70);
		indicador.setTrackStartColor(Color.red);
		indicador.setTrackSectionColor(Color.YELLOW);
		indicador.setTrackStopColor(Color.GREEN);
		indicador.setUnitString(ind.getDto_unidadmedida().getStrsimbolo());
		indicador.setTitle(ind.getStrcodigo());

		//indicador.setAutoResetToZero(true);
		//Estatus
		this.agregar(indicador,"width 180px,height 180px");
		
		JButton tende=new JButton("Tendencia");
		tende.setActionCommand("Tendencia_"+ind.getLngid());
		tende.addActionListener(al);
		this.agregar(tende,"wrap");
	
	}
}

}
