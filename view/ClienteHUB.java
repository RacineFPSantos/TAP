package view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import controller.ClienteController;
import model.CompraTableModel;
import model.Entidade;
import model.TipoConexao;

public class ClienteHUB {

	private ClienteController controllerc = new ClienteController();
	private CompraTableModel tableModel = new CompraTableModel();
	private JFrame frame;
	private JTable table;
	
	private TipoConexao tipoConexao = TipoConexao.JPA;

	public ClienteHUB(Entidade entidade) {
		initialize();		
		tableModel.updateLista(controllerc.listarProdutos());		
	}

	private void initialize() {		
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel clienteOptions = new JPanel();
		clienteOptions.setBounds(0, 0, 130, 322);
		frame.getContentPane().add(clienteOptions);
		clienteOptions.setLayout(null);
		
		JLabel lblClienteNome = new JLabel("nomeCliente");
		lblClienteNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblClienteNome.setBounds(0, 0, 130, 29);
		clienteOptions.add(lblClienteNome);
		
		JButton btnListaProdutos = new JButton("Listar Produtos");		
		btnListaProdutos.setBounds(10, 40, 110, 50);
		clienteOptions.add(btnListaProdutos);
		
		JButton btnNewButton = new JButton("Carrinho");
		btnNewButton.setBounds(10, 101, 110, 50);
		clienteOptions.add(btnNewButton);
				
		JLabel lblBancoAtual = new JLabel("JPA");
		lblBancoAtual.setHorizontalAlignment(SwingConstants.CENTER);
		lblBancoAtual.setBounds(20, 263, 89, 23);
		clienteOptions.add(lblBancoAtual);
		
		JButton btnMudarBanco = new JButton("Mudar Banco");
		btnMudarBanco.setBounds(10, 288, 110, 23);
		clienteOptions.add(btnMudarBanco);
		
		JPanel panel = new JPanel();
		panel.setBounds(140, 0, 384, 322);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel jpCompras = new JPanel();
		panel.add(jpCompras, "name_1719507947696000");
		jpCompras.setLayout(null);
		
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 384, 265);
        jpCompras.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(tableModel);
        
		JPanel jpCarrinho = new JPanel();
		panel.add(jpCarrinho, "name_1719519324900100");
		
		btnListaProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(tipoConexao.equals(TipoConexao.JPA)) {
					tableModel.updateLista(controllerc.listarProdutos());
				}
				
				if(tipoConexao.equals(TipoConexao.JDBC)) {
					tableModel.updateLista(controllerc.listarProdutos());
				}		
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
		
		frame.setVisible(true);
	}
}
