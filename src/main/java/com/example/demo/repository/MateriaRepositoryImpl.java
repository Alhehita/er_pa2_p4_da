package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MateriaRepositoryImpl implements MateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void ingresar(Materia materia) {
		this.entityManager.persist(materia);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Materia materia) {
		this.entityManager.merge(materia);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		Materia materia = this.seleccionar(id);
		this.entityManager.remove(materia);
	}

	@Override
	@Transactional
	public Materia seleccionar(Integer id) {
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	@Transactional
	public Materia seleccionarCodigo(String codigo) {
		TypedQuery<Materia> query = this.entityManager
				.createQuery("SELECT m FROM Materia m WHERE m.codigo = :datoCodigo", Materia.class);
		query.setParameter("datoCodigo", codigo);

		try {
			return query.getResultList().get(0);
		} catch (NoResultException ex) {
			return null;
		}
	}

	@Override
	@Transactional
	public List<Materia> seleccionarTodos() {
		TypedQuery<Materia> query = this.entityManager.createQuery("SELECT m FROM Materia m", Materia.class);

		try {
			return query.getResultList();
		} catch (NoResultException ex) {
			return null;
		}
	}

}
