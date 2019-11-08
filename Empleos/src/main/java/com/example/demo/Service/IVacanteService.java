package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Vacantes;

public interface IVacanteService {
	List<Vacantes> BuscarTodas();
	Vacantes BuscarPorId(Integer IdVacante);
	void Guardar(Vacantes Vacantes);
	List<Vacantes> Buscavacantesdestacadas();
}
