package school.sptech.ex_many_to_one_dto1.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.ex_many_to_one_dto1.dto.ativo.AtivoMapper;
import school.sptech.ex_many_to_one_dto1.dto.ativo.AtivoRequestDto;
import school.sptech.ex_many_to_one_dto1.dto.ativo.AtivoResponseDto;
import school.sptech.ex_many_to_one_dto1.entity.Ativo;
import school.sptech.ex_many_to_one_dto1.service.AtivoService;
import school.sptech.ex_many_to_one_dto1.service.CarteiraService;

import java.util.ArrayList;
import java.util.List;

// TODO: TERMINAR A CLASSE
@RestController
@RequestMapping("/ativos")
public class AtivoController {
    @Autowired
    AtivoService ativoService;

    @Autowired
    CarteiraService carteiraService;

    @PostMapping
    public ResponseEntity<AtivoResponseDto> cadastrar(
            @RequestBody @Valid AtivoRequestDto ativoRequestDto
    ){
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(AtivoMapper.toAtivoResponseDto(ativoService.salvar(AtivoMapper.toAtivoEntity(ativoRequestDto) , ativoRequestDto.getCarteiraId())));
    }

    @GetMapping
    public ResponseEntity<List<AtivoResponseDto>> buscarTodos() {
        List<Ativo> ativos = ativoService.buscarTodos();
        List<AtivoResponseDto> res = new ArrayList<>();
        for(Ativo a: ativos){
            res.add(AtivoMapper.toAtivoResponseDto(a));
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtivoResponseDto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(AtivoMapper.toAtivoResponseDto(ativoService.buscarPorId(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        ativoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/carteiras")
    public ResponseEntity<List<AtivoResponseDto>> buscarAtivosPorCarteiraNome(
            @RequestParam String nomeInvestidor) {
        List<AtivoResponseDto> res = new ArrayList<>();
        List<Ativo> ativos = ativoService.buscarAtivosPorInvestidorNome(nomeInvestidor);

        for(Ativo a: ativos){
            res.add(AtivoMapper.toAtivoResponseDto(a));
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(res);
    }

    public ResponseEntity<Double> buscarMediaAtivosPorCarteiraNome(String nomeInvestidor) {
        return ResponseEntity.ok(ativoService.buscarMediaAtivosPorInvestidorNome(nomeInvestidor));
    }
}
