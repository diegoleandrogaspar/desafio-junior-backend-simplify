package br.com.diegoleandro.desafiotodolist.api.exceptionhandler;

import br.com.diegoleandro.desafiotodolist.api.domain.exceptions.TodoNaoEncontradoException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TodoNaoEncontradoException.class)
    public ResponseEntity<?> tratarRecursoNaoEncontrado(TodoNaoEncontradoException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {

        body = Causa.builder()
                .dataHora(LocalDateTime.now())
                .mensagem(ex.getMessage()).build();

        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }
}
