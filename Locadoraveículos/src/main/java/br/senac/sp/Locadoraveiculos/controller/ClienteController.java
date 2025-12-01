package br.senac.sp.Locadoraveiculos.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

import br.senac.sp.Locadoraveiculos.model.Cliente;
import br.senac.sp.Locadoraveiculos.model.Erro;
import br.senac.sp.Locadoraveiculos.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> getClientes(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientes(@PathVariable("id") Long id){

        Optional<Cliente> cliente = repository.findById(id);

        if(cliente.isPresent()){

            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable("id") Long id){

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    //inserir um usuario no banco de dados(endPoints.post())

    @PostMapping
    public ResponseEntity<Object> criarCliente(@RequestBody Cliente usuario){
        try {
            
            repository.save(usuario);

        return ResponseEntity.created(URI.create("/usuario/" + usuario.getId())).body(usuario);

        } catch (DataIntegrityViolationException e) {
            //retorna um objeto erro na ResponseEntity

            Erro erro = Erro.builder().status(HttpStatus.BAD_REQUEST).
            mensagem("Possivel duplicação de resgistro").exception(e.getClass().getName()).build();

            return new ResponseEntity<>(erro, erro.getStatus());
        }catch (Exception e) {
            
            //retorna um objeto erro na ResponseEntity
            Erro erro = Erro.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).
            mensagem("Erro" + e.getMessage()).exception(e.getClass().getName()).build();

            return new ResponseEntity<>(erro, erro.getStatus());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <Cliente> atualizar(@PathVariable("id") Long id, @RequestBody Cliente usuario){

        usuario.setId(id);

        repository.save(usuario);

        return ResponseEntity.ok(usuario);
    }
}
