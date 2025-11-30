package br.senac.sp.Locadoraveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.sp.Locadoraveiculos.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    


}
