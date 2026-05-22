package com.joao.eventos.service;

import com.joao.eventos.dto.ParticipanteRequestDTO;
import com.joao.eventos.dto.ParticipanteResponseDTO;
import com.joao.eventos.entity.Participante;
import com.joao.eventos.repository.ParticipanteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipanteService {

    private final ParticipanteRepository repository;

    public ParticipanteService(ParticipanteRepository repository) {
        this.repository = repository;
    }

    public List<ParticipanteResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::converterParaResponseDTO)
                .collect(Collectors.toList());
    }

    public ParticipanteResponseDTO buscarPorId(Long id) {
        Participante participante = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Participante não encontrado"));
        return converterParaResponseDTO(participante);
    }

    public ParticipanteResponseDTO criar(ParticipanteRequestDTO dto) {
        Participante participante = new Participante();
        BeanUtils.copyProperties(dto, participante);
        participante = repository.save(participante);
        return converterParaResponseDTO(participante);
    }

    public ParticipanteResponseDTO atualizar(Long id, ParticipanteRequestDTO dto) {
        Participante participante = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Participante não encontrado"));
        BeanUtils.copyProperties(dto, participante, "id");
        participante = repository.save(participante);
        return converterParaResponseDTO(participante);
    }

    public void deletar(Long id) {
        Participante participante = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Participante não encontrado"));
        repository.delete(participante);
    }

    private ParticipanteResponseDTO converterParaResponseDTO(Participante participante) {
        ParticipanteResponseDTO dto = new ParticipanteResponseDTO();
        BeanUtils.copyProperties(participante, dto);
        return dto;
    }
}