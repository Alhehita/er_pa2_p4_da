package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

import jakarta.transaction.Transactional;

@Service
public class MatriculaServiceImpl implements MatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;

	@Autowired
	private MateriaService materiaService;

	@Autowired
	private EstudianteService estudianteService;

	@Override
	@Transactional
	public void guardar(Matricula matricula) {
		this.matriculaRepository.insertar(matricula);
	}

	@Override
	@Transactional
	public void actualizar(Matricula matricula) {
		this.matriculaRepository.actualizar(matricula);
	}

	@Override
	@Transactional
	public void guardarDTO(MatriculaDTO matriculaDTO) {

		Materia materia = this.materiaService.buscarCodigo(matriculaDTO.getCodigoM());
		Estudiante estudiante = this.estudianteService.buscarCedula(matriculaDTO.getCedulaE());

		Matricula matricula = new Matricula();
		matricula.setEstudiante(estudiante);
		matricula.setMateria(materia);
		matricula.setFechaMatricula(LocalDate.now());
		if (materia.getNumEstudiantes() == null) {
			materia.setNumEstudiantes(1);
		} else {
			Integer estu = materia.getNumEstudiantes() + 1;

			materia.setNumEstudiantes(estu);
		}
		estudiante.getMatriculas().add(matricula);
		materia.getMatriculas().add(matricula);

		this.guardar(matricula);
		this.estudianteService.actualizar(estudiante);
		this.materiaService.actualizar(materia);

	}

	@Override
	@Transactional
	public List<MatriculaDTO> listado() {
		// TODO Auto-generated method stub
		return this.matriculaRepository.reporte();
	}

}
