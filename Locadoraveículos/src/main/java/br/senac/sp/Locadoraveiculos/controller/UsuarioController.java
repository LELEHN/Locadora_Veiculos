package br.senac.sp.Locadoraveiculos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.sp.Locadoraveiculos.model.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){

        

        return null;

    } 
    
}
