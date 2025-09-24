package com.vidaplus.sghss.domain.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Embeddable
public class Contato {
    @NotBlank(message = "Telefone não pode estar vazio")
    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}", message = "Telefone inválido")
    private String telefone;
    
    @NotBlank(message = "Email não pode estar vazio")
    @Email(message = "Email inválido")
    private String email;

    protected Contato() {}

    public Contato(String telefone, String email) {
        this.telefone = telefone;
        this.email = email;
    }

    // Getters
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return telefone.equals(contato.telefone) && 
        email.equals(contato.email);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }
}