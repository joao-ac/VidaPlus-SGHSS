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
public class Suprimento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @NotBlank(message = "Nome não pode estar vazio")
    private String nome;
    
    @NotNull(message = "Quantidade não pode estar vazia")
    @Positive(message = "Quantidade deve ser positiva")
    private Integer quantidade;
    
    @NotBlank(message = "Unidade não pode estar vazia")
    private String unidade;
    
    @ManyToOne
    @NotNull(message = "Administração hospitalar não pode estar vazia")
    private AdministracaoHospitalar administracaoHospitalar;

    protected Suprimento() {}

    public Suprimento(String nome, Integer quantidade, String unidade, AdministracaoHospitalar administracaoHospitalar) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.administracaoHospitalar = administracaoHospitalar;
    }

    // Getters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public Integer getQuantidade() { return quantidade; }
    public String getUnidade() { return unidade; }
    public AdministracaoHospitalar getAdministracaoHospitalar() { return administracaoHospitalar; }

    // Métodos de domínio
    public void adicionarQuantidade(Integer quantidade) {
        if (quantidade > 0) {
            this.quantidade += quantidade;
        }
    }
    
    public void removerQuantidade(Integer quantidade) {
        if (quantidade > 0 && this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
        }
    }
}