package com.joao.eventos.service;

import com.joao.eventos.dto.OrganizadorRequestDTO;
import com.joao.eventos.dto.OrganizadorResponseDTO;
import com.joao.eventos.entity.Organizador;
import com.joao.eventos.repository.OrganizadorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizadorService {

    private final OrganizadorRepository repository;

    public OrganizadorService(OrganizadorRepository repository) {
        this.repository = repository;
    }

    public List<OrganizadorResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public OrganizadorResponseDTO buscarPorId(Long id) {
        Organizador o = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organizador não encontrado"));
        return toResponse(o);
    }

    public OrganizadorResponseDTO criar(OrganizadorRequestDTO dto) {
        Organizador o = new Organizador();
        o.setNome(dto.getNome());
        o.setEmail(dto.getEmail());
        o.setTelefone(dto.getTelefone());
        return toResponse(repository.save(o));
    }

    public OrganizadorResponseDTO atualizar(Long id, OrganizadorRequestDTO dto) {
        Organizador o = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organizador não encontrado"));
        o.setNome(dto.getNome());
        o.setEmail(dto.getEmail());
        o.setTelefone(dto.getTelefone());
        return toResponse(repository.save(o));
    }

    public void deletar(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organizador não encontrado"));
        repository.deleteById(id);
    }

    private OrganizadorResponseDTO toResponse(Organizador o) {
        OrganizadorResponseDTO dto = new OrganizadorResponseDTO();
        dto.setId(o.getId());
        dto.setNome(o.getNome());
        dto.setEmail(o.getEmail());
        dto.setTelefone(o.getTelefone());
        dto.setCreatedAt(o.getCreatedAt());
        dto.setUpdatedAt(o.getUpdatedAt());
        return dto;
    }
}