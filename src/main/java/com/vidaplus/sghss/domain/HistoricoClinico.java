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
public class HistoricoClinico {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @NotNull(message = "Data não pode estar vazia")
    private Date data;
    
    @NotBlank(message = "Descrição não pode estar vazia")
    private String descricao;
    
    @ManyToOne
    @NotNull(message = "Profissional não pode estar vazio")
    private ProfissionalDeSaude profissional;
    
    @ManyToOne
    @NotNull(message = "Paciente não pode estar vazio")
    private Paciente paciente;

    protected HistoricoClinico() {}

    public HistoricoClinico(Date data, String descricao, ProfissionalDeSaude profissional, Paciente paciente) {
        this.data = data;
        this.descricao = descricao;
        this.profissional = profissional;
        this.paciente = paciente;
    }

    // Getters
    public String getId() { return id; }
    public Date getData() { return data; }
    public String getDescricao() { return descricao; }
    public ProfissionalDeSaude getProfissional() { return profissional; }
    public Paciente getPaciente() { return paciente; }
}