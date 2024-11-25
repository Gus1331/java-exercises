package school.sptech.projeto_05_validations.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projeto_05_validations.entity.BoletoBancario;
import school.sptech.projeto_05_validations.services.BoletoBancarioService;

@RestController
@RequestMapping("/boletos")
public class BoletoBancarioController {

    @Autowired
    BoletoBancarioService service;

    @PostMapping
    public ResponseEntity<BoletoBancario> cadastrar(
            @RequestBody @Valid BoletoBancario boletobancario){
        return service.cadastrar(boletobancario);
    }
}
