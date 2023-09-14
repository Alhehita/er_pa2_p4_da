package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface MateriaRepository {

	public void ingresar(Materia materia);

	public void actualizar(Materia materia);

	public void eliminar( Integer id);

	public Materia seleccionar (Integer id);
	
	public Materia seleccionarCodigo(String codigo);

	public List<Materia> seleccionarTodos();

}
