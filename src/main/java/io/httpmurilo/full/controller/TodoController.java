package io.httpmurilo.full.controller;

import io.httpmurilo.full.domain.Todo;
import io.httpmurilo.full.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> getById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(todoService.obterTodoPorId(id));

    }

    @GetMapping(value = "/open")
    public ResponseEntity<List<Todo>> listOpen() {
        List<Todo> list = todoService.findAllByStatus(false);
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/close")
    public ResponseEntity<List<Todo>> listClose() {
        List<Todo> list = todoService.findAllByStatus(true);
        return ResponseEntity.ok().body(list);

    }

    @GetMapping()
    public ResponseEntity<List<Todo>> listAll() {
        List<Todo> list = todoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        todo = todoService.create(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todo.getId()).toUri();
        return ResponseEntity.created(uri).body(todo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo todo) {
        Todo newTodo = todoService.update(id, todo);
        return ResponseEntity.ok(newTodo);
    }
}
