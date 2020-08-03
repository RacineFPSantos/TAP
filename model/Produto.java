package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_produto;
	
	@Column
	private String nome;
	
	@Column
	private String preco;
	
	@Column
	private int quantidade;
	
	@Column
	private String descricao;
			
	public Produto(){	}
	public Produto(String _nome, String _preco, String _qnt, String _descricao) {
		nome = _nome;
		preco = _preco;
		quantidade = Integer.parseInt(_qnt);
		descricao = _descricao;
	}
	public int getId_produto() {
		return id_produto;
	}
	
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPreco() {
		return preco;
	}
	
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
