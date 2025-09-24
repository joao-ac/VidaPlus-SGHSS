package com.vidaplus.sghss.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @NotNull(message = "Data não pode estar vazia")
    private Date data;
    
    @NotNull(message = "Horários disponíveis não podem estar vazios")
    private List<String> horariosDisponiveis = new ArrayList<>();
    
    @ManyToOne
    @NotNull(message = "Profissional não pode estar vazio")
    private ProfissionalDeSaude profissional;

    protected Agenda() {}

    public Agenda(Date data, List<String> horariosDisponiveis, ProfissionalDeSaude profissional) {
        this.data = data;
        this.horariosDisponiveis = horariosDisponiveis;
        this.profissional = profissional;
    }

    // Getters
    public String getId() { return id; }
    public Date getData() { return data; }
    public List<String> getHorariosDisponiveis() { return horariosDisponiveis; }
    public ProfissionalDeSaude getProfissional() { return profissional; }

    // Métodos de domínio
    public void adicionarHorario(String horario) {
        this.horariosDisponiveis.add(horario);
    }
    
    public void removerHorario(String horario) {
        this.horariosDisponiveis.remove(horario);
    }
}