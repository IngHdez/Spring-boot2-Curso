package com.example.demo.Controlller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {

	@GetMapping("/index")
	public String mostraIndex(Model model) {
		return "categorias/listCategorias";

	}

	@GetMapping("/create")
	public String Crear(Model model) {

		System.out.println("");
		
		return "categorias/formCategoria";

	}

	@PostMapping("/save")
	public String Guardar(@RequestParam("nombre") String nombre,@RequestParam("descripcion") String descripcion) {
		System.out.println(nombre);
		System.out.println(descripcion);
		
		
		return "categorias/listCategorias";

	}

}
