package br.senac.sp.Locadoraveiculos.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private LocalDate dataNasc;
    private String telefone;
    private String endereco;
}
