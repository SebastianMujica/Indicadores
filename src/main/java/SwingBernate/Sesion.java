package SwingBernate;

import java.util.List;
import java.util.Vector;

import moduloPrototipo.mainPrototipo;

public class Sesion
{
	private List <DtoBase> dto=new Vector<DtoBase>();
	private Vector <VistaBase> vista = new Vector <VistaBase>();
	private int actual;
	private long lngusr = 0;

	public Sesion(){
		//this.dto.add(dtoParam);
		//this.vista.add(vistaParam);

	}
	public void setListaDto(List <DtoBase>lista){
		if (lista.size()>=0)
		{
			this.dto=lista;
		}
	}
	public List<DtoBase> getListaDto(){
		return this.dto;
	}
	public int getActual(){
		return this.actual;
	}

	public void setDtoActual(int a,DtoBase param){	
		if (a < dto.size())
		{
			this.actual=a;
			this.getVista().setDto(this.getDtoById(a));

			this.getVista().getSimpleGrid().setSelected(a);
		}
	}
	public void setActual(int a){

		if (a < dto.size())
		{
			this.actual=a;
		}

	}
	public void agregarDto(DtoBase dto){
		this.dto.add(dto);
	}
	public void agregarDto(DtoBase dto,int id){
		this.dto.add(id, dto);
	}
	public void replaceVista(VistaBase vista){
		this.vista.removeAllElements();
		this.vista.add(vista);
	}
	public void agregarVista(VistaBase vista){
		this.vista.add(vista);
	}
	public DtoBase getDto(int id){
		actual=id;
		return this.dto.get(id);	
	}
	public DtoBase getDtoById(int a){
		int indice;
		if (a<this.dto.size() && a>=0 ){
			indice=a;
			this.vista.firstElement().buttonSiguiente.setEnabled(true);
			this.vista.firstElement().buttonAnterior.setEnabled(true);
			this.vista.firstElement().buttonPrimero.setEnabled(true);
			this.vista.firstElement().buttonUltimo.setEnabled(true);
			if(a==0){
				this.vista.firstElement().buttonAnterior.setEnabled(false);	
				this.vista.firstElement().buttonPrimero.setEnabled(false);
			}else if(a+1 == this.dto.size()){
				this.vista.firstElement().buttonSiguiente.setEnabled(false);
				this.vista.firstElement().buttonUltimo.setEnabled(false);
			}

		}else{
			if(a<0){
				indice=0;
			}else{
				indice=this.dto.size()-1;
			}
		}
		//this.setActual(indice);
		actual=indice;
		return this.dto.get(indice);
	}
	public DtoBase getDtoByLngId(long id){
		boolean enc = false;
		int i =0;
		DtoBase getDto;
		getDto = null;
		while (!enc && i<this.dto.size()) {
			if(this.dto.get(i).getLngid()==id){
				getDto = this.dto.get(i);
				enc = true;
			}
			i++;
		}	
		return getDto;
	}

	public void setUsuarioInicio(VistaBase vista){
		if(this.lngusr==0){
			mainPrototipo principal = (mainPrototipo)vista.getParent().getParent().getParent().getParent().getParent().getParent();
			this.lngusr = principal.getUsrConectado().getLngid();	
		}		
	}

	public long getLngusr() {
		return lngusr;
	}
	
	public void setLngusr(long lngusr) {
		this.lngusr = lngusr;
	}

	public VistaBase getVista(){
		return this.vista.firstElement();
	}
	public void mostrar(){
		System.out.println("Vector{");
		for (int j = 0; j < this.dto.size(); j++) {
			System.out.println("["+j+"]");
			System.out.println("Objeto("+this.dto.get(j).getClass().getSimpleName()+")");
			System.out.println(this.dto.get(j).toString());
		}
		System.out.println("}");
	}

	/*
public static void main(String[] args) {
    DtoPersona a=new DtoPersona();
    a.setId(1);
    a.setNombre("Aguen");
	a.setApellido("Sueño");
	a.setCedula("123456");

	DtoUsuario b=new DtoUsuario();
	b.setId(12);
	b.setNombreUsuario("asdsa");
	b.setPassword("adaeawds");
	b.setCorreo("asdaddd@sdasd.com");


	Sesion prueba=new Sesion();
	prueba.agregarDto(b);

	prueba.mostrar();
}
	 */
}
