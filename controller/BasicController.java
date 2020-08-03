package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import dao.ConnectionFactory;
import model.Contatos;
import model.Usuario;

public class BasicController {	
	EntityManager em;
	Connection conn = null;
	ConnectionFactory cf = new ConnectionFactory();
	
	public void Cadastro(Usuario usuario) {			
		getConnection();	
		
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
	    em.close();		
	}
	
	public void CadastroJDBC(Contatos contatos) {		
		getConnectionJDBC();
		
		Statement stm;
		try {
			stm = (Statement) conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM produto");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	protected void getConnectionJDBC(){
		try {			
			conn = cf.getConnectionJDBC();
			
			if(conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("A conexão aconteceu");
		
			
		}catch(SQLException e) {			
			showMessage("Problema na conexão com o SGBD: "
					+ e.getMessage());
		}
	}
	
	protected void getConnection(){
		em = cf.getConnection();
	}

	public boolean verificarIsEmpty(String string) {
		return !string.equals("");
	}
	
	public void showMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error Message", JOptionPane.ERROR_MESSAGE);
	}
}
