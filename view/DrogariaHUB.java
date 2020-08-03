package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.DrogariaController;
import model.Produto;
import model.ProdutoTableModel;

public class DrogariaHUB {

	private DrogariaController controller;
	private ProdutoTableModel tableModel;
	
	private JTable table;
	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtConfSenha;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtSobrenome;
	private JTextField nomeProduto;
	private JTextField txtValorUnid;
	private JTextField txtQuantidade;
	private JTextField txtDescricao;
	
	private boolean inLista = false;

	public DrogariaHUB() {
		
		controller = new DrogariaController();		
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); 		
		frame.setTitle("Drogaria HUB");
		
        JMenuBar menuBar = new JMenuBar();         
        frame.setJMenuBar(menuBar);
         
        JMenu fileMenu = new JMenu("File");
        JMenu cadMenu = new JMenu("Cadastrar");
        menuBar.add(fileMenu);
        menuBar.add(cadMenu);
         
        JMenuItem estoqueProdutos = new JMenuItem("Produtos");      
        JMenuItem exitAction = new JMenuItem("Exit");                
        JMenuItem cadAtendente = new JMenuItem("Atendente");       
        JMenuItem cadFarmaceutico = new JMenuItem("Farmacêutico");

        fileMenu.add(estoqueProdutos);
        fileMenu.add(exitAction);
        cadMenu.add(cadAtendente);
        cadMenu.add(cadFarmaceutico);
        
        JPanel CardPanel = new JPanel();
        CardPanel.setBounds(0, 0, 484, 512);
        frame.getContentPane().add(CardPanel, BorderLayout.NORTH);
        CardPanel.setLayout(new CardLayout(0, 0));
        
		JPanel cardAtendente = formAtendente();
        CardPanel.add(cardAtendente, "atendente");
        cardAtendente.setLayout(null);
        
        JPanel cardFarmaceutico = formFarmaceutico();
        CardPanel.add(cardFarmaceutico, "farmaceutico");
        cardFarmaceutico.setLayout(null);                  
        
        JPanel cardListaProdutos = GerenciarEstoque();
        CardPanel.add(cardListaProdutos, "listaProdutos");
        
