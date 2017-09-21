package com.app.odbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class STEdita {
	
	public int editaUsuario(Usuario usr) {
		int res = 0;
		String usuario = usr.getUsuario();
		String nom = usr.getNombre();
		String pass = usr.getPassword();
		String id = usr.getId();
		String sql = "UPDATE usuarios SET nombre = '"+nom+"',usuario='"+usuario+"',password='"+pass+"' WHERE id= " + id;
		
		Conexion mysql = new Conexion();
		Connection conn = mysql.getConexion();
		
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			res = 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static void main(String[] args) {
		STEdita obj = new STEdita();
		Usuario usr = new Usuario();
		usr.setId("3");
		usr.setNombre("Cocho");
		usr.setUsuario("coch");
		usr.setPassword("coch");
		int res = obj.editaUsuario(usr);
		
		if ( res == 1) {
			System.out.println("Registro actualizado correctamente");
		}
		else
		{
			System.out.println("No se pudo actualizar el registro");
		}
	}
}
