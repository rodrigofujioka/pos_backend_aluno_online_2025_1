package br.com.alunoonline.api.dtos;

import lombok.Data;

@Data
public class ProfessorRequestDTO {
    private String nome;
    private String email;
    private String cpf;
    private String cep;
    private String numero;
}
