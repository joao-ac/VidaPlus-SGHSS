package com.vidaplus.sghss.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vidaplus.sghss.domain.valueobjects.Contato;
import com.vidaplus.sghss.domain.valueobjects.Endereco;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @NotBlank(message = "Nome não pode estar vazio")
    private String nome;
    
    @NotNull(message = "Data de nascimento não pode estar vazia")
    @Past(message = "Data de nascimento deve estar no passado")
    private Date dataNascimento;
    
    @NotBlank(message = "Sexo não pode estar vazio")
    @Pattern(regexp = "[MF]", message = "Sexo deve ser M ou F")
    private String sexo;
    
    @NotBlank(message = "CPF não pode estar vazio")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF inválido")
    private String cpf;
    
    @Embedded
    private Endereco endereco;
    
    @Embedded
    private Contato contatos;
    
    @OneToMany(mappedBy = "paciente")
    private List<HistoricoClinico> historicoClinico = new ArrayList<>();
    
    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas = new ArrayList<>();
    
    protected Paciente() {}
    
    public Paciente(String nome, Date dataNascimento, String sexo, String cpf, Endereco endereco, Contato contatos) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        this.endereco = endereco;
        this.contatos = contatos;
    }

    // Getters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public Date getDataNascimento() { return dataNascimento; }
    public String getSexo() { return sexo; }
    public String getCpf() { return cpf; }
    public Endereco getEndereco() { return endereco; }
    public Contato getContatos() { return contatos; }
    public List<HistoricoClinico> getHistoricoClinico() { return historicoClinico; }
    public List<Consulta> getConsultas() { return consultas; }

    // Métodos de domínio
    public void adicionarHistoricoClinico(HistoricoClinico historico) {
        this.historicoClinico.add(historico);
    }
    
    public void adicionarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }
}