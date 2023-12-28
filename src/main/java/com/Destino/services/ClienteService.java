package com.Destino.services;

import com.Destino.model.Cliente;

import java.util.List;
import org.springframework.stereotype.Service;

public interface ClienteService {

	List<Cliente> getAllClientes();


	Cliente getClienteById(Long id);


	Cliente saveCliente(Cliente cliente);


	Cliente updateCliente(Long id, Cliente clienteAtualizado);


	void deleteCliente(Long id);
}

