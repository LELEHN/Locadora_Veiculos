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

import br.senac.sp.Locadoraveiculos.model.Erro;
import br.senac.sp.Locadoraveiculos.model.Usuario;
import br.senac.sp.Locadoraveiculos.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario") // url do controller da api
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    //mostrar todos os usuarios

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> getUsuarios(){
        return ResponseEntity.ok(repository.findAll());
    }

    //Mostrar um usuario cadastrado(endPoints.get())

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable("id") Long id){

        Optional<Usuario> usuario = repository.findById(id);

        if(usuario.isPresent()){

            return ResponseEntity.ok(usuario.get());
        }

        return ResponseEntity.notFound().build();

    }

    //endpoint para deletar um usuario da tabela(endPOints.delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable("id") Long id){

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    //inserir um usuario no banco de dados(endPoints.post())

    @PostMapping
    public ResponseEntity<Object> criarUsuario(@RequestBody Usuario usuario){
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

    //Atualizando um dado da tabela(endPoints.put)

    @PutMapping("/{id}")
    public ResponseEntity <Usuario> atualizar(@PathVariable("id") Long id, @RequestBody Usuario usuario){

        repository.save(usuario);
        return ResponseEntity.ok(usuario);
        
    }
    
}
