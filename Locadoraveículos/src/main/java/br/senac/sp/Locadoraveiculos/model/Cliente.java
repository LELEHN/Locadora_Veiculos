package br.senac.sp.Locadoraveiculos.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Cliente extends Usuario {
    private boolean emAtividade;
    private String cnhNumero;
    private LocalDate cnhValidade;
}
