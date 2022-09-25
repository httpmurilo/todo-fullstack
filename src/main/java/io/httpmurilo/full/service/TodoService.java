package io.httpmurilo.full.service;

import io.httpmurilo.full.domain.Todo;
import io.httpmurilo.full.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

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
        return repository.findById(id).get();
    }

    public List<Todo> findAllOpen() {
        List<Todo> list = repository.findAllOpen();
        return list;
    }
}
