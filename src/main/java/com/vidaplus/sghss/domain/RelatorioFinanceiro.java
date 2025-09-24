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
public class RelatorioFinanceiro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @NotBlank(message = "Período não pode estar vazio")
    private String periodo;
    
    @NotNull(message = "Receitas não podem estar vazias")
    @Positive(message = "Receitas devem ser positivas")
    private Float receitas;
    
    @NotNull(message = "Despesas não podem estar vazias")
    @Positive(message = "Despesas devem ser positivas")
    private Float despesas;
    
    @ManyToOne
    @NotNull(message = "Administração hospitalar não pode estar vazia")
    private AdministracaoHospitalar administracaoHospitalar;

    protected RelatorioFinanceiro() {}

    public RelatorioFinanceiro(String periodo, Float receitas, Float despesas, AdministracaoHospitalar administracaoHospitalar) {
        this.periodo = periodo;
        this.receitas = receitas;
        this.despesas = despesas;
        this.administracaoHospitalar = administracaoHospitalar;
    }

    // Getters
    public String getId() { return id; }
    public String getPeriodo() { return periodo; }
    public Float getReceitas() { return receitas; }
    public Float getDespesas() { return despesas; }
    public AdministracaoHospitalar getAdministracaoHospitalar() { return administracaoHospitalar; }

    // Métodos de domínio
    public Float getSaldo() {
        return receitas - despesas;
    }
}