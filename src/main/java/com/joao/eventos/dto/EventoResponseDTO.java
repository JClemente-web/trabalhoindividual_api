package com.joao.eventos.dto;

import java.time.LocalDateTime;

public class EventoResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private String local;
    private LocalDateTime dataEvento;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String organizadorNome;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }
    public LocalDateTime getDataEvento() { return dataEvento; }
    public void setDataEvento(LocalDateTime dataEvento) { this.dataEvento = dataEvento; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public String getOrganizadorNome() { return organizadorNome; }
    public void setOrganizadorNome(String organizadorNome) { this.organizadorNome = organizadorNome; }
}