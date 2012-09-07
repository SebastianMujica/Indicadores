package SwingBernate.ayudantes;

/*
 * Clase generica que permite mostrar
 * el texto requerido en la Lista o el Combo
 * y obtener el id Asociado a la Seleccion
 */

public class opcionListaCombo {
	private Short id;
	private String texto;
	
	public opcionListaCombo(){}
	
	public opcionListaCombo(Short id, String texto){
		this.id = id;
		this.texto = texto;		
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		opcionListaCombo other = (opcionListaCombo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}

	public String toString(){
		return this.texto;
	}
}
