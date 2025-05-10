package br.com.alunoonline.api;

import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.ProfessorRepository;
import br.com.alunoonline.api.service.ProfessorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * Classe de teste da camada de serviço (ProfessorService).
 * Focada em verificar se o método salvar está sendo chamado corretamente.
 */
public class ProfessorServiceTest {

    @InjectMocks
    private ProfessorService professorService; // Classe que queremos testar

    @Mock
    private ProfessorRepository professorRepository; // Simulação do banco de dados

    @BeforeEach
    void setup() {
        // Inicializa os mocks antes de cada teste
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarProfessorComSucesso() {
        // Dado um professor de exemplo
        Professor professor = new Professor(1L, "Maria Oliveira", "maria@email.com", "98765432100");

        // Quando criamos um professor...
        professorService.criarProfessor(professor);

        // Então esperamos que o método save tenha sido chamado uma vez
        verify(professorRepository, times(1)).save(professor);
    }
}
