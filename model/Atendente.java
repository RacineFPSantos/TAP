package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "atendente")
public class Atendente extends Funcionario {	
	
	public Atendente() { }	
	public Atendente(String _nome, Contatos _contato) {
		super(_nome, _contato);
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
