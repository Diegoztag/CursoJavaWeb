package com.app.jdbc.ps;

import java.util.List;
import com.app.odbc.Usuario;

public class UsuarioService implements IUsuario {
	
	private IUsuario usrobj;
	
	public UsuarioService(IUsuario usrobj) {
		this.usrobj = usrobj;
	}
	
	public int insertaUsuario(Usuario usr) {
		int res = this.usrobj.insertaUsuario(usr);
		return res;
	}

	public int eliminaUsuario(String id) {
		int res = this.usrobj.eliminaUsuario(id);
		return res;
	}

	public int editaUsuario(Usuario usr) {
		int res = this.usrobj.editaUsuario(usr);
		return res;
	}

	public Usuario consultaUsuarioByID(String id) {
		Usuario usr = usrobj.consultaUsuarioByID(id);
		return usr;
	}

	public List<Usuario> consultaUsuario() {
		List<Usuario> lista = usrobj.consultaUsuario();
		return lista;
	}
}
