package com.example.demo.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Service.ICategoriasService;
import com.example.demo.Service.IVacanteService;
import com.example.demo.model.Vacantes;

import Util.Utileria;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	
	@Value("${empleosapp.ruta.images}")
	private String ruta;
	
	@Autowired
	IVacanteService VacanteService;

	@Autowired
	@Qualifier("categoriaServiceJpa")
	ICategoriasService icategoriasservice;
	

	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idvacante, Model model) {
		model.addAttribute("idvacante", idvacante);

		// ###Buscar Detalles de la Vacante en BD
		Vacantes vacantes = VacanteService.BuscarPorId(idvacante);

		model.addAttribute("vacantes", vacantes);

		return "detalles";

	}

	@GetMapping("/create")
	public String Crea(Vacantes vacantes,Model categorias) {
		categorias.addAttribute("cat",icategoriasservice.buscarTodas());

		return "vacantes/formVacante";
	}

	@PostMapping("/save")
	public String guarda(Vacantes vacante,BindingResult bindingResult,RedirectAttributes attributes,@RequestParam("archivoImagen") MultipartFile multiPart ) {
		
		if(bindingResult.hasErrors()) {
			for(ObjectError error:bindingResult.getAllErrors()) {
				
				System.out.println(error.getDefaultMessage());
			}
			return "vacantes/formVacante";
		}
		if (!multiPart.isEmpty()) {
			//String ruta = "/empleos/img-vacantes/"; // Linux/MAC
		
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null){ // La imagen si se subio
			// Procesamos la variable nombreImagen
			vacante.setImage(nombreImagen);
			}
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
