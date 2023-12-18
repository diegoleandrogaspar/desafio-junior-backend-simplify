package br.com.diegoleandro.desafiotodolist.api.exceptionhandler;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Causa {

    private LocalDateTime dataHora;
    private String mensagem;

}
