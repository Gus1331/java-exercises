package school.sptech.ex_many_to_one_dto1.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.ex_many_to_one_dto1.dto.carteira.CarteiraRequestDto;
import school.sptech.ex_many_to_one_dto1.dto.carteira.CarteiraResponseDto;
import school.sptech.ex_many_to_one_dto1.dto.carteira.CarteiraMapper;
import school.sptech.ex_many_to_one_dto1.entity.Carteira;
import school.sptech.ex_many_to_one_dto1.service.CarteiraService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carteiras")
public class CarteiraController {

    private final CarteiraService carteiraService;

    @PostMapping
    public ResponseEntity<CarteiraResponseDto> cadastrar(
            @Valid @RequestBody CarteiraRequestDto carteiraRequestDto
    ) {
        Carteira carteiraEntity = CarteiraMapper.toCarteiraEntity(carteiraRequestDto);
        Carteira carteiraSalva = carteiraService.salvar(carteiraEntity);
        CarteiraResponseDto carteiraResponseDto = CarteiraMapper.toCarteiraResponseDto(carteiraSalva);
        return ResponseEntity.status(201).body(carteiraResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<CarteiraResponseDto>> buscarTodos() {
        List<Carteira> carteiras = carteiraService.buscarTodos();

        if (carteiras.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<CarteiraResponseDto> carteirasResponseDto = carteiras.stream()
                .map(CarteiraMapper::toCarteiraResponseDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(carteirasResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarteiraResponseDto> buscarPorId(@PathVariable Integer id) {
        Carteira carteira = carteiraService.buscarPorId(id);
        CarteiraResponseDto carteiraResponseDto = CarteiraMapper.toCarteiraResponseDto(carteira);
        return ResponseEntity.ok(carteiraResponseDto);
    }
}
