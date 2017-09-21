package com.app.alumnos;

import java.util.List;

public interface IAlumnos {
	
	public int editaAlumno(Alumnos al);
	public int eliminaAlumno(String id);
	public Alumnos getAlumnoByID(String id);
	public List<Alumnos> getAlumnos();
	public int insertAlumno(Alumnos al);
	
}
