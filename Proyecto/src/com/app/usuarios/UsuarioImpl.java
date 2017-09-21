package com.app.usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.db.Conexion;

public class UsuarioImpl {
	
	private Connection conn;
	
	public UsuarioImpl() {
		Conexion mysql = new Conexion();
		this.conn = mysql.getConexion();
	}
	
	public int insertaUsuario(Usuario usr) {
		int res = 0;
		String sql = "INSERT INTO usuarios (usuario, password, nombre) VALUES (?,?,?)";
	
		try {
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, usr.getUsuario());
			pstmt.setString(2, usr.getPassword());
			pstmt.setString(3, usr.getNombre());
			res = 1;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return res;
	}
	
	public List<Usuario> getUsuarios(){
		List<Usuario> lista = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuarios";
		
		try {
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Usuario usr = new Usuario();
				usr.setId(rs.getString("id"));
				usr.setUsuario(rs.getString("usuario"));
				usr.setNombre(rs.getString("nombre"));
				usr.setPassword(rs.getString("password"));
				lista.add(usr);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return lista;
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
	
	public Usuario getUsuarioByID(String id) {
		Usuario usr = new Usuario();
		String sql = "SELECT * FROM usuarios WHERE id = ?";
		
		try {
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				usr.setId(rs.getString("id"));
				usr.setNombre(rs.getString("nombre"));
				usr.setUsuario(rs.getString("usuario"));
				usr.setUsuario(rs.getString("password"));
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return usr;
	}
	
	public int editaUsuario(Usuario usr) {
		int res = 0;
		String sql = "UPDATE usuarios SET usuario = ?, password = ?, nombre = ? WHERE id = ?";
		
		try {
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, usr.getUsuario());
			pstmt.setString(2, usr.getPassword());
			pstmt.setString(3, usr.getNombre());
			pstmt.setString(4, usr.getId());
			pstmt.execute();
			res = 1;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return res;
	}
	
}
