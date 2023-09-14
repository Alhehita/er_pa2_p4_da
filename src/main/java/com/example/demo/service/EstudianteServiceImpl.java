package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

import jakarta.transaction.Transactional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	@Override
	@Transactional
	public void guardar(Estudiante estudiante) {
		this.estudianteRepository.ingresar(estudiante);
	}

	@Override
	@Transactional
	public void actualizar(Estudiante estudiante) {
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	@Transactional
	public void borrar(Integer id) {
		this.estudianteRepository.eliminar(id);
	}

	@Override
	@Transactional
	public Estudiante buscar(Integer id) {
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	@Transactional
	public Estudiante buscarCedula(String cedula) {
		return this.estudianteRepository.seleccionarCedula(cedula);
	}

}
