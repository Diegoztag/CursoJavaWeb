package com.app.servlets.samples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioImpl {
	public Usuario getUsuarios(String usuario, String password) {
		Usuario usr = new Usuario();
		String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";
		Conexion mysql = new Conexion();
		Connection conn = mysql.getConexion();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usuario);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				usr.setId(rs.getString("id"));
				usr.setNombre(rs.getString("usuario"));
				usr.setPassword(rs.getString("password"));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return usr;
	}
	
}
