package br.com.alunoonline.api;

import br.com.alunoonline.api.client.ViaCepClient;
import br.com.alunoonline.api.dtos.EnderecoViaCepDTO;
import br.com.alunoonline.api.dtos.ProfessorRequestDTO;
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
 * Teste da classe ProfessorService
 * Verifica se o professor é salvo corretamente com os dados de endereço vindos do ViaCEP.
 */
public class ProfessorServiceTest {

    // Dizemos ao Spring que queremos testar essa classe
    @InjectMocks
    private ProfessorService professorService;

    // Simulamos a camada de banco de dados
    @Mock
    private ProfessorRepository professorRepository;

    // Simulamos a chamada à API ViaCEP
    @Mock
    private ViaCepClient viaCepClient;

    @BeforeEach
    void setup() {
        // Inicializa os mocks antes de cada teste
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCriarProfessorComEnderecoViaCep() {
        // Criamos um objeto DTO simulando uma requisição de cadastro
        ProfessorRequestDTO dto = new ProfessorRequestDTO();
        dto.setNome("Ana Teste");
        dto.setEmail("ana@teste.com");
        dto.setCpf("12345678901");
        dto.setCep("01001-000"); // apenas o CEP
        dto.setNumero("123");    // e o número

        // Simulamos o retorno da API ViaCEP
        EnderecoViaCepDTO enderecoViaCep = new EnderecoViaCepDTO();
        enderecoViaCep.setCep("01001-000");
        enderecoViaCep.setLogradouro("Praça da Sé");
        enderecoViaCep.setBairro("Sé");
        enderecoViaCep.setLocalidade("São Paulo");
        enderecoViaCep.setUf("SP");

        // Dizemos ao mock como deve se comportar
        when(viaCepClient.buscarEnderecoPorCep("01001-000")).thenReturn(enderecoViaCep);

        // Executa o método que queremos testar
        professorService.criarProfessor(dto);

        // Verifica se o método de salvar do repository foi chamado uma vez
        verify(professorRepository, times(1)).save(any(Professor.class));
    }
}
