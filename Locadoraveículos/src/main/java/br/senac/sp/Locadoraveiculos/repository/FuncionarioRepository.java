package br.senac.sp.Locadoraveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.sp.Locadoraveiculos.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
}
