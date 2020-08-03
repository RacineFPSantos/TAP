package controller;

import javax.persistence.NoResultException;
import javax.swing.JOptionPane;

import model.TipoUsuario;
import model.Usuario;
import view.ClienteHUB;
import view.DrogariaHUB;
import view.LoginView;

public class LoginController extends BasicController {	
	LoginView lv;
	
	public LoginController(LoginView _lv) {
		lv = _lv;
	}

	public void Login(String nomeUsuario, String senha, boolean isEmpresa) {	
		getConnection();
		
		if(isEmpresa) {
			try { 
			      Usuario usuario = (Usuario) em.createQuery("SELECT usuario from Usuario usuario where "
			      		+ "usuario.login = :name and usuario.senha = :senha and usuario.tipoUsuario = :tipousuario")	        		  						
			    		  .setParameter("name", nomeUsuario)
			    		  .setParameter("senha", senha)
			    		  .setParameter("tipousuario", TipoUsuario.FUNCIONARIO).getSingleResult();	
			      
			          em.close();		          
			          
			          DrogariaHUB d = new DrogariaHUB();
			          lv.Close();
			          
			    }catch (NoResultException e) {
			    	JOptionPane.showMessageDialog(null, "Dados incorretos, Tente novamente", "Error Message", JOptionPane.ERROR_MESSAGE);
			    }
			
		}else {
			try { 
				Usuario usuario = (Usuario) em.createQuery("SELECT usuario from Usuario usuario where "
			      		+ "usuario.login = :name and usuario.senha = :senha and usuario.tipoUsuario = :tipousuario")	        		  						
			    		  .setParameter("name", nomeUsuario)
			    		  .setParameter("senha", senha)
			    		  .setParameter("tipousuario", TipoUsuario.CLIENTE).getSingleResult();	
			      
			          em.close();		          
			          
			          ClienteHUB c = new ClienteHUB(usuario.getCliente());
			          lv.Close();
			          
			    }catch (NoResultException e) {
			    	JOptionPane.showMessageDialog(null, "Dados incorretos, Tente novamente", "Error Message", JOptionPane.ERROR_MESSAGE);
			    }
		}
	}
	
	public void LoginJDBC(String nomeUsuario, String senha, boolean isEmpresa) {
		if(isEmpresa) {
			try { 
			      Usuario usuario = (Usuario) em.createQuery("SELECT usuario from Usuario usuario where "
			      		+ "usuario.login = :name and usuario.senha = :senha and usuario.tipoUsuario = :tipousuario")	        		  						
			    		  .setParameter("name", nomeUsuario)
			    		  .setParameter("senha", senha)
			    		  .setParameter("tipousuario", TipoUsuario.FUNCIONARIO).getSingleResult();	
			      
			          em.close();		          
			          
			          DrogariaHUB d = new DrogariaHUB();
			          lv.Close();
			          
			    }catch (NoResultException e) {
			    	JOptionPane.showMessageDialog(null, "Dados incorretos, Tente novamente", "Error Message", JOptionPane.ERROR_MESSAGE);
			    }
			
		}else {
			try { 
				Usuario usuario = (Usuario) em.createQuery("SELECT usuario from Usuario usuario where "
			      		+ "usuario.login = :name and usuario.senha = :senha and usuario.tipoUsuario = :tipousuario")	        		  						
			    		  .setParameter("name", nomeUsuario)
			    		  .setParameter("senha", senha)
			    		  .setParameter("tipousuario", TipoUsuario.CLIENTE).getSingleResult();	
			      
			          em.close();		          
			          
			          ClienteHUB c = new ClienteHUB(usuario.getCliente());
			          lv.Close();
			          
			    }catch (NoResultException e) {
			    	JOptionPane.showMessageDialog(null, "Dados incorretos, Tente novamente", "Error Message", JOptionPane.ERROR_MESSAGE);
			    }
		}
	}
}
