package com.joao.eventos.controller;

import com.joao.eventos.dto.OrganizadorRequestDTO;
import com.joao.eventos.dto.OrganizadorResponseDTO;
import com.joao.eventos.service.OrganizadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizadores")
@Tag(name = "Organizadores", description = "CRUD de Organizadores do Sistema")
public class OrganizadorController {

    private final OrganizadorService service;

    public OrganizadorController(OrganizadorService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todos", description = "Retorna uma lista com todos os organizadores")
    @GetMapping
    public ResponseEntity<List<OrganizadorResponseDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @Operation(summary = "Buscar por ID", description = "Retorna um organizador específico")
    @GetMapping("/{id}")
    public ResponseEntity<OrganizadorResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Operation(summary = "Criar organizador", description = "Cadastra um novo organizador")
    @PostMapping
    public ResponseEntity<OrganizadorResponseDTO> criar(@Valid @RequestBody OrganizadorRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @Operation(summary = "Atualizar organizador", description = "Atualiza os dados de um organizador existente")
    @PutMapping("/{id}")
    public ResponseEntity<OrganizadorResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody OrganizadorRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @Operation(summary = "Deletar organizador", description = "Remove um organizador do sistema")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}