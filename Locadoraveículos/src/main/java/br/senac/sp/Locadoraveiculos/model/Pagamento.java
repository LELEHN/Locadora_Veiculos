package br.senac.sp.Locadoraveiculos.model;

import java.time.LocalDate;

import br.senac.sp.Locadoraveiculos.model.enums.MetodoPagamento;
import br.senac.sp.Locadoraveiculos.model.enums.StatusServico;
import lombok.Data;

@Data
public class Pagamento {
    private int id;
    private Aluguel aluguel;
    private MetodoPagamento metodoPagamento;
    private double valorPago;
    private LocalDate dataPagamento;
    private StatusServico statusPagamento;
}
