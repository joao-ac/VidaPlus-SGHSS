package com.vidaplus.sghss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vidaplus.sghss.domain.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, String> {
    // Métodos personalizados podem ser adicionados aqui
}