package com.joao.eventos.dto;

import jakarta.validation.constraints.NotBlank;

public class PreferenciaAcessibilidadeRequestDTO {

    @NotBlank(message = "A descrição da preferência é obrigatória")
    private String descricao;

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}