package br.com.alunoonline.api.service;

import br.com.alunoonline.api.dtos.AlunoResponseDTO;
import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final ModelMapper modelMapper;

    public void criarAluno(Aluno aluno) {
        try {
            alunoRepository.save(aluno);
        }catch (Exception e) {
            log.error("Erro ao criar aluno ", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao criar aluno");
        }
    }

    public List<Aluno> listarTodosAlunos() {
        return alunoRepository.findAll();
    }

    public Page<AlunoResponseDTO> listarTodosAlunosPaginado(Pageable pageable) {
        return alunoRepository.findAll(pageable)
                .map(aluno -> modelMapper.map(aluno, AlunoResponseDTO.class));
    }


    public Optional<Aluno> buscarAlunoPeloId(Long id) {
        return alunoRepository.findById(id);
    }

    public void deletarAlunoPorId(Long id) {
        alunoRepository.deleteById(id);
    }

    public void atualizarAlunoPorId(Long id, Aluno aluno) {
       //PRIMEIRO PASSO: VER SE O ALUNO EXISTE NO BD
       Optional<Aluno> alunoDoBancoDeDados =
               buscarAlunoPeloId(id);

       // E SE NÃO EXISTIR ESSE ALUNO
        if (alunoDoBancoDeDados.isEmpty()) {
            throw new
                    ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Aluno não encontrado no banco de dados"
                    );
        }

        // SE CHEGAR AQUI, SIGNIFICA QUE EXISTE ALUNO COM ESSE ID!
        // VOU ARMAZENA-LO EM UMA VARIAVEL PARA DEPOIS EDITA-LO
        Aluno alunoEditado = alunoDoBancoDeDados.get();

        // COM ESSE ALUNO EDITADO DE CIMA, FAÇO
        // OS SETS NECESSÁRIOS PARA ATUALIZAR OS ATRIBUTOS DELE
        alunoEditado.setNome(aluno.getNome());
        alunoEditado.setEmail(aluno.getEmail());
        alunoEditado.setCpf(aluno.getCpf());

        // COM O ALUNO TOTALMENTE EDITADO ACIMA
        // EU DEVOLVO ELE EDITADO/ATUALIZADO PARA O BANCO DE DADOS
        alunoRepository.save(alunoEditado);
    }


    public AlunoResponseDTO convertToDTO(Aluno aluno) {
        return modelMapper.map(aluno, AlunoResponseDTO.class);
    }

    public Aluno convertToEntity(AlunoResponseDTO dto) {
        return modelMapper.map(dto, Aluno.class);
    }
}
