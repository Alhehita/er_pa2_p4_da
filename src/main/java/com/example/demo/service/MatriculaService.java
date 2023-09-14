package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

public interface MatriculaService {

	public void guardar(Matricula matricula);

	public void actualizar(Matricula matricula);

	public void guardarDTO(MatriculaDTO matriculaDTO);
	
	public List<MatriculaDTO> listado() ;

}
