package com.example.demo.Controlller;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idvacante, Model model) {
		model.addAttribute("idvacante", idvacante);
		
		
		//###Buscar Detalles de la Vacante en BD
		
		
		
		return "vacantes/detalle";
		
	}
	
	@GetMapping("/delete")
    public String Eliminar (@RequestParam ("id") int id,Model model) {
		System.out.println("Elimina Vacante con ID: "+id);
		
		model.addAttribute("id",id);
		return "Mensaje";
		
	}
	
}
