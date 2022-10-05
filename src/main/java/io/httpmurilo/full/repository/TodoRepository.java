package io.httpmurilo.full.repository;

import io.httpmurilo.full.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Query("SELECT T FROM Todo WHERE T.finalizado = :status ORDER BY T.DataParaFinalizar")
    List<Todo> findAllByStatus(Boolean status);
}
