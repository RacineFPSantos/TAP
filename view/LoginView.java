package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.LoginController;
import model.TipoConexao;

public class LoginView {
	
	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField pfPassword;
	
	private TipoConexao tipoConexao = TipoConexao.JPA;
	
	private LoginController lc;
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginView() {
		lc = new LoginController(this);
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Usu\u00E1rio");
		lblUsername.setBounds(50, 83, 46, 14);
		frame.getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(95, 77, 129, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setBounds(50, 114, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(95, 108, 129, 20);
		frame.getContentPane().add(pfPassword);
		
		JLabel lblLogo = new JLabel("Farm\u00E1cia Brasil");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogo.setBounds(73, 5, 132, 67);
		frame.getContentPane().add(lblLogo);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.setBounds(50, 159, 174, 37);
		frame.getContentPane().add(btnLogin);
		
		JButton btnCadastro = new JButton("AQUI");
		btnCadastro.setBounds(168, 232, 89, 23);
		frame.getContentPane().add(btnCadastro);
		
		JLabel lblCadastro = new JLabel("N\u00E3o \u00E9 cadastrado? Click");
		lblCadastro.setBounds(10, 236, 148, 14);
		frame.getContentPane().add(lblCadastro);
		
		JCheckBox cbEmpresa = new JCheckBox("Entrar como drogaria");
		cbEmpresa.setBounds(3, 297, 254, 23);
		frame.getContentPane().add(cbEmpresa);
		
		JLabel lblBancoAtual = new JLabel("JPA");
		lblBancoAtual.setHorizontalAlignment(SwingConstants.CENTER);
		lblBancoAtual.setBounds(116, 327, 89, 23);
		frame.getContentPane().add(lblBancoAtual);
		
		JButton btnMudarBanco = new JButton("Mudar Banco");
		btnMudarBanco.setBounds(3, 327, 110, 23);
		frame.getContentPane().add(btnMudarBanco);
		
		btnLogin.addActionListener(new ActionListener() {	
			
		public void actionPerformed(ActionEvent event) {
			if(lc.verificarIsEmpty(txtUsername.getText())) {
				if(lc.verificarIsEmpty(new String(pfPassword.getPassword()))) {	
					lc.Login(txtUsername.getText(), new String(pfPassword.getPassword()),cbEmpresa.isSelected());	
				}else {lc.showMessage("Digite o seu senha");}							
			}else {lc.showMessage("Digite o seu usuário");}							
		}});
		
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				cadastroForm();
			}
		});		
		
		btnMudarBanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(lblBancoAtual.getText().equals("JPA")) {
					tipoConexao = TipoConexao.JDBC;
					lblBancoAtual.setText("JDBC");					
				}
				else if(lblBancoAtual.getText().equals("JDBC")) {
					tipoConexao = TipoConexao.JPA;
					lblBancoAtual.setText("JPA");					
				}
			}
		});
	}
	
	private void cadastroForm() {		
		try {
			CadastroFormulario dialog = new CadastroFormulario(lc, tipoConexao);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Close() {
		frame.dispose();		
	}
}
