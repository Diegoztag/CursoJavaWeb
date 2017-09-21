package com.app.jdbc.ps;

import java.util.List;
import com.app.odbc.Usuario;

public interface IUsuario {

	public int insertaUsuario(Usuario usr);
	public int eliminaUsuario(String id);
	public int editaUsuario(Usuario usr);
	public Usuario consultaUsuarioByID(String id);
	public List<Usuario> consultaUsuario();
	
}
