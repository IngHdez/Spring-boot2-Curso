package com.example.demo.Controlller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Model.Vacantes;
import com.example.demo.Service.IVacanteService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	@Autowired
	IVacanteService VacanteService;

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idvacante, Model model) {
		model.addAttribute("idvacante", idvacante);

		// ###Buscar Detalles de la Vacante en BD
		Vacantes vacantes = VacanteService.BuscarPorId(idvacante);

		model.addAttribute("vacantes", vacantes);

		return "detalles";

	}

	@GetMapping("/create")
	public String Crea(Vacantes vacantes) {

		return "vacantes/formVacante";
	}
/*
	@PostMapping("/save")
	public String guarda(@RequestParam ("nombre") String nombre,@RequestParam ("descripcion") String descripcion,
			@RequestParam ("estatus") String estatus,@RequestParam ("fecha") String fecha,
			@RequestParam ("destacado") int destacado,
			@RequestParam ("salario") String salario,@RequestParam ("detalles") String detalles) {
		System.out.println(nombre);
		System.out.println(descripcion);
		System.out.println(estatus);
		System.out.println(fecha);
		System.out.println(destacado);
		System.out.println(salario);
		System.out.println(detalles);
		return "vacantes/listVacantes";
	}
*/
	@PostMapping("/save")
	public String guarda(Vacantes vacante,BindingResult bindingResult,RedirectAttributes attributes ) {
		
		if(bindingResult.hasErrors()) {
			for(ObjectError error:bindingResult.getAllErrors()) {
				
				System.out.println(error.getDefaultMessage());
			}
			return "vacantes/formVacante";
		}
	
		VacanteService.Guardar(vacante);
		attributes.addFlashAttribute("msg","Registro Guardado");
		return "redirect:/vacantes/index";
	}
	@GetMapping("/delete")
	public String Eliminar(@RequestParam("id") int id, Model model) {
		System.out.println("Elimina Vacante con ID: " + id);

		model.addAttribute("id", id);
		return "Mensaje";

	}
	
	//siempre que venga un date de la vista
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		
		SimpleDateFormat dataFormat =new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(dataFormat,false));
		
	}

	@GetMapping("/index")
	public String mostrarIndex (Model model) {
		
	List<Vacantes> lista=VacanteService.BuscarTodas();
		model.addAttribute("vacante",lista);
		return "vacantes/listVacantes";
	}
	
	
}
