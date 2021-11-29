package com.sofka.KataCrud.crud.TodoController;

import com.sofka.KataCrud.crud.Dto.TodoDto;
import com.sofka.KataCrud.crud.TodoModel.TodoModel;
import com.sofka.KataCrud.crud.TodoService.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @Autowired
    private ModelMapper modelMapper;

    // Método para mostrar toda la información usando el DTO y programación declarativa con Stream(), Lambda y
    // Collect
    @GetMapping(value = "api/todos")
    public List<TodoDto> getAllTodo(){
        return service.list()
                .stream()
                .map(mapper -> modelMapper.map(mapper, TodoDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "api/todo")
    public ResponseEntity<TodoDto> save(@RequestBody TodoDto todoDto){

        // Mapper Dto a entidad
        TodoModel todoModel = modelMapper.map(todoDto, TodoModel.class);
        TodoModel todo = service.save(todoModel);

        // Mapper de entidad a Dto
        TodoDto dto = modelMapper.map(todo, TodoDto.class);

        return new ResponseEntity<TodoDto>(dto, HttpStatus.CREATED);
    }

    @PutMapping(value = "api/todo")
    public TodoModel update(@RequestBody TodoModel todoModel){
        if(todoModel.getId() != null){
            return service.save(todoModel);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public ResponseEntity<TodoDto> get(@PathVariable("id") Long id){
        TodoModel todoModel = service.get(id);

        // Mapper de entidad a Dto
        TodoDto todoDto = modelMapper.map(todoModel, TodoDto.class);

        return ResponseEntity.ok().body(todoDto);
    }
}
