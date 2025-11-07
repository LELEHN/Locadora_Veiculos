package br.senac.sp.Locadoraveiculos.model;

import java.time.LocalDate;

import br.senac.sp.Locadoraveiculos.model.enums.MetodoPagamento;
import br.senac.sp.Locadoraveiculos.model.enums.StatusServico;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Pagamento {
    @Id
    private int id;
    @OneToOne
    private Aluguel aluguel;
    private MetodoPagamento metodoPagamento;
    private double valorPago;
    private LocalDate dataPagamento;
    private StatusServico statusPagamento;
}
