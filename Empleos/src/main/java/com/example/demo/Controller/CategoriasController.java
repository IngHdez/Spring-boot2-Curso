package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Service.ICategoriasService;
import com.example.demo.Service.IVacanteService;
import com.example.demo.model.Categoria;
import com.example.demo.model.Vacantes;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {

	@Autowired
	@Qualifier("categoriaServiceJpa")
	ICategoriasService CategoriasService ;
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idcategoria, Model model) {
		model.addAttribute("idcategoria", idcategoria);

		// ###Buscar Detalles de la Vacante en BD
		Categoria categoria = CategoriasService.buscarPorId(idcategoria);

		model.addAttribute("categoria", categoria);

		return "detallecategorias";

	}

	
	@GetMapping("/index")
	public String mostraIndex(Model model) {
		
		List<Categoria> lista=CategoriasService.buscarTodas();
		model.addAttribute("categoria",lista);
		return "categorias/listCategorias";
	

	}

	@GetMapping("/create")
	public String Crear(Categoria categoria) {
		
		return "categorias/formCategoria";

	}
	@PostMapping("/save")
	public String guarda(Categoria Categoria,BindingResult bindingResult,RedirectAttributes attributes ) {
		
		if(bindingResult.hasErrors()) {
			for(ObjectError error:bindingResult.getAllErrors()) {
				
				System.out.println(error.getDefaultMessage());
			}
			return "categorias/formCategoria";
		}
	
		CategoriasService.Guardar(Categoria);
		attributes.addFlashAttribute("msg","Registro Guardado");
		return "redirect:/categorias/index";
	}
	

}
