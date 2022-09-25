package io.httpmurilo.full.controller;

import io.httpmurilo.full.domain.Todo;
import io.httpmurilo.full.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        List<Todo> list = todoService.findAllOpen();
        return ResponseEntity.ok().body(list);

    }
}
