package br.com.alunoonline.api.dtos;


import lombok.Data;


@Data
public class AlunoResponseDTO {

    private Long id;
    private String nome;
    private String email;

}
