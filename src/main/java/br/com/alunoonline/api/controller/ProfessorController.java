package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.dtos.ProfessorRequestDTO;
import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarProfessor(@RequestBody ProfessorRequestDTO professorDTO) {
        professorService.criarProfessor(professorDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Professor> getProfessores(){
        return professorService.listarProfessores();
    }



}
