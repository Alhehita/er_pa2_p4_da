package com.example.demo.repository.modelo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDTO {

	// ingresar matricula
	private String codigoM;

	private String cedulaE;

	// para sacar la lista

	private String apellidoE;

	private String nombreM;
	
	private LocalDate fechaM;

}
