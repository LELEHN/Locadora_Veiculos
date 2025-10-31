package br.senac.sp.Locadoraveiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.senac.sp.Locadoraveiculos.model.Usuario;

@SpringBootApplication
public class LocadoraveiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocadoraveiculosApplication.class, args);
		Usuario usuario = new Usuario();
	}

}
