package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.MateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {

	@Autowired
	private MateriaService materiaService;

	//ingresar
	@GetMapping("/insertar")
	public String nuevaMateria(Materia materia) {
		return "vistaMateria";
	}

	@PostMapping("/guardar")
	public String guardarMateria(Materia materia) {
		this.materiaService.guardar(materia);
		return "redirect:/materias/listado";
		
	}
	
	//listado
	@GetMapping("/listado")
	public String listado(Model model) {
		List<Materia> lista =  this.materiaService.buscarTodos();
		model.addAttribute("materias",lista);
		return "vistaListaMaterias";
	}
	
	//buscar por id
	
	@GetMapping("/buscarMateria/{idMateria}")
	public String buscar(@PathVariable("idMateria") Integer id, Model model) {
		Materia materia = this.materiaService.buscar(id);
		model.addAttribute("materia", materia);
		return "vistaMateriaI";
	}


}
