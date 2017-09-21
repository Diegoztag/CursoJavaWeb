package com.app.alumnos;

import java.util.List;

public class AlumnosService implements IAlumnos{
	
	IAlumnos alobj;
	
	public AlumnosService(IAlumnos alobj) {
		this.alobj = alobj;
	}

	public int editaAlumno(Alumnos al) {
		int res = this.alobj.editaAlumno(al);
		return res;
	}

	public int eliminaAlumno(String id) {
		int res = this.alobj.eliminaAlumno(id);
		return res;
	}

	public Alumnos getAlumnoByID(String id) {
		Alumnos al = this.alobj.getAlumnoByID(id);
		return al;
	}

	public List<Alumnos> getAlumnos() {
		List<Alumnos> lista = this.alobj.getAlumnos();
		return lista;
	}

	public int insertAlumno(Alumnos al) {
		int res = this.alobj.insertAlumno(al);
		return res;
	}
	
}
