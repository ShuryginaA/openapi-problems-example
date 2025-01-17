package com.example.controller;

import com.example.dto.BookInfo;
import io.micronaut.http.annotation.Controller;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller("/api/v1")
public class OpenapiProblemsController implements BooksApi{

    @Override
    public Mono<List<BookInfo>> getAll() {
        return Mono.just(List.of(new BookInfo("Brave new world", "Oldos Haksli")));
    }
}