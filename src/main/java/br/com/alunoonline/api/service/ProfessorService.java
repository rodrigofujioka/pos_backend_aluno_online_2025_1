package br.com.alunoonline.api.service;

import br.com.alunoonline.api.clients.ViaCepClient;
import br.com.alunoonline.api.dtos.EnderecoResponseDTO;
import br.com.alunoonline.api.dtos.ProfessorRequestDTO;
import br.com.alunoonline.api.model.Endereco;
import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ViaCepClient viaCepClient;
    private final ModelMapper modelMapper;

    public List<Professor> listar() {
        return professorRepository.findAll();
    }

    public void criarProfessor(Professor professor) {
        log.info("Criando Professor: {}", professor);
        professorRepository.save(professor);
    }

    public void criarProfessor(ProfessorRequestDTO professorDTO) {
        EnderecoResponseDTO enderecoDTO = viaCepClient.consultaCep(professorDTO.getCep());

        log.info("Criando Professor: {}", professorDTO);

        Endereco endereco = modelMapper.map(enderecoDTO, Endereco.class);
        Professor professor = modelMapper.map(professorDTO, Professor.class);
        professor.setEndereco(endereco);

        professorRepository.save(professor);
    }

}
