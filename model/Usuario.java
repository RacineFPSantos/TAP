package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_usuario;
	
	@Column
	private String login;
	@Column
	private String senha;
	@Column
	private TipoUsuario tipoUsuario;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_entidade")
	private Entidade entidade;    
    
	public Usuario(){}
	
	public Usuario(String _login, String _senha, Entidade _entidade, TipoUsuario _tipo){
		login = _login;
		senha = _senha;
		entidade = _entidade;
		tipoUsuario = _tipo;		
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String _login) {
		login = _login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String _senha) {
		senha = _senha;
	}
	
	public Entidade getCliente() {
		return entidade;
	}
	
	public void setEntidade(Entidade _entidade) {
		entidade = _entidade;
	}
	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	
	public void setTipoUsuario(TipoUsuario _ts) {
		tipoUsuario = _ts;
	}
}
