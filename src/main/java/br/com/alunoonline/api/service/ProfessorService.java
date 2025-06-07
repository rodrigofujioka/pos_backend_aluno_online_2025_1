package br.com.alunoonline.api.service;

import br.com.alunoonline.api.clients.ViaCepClient;
import br.com.alunoonline.api.dtos.EnderecoResponseDTO;
import br.com.alunoonline.api.dtos.ProfessorRequestDTO;
import br.com.alunoonline.api.model.Endereco;
import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ViaCepClient viaCepClient;

    public void criarProfessor(Professor professor) {
        log.info("Criando Professor: {}", professor);
        professorRepository.save(professor);
    }

    public void criarProfessor(ProfessorRequestDTO professorDTO) {
        EnderecoResponseDTO enderecoDTO = viaCepClient.consultaCep(professorDTO.getCep());

        log.info("Criando Professor: {}", professorDTO);

        Endereco endereco = Endereco.builder()
                .cep(enderecoDTO.getCep())
                .logradouro(enderecoDTO.getLogradouro())
                .complemento(enderecoDTO.getComplemento())
                .bairro(enderecoDTO.getBairro())
                .localidade(enderecoDTO.getLocalidade())
                .uf(enderecoDTO.getUf())
                .estado(enderecoDTO.getEstado())
                .regiao(enderecoDTO.getRegiao())
                .ibge(enderecoDTO.getIbge())
                .gia(enderecoDTO.getGia())
                .ddd(enderecoDTO.getDdd())
                .siafi(enderecoDTO.getSiafi())
                .numero(professorDTO.getNumero()) // dado manual
                .build();

        Professor professor = new Professor();
        professor.setNome(professorDTO.getNome());
        professor.setEmail(professorDTO.getEmail());
        professor.setCpf(professorDTO.getCpf());
        professor.setEndereco(endereco);

        professorRepository.save(professor);
    }

}
