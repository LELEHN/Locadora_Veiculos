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

import br.senac.sp.Locadoraveiculos.model.Aluguel;
import br.senac.sp.Locadoraveiculos.model.Erro;
import br.senac.sp.Locadoraveiculos.repository.AluguelRepository;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    private AluguelRepository repository;

    @GetMapping
    public ResponseEntity<Iterable<Aluguel>> getAlugueis() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> getAluguel(@PathVariable("id") Long id) {
        Optional<Aluguel> aluguel = repository.findById(id);

        if (aluguel.isPresent()) {
            return ResponseEntity.ok(aluguel.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluguel(@PathVariable("id") Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Object> createAluguel(@RequestBody Aluguel aluguel) {

        try {
            repository.save(aluguel);

            return ResponseEntity.created((URI.create("/aluguel/" + aluguel.getId()))).body(aluguel);
        } catch (Exception e) {

            Erro erro = Erro.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).mensagem("Erro" + e.getMessage())
                    .exception(e.getClass().getName()).build();

            return new ResponseEntity<>(erro, erro.getStatus());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluguel> updateAluguel(@PathVariable("id") Long id, @RequestBody Aluguel aluguel) {

        aluguel.setId(id);
        repository.save(aluguel);

        return ResponseEntity.ok(aluguel);
    }
}
