package com.app.odbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class STConsulta {
	
	private Connection conn;
	
	public STConsulta() {
		Conexion mysql = new Conexion();
		conn =  mysql.getConexion();
	}
	
	public Usuario getUsuarioByID(String id) {
		Usuario usr = new Usuario();
		String sql = "SELECT * FROM usuarios WHERE id = " + id;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				usr.setId(rs.getString("id"));
				usr.setNombre(rs.getString("nombre"));
				usr.setUsuario(rs.getString("usuario"));
				usr.setPassword(rs.getString("password"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return usr;
	}
	
	public List<Usuario> getUsuarios(){
		List<Usuario> lista = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuarios";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Usuario usr = new Usuario();
				usr.setId(rs.getString("id"));
				usr.setNombre(rs.getString("nombre"));
				usr.setPassword(rs.getString("password"));
				usr.setUsuario(rs.getString("usuario"));
				lista.add(usr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public static void main(String[] args) {
		STConsulta obj = new STConsulta();
		//Usuario usr = obj.getUsuarioByID("1");
		//System.out.println("Nombre: " + usr.getNombre());
		//System.out.println("Usuario: " + usr.getUsuario());
		//System.out.println("Pass: " + usr.getPassword());
		
		List<Usuario> lista = obj.getUsuarios();
		
		for(Usuario dto : lista) {
			System.out.println("Nombre: " + dto.getNombre());
		}
	}
}
