package com.vidaplus.sghss.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class AdministracaoHospitalar {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @OneToMany(mappedBy = "administracaoHospitalar")
    private List<Leito> leitos = new ArrayList<>();
    
    @OneToMany(mappedBy = "administracaoHospitalar")
    private List<RelatorioFinanceiro> relatoriosFinanceiros = new ArrayList<>();
    
    @OneToMany(mappedBy = "administracaoHospitalar")
    private List<Suprimento> suprimentos = new ArrayList<>();

    protected AdministracaoHospitalar() {}

    // Getters
    public String getId() { return id; }
    public List<Leito> getLeitos() { return leitos; }
    public List<RelatorioFinanceiro> getRelatoriosFinanceiros() { return relatoriosFinanceiros; }
    public List<Suprimento> getSuprimentos() { return suprimentos; }

    // Métodos de domínio
    public void adicionarLeito(Leito leito) {
        this.leitos.add(leito);
    }
    
    public void adicionarRelatorioFinanceiro(RelatorioFinanceiro relatorio) {
        this.relatoriosFinanceiros.add(relatorio);
    }
    
    public void adicionarSuprimento(Suprimento suprimento) {
        this.suprimentos.add(suprimento);
    }
}