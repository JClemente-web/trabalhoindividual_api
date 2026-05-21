package com.joao.eventos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "preferencias_acessibilidade")
public class PreferenciaAcessibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "necessita_interprete_libras")
    private Boolean necessitaInterpreteLibras = false;

    @Column(name = "necessita_cadeira_rodas")
    private Boolean necessitaCadeiraRodas = false;

    @Column(name = "outras_necessidades", columnDefinition = "TEXT")
    private String outrasNecessidades;

    @OneToOne
    @JoinColumn(name = "participante_id", nullable = false)
    @JsonBackReference
    private Participante participante;
}