package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "drogaria")
public class Drogaria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_drogaria;
	
	@Column
	private String nome;
	
	@Column
	private String cnpj;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contatos")
	private Contatos contato;
	
	public int getId() {
		return id_drogaria;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
    public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
    public Contatos getContato() {
        return contato;
    }
 
    public void setContato(Contatos _contato) {
        contato = _contato;
    }
}
