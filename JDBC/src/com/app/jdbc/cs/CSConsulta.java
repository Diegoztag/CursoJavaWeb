package com.app.jdbc.cs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.odbc.Conexion;
import com.app.odbc.Usuario;

public class CSConsulta {
	
	private Connection conn;
	
	public CSConsulta() {
		Conexion mysql = new Conexion();
		this.conn = mysql.getConexion();
	}
	
	public Usuario selectUsuarioByID(String id) {
		Usuario usr = new Usuario();
		String sql = "{CALL selectUsrByID(?)}";
		
		try {
			CallableStatement cstmt = this.conn.prepareCall(sql);
			cstmt.setString(1, id);
			ResultSet rs = cstmt.executeQuery();
			
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
	
	public List<Usuario> getUsuarios() {
		List<Usuario> lista = new ArrayList<Usuario>();
		String sql = "{CALL selectUsuarios()}";
		
		try {
			CallableStatement cstmt = this.conn.prepareCall(sql);
			ResultSet rs = cstmt.executeQuery();
				
			while(rs.next()) {
				Usuario usr = new Usuario();
				usr.setNombre(rs.getString("nombre"));
				usr.setUsuario(rs.getString("usuario"));
				usr.setPassword(rs.getString("password"));
				lista.add(usr);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return lista;
	}
	
	public static void main(String[] args) {
		CSConsulta obj = new CSConsulta();
		
		/* Seleccion por id
		Usuario usr = obj.selectUsuarioByID("3");
		System.out.println("Nombre: " + usr.getNombre());
		System.out.println("User: " + usr.getUsuario());
		System.out.println("Password: " + usr.getPassword());
		*/
		
		List<Usuario> lista = obj.getUsuarios();
		for(Usuario dto : lista) {
			System.out.println("Nombre: " + dto.getNombre());
		}
	}
}
