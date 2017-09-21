package com.app.jdbc.ps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.app.odbc.Conexion;
import com.app.odbc.Usuario;

public class UsuarioImplMySQL implements IUsuario {
	
	private Connection conn;
	
	public UsuarioImplMySQL() {
		Conexion mysql = new Conexion();
		this.conn = mysql.getConexion();
	}

	public int insertaUsuario(Usuario usr) {
		int res = 0;
		String sql = "INSERT INTO usuarios (nombre,usuario,password) VALUES (?,?,?)";
		
		try {
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, usr.getNombre());
			pstmt.setString(2, usr.getUsuario());
			pstmt.setString(3, usr.getPassword());
			pstmt.execute();
			res = 1;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return res;
	}

	public int eliminaUsuario(String id) {
		int res = 0;
		String sql = "DELETE FROM usuarios WHERE id = ?";
		
		try {
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.execute();
			res = 1;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return res;
	}

	public int editaUsuario(Usuario usr) {
		//Revisarlo no actualiza pero si muetra exito
		int res = 0;
		String sql = "UPDATE usuarios SET nombre = ?, usuario = ?, password = ? WHERE id = ?";
		Usuario usrdel = new Usuario();
		
		try {
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, usrdel.getNombre());
			pstmt.setString(2, usrdel.getUsuario());
			pstmt.setString(3, usrdel.getPassword());
			pstmt.setString(4, usrdel.getId());
			pstmt.execute();
			res = 1;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return res;
	}

	public Usuario consultaUsuarioByID(String id) {
		String sql = "SELECT * FROM usuarios WHERE id = ?";
		Usuario usr = new Usuario();
		
		try {
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while( rs.next()) {
				usr.setNombre(rs.getString("nombre"));
				usr.setUsuario(rs.getString("usuario"));
				usr.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usr;
	}

	public List<Usuario> consultaUsuario() {
		//Terminarlo
		/*List<Usuario> lista = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuarios";
		
		try {
			PreparedStatement stmt = ;
			ResultSet rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}*/
		return null;
	}
	
}
