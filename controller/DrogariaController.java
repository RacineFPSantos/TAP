package controller;

import java.util.List;

import javax.persistence.Query;

import model.Produto;

public class DrogariaController extends BasicController {
	
	//Para Cadastrar chama Cadastro que se encontra em BasicController()
	
	//Aqui é de produto
	public boolean CadastrarProduto(Produto produto) {
		getConnection();
		
		try {				
			em.getTransaction().begin();		
			em.persist(produto);				
			em.getTransaction().commit();
		} 
		catch (Exception e) {			
			System.out.println(e);			
			em.getTransaction().rollback();
			return false;
		}finally{
			em.close();
		}
		
		return true;
	}	
	
	//Atualizar produto
	public boolean atualizarProduto(Produto _p) {
		getConnection();
		
		try {				
			em.getTransaction().begin();
			em.merge(_p);
			em.getTransaction().commit();
		} 
		catch (Exception e) {			
			System.out.println(e);			
			em.getTransaction().rollback();
			return false;
		}finally{
			em.close();
		}
		
		return true;			
	}
	
	//Deletar Produto
	public boolean removerProduto(int id) {
		getConnection();
		
		try {
			Produto p = em.find(Produto.class, id);
			
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
		} 
		catch (Exception e) {			
			System.out.println(e);			
			em.getTransaction().rollback();
			return false;
		}finally{
			em.close();
		}
		
		return true;			
	}
	
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
