package com.vidaplus.sghss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vidaplus.sghss.domain.Paciente;
import com.vidaplus.sghss.repository.PacienteRepository;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Transactional(readOnly = true)
    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Paciente> buscarPorId(String id) {
        return pacienteRepository.findById(id);
    }

    @Transactional
    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Transactional
    public void excluir(String id) {
        pacienteRepository.deleteById(id);
    }
}