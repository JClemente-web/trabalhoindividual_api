package com.joao.eventos.repository;

import com.joao.eventos.entity.PreferenciaAcessibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenciaAcessibilidadeRepository extends JpaRepository<PreferenciaAcessibilidade, Long> {}