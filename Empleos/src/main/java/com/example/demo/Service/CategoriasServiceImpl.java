package com.example.demo.Service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Model.Categoria;
import com.example.Model.Vacantes;
@Service
public class CategoriasServiceImpl implements ICategoriasService{
	private List<Categoria> ListaCategoria =new LinkedList<Categoria>();
	
	public  CategoriasServiceImpl() {
		ListaCategoria =new LinkedList<Categoria>();
		 
		Categoria Categoria=new Categoria();
		Categoria.setId(1);
		Categoria.setNombre("ahuevo");
		 Categoria.setDescripcion(12);
		ListaCategoria.add(Categoria);
		
		 Categoria=new Categoria();
		Categoria.setId(1);
		Categoria.setNombre("ahuevo2");
		 Categoria.setDescripcion(12);
		ListaCategoria.add(Categoria);
		
	}
	
	@Override
	public void Guardar(Categoria categoria) {
		ListaCategoria.add(categoria);
		System.out.println(ListaCategoria.get(0));
	}

	@Override
	public List<Categoria> buscarTodas() {
		
		return ListaCategoria;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for (Categoria categoria : ListaCategoria) {
			
			if(categoria.getId()==idCategoria) {
				return categoria;
				
			}
			
		}
		
		return null;
	}

}
