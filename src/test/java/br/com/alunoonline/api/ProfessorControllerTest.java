package br.com.alunoonline.api;

import br.com.alunoonline.api.controller.ProfessorController;
import br.com.alunoonline.api.dtos.ProfessorRequestDTO;
import br.com.alunoonline.api.service.ProfessorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Testa o comportamento da chamada HTTP para criar um professor.
 * Simula o envio de um JSON com nome, cpf, email, cep e número.
 */
@WebMvcTest(ProfessorController.class)
public class ProfessorControllerTest {

    @Autowired
    private MockMvc mockMvc; // Ferramenta para simular requisições HTTP

    @MockBean
    private ProfessorService professorService; // Simulamos o service

    @Autowired
    private ObjectMapper objectMapper; // Converte objetos Java para JSON

    private ProfessorRequestDTO dto;

    @BeforeEach
    void setup() {
        // Simulamos os dados da requisição
        dto = new ProfessorRequestDTO();
        dto.setNome("João da Silva");
        dto.setEmail("joao@email.com");
        dto.setCpf("12345678900");
        dto.setCep("01001-000");
        dto.setNumero("100");
    }

    @Test
    void deveCriarProfessorComEnderecoAutoPreenchido() throws Exception {
        // Faz uma chamada POST simulada para /professores
        mockMvc.perform(post("/professores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated()); // Esperamos resposta HTTP 201

        // Verificamos se o método do service foi chamado corretamente
        verify(professorService, times(1)).criarProfessor(any(ProfessorRequestDTO.class));
    }
}
