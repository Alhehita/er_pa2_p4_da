package com.example.demo.repository.modelo;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "matricula")
@Getter
@Setter
public class Matricula {

	@GeneratedValue(generator = "seq_matricula", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
	@Id
	@Column(name = "mtrc_id")
	private Integer id;

	@Column(name = "mtrc_fecha_matricula")
	private LocalDate fechaMatricula;

	@ManyToOne
	@JoinColumn(name = "mtrc_id_estudiante")
	private Estudiante estudiante;

	@ManyToOne
	@JoinColumn(name = "mtrc_id_materia")
	private Materia materia;

}
