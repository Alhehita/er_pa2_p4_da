package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.MateriaRepository;
import com.example.demo.repository.modelo.Materia;

import jakarta.transaction.Transactional;

@Service
public class MateriaServiceImpl implements MateriaService {

	@Autowired
	private MateriaRepository materiaRepository;

	@Override
	@Transactional
	public void guardar(Materia materia) {
		materia.setNumEstudiantes(0);
		this.materiaRepository.ingresar(materia);
	}

	@Override
	@Transactional
	public void actualizar(Materia materia) {
		this.materiaRepository.actualizar(materia);
	}

	@Override
	@Transactional
	public void borrar(Integer id) {
		this.materiaRepository.eliminar(id);
	}

	@Override
	@Transactional
	public Materia buscar(Integer id) {
		return this.materiaRepository.seleccionar(id);
	}

	@Override
	@Transactional
	public Materia buscarCodigo(String codigo) {
		return this.materiaRepository.seleccionarCodigo(codigo);
	}

	@Override
	@Transactional
	public List<Materia> buscarTodos() {
		return this.materiaRepository.seleccionarTodos();
	}

}
