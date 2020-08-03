package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estoque")
public class Estoque {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_estoque;
	
	@OneToMany(mappedBy="estoque", cascade = CascadeType.ALL)
	List<ProdutoNoEstoque> estoque = new ArrayList<>();

	public List<ProdutoNoEstoque> getProduto() {
		return estoque;
	}

	public void setProduto(List<ProdutoNoEstoque> _estoque) {
		this.estoque = _estoque;
	}
	
	public void add(ProdutoNoEstoque _p) {
		estoque.add(_p);
	}
}
