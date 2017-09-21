package com.app.samples;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.app.odbc.Conexion;

public class DeleteCursos {
	
	public int eliminarCurso(String id) {
		int res = 0;
		String sql = "DELETE FROM cursos WHERE id = " + id;
		
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
		DeleteCursos obj = new DeleteCursos();
		int res = obj.eliminarCurso("1");
		
		if (res == 1) {
			System.out.println("Registro eliminado exitosamente");
		}
		else
		{
			System.out.println("No se pudo eliminar el registro");
		}
	}
	
}
