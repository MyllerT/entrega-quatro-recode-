package com.Destino.controllers;
import com.Destino.model.Cliente;

import com.Destino.model.Destino;

import com.Destino.services.DestinoService;
import com.Destino.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/destinos")
public class DestinoController {

    private final DestinoService destinoService;
    private final ClienteService clienteService;

    @Autowired
    public DestinoController(DestinoService destinoService, ClienteService clienteService) {
        this.destinoService = destinoService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public String listarDestinos(Model model) {
        List<Destino> destinos = destinoService.getAllDestinos();
        model.addAttribute("destinos", destinos);
        return "ListarDestinos";
    }

    @GetMapping("/novo")
    public String exibirFormularioAdicao(Model model) {
        model.addAttribute("destino", new Destino(new Cliente()));
        model.addAttribute("clientes", clienteService.getAllClientes());
        return "destinoForm";
    }

    @PostMapping("/adicionar")
    public String adicionarDestino(@ModelAttribute("destino") Destino destino) {
        destinoService.saveDestino(destino);
        return "redirect:/destinos";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        Destino destino = destinoService.getDestinoById(id);
        model.addAttribute("destino", destino);
        model.addAttribute("clientes", clienteService.getAllClientes());
        return "editarDestino";
    }

    @PostMapping("/editar/{id}")
    public String editarDestino(@PathVariable Long id, @ModelAttribute("destino") Destino destino) {
        destinoService.updateDestino(id, destino);
        return "redirect:/destinos";
    }

    @GetMapping("/deletar/{id}")
    public String deletarDestino(@PathVariable Long id) {
        destinoService.deleteDestino(id);
        return "redirect:/destinos";
    }
}
