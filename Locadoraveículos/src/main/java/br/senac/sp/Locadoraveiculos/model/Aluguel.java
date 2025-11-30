package br.senac.sp.Locadoraveiculos.model;

import java.time.LocalDate;

import br.senac.sp.Locadoraveiculos.model.enums.StatusServico;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Reserva reserva;
    @OneToOne
    private Cliente cliente;
    @OneToOne
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
