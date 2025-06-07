package br.com.alunoonline.api.dtos;

import br.com.alunoonline.api.validator.ApenasIespEmail;
import lombok.Data;

@Data
public class ProfessorRequestDTO {
    private String nome;
    @ApenasIespEmail
    private String email;
    private String cpf;
    private String cep;
    private String numero;
}
