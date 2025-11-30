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
import br.senac.sp.Locadoraveiculos.model.Funcionario;
import br.senac.sp.Locadoraveiculos.model.Usuario;
import br.senac.sp.Locadoraveiculos.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    

    @Autowired
    private FuncionarioRepository repository;

    @GetMapping
    public ResponseEntity<Iterable<Funcionario>> getFuncionario(){
        return ResponseEntity.ok(repository.findAll());
    }

    //Mostrar um usuario cadastrado(endPoints.get())

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionario(@PathVariable("id") Long id){

        Optional<Funcionario> funcionario = repository.findById(id);

        if(funcionario.isPresent()){

            return ResponseEntity.ok(funcionario.get());
        }

        return ResponseEntity.notFound().build();

    }

    //endpoint para deletar um usuario da tabela(endPOints.delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFuncionario(@PathVariable("id") Long id){

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    
    @PostMapping
    public ResponseEntity<Object> criarFuncionario(@RequestBody Funcionario funcionario){
        try {
            
            repository.save(funcionario);

        return ResponseEntity.created(URI.create("/usuario/" + funcionario.getId())).body(funcionario);

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
    public ResponseEntity <Usuario> atualizar(@PathVariable("id") Long id, @RequestBody Funcionario funcionario){

        repository.save(funcionario);
        return ResponseEntity.ok(funcionario);
    }
}
