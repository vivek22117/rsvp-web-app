package com.doubledigit.solutions.rsvp.app.repository;

import com.doubledigit.solutions.rsvp.app.model.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

interface LoginRepository extends CrudRepository<Login, Long> {

    @Async
    public Future<Login> findByUsername(String username);

    @Async
    public CompletableFuture<Login> findOneByUsername(String username);

}
