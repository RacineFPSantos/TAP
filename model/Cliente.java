package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends Entidade {
		
    public Cliente() { }
    public Cliente(String _nome, Contatos _contato) {
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
	
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_cliente;
	
	@Column
	private String nome;
	
	@Column
	private String cpf;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contatos")
	private Contatos contato;

    public Cliente() { }
    public Cliente(String _nome, Contatos _contato) {
    	nome =  _nome;
    	contato = _contato;
    }
    
	//Getters and Setters
	public int getId() {
		return id_cliente;
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
 
    public void setContato(Contatos _contato) {
        contato = _contato;
    }
    */
}
