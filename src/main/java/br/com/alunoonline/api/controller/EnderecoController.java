package br.com.alunoonline.api.controller;


import br.com.alunoonline.api.clients.ViaCepClient;
import br.com.alunoonline.api.dtos.EnderecoResponseDTO;
import br.com.alunoonline.api.service.ViaCepService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
@Slf4j
public class EnderecoController {

 private final ViaCepClient viaCepClient;

    @GetMapping("/{cep}")
    public EnderecoResponseDTO
    buscarPorCep(@PathVariable String cep) {
        log.info("Buscando endereco com CEP: {}", cep);
        return viaCepClient.consultaCep(cep);
    }
}
