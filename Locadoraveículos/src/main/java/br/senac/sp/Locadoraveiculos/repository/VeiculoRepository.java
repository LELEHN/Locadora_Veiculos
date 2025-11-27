package br.senac.sp.Locadoraveiculos.repository;

import org.springframework.data.repository.CrudRepository;

import br.senac.sp.Locadoraveiculos.model.Veiculo;

//repository de veiculo

public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {


    
}
