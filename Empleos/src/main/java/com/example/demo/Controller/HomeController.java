package com.example.demo.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Model.Categoria;
import com.example.Model.Vacantes;
import com.example.demo.Service.ICategoriasService;
import com.example.demo.Service.IVacanteService;

@Controller
public class HomeController {

	@Autowired
	IVacanteService ivacanteservice;
	@Autowired
	ICategoriasService icategoriaservice;
	
	@GetMapping("/")
	public String MuestraHome(Model model) {

		List<Vacantes> listavacantes=ivacanteservice.BuscarTodas();
		
		model.addAttribute("vacantes",listavacantes);
		
		List<Categoria> listcategorias=icategoriaservice.buscarTodas();
		
		model.addAttribute("vacantes",listavacantes);
		model.addAttribute("categorias",listcategorias);
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
		List<Vacantes> listavacantes=ivacanteservice.BuscarTodas();
		
		model.addAttribute("vacantes",listavacantes);
		
		return "Tabla";
		
	}
	@GetMapping("/categorias")
	public String Mostrar(Model model) {
		List<Categoria> listcategoria=icategoriaservice.buscarTodas();
		
		model.addAttribute("categoria",listcategoria);
		
		return "TablaCategorias";
		
	}



}
