package br.com.diegoleandro.desafiotodolist.api.domain.service;

import br.com.diegoleandro.desafiotodolist.api.domain.exceptions.TodoNaoEncontradoException;
import br.com.diegoleandro.desafiotodolist.api.domain.model.Todo;
import br.com.diegoleandro.desafiotodolist.api.domain.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroTodoService {

    public static final String MSG_RECURSO_NAO_ENCONTRADO
          = "Tarefa com o id %d informado não está cadastrado no sistema.";

    @Autowired
    TodoRepository todoRepository;

    public Todo salvar(Todo todo){
        return todoRepository.save(todo);
    }

    public void excluir(Long todoId) {
        try {
            todoRepository.deleteById(todoId);
        } catch (EmptyResultDataAccessException ex) {
            throw new TodoNaoEncontradoException(
                    String.format(MSG_RECURSO_NAO_ENCONTRADO, todoId));
        }
    }

    public Todo buscarOuFalhar(Long todoId) {
        return todoRepository.findById(todoId)
                .orElseThrow(()-> new TodoNaoEncontradoException(
                        String.format(MSG_RECURSO_NAO_ENCONTRADO, todoId)));
    }
}
