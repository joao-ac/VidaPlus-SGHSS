package com.vidaplus.sghss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vidaplus.sghss.domain.Consulta;
import com.vidaplus.sghss.repository.ConsultaRepository;

@Service
public class ConsultaService {
    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Transactional(readOnly = true)
    public List<Consulta> listarTodas() {
        return consultaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Consulta> buscarPorId(String id) {
        return consultaRepository.findById(id);
    }

    @Transactional
    public Consulta salvar(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Transactional
    public void excluir(String id) {
        consultaRepository.deleteById(id);
    }
}