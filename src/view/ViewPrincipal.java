package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.security.AlgorithmConstraints;
import java.awt.event.ActionEvent;

public class ViewPrincipal extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrincipal frame = new ViewPrincipal();
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
	public ViewPrincipal() {
		setFont(null);
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1357, 755);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 194, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 701, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 1326, SpringLayout.WEST, contentPane);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 5, SpringLayout.NORTH, contentPane);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lgste.000\\Documents\\Git\\Barbearia\\sal\u00E3o2.jpg"));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 63, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 154, SpringLayout.WEST, contentPane);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Boolean lg;
				lg = Login.liberado.booleanValue();
				
				if(lg) {
					ViewCadastro viewCadastro = new ViewCadastro();
					viewCadastro.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "Login não efetuado");
				}
				
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 136, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -42, SpringLayout.NORTH, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 41, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, -40, SpringLayout.WEST, lblNewLabel);
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Consulta");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Boolean lg;
				lg = Login.liberado.booleanValue();
				
				if(lg) {
					ViewConsulta viewConsulta = new ViewConsulta();
					viewConsulta.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Login não efetuado");
				}
				
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_2, 42, SpringLayout.SOUTH, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 41, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_2, 73, SpringLayout.SOUTH, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_2, -40, SpringLayout.WEST, lblNewLabel);
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sair");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_3, 41, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_3, -40, SpringLayout.WEST, lblNewLabel);
		btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 16));
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_3, 39, SpringLayout.SOUTH, btnNewButton_2);
		contentPane.add(btnNewButton_3);
	}
}
