package br.senac.sp.Locadoraveiculos.model;

import java.time.LocalDate;

import br.senac.sp.Locadoraveiculos.model.enums.StatusServico;
import lombok.Data;

@Data
public class Reserva {
    private int id;
    private Usuario usuario;
    private Veiculo veiculo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double valorFinal;
    private StatusServico statusServico;
    private int diasReservados;
    private double taxa;
    private LocalDate dataEmissao;
}
