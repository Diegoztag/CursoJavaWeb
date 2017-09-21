package com.app.jdbc.ps;

import com.app.odbc.Usuario;

public class UsuarioApp {
	
	public static void main(String[] args) {
		IUsuario usrobj = new UsuarioService(new UsuarioImplMySQL()); //inyectando dependencias
		
		/* Insersion
		Usuario usr = new Usuario();
		usr.setNombre("Maria Nuñez");
		usr.setUsuario("marian");
		usr.setPassword("marian");
		int resInsert = usrobj.insertaUsuario(usr);
		
		if (resInsert == 1) {
			System.out.println("Registro insertado correctamente");
		}
		else
		{
			System.out.println("No sepudo compretar la insersion");
		}
		*/
		
		/* Consultando por id
		Usuario usr = usrobj.consultaUsuarioByID("2");
		String nombre = usr.getNombre();
		System.out.println("El nombre de usuario es: " + nombre);
		*/
		
		/* Eliminando
		int resDelete = usrobj.eliminaUsuario("2");
		
		if (resDelete == 1) {
			System.out.println("Eliminado al cien");
		}
		else
		{
			System.out.println("Falio la eliminada");
		}
		*/
		
		Usuario usr = new Usuario();
		usr.setNombre("jojo");
		usr.setUsuario("jj");
		usr.setPassword("jj");
		usr.setId("4");
		int resUpdate = usrobj.editaUsuario(usr);
		
		if (resUpdate == 1) {
			System.out.println("Registro actualizado correctamente");
		}
		else
		{
			System.out.println("No sepudo actualizar la insersion");
		}
		
	}

}
