package br.senac.sp.Locadoraveiculos.model;

import br.senac.sp.Locadoraveiculos.model.enums.Cor;
import br.senac.sp.Locadoraveiculos.model.enums.Disponibilidade;
import br.senac.sp.Locadoraveiculos.model.enums.TipoMotor;
import br.senac.sp.Locadoraveiculos.model.enums.TipoTransmissao;
import br.senac.sp.Locadoraveiculos.model.enums.TipoVeiculo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private boolean valorDiaria;
    private Cor cor;
    private TipoVeiculo tipoVeiculo;
    private String motorizacao;
    private TipoMotor tipoMotor;
    private TipoTransmissao tipoTransmissao;
    private Disponibilidade disponibilidade;
    private boolean emManutencao;
}
