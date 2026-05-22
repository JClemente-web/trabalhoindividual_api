package com.joao.eventos.controller;

import com.joao.eventos.dto.CategoriaEventoRequestDTO;
import com.joao.eventos.dto.CategoriaEventoResponseDTO;
import com.joao.eventos.service.CategoriaEventoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias-evento")
@Tag(name = "Categorias de Evento", description = "CRUD de Categorias de Evento")
public class CategoriaEventoController {

    private final CategoriaEventoService service;

    public CategoriaEventoController(CategoriaEventoService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todas", description = "Retorna uma lista com todas as categorias")
    @GetMapping
    public ResponseEntity<List<CategoriaEventoResponseDTO>> listarTodas() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @Operation(summary = "Buscar por ID", description = "Retorna os detalhes de uma categoria específica")
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaEventoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Operation(summary = "Criar categoria", description = "Cadastra uma nova categoria no sistema")
    @PostMapping
    public ResponseEntity<CategoriaEventoResponseDTO> criar(@Valid @RequestBody CategoriaEventoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @Operation(summary = "Atualizar categoria", description = "Atualiza os dados de uma categoria existente")
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaEventoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody CategoriaEventoRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @Operation(summary = "Deletar categoria", description = "Remove uma categoria do sistema")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}