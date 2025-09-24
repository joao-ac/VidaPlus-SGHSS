package com.vidaplus.sghss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vidaplus.sghss.domain.ProfissionalDeSaude;

public interface ProfissionalDeSaudeRepository extends JpaRepository<ProfissionalDeSaude, String> {
    // Métodos personalizados podem ser adicionados aqui
}