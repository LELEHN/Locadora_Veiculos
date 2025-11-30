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
import br.senac.sp.Locadoraveiculos.model.Reserva;
import br.senac.sp.Locadoraveiculos.repository.ReservaRepository;

@RestController
@RequestMapping("/reserva") // url do controller
public class ReservaController {

    @Autowired
    private ReservaRepository repository;

    @GetMapping
    public ResponseEntity<Iterable<Reserva>> getReservas() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReserva(@PathVariable("id") Long id ) {
        Optional<Reserva> reserva = repository.findById(id);

        if (reserva.isPresent()) {
            return ResponseEntity.ok(reserva.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable("id") Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Object> createReserva(@RequestBody Reserva reserva) {
        try {
            repository.save(reserva);

            return ResponseEntity.created((URI.create("/reserva/" + reserva.getId()))).body(reserva);
        } catch (Exception e) {
            
            Erro erro = Erro.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).mensagem("Erro" + e.getMessage()).exception(e.getClass().getName()).build();

            return new ResponseEntity<>(erro, erro.getStatus());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable("id") Long id, @RequestBody Reserva reserva){
        repository.save(reserva);

        return ResponseEntity.ok(reserva);
    }
}
