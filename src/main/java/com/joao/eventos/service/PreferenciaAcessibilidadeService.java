package com.joao.eventos.service;

import com.joao.eventos.dto.PreferenciaAcessibilidadeRequestDTO;
import com.joao.eventos.dto.PreferenciaAcessibilidadeResponseDTO;
import com.joao.eventos.entity.PreferenciaAcessibilidade;
import com.joao.eventos.repository.PreferenciaAcessibilidadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PreferenciaAcessibilidadeService {

    private final PreferenciaAcessibilidadeRepository repository;

    public PreferenciaAcessibilidadeService(PreferenciaAcessibilidadeRepository repository) {
        this.repository = repository;
    }

    public List<PreferenciaAcessibilidadeResponseDTO> listarTodas() {
        return repository.findAll().stream()
                .map(this::converterParaResponseDTO)
                .collect(Collectors.toList());
    }

    public PreferenciaAcessibilidadeResponseDTO buscarPorId(Long id) {
        PreferenciaAcessibilidade preferencia = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Preferência não encontrada"));
        return converterParaResponseDTO(preferencia);
    }

    public PreferenciaAcessibilidadeResponseDTO criar(PreferenciaAcessibilidadeRequestDTO dto) {
        PreferenciaAcessibilidade preferencia = new PreferenciaAcessibilidade();
        BeanUtils.copyProperties(dto, preferencia);
        preferencia = repository.save(preferencia);
        return converterParaResponseDTO(preferencia);
    }

    public PreferenciaAcessibilidadeResponseDTO atualizar(Long id, PreferenciaAcessibilidadeRequestDTO dto) {
        PreferenciaAcessibilidade preferencia = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Preferência não encontrada"));
        BeanUtils.copyProperties(dto, preferencia, "id");
        preferencia = repository.save(preferencia);
        return converterParaResponseDTO(preferencia);
    }

    public void deletar(Long id) {
        PreferenciaAcessibilidade preferencia = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Preferência não encontrada"));
        repository.delete(preferencia);
    }

    private PreferenciaAcessibilidadeResponseDTO converterParaResponseDTO(PreferenciaAcessibilidade preferencia) {
        PreferenciaAcessibilidadeResponseDTO dto = new PreferenciaAcessibilidadeResponseDTO();
        BeanUtils.copyProperties(preferencia, dto);
        return dto;
    }
}