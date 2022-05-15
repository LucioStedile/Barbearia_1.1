package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.UsuarioDTO;

public class ClienteDao {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<UsuarioDTO> lista = new ArrayList<>();
	
	public void cadastrarCliente(UsuarioDTO objclientedto) {
		String sql = "insert into clientes (nome_cliente, telefone_cliente, tipo_de_corte, tipo_de_barba, preco_corte, preco_barba, total) values (?,?,?,?,?,?,?)";
		
		conn = new ConnectionFactory().getConnection();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objclientedto.getNome_cliente());
			pstm.setString(2, objclientedto.getTelefone_cliente());
			pstm.setString(3, objclientedto.getTipo_de_corte());
			pstm.setString(4, objclientedto.getTipo_de_barba());
			pstm.setFloat(5, objclientedto.getPreco_corte());
			pstm.setFloat(6, objclientedto.getPreco_barba());
			pstm.setFloat(7, objclientedto.getTotal());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Cadastrar Cliente" + e);
		}
	}
	
	public ArrayList<UsuarioDTO> consultarCliente() {
		String sql = "select * from clientes";
		conn = new ConnectionFactory().getConnection();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				UsuarioDTO objclientedto = new UsuarioDTO();
		
				objclientedto.setId_cliente(rs.getInt("id_cliente"));
				objclientedto.setNome_cliente(rs.getString("nome_cliente"));
				objclientedto.setTelefone_cliente(rs.getString("telefone_cliente"));
				objclientedto.setTipo_de_corte(rs.getString("tipo_de_corte"));
				objclientedto.setTipo_de_barba(rs.getString("tipo_de_barba"));
				objclientedto.setPreco_corte(rs.getFloat("preco_corte"));
				objclientedto.setPreco_barba(rs.getFloat("preco_barba"));
				objclientedto.setTotal(rs.getFloat("total"));
				
				lista.add(objclientedto);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Consultar Cliente" + e);
		}
		return lista;
	}
	
	public void alterarCliente(UsuarioDTO objclientedto) {
		String sql = "update clientes set nome_cliente=?, telefone_cliente=?,"
				+ " tipo_de_corte=?, tipo_de_barba=?, preco_corte=?,"
				+ " preco_barba=?, total=? where id_cliente=?";
		conn = new ConnectionFactory().getConnection();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objclientedto.getNome_cliente());
			pstm.setString(2, objclientedto.getTelefone_cliente());
			pstm.setString(3, objclientedto.getTipo_de_corte());
			pstm.setString(4, objclientedto.getTipo_de_barba());
			pstm.setFloat(5, objclientedto.getPreco_corte());
			pstm.setFloat(6, objclientedto.getPreco_barba());
			pstm.setFloat(7, objclientedto.getTotal());
			pstm.setInt(8, objclientedto.getId_cliente());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Alterar Cliente" + e);
		}
		
	}
	
	public void excluirCliente(UsuarioDTO objclientedto) {
		String sql = "delete from clientes where id_cliente=?";
		conn = new ConnectionFactory().getConnection();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, objclientedto.getId_cliente());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Excluir Cliente" + e);
		}
	}
}
