package com.vidaplus.sghss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vidaplus.sghss.domain.AdministracaoHospitalar;
import com.vidaplus.sghss.repository.AdministracaoHospitalarRepository;

@Service
public class AdministracaoHospitalarService {
    private final AdministracaoHospitalarRepository administracaoRepository;

    public AdministracaoHospitalarService(AdministracaoHospitalarRepository administracaoRepository) {
        this.administracaoRepository = administracaoRepository;
    }

    @Transactional(readOnly = true)
    public List<AdministracaoHospitalar> listarTodas() {
        return administracaoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<AdministracaoHospitalar> buscarPorId(String id) {
        return administracaoRepository.findById(id);
    }

    @Transactional
    public AdministracaoHospitalar salvar(AdministracaoHospitalar administracao) {
        return administracaoRepository.save(administracao);
    }

    @Transactional
    public void excluir(String id) {
        administracaoRepository.deleteById(id);
    }
}