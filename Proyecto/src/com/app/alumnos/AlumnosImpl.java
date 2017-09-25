package com.app.alumnos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.db.Conexion;

public class AlumnosImpl implements IAlumnos {
	
	private Connection conn;
	
	public AlumnosImpl() {
		Conexion mysql = new Conexion();
		this.conn = mysql.getConexion();
	}

	public int editaAlumno(Alumnos al) {
		int res = 0;
		String sql = "{CALL update_alumnos(?,?,?,?,?)}";
		
		try {
			CallableStatement cstmt = this.conn.prepareCall(sql);
			cstmt.setString(1, al.getNombre());
			cstmt.setString(2, al.getApaterno());
			cstmt.setString(3, al.getAmaterno());
			cstmt.setString(4, al.getMatricula());
			cstmt.setString(5, al.getId());
			cstmt.execute();
			res = 1;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return res;
	}

	public int eliminaAlumno(String id) {
		int res = 0;
		String sql = "{CALL delete_alumnos(?)}";
		
		try {
			CallableStatement pstmt = this.conn.prepareCall(sql);
			pstmt.setString(1, id);
			pstmt.execute();
			res = 1;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return res;
	}

	public Alumnos getAlumnoByID(String id) {
		Alumnos al = new Alumnos();
		String sql = "{CALL select_alByID(?)}";
		
		try {
			CallableStatement cstmt = this.conn.prepareCall(sql);
			cstmt.setString(1, id);
			ResultSet rs = cstmt.executeQuery();
			
			while(rs.next()) {
				al.setId(rs.getString("id"));
				al.setNombre(rs.getString("nombre"));
				al.setApaterno(rs.getString("apaterno"));
				al.setAmaterno(rs.getString("amaterno"));
				al.setMatricula(rs.getString("matricula"));
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return al;
	}

	public List<Alumnos> getAlumnos() {
		List<Alumnos> lista = new ArrayList<Alumnos>();
		String sql = "{CALL selectAlumnos()}";
		
		try {
			CallableStatement cstmt = this.conn.prepareCall(sql);
			ResultSet rs = cstmt.executeQuery();
			
			while(rs.next()) {
				Alumnos al = new Alumnos();
				al.setId(rs.getString("id"));
				al.setNombre(rs.getString("nombre"));
				al.setApaterno(rs.getString("apaterno"));
				al.setAmaterno(rs.getString("amaterno"));
				al.setMatricula(rs.getString("matricula"));
				lista.add(al);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return lista;
	}

	public int insertAlumno(Alumnos al) {
		int res = 0;
		Conexion mysql = new Conexion();
		Connection conn = mysql.getConexion();
		String sql = "{CALL insert_alumnos(?,?,?,?)}";
		
		try {
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, al.getNombre());
			cstmt.setString(2, al.getApaterno());
			cstmt.setString(3, al.getAmaterno());
			cstmt.setString(4, al.getMatricula());
			cstmt.execute();
			res = 1;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		AlumnosImpl obj = new AlumnosImpl();
		Alumnos al = new Alumnos();
		al = obj.getAlumnoByID("6");
		System.out.println(al.getNombre());
	}

}
