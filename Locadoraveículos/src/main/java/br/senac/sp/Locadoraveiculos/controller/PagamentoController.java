package br.senac.sp.Locadoraveiculos.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.senac.sp.Locadoraveiculos.model.Pagamento;
import br.senac.sp.Locadoraveiculos.repository.PagamentoRepository;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoRepository repository;

    @GetMapping
    public ResponseEntity<Iterable<Pagamento>> getPagamentos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> getPagamento(@PathVariable("id") Long id) {
        Optional<Pagamento> pagamento = repository.findById(id);
        
        if (pagamento.isPresent()) {
            return ResponseEntity.ok(pagamento.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePagamento(@PathVariable("id") Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Object> createPagamento(@RequestBody Pagamento pagamento) {

        try {
            repository.save(pagamento);

            return ResponseEntity.created((URI.create("/pagamento/" + pagamento.getId()))).body(pagamento);

        } catch (Exception e) {
            
            Erro erro = Erro.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).mensagem("Erro" + e.getMessage()).exception(e.getClass().getName()).build();

            return new ResponseEntity<>(erro, erro.getStatus());
        }
    }

    @PutMapping("/{id}")

    public ResponseEntity<Pagamento> atualizarVeiculo(@PathVariable("id") Long id, @RequestBody Pagamento pagamento){

        pagamento.setId(id);
        repository.save(pagamento);

        return ResponseEntity.ok(pagamento);
    }
}
