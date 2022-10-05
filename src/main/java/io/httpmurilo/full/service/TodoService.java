package io.httpmurilo.full.service;

import io.httpmurilo.full.domain.Todo;
import io.httpmurilo.full.exception.CustomNotFoundException;
import io.httpmurilo.full.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    @Bean
    public void initDb() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Todo t1 = new Todo(null, "Estudar", "Estudar spring", LocalDateTime.parse("25/03/2022", formatter), false);
        Todo t2 = new Todo(null, "Lavar o carro", "Lavar o carro", LocalDateTime.parse("26/03/2022", formatter), false);
        Todo t3 = new Todo(null, "Lavar a louca", "Lavar a louça da pia", LocalDateTime.parse("27/03/2022", formatter), false);
        Todo t4 = new Todo(null, "Passear", "Passear com a cachorra", LocalDateTime.parse("28/03/2022", formatter), false);

        repository.saveAll(Arrays.asList(t1, t2, t3, t4));
    }

    public Todo obterTodoPorId(Integer id) {
        Optional<Todo> todo = repository.findById(id);
        return todo.orElseThrow(() -> new CustomNotFoundException("Objeto não encontrado no banco de dados : " + id + Todo.class.getName()));
    }

    public List<Todo> findAllByStatus(Boolean status) {
        List<Todo> list = repository.findAllByStatus(status);
        return list;
    }

    public List<Todo> findAll() {
        return repository.findAll();
    }

    public Todo create(Todo todo) {
        todo.setId(null);
        return repository.save(todo);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Todo update(Integer id, Todo todo) {
            return repository
                    .findById(id)
                    .map(todoExistente -> {
                        todo.setId(todoExistente.getId());
                        repository.save(todo);
                        return todoExistente;
                    }).get();
        }
}
