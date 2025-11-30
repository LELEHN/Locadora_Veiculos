package br.senac.sp.Locadoraveiculos.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Cliente extends Usuario {

    private boolean emAtividade;
    private String cnhNumero;
    private LocalDate cnhValidade;
}
