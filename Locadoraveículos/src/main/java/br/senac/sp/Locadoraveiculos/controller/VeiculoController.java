package br.senac.sp.Locadoraveiculos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.senac.sp.Locadoraveiculos.model.Erro;
import br.senac.sp.Locadoraveiculos.model.Veiculo;
import br.senac.sp.Locadoraveiculos.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculo") // url do controller
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    // endPoint para retornar todos os veiculos cadastrados

    
    @GetMapping
    public ResponseEntity<Iterable<Veiculo>> getVeiculos() {

        return ResponseEntity.ok(repository.findAll());
    }


    // endPOint para mostrar veiculo por id

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getVeiculo(@PathVariable("id") Long id) {

        Optional<Veiculo> veiculo = repository.findById(id);

        if (veiculo.isPresent()) {

            return ResponseEntity.ok(veiculo.get());
        }

        return ResponseEntity.notFound().build();
    }

    // endPOint para deletar um veiculo

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirVeiculo(@PathVariable("id") Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    // endPont para inserir um veiculo no banco

    @PostMapping
    public ResponseEntity<Object> criarVeiculo(@RequestBody Veiculo veiculo) {

        try {
            repository.save(veiculo);

            return ResponseEntity.created((URI.create("/veiculo/" + veiculo.getId()))).body(veiculo);

        } catch (Exception e) {
            
            Erro erro = Erro.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).mensagem("Erro" + e.getMessage()).exception(e.getClass().getName()).build();

            return new ResponseEntity<>(erro, erro.getStatus());
        }
    }

    @PutMapping("/{id}")

    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable("id") Long id, @RequestBody Veiculo veiculo){

        repository.save(veiculo);

        return ResponseEntity.ok(veiculo);
    }

    @GetMapping
    public Page<Veiculo> lista(Pageable pageable){
        return repository.findAll(pageable);
    }

}
