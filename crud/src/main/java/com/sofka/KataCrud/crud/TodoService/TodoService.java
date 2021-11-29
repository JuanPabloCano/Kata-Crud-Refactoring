package com.sofka.KataCrud.crud.TodoService;

import com.sofka.KataCrud.crud.TodoModel.TodoModel;
import com.sofka.KataCrud.crud.TodoRepository.TodoInterfaceServices;
import com.sofka.KataCrud.crud.TodoRepository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TodoService implements TodoInterfaceServices {

    @Autowired
    private TodoRepository repository;

    @Override
    public List<TodoModel> list() {
        return (List<TodoModel>) repository.findAll();
    }

    @Override
    public TodoModel save(TodoModel todoModel) {
        return repository.save(todoModel);
    }

    @Override
    public void delete(Long id) {
        repository.delete(get(id));
    }

    @Override
    public TodoModel get(long id) {
        return repository.findById(id).orElseThrow();
    }
}
