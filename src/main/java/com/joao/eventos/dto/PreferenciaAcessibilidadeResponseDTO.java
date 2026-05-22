package com.joao.eventos.dto;

public class PreferenciaAcessibilidadeResponseDTO {

    private Long id;
    private String tipoAcessibilidade;
    private String descricao;
    private String participanteNome;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipoAcessibilidade() { return tipoAcessibilidade; }
    public void setTipoAcessibilidade(String tipoAcessibilidade) { this.tipoAcessibilidade = tipoAcessibilidade; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getParticipanteNome() { return participanteNome; }
    public void setParticipanteNome(String participanteNome) { this.participanteNome = participanteNome; }
}