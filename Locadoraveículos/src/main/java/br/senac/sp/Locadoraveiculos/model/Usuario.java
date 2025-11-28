package br.senac.sp.Locadoraveiculos.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public  class Usuario {
    @Id
    private int id;
    private String nome;
    private String email;
    @JsonProperty(access = Access.WRITE_ONLY)
    private String senha;
    private String cpf;
    private LocalDate dataNasc;
    private String telefone;
    private String endereco;
}
