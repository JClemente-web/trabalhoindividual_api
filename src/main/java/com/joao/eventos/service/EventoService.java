package com.joao.eventos.service;

import com.joao.eventos.dto.EventoRequestDTO;
import com.joao.eventos.dto.EventoResponseDTO;
import com.joao.eventos.entity.Evento;
import com.joao.eventos.entity.Organizador;
import com.joao.eventos.repository.EventoRepository;
import com.joao.eventos.repository.OrganizadorRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoService {

    private final EventoRepository repository;
    private final OrganizadorRepository organizadorRepository;

    public EventoService(EventoRepository repository, OrganizadorRepository organizadorRepository) {
        this.repository = repository;
        this.organizadorRepository = organizadorRepository;
    }

    public List<EventoResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public EventoResponseDTO buscarPorId(Long id) {
        Evento e = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        return toResponse(e);
    }

    public EventoResponseDTO criar(EventoRequestDTO dto) {
        Organizador org = organizadorRepository.findById(dto.getOrganizadorId())
                .orElseThrow(() -> new RuntimeException("Organizador não encontrado"));
        Evento e = new Evento();
        e.setNome(dto.getNome());
        e.setDescricao(dto.getDescricao());
        e.setLocal(dto.getLocal());
        e.setDataEvento(LocalDateTime.parse(dto.getDataEvento()));
        e.setOrganizador(org);
        return toResponse(repository.save(e));
    }

    public EventoResponseDTO atualizar(Long id, EventoRequestDTO dto) {
        Evento e = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        Organizador org = organizadorRepository.findById(dto.getOrganizadorId())
                .orElseThrow(() -> new RuntimeException("Organizador não encontrado"));
        e.setNome(dto.getNome());
        e.setDescricao(dto.getDescricao());
        e.setLocal(dto.getLocal());
        e.setDataEvento(LocalDateTime.parse(dto.getDataEvento()));
        e.setOrganizador(org);
        return toResponse(repository.save(e));
    }

    public void deletar(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        repository.deleteById(id);
    }

    private EventoResponseDTO toResponse(Evento e) {
        EventoResponseDTO dto = new EventoResponseDTO();
        dto.setId(e.getId());
        dto.setNome(e.getNome());
        dto.setDescricao(e.getDescricao());
        dto.setLocal(e.getLocal());
        dto.setDataEvento(e.getDataEvento());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setUpdatedAt(e.getUpdatedAt());
        if (e.getOrganizador() != null) {
            dto.setOrganizadorNome(e.getOrganizador().getNome());
        }
        return dto;
    }
}