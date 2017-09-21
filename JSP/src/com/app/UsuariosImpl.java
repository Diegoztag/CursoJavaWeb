package com.app;

import java.util.ArrayList;
import java.util.List;

public class UsuariosImpl {
	
	public List<Usuario> getUsuarios(){
		List<Usuario> lista = new ArrayList<Usuario>();
		Usuario usrl1 = new Usuario();
		Usuario usrl2 = new Usuario();
		
		usrl1.setNombre("Hugo");
		usrl1.setUsuario("Hug");
		lista.add(usrl1);
		usrl2.setNombre("Paco");
		usrl2.setUsuario("Chueco");
		lista.add(usrl2);	
		return lista;
	}
	
	public static void main(String[] args) {
		UsuariosImpl obj = new UsuariosImpl();
		List<Usuario> lista = obj.getUsuarios();
		
		for(Usuario dto : lista)
		{
			System.out.println(dto.getNombre());
		}
	}
}
