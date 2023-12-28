package com.Destino.servicesImpl;

import com.Destino.model.Destino;
import com.Destino.repositories.DestinoRepository;
import com.Destino.services.DestinoService;
import com.Destino.services.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DestinoServiceImpl implements DestinoService {

    private final DestinoRepository destinoRepository;
    private final ClienteService clienteService;

    @Autowired
    public DestinoServiceImpl(DestinoRepository destinoRepository, ClienteService clienteService) {
        this.destinoRepository = destinoRepository;
        this.clienteService = clienteService;
    }

    @Override
    public List<Destino> getAllDestinos() {
        return destinoRepository.findAll();
    }

    @Override
    public Destino getDestinoById(Long id) {
        return destinoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Destino com ID " + id + " não encontrado."));
    }

    @Override
    @Transactional
    public Destino saveDestino(Destino destino) {
        return destinoRepository.save(destino);
    }

    @Override
    @Transactional
    public Destino updateDestino(Long id, Destino destinoAtualizado) {
        Destino destinoExistente = getDestinoById(id);

        destinoExistente.setNome(destinoAtualizado.getNome());
        // Adicione outras atualizações conforme necessário

        return destinoRepository.save(destinoExistente);
    }

    @Override
    @Transactional
    public void deleteDestino(Long id) {
        destinoRepository.deleteById(id);
    }

    @Override
    public List<Destino> getAllEmpresas() {
        return null;
    }

    @Override
    public Destino getEmpresaById(Long id) {
        return null;
    }
}
