package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.dto.MatriculaDTO;
import com.example.demo.service.MatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

	@Autowired
	private MatriculaService matriculaService;

	//ingresar
	@GetMapping("/insertar")
	public String nuevaMatricula(Model model) {
		model.addAttribute("matricula", new MatriculaDTO());
		return "vistaMatricula";
	}

	@PostMapping("/guardar")
	public String guardarMatricula(MatriculaDTO matricula) {
		this.matriculaService.guardarDTO(matricula);
		return "redirect:/matriculas/listado";
	}
	
	//listado
	
	@GetMapping("/listado")
	public String listado(Model model) {
		
		List<MatriculaDTO> listado =  this.matriculaService.listado();
		model.addAttribute("matriculas", listado);
		return "vistaListaMatriculas";
	}

}
