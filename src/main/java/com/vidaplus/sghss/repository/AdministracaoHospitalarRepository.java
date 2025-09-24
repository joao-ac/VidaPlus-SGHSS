package com.vidaplus.sghss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vidaplus.sghss.domain.AdministracaoHospitalar;

public interface AdministracaoHospitalarRepository extends JpaRepository<AdministracaoHospitalar, String> {
    // Métodos personalizados podem ser adicionados aqui
}