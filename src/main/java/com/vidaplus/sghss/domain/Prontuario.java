package com.vidaplus.sghss.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @NotBlank(message = "Diagnóstico não pode estar vazio")
    private String diagnostico;
    
    @OneToMany(mappedBy = "prontuario")
    private List<Prescricao> prescricao = new ArrayList<>();
    
    @OneToOne(mappedBy = "prontuario")
    private Consulta consulta;

    protected Prontuario() {}

    public Prontuario(String diagnostico, Consulta consulta) {
        this.diagnostico = diagnostico;
        this.consulta = consulta;
    }

    // Getters
    public String getId() { return id; }
    public String getDiagnostico() { return diagnostico; }
    public List<Prescricao> getPrescricao() { return prescricao; }
    public Consulta getConsulta() { return consulta; }

    // Métodos de domínio
    public void adicionarPrescricao(Prescricao prescricao) {
        this.prescricao.add(prescricao);
    }
}