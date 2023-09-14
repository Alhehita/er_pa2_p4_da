package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface MateriaService {
	
	public void guardar(Materia materia);

	public void actualizar(Materia materia);

	public void borrar( Integer id);

	public Materia buscar(Integer id);
	
	public Materia buscarCodigo(String codigo);
	
	public List<Materia> buscarTodos();


}
