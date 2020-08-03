package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Entidade")
public class Entidade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_entidade;
	
	@Column
	protected String nome;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contatos")
    protected Contatos contato;
    
    public Entidade() { }
    
	public Entidade(String _nome, Contatos _contato) {
		nome = _nome;
		contato = _contato;
	}

}
