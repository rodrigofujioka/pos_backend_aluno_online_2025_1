package br.com.alunoonline.api.scheduling;

import br.com.alunoonline.api.clients.ViaCepClient;
import br.com.alunoonline.api.dtos.EnderecoResponseDTO;
import br.com.alunoonline.api.service.AlunoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class SchedulingTasks {

    private final AlunoService alunoService;
    private final ViaCepClient viaCepClient;

    @Scheduled(fixedRate = 30000)
    public void atualizarEnderecos(){
        EnderecoResponseDTO response =
                viaCepClient.consultaCep("58031010");

        log.info("Atualizando enderecos {} ", response);
    }

    @Scheduled(fixedRate = 20000)
    public void schedule() {
        log.info("Listando Alunos");
        log.info(alunoService.listarTodosAlunos().toString());
    }

    @Scheduled(fixedRate = 1000000)
    public void executarTarefaComIntervaloFixo() {
        log.info("Executando tarefa a cada 10 segundos: {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 22 11 * * *")
    public void enviarRelatorioMatinal() {
        log.info("Executando tarefa as 11:22: {}" , LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 15000)
    public void executarComAtraso() {
        log.info("Executando com um delay 15 segundos: {}" , LocalDateTime.now());
    }
}
