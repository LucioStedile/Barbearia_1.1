package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ClienteDao;
import model.UsuarioDTO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JTabbedPane;

public class ViewCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfTelefone;
	private JTextField tfTipo_de_corte;
	private JTextField tfTipo_de_barba;
	private JTextField tfPreco_corte;
	private JTextField tfPreco_barba;
	private JTextField tfTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastro frame = new ViewCadastro();
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
	public ViewCadastro() {
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lgste.000\\Documents\\Git\\Barbearia\\pincel.jpg"));
		setResizable(false);
		setTitle("Barbearia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 536);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(291, 11, 96, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(21, 144, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNome.setBounds(66, 141, 359, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(449, 144, 82, 14);
		contentPane.add(lblNewLabel_2);
		
		tfTelefone = new JTextField();
		tfTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTelefone.setBounds(516, 141, 130, 20);
		contentPane.add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar Cliente");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome,telefone,tipo_de_corte,tipo_de_barba;
				Float preco_corte, preco_barba, total;
				
				nome = tfNome.getText();
				telefone = tfTelefone.getText();
				tipo_de_corte = tfTipo_de_corte.getText();
				tipo_de_barba = tfTipo_de_barba.getText();
				preco_corte = Float.parseFloat(tfPreco_corte.getText()) ;
				preco_barba = Float.parseFloat(tfPreco_barba.getText());
				total = Float.parseFloat(tfTotal.getText());
				
				UsuarioDTO objclientedto = new UsuarioDTO();
				objclientedto.setNome_cliente(nome);
				objclientedto.setTelefone_cliente(telefone);
				objclientedto.setTipo_de_corte(tipo_de_corte);
				objclientedto.setTipo_de_barba(tipo_de_barba);
				objclientedto.setPreco_corte(preco_corte);
				objclientedto.setPreco_barba(preco_barba);
				objclientedto.setTotal(total);
				
				ClienteDao objclientedao = new ClienteDao();
				objclientedao.cadastrarCliente(objclientedto);
			}
		});
		btnCadastrar.setBounds(134, 53, 143, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de corte");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(15, 228, 126, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo de barba");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(15, 299, 109, 14);
		contentPane.add(lblNewLabel_4);
		
		tfTipo_de_corte = new JTextField();
		tfTipo_de_corte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTipo_de_corte.setBounds(117, 225, 359, 20);
		contentPane.add(tfTipo_de_corte);
		tfTipo_de_corte.setColumns(10);
		
		tfTipo_de_barba = new JTextField();
		tfTipo_de_barba.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTipo_de_barba.setBounds(121, 296, 355, 20);
		contentPane.add(tfTipo_de_barba);
		tfTipo_de_barba.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Pre\u00E7o");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(485, 228, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Pre\u00E7o");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(485, 299, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		tfPreco_corte = new JTextField();
		tfPreco_corte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPreco_corte.setBounds(560, 225, 86, 20);
		contentPane.add(tfPreco_corte);
		tfPreco_corte.setColumns(10);
		
		tfPreco_barba = new JTextField();
		tfPreco_barba.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPreco_barba.setBounds(560, 296, 86, 20);
		contentPane.add(tfPreco_barba);
		tfPreco_barba.setColumns(10);
		
		tfTotal = new JTextField();
		tfTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTotal.setBounds(560, 413, 86, 20);
		contentPane.add(tfTotal);
		tfTotal.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Total");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(485, 416, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btnConsultarClientes = new JButton("Consultar Clientes");
		btnConsultarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewConsulta viewConsulta = new ViewConsulta();
				viewConsulta.setVisible(true);
				
				dispose();
			}
		});
		btnConsultarClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarClientes.setBounds(287, 53, 152, 23);
		contentPane.add(btnConsultarClientes);
		
		JLabel lblNewLabel_8 = new JLabel("R$");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(531, 228, 19, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("R$");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8_1.setBounds(533, 298, 28, 17);
		contentPane.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_2 = new JLabel("R$");
		lblNewLabel_8_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8_2.setBounds(535, 412, 26, 22);
		contentPane.add(lblNewLabel_8_2);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(449, 53, 89, 23);
		contentPane.add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 125, 649, 54);
		contentPane.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(117, 44, 434, 41);
		contentPane.add(tabbedPane_1);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(478, 403, 181, 41);
		contentPane.add(tabbedPane_2);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setBounds(10, 213, 649, 47);
		contentPane.add(tabbedPane_3);
		
		JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_4.setBounds(10, 282, 649, 47);
		contentPane.add(tabbedPane_4);
	}
}
