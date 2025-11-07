package br.senac.sp.Locadoraveiculos.model;

import br.senac.sp.Locadoraveiculos.model.enums.Cor;
import br.senac.sp.Locadoraveiculos.model.enums.Disponibilidade;
import br.senac.sp.Locadoraveiculos.model.enums.TipoMotor;
import br.senac.sp.Locadoraveiculos.model.enums.TipoTransmissao;
import br.senac.sp.Locadoraveiculos.model.enums.TipoVeiculo;
import lombok.Data;

@Data
public class Veiculo {
    private int id;
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
    private Disponibilidade disponilidade;
    private boolean emManutencao;
}
