package com.vidaplus.sghss.domain.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Embeddable
public class Endereco {
    @NotBlank(message = "Rua não pode estar vazia")
    private String rua;
    
    @NotBlank(message = "Número não pode estar vazio")
    private String numero;
    
    @NotBlank(message = "Bairro não pode estar vazio")
    private String bairro;
    
    @NotBlank(message = "Cidade não pode estar vazia")
    private String cidade;
    
    @NotBlank(message = "Estado não pode estar vazio")
    private String estado;
    
    @NotBlank(message = "CEP não pode estar vazio")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP inválido")
    private String cep;

    protected Endereco() {}

    public Endereco(String rua, String numero, String bairro, String cidade, String estado, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    // Getters
    public String getRua() { return rua; }
    public String getNumero() { return numero; }
    public String getBairro() { return bairro; }
    public String getCidade() { return cidade; }
    public String getEstado() { return estado; }
    public String getCep() { return cep; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return rua.equals(endereco.rua) && 
        numero.equals(endereco.numero) && 
        bairro.equals(endereco.bairro) && 
        cidade.equals(endereco.cidade) && 
        estado.equals(endereco.estado) && 
        cep.equals(endereco.cep);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rua == null) ? 0 : rua.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
        result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        result = prime * result + ((cep == null) ? 0 : cep.hashCode());
        return result;
    }
}