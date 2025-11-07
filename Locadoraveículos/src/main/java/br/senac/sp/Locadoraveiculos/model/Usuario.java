package br.senac.sp.Locadoraveiculos.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public abstract class Usuario {
    @Id
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private LocalDate dataNasc;
    private String telefone;
    private String endereco;
}
