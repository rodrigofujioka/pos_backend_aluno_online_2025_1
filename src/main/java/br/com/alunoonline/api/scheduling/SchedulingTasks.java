package br.com.alunoonline.api.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class SchedulingTasks {

    @Scheduled(fixedRate = 10000)
    public void executarTarefaComIntervaloFixo() {
        log.info("Executando tarefa a cada 10 segundos: {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 32 7 * * *")
    public void enviarRelatorioMatinal() {
        log.info("Executando tarefa a cada 10 segundos: {}" , LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 15000)
    public void executarComAtraso() {
        log.info("Executando tarefa a cada 10 segundos: {}" , LocalDateTime.now());
    }
}
