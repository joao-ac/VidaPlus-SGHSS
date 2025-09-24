package com.vidaplus.sghss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vidaplus.sghss.domain.ProfissionalDeSaude;
import com.vidaplus.sghss.repository.ProfissionalDeSaudeRepository;

@Service
public class ProfissionalDeSaudeService {
    private final ProfissionalDeSaudeRepository profissionalRepository;

    public ProfissionalDeSaudeService(ProfissionalDeSaudeRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }

    @Transactional(readOnly = true)
    public List<ProfissionalDeSaude> listarTodos() {
        return profissionalRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<ProfissionalDeSaude> buscarPorId(String id) {
        return profissionalRepository.findById(id);
    }

    @Transactional
    public ProfissionalDeSaude salvar(ProfissionalDeSaude profissional) {
        return profissionalRepository.save(profissional);
    }

    @Transactional
    public void excluir(String id) {
        profissionalRepository.deleteById(id);
    }
}