package br.com.diegoleandro.desafiotodolist.api.domain.exceptions;

import br.com.diegoleandro.desafiotodolist.api.domain.model.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class TodoNaoEncontradoException extends EntidadeNaoEncontradaException{


    public TodoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }


}
