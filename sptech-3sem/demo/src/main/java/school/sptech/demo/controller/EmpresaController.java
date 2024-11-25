package school.sptech.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.demo.entity.Empresa;
import school.sptech.demo.service.EmpresaService;

import java.util.List;

@RestController
@RequestMapping("/empresas")
@RequiredArgsConstructor
public class EmpresaController {
    private final EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> listar(){
        List<Empresa> empresas = empresaService.buscarTodos();
        if(empresas.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(empresas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> porId(@PathVariable int id){
        return ResponseEntity.ok(empresaService.buscarPorId(id));
    }
}
