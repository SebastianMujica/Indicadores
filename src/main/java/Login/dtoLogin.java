package Login;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import SwingBernate.DtoBase;

public class dtoLogin extends DtoBase {
	
	@NotEmpty(message="{campo_obligatorio}")
	private String srtusuario;
	@NotNull
	@Size(min = 6, max = 10,  message="{longitud_entre}")
	private String srtpassword;
	
	public dtoLogin(){}

	public String getSrtusuario() {
		return srtusuario;
	}

	public void setSrtusuario(String srtusuario) {
		this.srtusuario = srtusuario;
	}

	public String getSrtpassword() {
		return srtpassword;
	}

	public void setSrtpassword(String srtpassword) {
		this.srtpassword = srtpassword;
	}

}
