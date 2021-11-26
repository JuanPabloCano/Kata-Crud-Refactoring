package com.sofka.KataCrud.crud.TodoRepository;

import com.sofka.KataCrud.crud.TodoModel.TodoModel;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoModel, Long> {
}
