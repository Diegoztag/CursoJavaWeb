package com.app.odbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	Connection conn = null;
	String base = "cjee21";
	String url = "192.168.1.79";
	String usuario = "cjee21";
	String password = "password";
	
	public Connection getConexion() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://"+url+"/"+base, usuario, password);
			System.out.println("Conexon Exitosa");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error en el driver");
			e.printStackTrace();
			
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
			
		}
		return conn;
	}
	
	public static void main(String[] args) {
		Conexion mysql = new Conexion();
		mysql.getConexion();
	}
	
	
}
