package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contatos")
public class Contatos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_contatos;	
	
	@Column
	private String email;
	
	@Column
	private String telefone;

	public Contatos() {	}	
	public Contatos(String _email, String _telefone) {	
		email = _email;
		telefone = _telefone;
	}

	public int getId() {
		return id_contatos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
