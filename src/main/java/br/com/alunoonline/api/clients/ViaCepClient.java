package br.com.alunoonline.api.clients;

import br.com.alunoonline.api.dtos.EnderecoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCEP",
        url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    EnderecoResponseDTO consultaCep(@PathVariable("cep") String cep);

}
