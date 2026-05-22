package com.joao.eventos.controller;

import com.joao.eventos.dto.InscricaoRequestDTO;
import com.joao.eventos.dto.InscricaoResponseDTO;
import com.joao.eventos.service.InscricaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscricoes")
@Tag(name = "Inscrições", description = "CRUD de Inscrições em Eventos")
public class InscricaoController {

    private final InscricaoService service;

    public InscricaoController(InscricaoService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todas", description = "Retorna uma lista com todas as inscrições")
    @GetMapping
    public ResponseEntity<List<InscricaoResponseDTO>> listarTodas() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @Operation(summary = "Buscar por ID", description = "Retorna os detalhes de uma inscrição específica")
    @GetMapping("/{id}")
    public ResponseEntity<InscricaoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Operation(summary = "Criar inscrição", description = "Realiza uma nova inscrição em um evento")
    @PostMapping
    public ResponseEntity<InscricaoResponseDTO> criar(@Valid @RequestBody InscricaoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @Operation(summary = "Atualizar inscrição", description = "Atualiza os dados de uma inscrição existente")
    @PutMapping("/{id}")
    public ResponseEntity<InscricaoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody InscricaoRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @Operation(summary = "Deletar inscrição", description = "Cancela ou remove uma inscrição do sistema")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}