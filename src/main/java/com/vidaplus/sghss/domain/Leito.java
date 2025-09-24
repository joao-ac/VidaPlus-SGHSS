package com.vidaplus.sghss.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Leito {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @NotBlank(message = "Status não pode estar vazio")
    private String status;
    
    @ManyToOne
    private Paciente paciente;
    
    private Date dataInternacao;
    
    @ManyToOne
    @NotNull(message = "Administração hospitalar não pode estar vazia")
    private AdministracaoHospitalar administracaoHospitalar;

    protected Leito() {}

    public Leito(String status, Paciente paciente, Date dataInternacao, AdministracaoHospitalar administracaoHospitalar) {
        this.status = status;
        this.paciente = paciente;
        this.dataInternacao = dataInternacao;
        this.administracaoHospitalar = administracaoHospitalar;
    }

    // Getters
    public String getId() { return id; }
    public String getStatus() { return status; }
    public Paciente getPaciente() { return paciente; }
    public Date getDataInternacao() { return dataInternacao; }
    public AdministracaoHospitalar getAdministracaoHospitalar() { return administracaoHospitalar; }
}