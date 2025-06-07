package br.com.alunoonline.api.exceptions;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ApiError {
    private int status;
    private String mensagem;
    private LocalDateTime timestamp;
    private List<String> erros;
}
