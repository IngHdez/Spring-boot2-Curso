package com.example.demo.Controlller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public  String  MuestraHome(Model model) {
		
		String Nombre ="Auxiliar de Contabilidad";
		Date Fechapub=new Date();
		double Salario=1000;
		boolean vigente=true;
		
		
		
		model.addAttribute("Nombre",Nombre);
		model.addAttribute("Fecha",Fechapub);
		model.addAttribute("Salario",Salario);
		model.addAttribute("vigente",vigente);
		
		
		return "Home";
	}
	
	
	
}
