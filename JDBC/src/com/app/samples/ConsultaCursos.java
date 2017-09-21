package com.app.samples;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.odbc.Conexion;

public class ConsultaCursos {
	
	private Connection conn;
	
	public ConsultaCursos() {
		Conexion mysql = new Conexion();
		conn = mysql.getConexion();
	}
	
	public Cursos getCursoByID(String id) {
		Cursos curs = new Cursos();
		String sql = "SELECT * FROM cursos WHERE id = " + id;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				curs.setId(rs.getString("id"));
				curs.setNombre(rs.getString("nombre"));
				curs.setNivel(rs.getString("nivel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return curs;
	}
	
	public List<Cursos> getCursos(){
		List<Cursos> lista = new ArrayList<Cursos>();
		String sql = "SELECT * FROM cursos";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Cursos curs = new Cursos();
				curs.setId(rs.getString("id"));
				curs.setNombre(rs.getString("nombre"));
				curs.setNivel(rs.getString("nivel"));
				lista.add(curs);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public static void main(String[] args) {
		ConsultaCursos obj = new ConsultaCursos();
		Cursos curs = obj.getCursoByID("1");
		System.out.println("Nombre: " + curs.getNombre());
		
		//List<Cursos> lista = obj.getCursos();
		
		//for(Cursos dto : lista) {
			//System.out.println("<<<<Nombre: " + dto.getNombre() + " >>>Nivel: " + dto.getNivel());
		//}
	}
}
