package com.example.demo.repository;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteRepository {
	
	public void ingresar(Estudiante estudiante);
	
	public void actualizar(Estudiante estudiante);

	public void eliminar(Integer id);

	public Estudiante seleccionar(Integer id);
	
	public Estudiante seleccionarCedula(String cedula);


}
