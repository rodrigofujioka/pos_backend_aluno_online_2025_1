package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.dtos.AlunoResponseDTO;
import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@RequestBody @Valid Aluno aluno) {
        log.info("Criando aluno : {}", aluno);
        alunoService.criarAluno(aluno);
        log.info("Aluno criado : {}", aluno);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> listarTodosAlunos() {
        log.info("Consultando lista de alunos ");
        return alunoService.listarTodosAlunos();
    }

    @GetMapping("/paginada")
    @ResponseStatus(HttpStatus.OK)
    public Page<AlunoResponseDTO>
                  listarTodosAlunos(Pageable pageable) {
        log.info("Consultando alunos paginados");
        return alunoService.
                 listarTodosAlunosPaginado(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> buscarAlunoPeloId(@PathVariable Long id) {
        return alunoService.buscarAlunoPeloId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAlunoPorId(@PathVariable Long id) {
        alunoService.deletarAlunoPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarAlunoPorId(@PathVariable Long id,
                                    @RequestBody Aluno aluno) {
        alunoService.atualizarAlunoPorId(id, aluno);
    }
}
