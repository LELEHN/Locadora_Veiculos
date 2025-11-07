package br.senac.sp.Locadoraveiculos.model;

import java.time.LocalDate;

import br.senac.sp.Locadoraveiculos.model.enums.StatusServico;
import lombok.Data;

@Data
public class Aluguel {
    private int id;
    private Reserva reserva;
    private Usuario usuario;
    private Veiculo veiculo;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private StatusServico statusServico;
    private int diasAlugados;
    private double valorFinal;
    private LocalDate dataEmissao;
    private LocalDate dataDevolucao;
    private double multa;
    private String observacoes;
}
