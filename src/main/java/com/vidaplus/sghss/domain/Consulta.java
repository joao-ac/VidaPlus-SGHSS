package com.vidaplus.sghss.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @ManyToOne
    @NotNull(message = "Paciente não pode estar vazio")
    private Paciente paciente;
    
    @ManyToOne
    @NotNull(message = "Profissional não pode estar vazio")
    private ProfissionalDeSaude profissional;
    
    @NotNull(message = "Data e hora não podem estar vazios")
    private Date dataHora;
    
    @NotBlank(message = "Tipo não pode estar vazio")
    private String tipo;
    
    @NotBlank(message = "Status não pode estar vazio")
    private String status;
    
    @OneToOne
    private Prontuario prontuario;

    protected Consulta() {}

    public Consulta(Paciente paciente, ProfissionalDeSaude profissional, Date dataHora, String tipo, String status) {
        this.paciente = paciente;
        this.profissional = profissional;
        this.dataHora = dataHora;
        this.tipo = tipo;
        this.status = status;
    }

    // Getters
    public String getId() { return id; }
    public Paciente getPaciente() { return paciente; }
    public ProfissionalDeSaude getProfissional() { return profissional; }
    public Date getDataHora() { return dataHora; }
    public String getTipo() { return tipo; }
    public String getStatus() { return status; }
    public Prontuario getProntuario() { return prontuario; }

    // Métodos de domínio
    public void adicionarProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
}