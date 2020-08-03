package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "farmaceutico")
public class Farmaceutico extends Funcionario{
	
	@Column
	private String crm;
	
	public Farmaceutico() {	}
	public Farmaceutico(String _crm, String _nome, Contatos _contato) {
		super(_nome, _contato);
		crm = _crm;
	}
	
	public String getCrm() {
		return crm;
	}
	
	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public Contatos getContato() {
		return contato;
	}
	public void setContato(Contatos contato) {
		this.contato = contato;
	}

}
