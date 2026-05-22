package com.joao.eventos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "preferencias_acessibilidade")
public class PreferenciaAcessibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoAcessibilidade;

    @Column
    private String descricao;

    @OneToOne
    @JoinColumn(name = "participante_id", nullable = false, unique = true)
    @JsonBackReference
    private Participante participante;

    public PreferenciaAcessibilidade() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipoAcessibilidade() { return tipoAcessibilidade; }
    public void setTipoAcessibilidade(String tipoAcessibilidade) { this.tipoAcessibilidade = tipoAcessibilidade; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Participante getParticipante() { return participante; }
    public void setParticipante(Participante participante) { this.participante = participante; }
}