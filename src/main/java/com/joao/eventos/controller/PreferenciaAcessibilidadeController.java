package com.joao.eventos.controller;

import com.joao.eventos.dto.PreferenciaAcessibilidadeRequestDTO;
import com.joao.eventos.dto.PreferenciaAcessibilidadeResponseDTO;
import com.joao.eventos.service.PreferenciaAcessibilidadeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preferencias-acessibilidade")
@Tag(name = "Preferências de Acessibilidade", description = "CRUD de Preferências de Acessibilidade")
public class PreferenciaAcessibilidadeController {

    private final PreferenciaAcessibilidadeService service;

    public PreferenciaAcessibilidadeController(PreferenciaAcessibilidadeService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todas", description = "Retorna uma lista com todas as preferências de acessibilidade")
    @GetMapping
    public ResponseEntity<List<PreferenciaAcessibilidadeResponseDTO>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @Operation(summary = "Buscar por ID", description = "Retorna os detalhes de uma preferência específica")
    @GetMapping("/{id}")
    public ResponseEntity<PreferenciaAcessibilidadeResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Operation(summary = "Criar preferência", description = "Cadastra uma nova preferência de acessibilidade no sistema")
    @PostMapping
    public ResponseEntity<PreferenciaAcessibilidadeResponseDTO> criar(@Valid @RequestBody PreferenciaAcessibilidadeRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @Operation(summary = "Atualizar preferência", description = "Atualiza os dados de uma preferência existente")
    @PutMapping("/{id}")
    public ResponseEntity<PreferenciaAcessibilidadeResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody PreferenciaAcessibilidadeRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @Operation(summary = "Deletar preferência", description = "Remove uma preferência do sistema")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}