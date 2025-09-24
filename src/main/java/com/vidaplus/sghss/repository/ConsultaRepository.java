package com.vidaplus.sghss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vidaplus.sghss.domain.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, String> {
    // Métodos personalizados podem ser adicionados aqui
}