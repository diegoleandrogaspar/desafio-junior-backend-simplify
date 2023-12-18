package br.com.diegoleandro.desafiotodolist.api.domain.repository;

import br.com.diegoleandro.desafiotodolist.api.domain.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository  extends JpaRepository<Todo, Long> {
}
