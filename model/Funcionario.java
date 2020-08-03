package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "funcionario")
public class Funcionario extends Entidade{
			
	public Funcionario() {	}
	public Funcionario(String _nome, Contatos _contato) {
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
