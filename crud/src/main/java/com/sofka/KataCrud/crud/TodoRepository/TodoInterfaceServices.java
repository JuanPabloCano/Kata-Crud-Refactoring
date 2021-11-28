package com.sofka.KataCrud.crud.TodoRepository;

import com.sofka.KataCrud.crud.TodoModel.TodoModel;

import java.util.List;

public interface TodoInterfaceServices {
    List<TodoModel> list();
    TodoModel save(TodoModel todoModel);
    void delete(Long id);
    TodoModel get(long id);
}
