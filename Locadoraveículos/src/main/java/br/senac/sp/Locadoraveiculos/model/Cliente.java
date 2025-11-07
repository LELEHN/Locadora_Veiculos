package br.senac.sp.Locadoraveiculos.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Cliente {
    private boolean emAtividade;
    private String cnhNumero;
    private LocalDate cnhValidade;
}
