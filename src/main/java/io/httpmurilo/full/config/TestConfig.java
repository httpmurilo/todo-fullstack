package io.httpmurilo.full.config;

import io.httpmurilo.full.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private TodoService todoService;

    public void instancia() {
        this.todoService.initDb();
    }
}
