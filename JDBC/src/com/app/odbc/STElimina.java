package com.app.odbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class STElimina {
	
	public int eliminaUsuario(String id) {
		int res = 0;
		String sql = "DELETE FROM usuarios WHERE id = " + id;
		
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
		STElimina obj = new STElimina();
		int res = obj.eliminaUsuario("1");
		
		if (res == 1) {
			System.out.println("Registro eliminado exitosamente");
		}
		else
		{
			System.out.println("No se pudo eliminar el registro");
		}
	}
}
