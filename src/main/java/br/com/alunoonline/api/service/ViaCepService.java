package br.com.alunoonline.api.service;


import br.com.alunoonline.api.dtos.EnderecoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ViaCepService {

    private final RestTemplate restTemplate;

    public EnderecoResponseDTO buscarEnderecoPorCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        return restTemplate.getForObject(url, EnderecoResponseDTO.class);
    }


}
