package br.senac.sp.Locadoraveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.sp.Locadoraveiculos.model.Pagamento;

public interface AluguelRepository extends JpaRepository<Pagamento, Long> {

    
}
