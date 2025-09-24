package com.vidaplus.sghss.domain;

import java.util.ArrayList;
import java.util.List;

import com.vidaplus.sghss.domain.valueobjects.Contato;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class ProfissionalDeSaude {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @NotBlank(message = "Nome não pode estar vazio")
    private String nome;
    
    @NotBlank(message = "Especialidade não pode estar vazia")
    private String especialidade;
    
    @NotBlank(message = "Registro do conselho não pode estar vazio")
    private String registroConselho;
    
    @Embedded
    private Contato contatos;
    
    @OneToMany(mappedBy = "profissional")
    private List<Agenda> agenda = new ArrayList<>();

    protected ProfissionalDeSaude() {}

    public ProfissionalDeSaude(String nome, String especialidade, String registroConselho, Contato contatos) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.registroConselho = registroConselho;
        this.contatos = contatos;
    }

    // Getters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getEspecialidade() { return especialidade; }
    public String getRegistroConselho() { return registroConselho; }
    public Contato getContatos() { return contatos; }
    public List<Agenda> getAgenda() { return agenda; }

    // Métodos de domínio
    public void adicionarAgenda(Agenda novaAgenda) {
        this.agenda.add(novaAgenda);
    }
}