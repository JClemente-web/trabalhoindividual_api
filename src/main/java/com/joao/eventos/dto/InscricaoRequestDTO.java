package com.joao.eventos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class InscricaoRequestDTO {

    @NotNull(message = "O ID do participante é obrigatório")
    private Long participanteId;

    @NotNull(message = "O ID do evento é obrigatório")
    private Long eventoId;

    @NotBlank(message = "O status é obrigatório")
    private String status;

    public Long getParticipanteId() { return participanteId; }
    public void setParticipanteId(Long participanteId) { this.participanteId = participanteId; }
    public Long getEventoId() { return eventoId; }
    public void setEventoId(Long eventoId) { this.eventoId = eventoId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}