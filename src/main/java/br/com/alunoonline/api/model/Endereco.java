package br.com.alunoonline.api.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "enderecos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private String ddd;


    private String numero; // campo preenchido manualmente
}
