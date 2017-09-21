package com.app.samples;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.app.odbc.Conexion;

public class InsertCursos {
	
	public int insertaCurso(Cursos pjcurso) {
		
		String nombre = pjcurso.getNombre();
		String nivel = pjcurso.getNivel();
		
		String sql = "INSERT INTO cursos (nombre, nivel) VALUES ('"+nombre+"','"+nivel+"')";
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
		
		InsertCursos obj = new InsertCursos();
		Cursos crs = new Cursos();
		crs.setNombre("C#");
		crs.setNivel("Basico");
		
		int res = obj.insertaCurso(crs);
		
		if (res == 1) {
			System.out.println("El Curso se ha insertado");
		}
		else
		{
			System.out.println("No se ha podido registrar el Curso");
		}
	}
	
}
