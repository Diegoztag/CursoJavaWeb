package com.app.odbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class STInsert {
	
	public int insertaUsuario(Usuario ousr) {
		
		String nombre = ousr.getNombre();
		String usr = ousr.getUsuario();
		String pass = ousr.getPassword();
		String sql = "INSERT INTO usuarios (usuario, nombre, password) VALUES ('"+usr+"','"+nombre+"','"+pass+"')";
		Conexion mysql = new Conexion();
		Connection conn = mysql.getConexion();
		int res = 0;
		
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			res = 1;
			
		} catch (SQLException e) {
			System.out.println("Error en la sentencia SQL:");
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		STInsert obj = new STInsert();
		Usuario usr = new Usuario();
		usr.setNombre("Juan Lopez");
		usr.setUsuario("jlopez");
		usr.setPassword("jlopez");
		
		int res = obj.insertaUsuario(usr);
		
		if (res == 1) {
			System.out.println("El usuario se ha insertado");
		}
		else
		{
			System.out.println("No se ha podido registrar el usuario");
		}
		
	}
}
