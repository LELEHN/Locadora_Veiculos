package br.senac.sp.Locadoraveiculos.model;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Erro {
    private HttpStatus status;

    private String mensagem;

    private String exception;


}
