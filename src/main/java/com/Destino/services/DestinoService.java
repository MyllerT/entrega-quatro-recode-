package com.Destino.services;

import com.Destino.model.Destino;

import java.util.List;


import com.Destino.model.Destino;

import java.util.List;

public interface DestinoService {

	List<Destino> getAllDestinos();

	Destino getDestinoById(Long id);

	Destino saveDestino(Destino destino);

	Destino updateDestino(Long id, Destino destinoAtualizado);

	void deleteDestino(Long id);

	List<Destino> getAllEmpresas();

	Destino getEmpresaById(Long id);
}
