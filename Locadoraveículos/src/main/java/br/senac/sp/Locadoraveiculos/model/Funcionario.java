package br.senac.sp.Locadoraveiculos.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Funcionario {
    private String cargo;
    private double salario;
    private LocalDate dataContratacao;
}
