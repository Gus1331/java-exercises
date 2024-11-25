package school.sptech.prova_ac1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;


    @PostMapping
    public ResponseEntity<Usuario> post(@RequestBody Usuario usuario){

        if( !repository.findByEmail(usuario.getEmail()).isEmpty() ||
        !repository.findByCpf(usuario.getCpf()).isEmpty()){
            return ResponseEntity.status(409).build();
        }
        usuario.setId(null);
        return ResponseEntity.status(201).body(repository.save(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> get(){
        List<Usuario> res = repository.findAll();

        if (res.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(res);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getId(@PathVariable Integer id){
        Usuario res = repository.findById(id).orElse(null);

        if(res == null){
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.status(200).body(res);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable Integer id){
        Usuario res = repository.findById(id).orElse(null);

        if(res == null){
            return ResponseEntity.status(404).build();
        } else {
            repository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
    }

    @GetMapping("/filtro-data")
    public ResponseEntity<List<Usuario>> getByDataNascimento(@RequestParam("dataNascimento") LocalDate dataAniversario){
        List<Usuario> res = repository.findByDataNascimentoAfter(dataAniversario);
        if(res.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(res);
        }
    }
}
