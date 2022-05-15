package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.UsuarioDTO;

public class UsuarioDao{
	
	Connection conn;
	PreparedStatement pstm;
	
	public ResultSet autentUsuario(UsuarioDTO objusuariodto) {
		
		conn = new ConnectionFactory().getConnection();
		
		try {
			String sql = "select * from usuario where nome_usuario= ? and senha_usuario = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objusuariodto.getNome_usuario());
			pstm.setString(2, objusuariodto.getSenha_usuario());
			
			ResultSet rs = pstm.executeQuery();
			
			return rs;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Usuario não encontrado!" + e);
			return null;
		}
		
	}
	
}
