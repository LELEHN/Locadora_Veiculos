package br.senac.sp.Locadoraveiculos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.sp.Locadoraveiculos.model.Veiculo;

//repository de veiculo

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    public List<Veiculo> findByMarca();

    public List<Veiculo> findByModelo();
}
