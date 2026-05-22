package com.joao.eventos.service;

import com.joao.eventos.dto.InscricaoRequestDTO;
import com.joao.eventos.dto.InscricaoResponseDTO;
import com.joao.eventos.entity.Evento;
import com.joao.eventos.entity.Inscricao;
import com.joao.eventos.entity.Participante;
import com.joao.eventos.repository.EventoRepository;
import com.joao.eventos.repository.InscricaoRepository;
import com.joao.eventos.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscricaoService {

    private final InscricaoRepository repository;
    private final ParticipanteRepository participanteRepository;
    private final EventoRepository eventoRepository;

    public InscricaoService(InscricaoRepository repository,
                            ParticipanteRepository participanteRepository,
                            EventoRepository eventoRepository) {
        this.repository = repository;
        this.participanteRepository = participanteRepository;
        this.eventoRepository = eventoRepository;
    }

    public List<InscricaoResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public InscricaoResponseDTO buscarPorId(Long id) {
        Inscricao i = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscrição não encontrada"));
        return toResponse(i);
    }

    public InscricaoResponseDTO criar(InscricaoRequestDTO dto) {
        Participante p = participanteRepository.findById(dto.getParticipanteId())
                .orElseThrow(() -> new RuntimeException("Participante não encontrado"));
        Evento e = eventoRepository.findById(dto.getEventoId())
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        Inscricao i = new Inscricao();
        i.setParticipante(p);
        i.setEvento(e);
        i.setStatus(dto.getStatus());
        return toResponse(repository.save(i));
    }

    public InscricaoResponseDTO atualizar(Long id, InscricaoRequestDTO dto) {
        Inscricao i = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscrição não encontrada"));
        i.setStatus(dto.getStatus());
        return toResponse(repository.save(i));
    }

    public void deletar(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscrição não encontrada"));
        repository.deleteById(id);
    }

    private InscricaoResponseDTO toResponse(Inscricao i) {
        InscricaoResponseDTO dto = new InscricaoResponseDTO();
        dto.setId(i.getId());
        dto.setStatus(i.getStatus());
        dto.setDataInscricao(i.getDataInscricao());
        if (i.getParticipante() != null) {
            dto.setParticipanteNome(i.getParticipante().getNome());
        }
        if (i.getEvento() != null) {
            dto.setEventoNome(i.getEvento().getNome());
        }
        return dto;
    }
}