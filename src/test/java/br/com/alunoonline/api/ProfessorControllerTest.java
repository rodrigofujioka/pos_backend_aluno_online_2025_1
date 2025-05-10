// Pacote onde está o teste
package br.com.alunoonline.api;

// Importações necessárias
import br.com.alunoonline.api.controller.ProfessorController;
import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.service.ProfessorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Classe de teste para o controller ProfessorController.
 * Estamos testando o endpoint POST que cria um novo professor.
 */
@WebMvcTest(ProfessorController.class) // Diz ao Spring para inicializar apenas o Controller (testes leves e rápidos)
public class ProfessorControllerTest {

    @Autowired
    private MockMvc mockMvc; // Usado para simular requisições HTTP (sem subir o servidor)

    @MockBean
    private ProfessorService professorService; // Mock do service para não usar banco de verdade

    @Autowired
    private ObjectMapper objectMapper; // Usado para converter objetos em JSON

    private Professor professor; // Objeto de teste

    @BeforeEach
    void setup() {
        // Criando um objeto Professor para usar nos testes
        professor = new Professor(1L, "João da Silva", "joao@email.com", "12345678900");
    }

    @Test
    void deveCriarProfessorComSucesso() throws Exception {
        // Realiza uma requisição POST simulada para o endpoint /professores
        mockMvc.perform(post("/professores")
                        .contentType(MediaType.APPLICATION_JSON) // Tipo do conteúdo (JSON)
                        .content(objectMapper.writeValueAsString(professor))) // Corpo da requisição em JSON
                .andExpect(status().isCreated()); // Verifica se o status de retorno foi 201 CREATED

        // Verifica se o método criarProfessor foi chamado exatamente uma vez com qualquer objeto Professor
        verify(professorService, times(1)).criarProfessor(any(Professor.class));
    }
}
