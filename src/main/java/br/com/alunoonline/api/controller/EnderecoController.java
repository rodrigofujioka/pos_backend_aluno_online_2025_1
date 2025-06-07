package br.com.alunoonline.api.controller;


import br.com.alunoonline.api.dtos.EnderecoResponseDTO;
import br.com.alunoonline.api.service.ViaCepService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
public class EnderecoController {

    private final ViaCepService viaCepService;

    @GetMapping("/{cep}")
    public EnderecoResponseDTO buscarPorCep(@PathVariable String cep) {
        return viaCepService.buscarEnderecoPorCep(cep);
    }
}
