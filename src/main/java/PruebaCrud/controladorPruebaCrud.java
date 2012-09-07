package PruebaCrud;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
import SwingBernate.ControladorBase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class controladorPruebaCrud extends ControladorBase implements ActionListener {
  public controladorPruebaCrud(){
    vistaPruebaCrud vista=new vistaPruebaCrud(this);
    PruebaCrud dto=new PruebaCrud();
    this.iniciarSesion(vista,dto);
  }
  public void nuevo(){
    vistaPruebaCrud vista=new vistaPruebaCrud(this);
    vista=(vistaPruebaCrud)this.getSession().getVista();
 //   vista.setDtoPruebaCrud(new PruebaCrud());
  }
  public void grabar(){
  }
  public void eliminar(){
  }
  public void buscar(){
  }
  public void actionPerformed(  ActionEvent ae){
    if ("nuevo".equals(ae.getActionCommand()))     this.nuevo();
    if ("grabar".equals(ae.getActionCommand()))     this.grabar();
    if ("buscar".equals(ae.getActionCommand()))     this.buscar();
    if ("eliminar".equals(ae.getActionCommand()))     this.eliminar();
    if ("Salir".equals(ae.getActionCommand()))     this.terminarVista();
  }
}

