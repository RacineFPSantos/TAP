package view;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import model.Cliente;
import model.Contatos;
import model.TipoConexao;
import model.TipoUsuario;
import model.Usuario;

public class CadastroFormulario extends JDialog {
	private static final long serialVersionUID = 1L;

	private LoginController lc;	
	private final JPanel contentPanel = new JPanel();

	private JPasswordField pfPassword;
	private JPasswordField pfConfirmPassword;
	private JTextField txtusername;
	private JTextField txtFirstName;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	
	private TipoConexao tipoConexao = TipoConexao.JPA;
	
	public CadastroFormulario(LoginController _lc, TipoConexao tipo) {	
		tipoConexao = tipo;
		
		lc =_lc;
		
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 250, 380);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(27, 58, 61, 14);
		contentPanel.add(lblUsername);
		
		txtusername = new JTextField();
		txtusername.setBounds(117, 52, 86, 20);
		contentPanel.add(txtusername);
		txtusername.setColumns(10);		
		
		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setBounds(27, 82, 46, 14);
		contentPanel.add(lblPassword);

		JLabel lblConfirmPassword = new JLabel("Confirmar senha");
		lblConfirmPassword.setBounds(27, 107, 86, 14);
		contentPanel.add(lblConfirmPassword);

		pfPassword = new JPasswordField();
		pfPassword.setBounds(117, 79, 86, 20);
		contentPanel.add(pfPassword);

		pfConfirmPassword = new JPasswordField();
		pfConfirmPassword.setBounds(116, 104, 87, 20);
		contentPanel.add(pfConfirmPassword);

		JLabel lblTitleAccess = new JLabel("Dados de Acesso");
		lblTitleAccess.setBounds(27, 21, 176, 14);
		contentPanel.add(lblTitleAccess);
		
		JLabel lblfirstName = new JLabel("Primeiro nome");
		lblfirstName.setBounds(27, 166, 74, 14);
		contentPanel.add(lblfirstName);		
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(117, 163, 86, 20);
		contentPanel.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblTitleInformation = new JLabel("Informa\u00E7\u00F5es");
		lblTitleInformation.setBounds(27, 144, 176, 14);
		contentPanel.add(lblTitleInformation);
		
		JLabel lblTitleContato = new JLabel("Contato"); 
		lblTitleContato.setBounds(27, 212, 46, 14);
		contentPanel.add(lblTitleContato);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(27, 237, 46, 14);
		contentPanel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(117, 234, 86, 20);
		contentPanel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone"); 
		lblTelefone.setBounds(27, 270, 46, 14);
		contentPanel.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(117, 267, 86, 20);
		contentPanel.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("Cadastrar");
		okButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
				if(lc.verificarIsEmpty(txtusername.getText())) {
					if(lc.verificarIsEmpty(new String(pfPassword.getPassword()))){
						if(lc.verificarIsEmpty(new String(pfConfirmPassword.getPassword()))) {
							if(lc.verificarIsEmpty(txtFirstName.getText())) {
								if(lc.verificarIsEmpty(txtEmail.getText())) {
									if(lc.verificarIsEmpty(txtTelefone.getText())) {									
										if(new String(pfPassword.getPassword()).equals(new String(pfConfirmPassword.getPassword()))) {
											if(tipo.equals(TipoConexao.JPA)) {
												lc.Cadastro(
														new Usuario(txtusername.getText(), new String(pfPassword.getPassword()), 
																new Cliente(txtFirstName.getText(), 
																		new Contatos( txtEmail.getText(), txtTelefone.getText())), TipoUsuario.CLIENTE));
											}
											
											//TODO - Verificar se essa é a melhor forma
											dispose();
											
										}else { lc.showMessage("Senhas não são iguais");}									
									}else { lc.showMessage("Digite o telefone");}								
								}else { lc.showMessage("Digite o email");}			
							}else { lc.showMessage("Digite o seu primeiro nome");}
						}else { lc.showMessage("Digite o password de confirmação");}					
					}else { lc.showMessage("Digite o password");}
				}else {lc.showMessage("Digite o seu usuário");}
			}
		});
		
		buttonPane.add(okButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		buttonPane.add(cancelButton);
	}
}
