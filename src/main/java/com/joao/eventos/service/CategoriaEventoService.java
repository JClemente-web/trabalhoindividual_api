package com.joao.eventos.service;

import com.joao.eventos.dto.CategoriaEventoRequestDTO;
import com.joao.eventos.dto.CategoriaEventoResponseDTO;
import com.joao.eventos.entity.CategoriaEvento;
import com.joao.eventos.repository.CategoriaEventoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaEventoService {

    private final CategoriaEventoRepository repository;

    public CategoriaEventoService(CategoriaEventoRepository repository) {
        this.repository = repository;
    }

    public List<CategoriaEventoResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public CategoriaEventoResponseDTO buscarPorId(Long id) {
        CategoriaEvento c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return toResponse(c);
    }

    public CategoriaEventoResponseDTO criar(CategoriaEventoRequestDTO dto) {
        CategoriaEvento c = new CategoriaEvento();
        c.setNome(dto.getNome());
        c.setDescricao(dto.getDescricao());
        return toResponse(repository.save(c));
    }

    public CategoriaEventoResponseDTO atualizar(Long id, CategoriaEventoRequestDTO dto) {
        CategoriaEvento c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        c.setNome(dto.getNome());
        c.setDescricao(dto.getDescricao());
        return toResponse(repository.save(c));
    }

    public void deletar(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        repository.deleteById(id);
    }

    private CategoriaEventoResponseDTO toResponse(CategoriaEvento c) {
        CategoriaEventoResponseDTO dto = new CategoriaEventoResponseDTO();
        dto.setId(c.getId());
        dto.setNome(c.getNome());
        dto.setDescricao(c.getDescricao());
        return dto;
    }
}