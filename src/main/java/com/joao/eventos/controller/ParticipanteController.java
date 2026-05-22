package com.joao.eventos.controller;

import com.joao.eventos.dto.ParticipanteRequestDTO;
import com.joao.eventos.dto.ParticipanteResponseDTO;
import com.joao.eventos.service.ParticipanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participantes")
@Tag(name = "Participantes", description = "CRUD de Participantes do Sistema de Eventos")
public class ParticipanteController {

    private final ParticipanteService service;

    public ParticipanteController(ParticipanteService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todos", description = "Retorna uma lista com todos os participantes cadastrados")
    @GetMapping
    public ResponseEntity<List<ParticipanteResponseDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @Operation(summary = "Buscar por ID", description = "Retorna os detalhes de um participante específico")
    @GetMapping("/{id}")
    public ResponseEntity<ParticipanteResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Operation(summary = "Criar participante", description = "Cadastra um novo participante no sistema")
    @PostMapping
    public ResponseEntity<ParticipanteResponseDTO> criar(@Valid @RequestBody ParticipanteRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @Operation(summary = "Atualizar participante", description = "Atualiza os dados de um participante existente")
    @PutMapping("/{id}")
    public ResponseEntity<ParticipanteResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ParticipanteRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @Operation(summary = "Deletar participante", description = "Remove um participante do sistema")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}