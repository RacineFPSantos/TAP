package controller;

import java.util.List;

import javax.persistence.Query;

import model.Produto;

public class ClienteController extends BasicController{
		
	//Carregar Lista estoque
    public List<Produto> listarProdutos(){
    	getConnection();
    	
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT produto FROM Produto produto");
		List<Produto> lista = query.getResultList();
				
		em.close();
		return lista;
    }	   
    
}
