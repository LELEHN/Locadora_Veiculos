package br.senac.sp.Locadoraveiculos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.sp.Locadoraveiculos.model.Usuario;

//repository de usuario

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    
}