        estoqueProdutos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) { 	
        		
        		inLista = true;        		
        		tableModel.updateLista(controller.listarProdutos());    		
        		
        		CardLayout cl = (CardLayout) CardPanel.getLayout();
        		cl.show(CardPanel, "listaProdutos");
        	}
        });
        
        cadAtendente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if(inLista) { 
        			salvarBancoPopUp();
        			inLista = false;
        		}
        		
        		CardLayout cl = (CardLayout) CardPanel.getLayout();
        		cl.show(CardPanel, "atendente");
        	}
        });
                
        cadFarmaceutico.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(inLista) { 
        			salvarBancoPopUp(); 
        			inLista = false;
        		}
        		
        		CardLayout cl = (CardLayout) CardPanel.getLayout();
        		cl.show(CardPanel, "farmaceutico");
        	}
        });
                        
		frame.setVisible(true);
	}
	
	private JPanel formAtendente() {
		JPanel cardAtendente = new JPanel();
		
        JLabel lblNewLabel = new JLabel("Cadastro atendente");
        lblNewLabel.setBounds(10, 11, 370, 14);
        cardAtendente.add(lblNewLabel);
        
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(10, 36, 46, 14);
        cardAtendente.add(lblNome);
        
        txtNome = new JTextField();
        txtNome.setBounds(66, 33, 72, 20);
        cardAtendente.add(txtNome);
        txtNome.setColumns(10);
        
        JLabel lblCpf = new JLabel("CPF");
        lblCpf.setBounds(10, 64, 46, 14);
        cardAtendente.add(lblCpf);
        
        txtCpf = new JTextField();
        txtCpf.setBounds(66, 61, 314, 20);
        cardAtendente.add(txtCpf);
        txtCpf.setColumns(10);
        
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setBounds(10, 95, 46, 14);
        cardAtendente.add(lblSenha);
        
        JTextField txtSenha = new JTextField();
        txtSenha.setBounds(66, 92, 72, 20);
        cardAtendente.add(txtSenha);
        txtSenha.setColumns(10);
        
        JLabel lblConfSenha = new JLabel("Confirma\u00E7\u00E3o Senha");
        lblConfSenha.setBounds(148, 95, 99, 14);
        cardAtendente.add(lblConfSenha);
        
        txtConfSenha = new JTextField();
        txtConfSenha.setBounds(260, 92, 120, 20);
        cardAtendente.add(txtConfSenha);
        txtConfSenha.setColumns(10);
        
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(10, 134, 46, 14);
        cardAtendente.add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(66, 131, 314, 20);
        cardAtendente.add(txtEmail);
        txtEmail.setColumns(10);
        
        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setBounds(10, 174, 46, 14);
        cardAtendente.add(lblTelefone);
        
        txtTelefone = new JTextField();
        txtTelefone.setBounds(66, 171, 314, 20);
        cardAtendente.add(txtTelefone);
        txtTelefone.setColumns(10);
        
        JLabel lblSobrenome = new JLabel("Sobrenome");
        lblSobrenome.setBounds(148, 36, 61, 14);
        cardAtendente.add(lblSobrenome);
        
        txtSobrenome = new JTextField();
        txtSobrenome.setBounds(219, 33, 161, 20);
        cardAtendente.add(txtSobrenome);
        txtSobrenome.setColumns(10);
        
		return cardAtendente;
	}
	
	private JPanel formFarmaceutico() {
		JPanel cardFarmaceutico = new JPanel();
		
        JLabel lblNewLabel = new JLabel("Cadastro Farmaceutico");
        lblNewLabel.setBounds(10, 11, 370, 14);
        cardFarmaceutico.add(lblNewLabel);
        
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(10, 36, 46, 14);
        cardFarmaceutico.add(lblNome);
        
        txtNome = new JTextField();
        txtNome.setBounds(66, 33, 72, 20);
        cardFarmaceutico.add(txtNome);
        txtNome.setColumns(10);
        
        JLabel lblCpf = new JLabel("CPF");
        lblCpf.setBounds(10, 64, 46, 14);
        cardFarmaceutico.add(lblCpf);
        
        txtCpf = new JTextField();
        txtCpf.setBounds(66, 61, 314, 20);
        cardFarmaceutico.add(txtCpf);
        txtCpf.setColumns(10);
        
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setBounds(10, 95, 46, 14);
        cardFarmaceutico.add(lblSenha);
        
        JTextField txtSenha = new JTextField();
        txtSenha.setBounds(66, 92, 72, 20);
        cardFarmaceutico.add(txtSenha);
        txtSenha.setColumns(10);
        
        JLabel lblConfSenha = new JLabel("Confirma\u00E7\u00E3o Senha");
        lblConfSenha.setBounds(148, 95, 99, 14);
        cardFarmaceutico.add(lblConfSenha);
        
        txtConfSenha = new JTextField();
        txtConfSenha.setBounds(260, 92, 120, 20);
        cardFarmaceutico.add(txtConfSenha);
        txtConfSenha.setColumns(10);
        
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(10, 134, 46, 14);
        cardFarmaceutico.add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(66, 131, 314, 20);
        cardFarmaceutico.add(txtEmail);
        txtEmail.setColumns(10);
        
        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setBounds(10, 174, 46, 14);
        cardFarmaceutico.add(lblTelefone);
        
        txtTelefone = new JTextField();
        txtTelefone.setBounds(66, 171, 314, 20);
        cardFarmaceutico.add(txtTelefone);
        txtTelefone.setColumns(10);
        
        JLabel lblSobrenome = new JLabel("Sobrenome");
        lblSobrenome.setBounds(148, 36, 61, 14);
        cardFarmaceutico.add(lblSobrenome);
        
        txtSobrenome = new JTextField();
        txtSobrenome.setBounds(219, 33, 161, 20);
        cardFarmaceutico.add(txtSobrenome);
        txtSobrenome.setColumns(10);
        
		return cardFarmaceutico;
	}
		
	private JPanel GerenciarEstoque() {
		tableModel = new ProdutoTableModel();
		
		JPanel cardListaProdutos = new JPanel();
        cardListaProdutos.setLayout(null);
		
        JLabel lblListaProdutos = new JLabel("Lista de Produtos");
        lblListaProdutos.setBounds(10, 11, 414, 14);
        cardListaProdutos.add(lblListaProdutos);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 89, 464, 378);
        cardListaProdutos.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(tableModel);
        
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(10, 36, 46, 14);
        cardListaProdutos.add(lblNome);
        
        nomeProduto = new JTextField();
        nomeProduto.setBounds(43, 33, 136, 20);
        cardListaProdutos.add(nomeProduto);
        nomeProduto.setColumns(10);
        
        JLabel lblVarlorUni = new JLabel("Valor Unidade");
        lblVarlorUni.setBounds(189, 36, 75, 14);
        cardListaProdutos.add(lblVarlorUni);
        
        txtValorUnid = new JTextField();
        txtValorUnid.setBounds(258, 33, 75, 20);
        cardListaProdutos.add(txtValorUnid);
        txtValorUnid.setColumns(10);
        
        JLabel lblqnt = new JLabel("Quantidade");
        lblqnt.setBounds(343, 36, 63, 14);
        cardListaProdutos.add(lblqnt);
        
        txtQuantidade = new JTextField();
        txtQuantidade.setBounds(416, 33, 58, 20);
        cardListaProdutos.add(txtQuantidade);
        txtQuantidade.setColumns(10);
        
        JLabel lblDescricao = new JLabel("Descricao");
        lblDescricao.setBounds(10, 64, 46, 14);
        cardListaProdutos.add(lblDescricao);
        
        txtDescricao = new JTextField();
        txtDescricao.setBounds(66, 61, 408, 20);
        cardListaProdutos.add(txtDescricao);
        txtDescricao.setColumns(10);
        
        //TODO - Try catch
        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) { 
        		if(controller.verificarIsEmpty(nomeProduto.getText())) {
        			if(controller.verificarIsEmpty(txtValorUnid.getText())) {
        				if(controller.verificarIsEmpty(txtQuantidade.getText())) {
        					if(controller.verificarIsEmpty(txtDescricao.getText())) {
        						Produto p = new Produto(nomeProduto.getText(), txtValorUnid.getText(), txtQuantidade.getText(), txtDescricao.getText());     						      						
        						if(controller.CadastrarProduto(p)) {
        							tableModel.addRow(p);       					
        						}        						 		   		
        					}else {	controller.showMessage("Campo descrição, não pode estar vazio"); }
        				}else {	controller.showMessage("Campo quantidade, não pode estar vazio"); }
        			}else {	controller.showMessage("Campo valor unidade, não pode estar vazio"); }
        		}else {	controller.showMessage("Campo nome, não pode estar vazio"); }      		
        	}
        });
        btnAdicionar.setBounds(109, 478, 115, 23);
        cardListaProdutos.add(btnAdicionar);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {        		
        		if(table.getSelectedRow() != -1) {       			
					if (controller.verificarIsEmpty(nomeProduto.getText()))
						tableModel.setValueAt(nomeProduto.getText(), table.getSelectedRow(), 1);

					if (controller.verificarIsEmpty(txtValorUnid.getText()))
						tableModel.setValueAt(txtValorUnid.getText(), table.getSelectedRow(), 2);

					if (controller.verificarIsEmpty(txtQuantidade.getText()))
						tableModel.setValueAt(txtQuantidade.getText(), table.getSelectedRow(), 3);

					if (controller.verificarIsEmpty(txtDescricao.getText()))
						tableModel.setValueAt(txtDescricao.getText(), table.getSelectedRow(), 4); 
					
					controller.atualizarProduto(tableModel.getRowProduto(table.getSelectedRow()));
					
        		}else {
        			System.out.println("Selecione um produto");
        		}
        	}
        });
        btnAtualizar.setBounds(234, 478, 115, 23);
        cardListaProdutos.add(btnAtualizar);
        
        JButton btnRemover = new JButton("Remover");
        btnRemover.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(table.getSelectedRow() != -1) {
        			if(controller.removerProduto((int) table.getValueAt(table.getSelectedRow(), 0))) {
        				tableModel.removeRow(table.getSelectedRow());
        			}
        		}
        	}
        });
        btnRemover.setBounds(359, 478, 115, 23);
        cardListaProdutos.add(btnRemover);
                                
		return cardListaProdutos;
	}
	
	private void salvarBancoPopUp(){
		controller.showMessage("Deseja salvar as mudanças?");
	}
}
