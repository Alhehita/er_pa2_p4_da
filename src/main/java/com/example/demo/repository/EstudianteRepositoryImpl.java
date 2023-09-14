package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void ingresar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		Estudiante estudiante = this.seleccionar(id);
		this.entityManager.remove(estudiante);
	}

	@Override
	@Transactional
	public Estudiante seleccionar(Integer id) {
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	@Transactional
	public Estudiante seleccionarCedula(String cedula) {
		TypedQuery<Estudiante> query = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :datoCedula", Estudiante.class);
		query.setParameter("datoCedula", cedula);
		try {
			return query.getResultList().get(0);
		} catch (NoResultException ex) {
			return null;
		}
	}

}
