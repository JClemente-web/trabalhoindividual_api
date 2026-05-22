package com.joao.eventos.dto;

import java.time.LocalDateTime;

public class ParticipanteResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Construtores
    public ParticipanteResponseDTO() {}

    public ParticipanteResponseDTO(Long id, String nome, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}