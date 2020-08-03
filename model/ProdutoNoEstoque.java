package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

@Entity
public class ProdutoNoEstoque {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_produtosNoEstoque;
	
	@ManyToOne
	@JoinColumn(name="estoque")
	@ForeignKey(name="estoque_fk")
	private Estoque estoque;	

	private int idProduto;
	private int quantidade;
	
	ProdutoNoEstoque(){	}
	ProdutoNoEstoque(int _idProduto, int _qnt){
		idProduto = _idProduto;
		quantidade = _qnt;
	}
	
	public int getId_produtosNoEstoque() {
		return id_produtosNoEstoque;
	}
	public void setId_produtosNoEstoque(int id_produtosNoEstoque) {
		this.id_produtosNoEstoque = id_produtosNoEstoque;
	}
	
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	public int getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
