package br.com.diegoleandro.desafiotodolist.api.controller;

import br.com.diegoleandro.desafiotodolist.api.domain.model.Todo;
import br.com.diegoleandro.desafiotodolist.api.domain.repository.TodoRepository;
import br.com.diegoleandro.desafiotodolist.api.domain.service.CadastroTodoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    CadastroTodoService cadastroTodoService;

    @GetMapping
    public List<Todo> listar(){
        return todoRepository.findAll();
    }

    @GetMapping("/{todoId}")
    public Todo buscar(@PathVariable Long todoId) {
     return cadastroTodoService.buscarOuFalhar(todoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo adicionar(@RequestBody Todo todo) {
        return cadastroTodoService.salvar(todo);
    }

    @PutMapping("/{todoId}")
    public Todo atualizar(@RequestBody Todo todo, @PathVariable Long todoId) {
        Todo todoAtual = cadastroTodoService.buscarOuFalhar(todoId);

        BeanUtils.copyProperties(todo, todoAtual, "id");

        return cadastroTodoService.salvar(todoAtual);
    }

    @DeleteMapping("/{todoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long todoId){
        cadastroTodoService.excluir(todoId);
    }


}
