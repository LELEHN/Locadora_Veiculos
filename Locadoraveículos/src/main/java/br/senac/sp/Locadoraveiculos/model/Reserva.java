package br.senac.sp.Locadoraveiculos.model;

import java.time.LocalDate;

import br.senac.sp.Locadoraveiculos.model.enums.StatusServico;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Reserva {
    @Id
    private int id;
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Veiculo veiculo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double valorFinal;
    private StatusServico statusServico;
    private int diasReservados;
    private double taxa;
    private LocalDate dataEmissao;
}
