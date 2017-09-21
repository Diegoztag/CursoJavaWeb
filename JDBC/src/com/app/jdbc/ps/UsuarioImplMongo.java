package com.app.jdbc.ps;

import java.util.List;

import com.app.odbc.Usuario;

public class UsuarioImplMongo implements IUsuario {

	public int insertaUsuario(Usuario usr) {
		System.out.println("Insertando usuarios con MongoDB");
		return 0;
	}

	public int eliminaUsuario(String id) {
		System.out.println("Eliminando usuario con MongoDB");
		return 0;
	}

	public int editaUsuario(Usuario usr) {
		System.out.println("Editando usuario con MongoDB");
		return 0;
	}

	public Usuario consultaUsuarioByID(String id) {
		System.out.println("Consultando usuario por id con MongoDB");
		return null;
	}

	public List<Usuario> consultaUsuario() {
		System.out.println("Listando usuarios con MongoDB");
		return null;
	}

}
