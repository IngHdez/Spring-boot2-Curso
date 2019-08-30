package com.example.demo.Controlller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Model.Vacantes;

@Controller
public class HomeController {

	@GetMapping("/")
	public String MuestraHome(Model model) {

		String Nombre = "Auxiliar de Contabilidad";
		Date Fechapub = new Date();
		double Salario = 1000;
		boolean vigente = true;
		model.addAttribute("Nombre", Nombre);
		model.addAttribute("Fecha", Fechapub);
		model.addAttribute("Salario", Salario);
		model.addAttribute("vigente", vigente);
		return "Home";
	}

	@GetMapping("/Detalles")
	public String Detalles(Model model) {
		Vacantes vacantes = new Vacantes();

		vacantes.setNombre("Ing En sistemas");
		vacantes.setDescripcion("vacante parea que te la chupen");
		vacantes.setFecha(new Date());
		vacantes.setSalario(152422.0);
		model.addAttribute("vacantes", vacantes);
		return "detalles";

	}
	@GetMapping("/listado")
	public String MuestraListado(Model model) {
		List<String> lista = new ArrayList<String>();

		lista.add("Ingeniero en Sistemas");
		lista.add("Auxiliar Tecnico");
		lista.add("Contabilidad");
		lista.add("RH");

		model.addAttribute("empleos", lista);
		return "listado";

	}
	@GetMapping("/Vacantes")
	public String MostrarTable(Model model) {
		List<Vacantes> listavacantes=GetVacantes();
		
		model.addAttribute("vacantes",listavacantes);
		
		return "Tabla";
		
	}
	
	private List<Vacantes> GetVacantes(){
		List<Vacantes> Lista =new LinkedList<Vacantes>();
		try {
		SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
		
		Vacantes vacante =new Vacantes();
		vacante.setId(1);
		vacante.setNombre("Ing En sistemas");
		vacante.setDescripcion("vacante para que te la chupen");
		vacante.setFecha(sdf.parse("02-08-2019"));
		vacante.setSalario(152422.0);
		vacante.setDestacado(1);
		vacante.setImage("hulk.png");
		Lista.add(vacante);
		
		vacante =new Vacantes();
		vacante.setId(2);
		vacante.setNombre("Ing Civil");
		vacante.setDescripcion("para que se rife un puente");
		vacante.setFecha(sdf.parse("02-06-2019"));
		vacante.setSalario(300.0);
		vacante.setDestacado(0);
		vacante.setImage("spiderman.png");
		Lista.add(vacante);
		
		vacante =new Vacantes();
		vacante.setId(3);
		vacante.setNombre("Ing Industrial");
		vacante.setDescripcion("para que se la chupe al Ing en sistemas");
		vacante.setFecha(sdf.parse("02-07-2019"));
		vacante.setSalario(50.0);
		vacante.setDestacado(1);
		vacante.setImage("thor.png");
		Lista.add(vacante);
		
		vacante =new Vacantes();
		vacante.setId(3);
		vacante.setNombre("Ing Industrial");
		vacante.setDescripcion("para que se la chupe al Ing en sistemas");
		vacante.setFecha(sdf.parse("02-07-2019"));
		vacante.setSalario(50.0);
		vacante.setDestacado(1);
		Lista.add(vacante);
		
		}catch (ParseException e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		
		
		return Lista;
	}


}
