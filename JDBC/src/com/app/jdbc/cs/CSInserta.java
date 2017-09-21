package com.app.jdbc.cs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.app.odbc.Conexion;
import com.app.odbc.Usuario;

public class CSInserta {
	
	public int  insertaUsuariosCS(Usuario usr) {
		int res = 0;
		Conexion mysql = new Conexion();
		Connection conn = mysql.getConexion();
		String sql = "{CALL insert_usuarios(?,?,?)}";
		
		try {
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, usr.getUsuario());
			cstmt.setString(2, usr.getNombre());
			cstmt.setString(3, usr.getPassword());
			cstmt.execute();
			res = 1;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		CSInserta obj = new CSInserta();
		Usuario usr = new Usuario();
		usr.setNombre("Rosa Juarez");
		usr.setUsuario("rosaju");
		usr.setPassword("rojajuju");
		int res = obj.insertaUsuariosCS(usr);
		System.out.println(res);
	}
}
