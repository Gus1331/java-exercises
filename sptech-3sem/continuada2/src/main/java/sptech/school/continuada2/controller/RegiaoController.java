package sptech.school.continuada2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sptech.school.continuada2.dto.regiao.RegiaoCreateDto;
import sptech.school.continuada2.dto.regiao.RegiaoMapper;
import sptech.school.continuada2.dto.regiao.RegiaoResponseDto;
import sptech.school.continuada2.entity.Regiao;
import sptech.school.continuada2.service.RegiaoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regioes")
public class RegiaoController {

    // WARN: Não edite essa classe! Já está pronta.

    private final RegiaoService regiaoService;

    @PostMapping
    public ResponseEntity<RegiaoResponseDto> cadastrar(@RequestBody @Valid RegiaoCreateDto regiaoCreateDto) {
        Regiao regiao = RegiaoMapper.toEntity(regiaoCreateDto);
        Regiao regiaoSalva = regiaoService.cadastrar(regiao);
        RegiaoResponseDto dto = RegiaoMapper.toResponseDto(regiaoSalva);
        return ResponseEntity.status(201).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<RegiaoResponseDto>> listar() {
        List<Regiao> todas = regiaoService.listar();

        List<RegiaoResponseDto> dtos = todas.stream()
                .map(RegiaoMapper::toResponseDto)
                .toList();

        return ResponseEntity.status(200).body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegiaoResponseDto> buscarPorId(@PathVariable Integer id) {
        Regiao regiao = regiaoService.buscarPorId(id);
        RegiaoResponseDto dto = RegiaoMapper.toResponseDto(regiao);
        return ResponseEntity.status(200).body(dto);
    }
}
