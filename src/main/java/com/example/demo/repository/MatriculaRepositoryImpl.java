package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements MatriculaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Matricula matricula) {
		this.entityManager.persist(matricula);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Matricula matricula) {
		this.entityManager.merge(matricula);
	}

	@Override
	@Transactional
	public List<MatriculaDTO> reporte() {
		TypedQuery<MatriculaDTO> query = this.entityManager.createQuery(
				"SELECT NEW com.example.demo.repository.modelo.dto.MatriculaDTO(m.materia.codigo, m.estudiante.cedula,m.estudiante.apellido,m.materia.nombre, m.fechaMatricula) FROM Matricula m",
				MatriculaDTO.class);
		try {
			return query.getResultList();
		} catch (NoResultException ex) {
			return null;
		}	}

}
