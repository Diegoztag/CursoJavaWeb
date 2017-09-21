package com.app.samples;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.app.odbc.Conexion;

public class UpdateCursos {
	
	public int editaClase(Cursos cur) {
		int res = 0;
		String nom = cur.getNombre();
		String nivel = cur.getNivel();
		String id = cur.getId();
		String sql = "UPDATE cursos SET nombre = '"+nom+"',nivel='"+nivel+"' WHERE id= " + id;
		
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
		UpdateCursos obj = new UpdateCursos();
		Cursos cur = new Cursos();
		cur.setId("2");
		cur.setNombre("Algoritmos");
		cur.setNivel("Mega Avanzado");

		int res = obj.editaClase(cur);
		
		if ( res == 1) {
			System.out.println("Registro actualizado correctamente");
		}
		else
		{
			System.out.println("No se pudo actualizar el registro");
		}
	}
}
