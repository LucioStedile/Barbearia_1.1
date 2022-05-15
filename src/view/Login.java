package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UsuarioDao;
import model.UsuarioDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JLabel lblNewLabel_1;
	private JPasswordField tfSenha;
	public static Boolean liberado = false;


	public static void login(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setType(Type.UTILITY);
		setAutoRequestFocus(false);
		setResizable(false);
		setForeground(new Color(192, 192, 192));
		setFont(new Font("Dialog", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lgste.000\\Documents\\Git\\Barbearia\\pincel.jpg"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Usu\u00E1rio");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 25, 84, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("  Senha");
		lblSenha.setForeground(Color.DARK_GRAY);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenha.setBounds(10, 93, 70, 27);
		contentPane.add(lblSenha);
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		tfUsuario.setBounds(10, 53, 138, 25);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				Logar();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(30, 201, 89, 23);
		contentPane.add(btnNewButton);
		
		tfSenha = new JPasswordField();
		tfSenha.setBackground(Color.WHITE);
		tfSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		tfSenha.setBounds(10, 121, 138, 25);
		contentPane.add(tfSenha);
		tfSenha.setColumns(10);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\lgste.000\\Documents\\Git\\Barbearia\\pexels-josh-sorenson-995300.jpg"));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_1);
	}
	
	private void Logar() {
		try {
			String nome_usuario, senha_usuario;
			
			nome_usuario = tfUsuario.getText();
			senha_usuario = new String(tfSenha.getPassword()) ;
			
			UsuarioDTO objusuariodto = new UsuarioDTO();
			
			objusuariodto.setNome_usuario(nome_usuario);
			objusuariodto.setSenha_usuario(senha_usuario);
			
			UsuarioDao objusuariodao = new UsuarioDao();
			ResultSet rsusuario = objusuariodao.autentUsuario(objusuariodto);
			
						
			if(rsusuario.next()) {
				liberado = true;
				
				dispose();
				
			}else {
				liberado = false;
				JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválida!");
			}
			
		}catch(SQLException erro) {
			JOptionPane.showMessageDialog(null,"Erro ao tentar se Logar!" + erro);
		}
	}
}
