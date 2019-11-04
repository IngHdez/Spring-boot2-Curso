package com.example.demo.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Model.Vacantes;
@Service
public class VcantesServiceImp implements IVacanteService{

	private List<Vacantes> Lista =new LinkedList<Vacantes>();
	
	public VcantesServiceImp() {
		 Lista =new LinkedList<Vacantes>();
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
			vacante.setEstatus("creada");
			Lista.add(vacante);
			
			vacante =new Vacantes();
			vacante.setId(2);
			vacante.setNombre("Ing Civil");
			vacante.setDescripcion("para que se rife un puente");
			vacante.setFecha(sdf.parse("02-06-2019"));
			vacante.setSalario(300.0);
			vacante.setDestacado(0);
			vacante.setImage("spiderman.png");
			vacante.setEstatus("Eliminada");
			Lista.add(vacante);
			
			vacante =new Vacantes();
			vacante.setId(3);
			vacante.setNombre("Ing Industrial");
			vacante.setDescripcion("para que se la chupe al Ing en sistemas");
			vacante.setFecha(sdf.parse("02-07-2019"));
			vacante.setSalario(50.0);
			vacante.setDestacado(1);
			vacante.setImage("thor.png");
			vacante.setEstatus("creada");
			Lista.add(vacante);
			
			vacante =new Vacantes();
			vacante.setId(3);
			vacante.setNombre("Ing Industrial");
			vacante.setDescripcion("para que se la chupe al Ing en sistemas");
			vacante.setFecha(sdf.parse("02-07-2019"));
			vacante.setSalario(50.0);
			vacante.setDestacado(1);
			vacante.setEstatus("Aprobada");
			Lista.add(vacante);
			
			}catch (ParseException e) {
				System.out.println("Error: "+e.getMessage());
			}
	}
	
	
	@Override
	public List<Vacantes> BuscarTodas() {
		// TODO Auto-generated method stub
		return Lista;
	}


	@Override
	public Vacantes BuscarPorId(Integer IdVacante) {
		for(Vacantes vacante:Lista) {
			if(vacante.getId()==IdVacante) {
				return vacante;
			}
		}
		return null;
	}


	@Override
	public void Guardar(Vacantes Vacantes) {
		Lista.add(Vacantes);
		System.out.println(Lista);
	}

}
