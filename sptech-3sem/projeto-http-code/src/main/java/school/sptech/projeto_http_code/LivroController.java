package school.sptech.projeto_http_code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    LivroRepository livroRepository;

    @GetMapping
    public List<Livro> listar(){
        return livroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Integer id){
        return livroRepository.existsById(id) ? livroRepository.findById(id).orElse(null) : null;
    }

    @PostMapping
    public Livro cadastrar(@RequestBody Livro livro){
        return livroRepository.save(livro);
    }

    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Integer id, @RequestBody Livro livro){
        if(livroRepository.existsById(id)){
            livro.setId(id);
            return livroRepository.save(livro);
        } else {return null;}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        if(livroRepository.existsById(id)){
            livroRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return  ResponseEntity.status(404).build();
    }

    @GetMapping("pt2/")
    public ResponseEntity<List<Livro>> listarPt2(){
        List<Livro> livros = livroRepository.findAll();
        if(livros.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(livros);
        }
    }

    @PutMapping("/{id}/pt2")
    public ResponseEntity<Livro> atualizarPt2(@PathVariable Integer id, @RequestBody Livro livro){
        return ResponseEntity.status(202).body(livroRepository.save(livro));
    }

    @GetMapping("/filtro-nome")
    public ResponseEntity<List<Livro>> porNome( @RequestParam String nome){
        if(livroRepository.findByNome(nome).isEmpty()){
            return ResponseEntity.status(204).build();
        } else {return ResponseEntity.status(200).build();}
    }
}
