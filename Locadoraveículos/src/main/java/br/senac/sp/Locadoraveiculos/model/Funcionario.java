package br.senac.sp.Locadoraveiculos.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Funcionario extends Usuario {
    private String cargo;
    private double salario;
    private LocalDate dataContratacao;
}
