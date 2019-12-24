package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Categoria;

public interface ICategoriasService {
	void Guardar(Categoria categoria);
	List<Categoria> buscarTodas();
	Categoria buscarPorId(Integer idCategoria);	
}