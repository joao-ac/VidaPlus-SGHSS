package com.vidaplus.sghss.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Prescricao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @NotBlank(message = "Medicamento não pode estar vazio")
    private String medicamento;
    
    @NotBlank(message = "Posologia não pode estar vazia")
    private String posologia;
    
    @NotNull(message = "Quantidade não pode estar vazia")
    @Positive(message = "Quantidade deve ser positiva")
    private Integer quantidade;
    
    @ManyToOne
    @NotNull(message = "Prontuário não pode estar vazio")
    private Prontuario prontuario;

    protected Prescricao() {}

    public Prescricao(String medicamento, String posologia, Integer quantidade, Prontuario prontuario) {
        this.medicamento = medicamento;
        this.posologia = posologia;
        this.quantidade = quantidade;
        this.prontuario = prontuario;
    }

    // Getters
    public String getId() { return id; }
    public String getMedicamento() { return medicamento; }
    public String getPosologia() { return posologia; }
    public Integer getQuantidade() { return quantidade; }
    public Prontuario getProntuario() { return prontuario; }
}