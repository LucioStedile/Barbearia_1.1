package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.ClienteDao;
import model.UsuarioDTO;

import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class ViewConsulta extends JFrame {

	private JPanel contentPane;
	
	DefaultTableModel model;
	ArrayList<UsuarioDTO> lista;
	private JPanel panel_1;
	private JTable tableCliente;
	private JTabbedPane tabbedPane;
	private JTextField tfNumcadastro;
	private JTextField tfNome;
	private JTextField tfTelefone;
	private JTextField tfTotal;
	private JTextField tfCorte;
	private JTextField tfBarba;
	private JTextField tfPreco_1;
	private JTextField tfPreco_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewConsulta frame = new ViewConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public ViewConsulta() {
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lgste.000\\Documents\\Git\\Barbearia\\pincel.jpg"));
		setTitle("Barbearia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 524);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 914, 493);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				dispose();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Alterar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarCliente();
				listarValores();
				LimparCampos();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(719, 434, 89, 23);
		panel_1.add(btnNewButton_2);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBounds(521, 33, 89, 23);
		panel_1.add(btnVoltar);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastro viewCadastro = new ViewCadastro();
				viewCadastro.setVisible(true);
				
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(402, 33, 109, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(280, 33, 112, 23);
		panel_1.add(btnPesquisar);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listarValores();
			}
			
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_8 = new JLabel("Pesquisar Cliente");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(374, 0, 166, 22);
		panel_1.add(lblNewLabel_8);
		
		tableCliente = new JTable();
		tableCliente.setCellSelectionEnabled(true);
		tableCliente.setFont(new Font("Tahoma", Font.BOLD, 10));
		tableCliente.setModel(new  DefaultTableModel(
			new Object[][] {
				{"NºCADASTRO  ","                   NOME DO CLIENTE", "       TELEFONE", "   TIPO DE CORTE", "   TIPO DE BARBA", " PREÇO CORTE R$", " PREÇO BARBA R$", "     TOTAL R$"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableCliente.getColumnModel().getColumn(0).setPreferredWidth(70);
		tableCliente.getColumnModel().getColumn(1).setPreferredWidth(177);
		tableCliente.getColumnModel().getColumn(5).setPreferredWidth(75);
		tableCliente.getColumnModel().getColumn(6).setPreferredWidth(75);
		tableCliente.getColumnModel().getColumn(7).setPreferredWidth(54);
		tableCliente.setFillsViewportHeight(true);
		tableCliente.setColumnSelectionAllowed(true);
		tableCliente.setBackground(Color.CYAN);
		tableCliente.setBounds(0, 78, 913, 213);
		panel_1.add(tableCliente);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(271, 25, 351, 42);
		panel_1.add(tabbedPane);
		
		JLabel lblNewLabel = new JLabel("N\u00BA Cadastro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(31, 309, 82, 14);
		panel_1.add(lblNewLabel);
		
		tfNumcadastro = new JTextField();
		tfNumcadastro.setBackground(Color.BLACK);
		tfNumcadastro.setEnabled(false);
		tfNumcadastro.setBounds(110, 308, 109, 20);
		panel_1.add(tfNumcadastro);
		tfNumcadastro.setColumns(10);
		
		JButton btnCarregarCliente = new JButton("Carregar Cliente");
		btnCarregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarClientes();
			}
		});
		btnCarregarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCarregarCliente.setBounds(41, 334, 144, 23);
		panel_1.add(btnCarregarCliente);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 302, 219, 61);
		panel_1.add(tabbedPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(151, 368, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNome.setBounds(10, 388, 334, 20);
		panel_1.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(354, 391, 64, 17);
		panel_1.add(lblNewLabel_2);
		
		tfTelefone = new JTextField();
		tfTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTelefone.setBounds(415, 388, 112, 20);
		panel_1.add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Total R$");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(744, 391, 64, 14);
		panel_1.add(lblNewLabel_3);
		
		tfTotal = new JTextField();
		tfTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTotal.setBounds(818, 388, 86, 20);
		panel_1.add(tfTotal);
		tfTotal.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparCampos();
			}
		});
		btnLimpar.setBounds(815, 434, 89, 23);
		panel_1.add(btnLimpar);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo de Corte");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(20, 418, 109, 22);
		panel_1.add(lblNewLabel_4);
		
		tfCorte = new JTextField();
		tfCorte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCorte.setBounds(10, 447, 138, 20);
		panel_1.add(tfCorte);
		tfCorte.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo de Barba");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(329, 419, 89, 21);
		panel_1.add(lblNewLabel_5);
		
		tfBarba = new JTextField();
		tfBarba.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfBarba.setColumns(10);
		tfBarba.setBounds(296, 447, 138, 20);
		panel_1.add(tfBarba);
		
		JLabel lblNewLabel_6 = new JLabel("R$");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(151, 443, 17, 23);
		panel_1.add(lblNewLabel_6);
		
		tfPreco_1 = new JTextField();
		tfPreco_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPreco_1.setBounds(175, 447, 70, 20);
		panel_1.add(tfPreco_1);
		tfPreco_1.setColumns(10);
		
		JLabel lblNewLabel_6_1 = new JLabel("R$");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6_1.setBounds(436, 446, 17, 23);
		panel_1.add(lblNewLabel_6_1);
		
		tfPreco_2 = new JTextField();
		tfPreco_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPreco_2.setColumns(10);
		tfPreco_2.setBounds(457, 447, 70, 20);
		panel_1.add(tfPreco_2);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(0, 368, 540, 114);
		panel_1.add(tabbedPane_2);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExcluirCliente();
				listarValores();
				LimparCampos();
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExcluir.setBounds(620, 434, 89, 23);
		panel_1.add(btnExcluir);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setBounds(600, 368, 304, 114);
		panel_1.add(tabbedPane_3);
	}
	
	private void listarValores() {
		
		try {
			ClienteDao objclientedao = new ClienteDao();
			
			DefaultTableModel model = (DefaultTableModel) tableCliente.getModel();
			model.setNumRows(1);
			
			lista = objclientedao.consultarCliente();
			
			for(int num = 0; num < lista.size(); num ++){
				
				model.addRow(new Object[] {
						lista.get(num).getId_cliente(),
						lista.get(num).getNome_cliente(),
						lista.get(num).getTelefone_cliente(),
						lista.get(num).getTipo_de_corte(),
						lista.get(num).getTipo_de_barba(),
						lista.get(num).getPreco_corte(),
						lista.get(num).getPreco_barba(),
						lista.get(num).getTotal(),
					
				});
				
				tableCliente.setModel(model);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lista client" + e);
		}
	}
	
	private void CarregarClientes() {
		int setar = tableCliente.getSelectedRow();
		
		tfNumcadastro.setText(tableCliente.getModel().getValueAt(setar,  0).toString());
		tfNome.setText(tableCliente.getModel().getValueAt(setar, 1).toString());
		tfTelefone.setText(tableCliente.getModel().getValueAt(setar, 2).toString());
		tfCorte.setText(tableCliente.getModel().getValueAt(setar, 3).toString());
		tfBarba.setText(tableCliente.getModel().getValueAt(setar, 4).toString());
		tfPreco_1.setText(tableCliente.getModel().getValueAt(setar, 5).toString());
		tfPreco_2.setText(tableCliente.getModel().getValueAt(setar, 6).toString());
		tfTotal.setText(tableCliente.getModel().getValueAt(setar, 7).toString());
	}
	
	private void LimparCampos() {
		tfNumcadastro.setText("");
		tfNome.setText("");
		tfTelefone.setText("");
		tfCorte.setText("");
		tfBarba.setText("");
		tfPreco_1.setText("");
		tfPreco_2.setText("");
		tfTotal.setText("");
		
		tfNome.requestFocus();
	}
	
	private void AlterarCliente() {
		int id_cliente;
		String nome_cliente,telefone_cliente,tipoCabelo,tipoBarba;
		float preco_1,preco_2,total;
		
		id_cliente = Integer.parseInt(tfNumcadastro.getText());
		nome_cliente = tfNome.getText();
		telefone_cliente = tfTelefone.getText();
		tipoCabelo = tfCorte.getText();
		tipoBarba= tfBarba.getText();
		preco_1 = Float.parseFloat(tfPreco_1.getText());
		preco_2 = Float.parseFloat(tfPreco_2.getText());
		total = Float.parseFloat(tfTotal.getText());
		
		UsuarioDTO objusuariodto = new UsuarioDTO();
		objusuariodto.setId_cliente(id_cliente);
		objusuariodto.setNome_cliente(nome_cliente);
		objusuariodto.setTelefone_cliente(telefone_cliente);
		objusuariodto.setTipo_de_corte(tipoCabelo);
		objusuariodto.setTipo_de_barba(tipoBarba);
		objusuariodto.setPreco_corte(preco_1);
		objusuariodto.setPreco_barba(preco_2);
		objusuariodto.setTotal(total);
		
		ClienteDao objclientedao = new ClienteDao();
		objclientedao.alterarCliente(objusuariodto);;
		
	}
	
	private void ExcluirCliente() {
		int id_cliente;
				
		id_cliente = Integer.parseInt(tfNumcadastro.getText());
				
		UsuarioDTO objusuariodto = new UsuarioDTO();
		objusuariodto.setId_cliente(id_cliente);
				
		ClienteDao objclientedao = new ClienteDao();
		objclientedao.excluirCliente(objusuariodto);;
	}
}