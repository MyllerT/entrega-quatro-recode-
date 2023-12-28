package com.Destino.controllers;

import com.Destino.model.Cliente;
import com.Destino.services.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@Controller
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping
	public String listarClientes(Model model) {
		List<Cliente> clientes = clienteService.getAllClientes();
		model.addAttribute("clientes", clientes);
		return "listarClientes";
	}


	@GetMapping("/novo")
	public String exibirFormularioAdicao(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "clienteForm";
	}


	@PostMapping("/adicionar")
	public String adicionarCliente(@ModelAttribute("cliente") Cliente cliente) {
		clienteService.saveCliente(cliente);
		return "redirect:/clientes";
	}

	@GetMapping("/editar/{id}")
	public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
		try {
			Cliente cliente = clienteService.getClienteById(id);
			model.addAttribute("cliente", cliente);
			return "editarCliente";
		} catch (EntityNotFoundException e) {
			return "redirect:/clientes";
		}
	}

	@PostMapping("/editar/{id}")
	public String atualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente) {
		try {
			clienteService.updateCliente(id, cliente);
			return "redirect:/clientes";
		} catch (EntityNotFoundException e) {

			return "redirect:/clientes";
		}
	}

	@GetMapping("/deletar/{id}")
	public String deletarCliente(@PathVariable Long id) {
		try {
			clienteService.deleteCliente(id);
			return "redirect:/clientes";
		} catch (EntityNotFoundException e) {
			return "redirect:/clientes";
		}
	}
}
