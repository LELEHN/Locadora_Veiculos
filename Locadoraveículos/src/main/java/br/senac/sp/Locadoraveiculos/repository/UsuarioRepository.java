package br.senac.sp.Locadoraveiculos.repository;

import org.springframework.data.repository.CrudRepository;

import br.senac.sp.Locadoraveiculos.model.Usuario;

//repository de usuario

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
