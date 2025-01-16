package com.example.controller;

import com.example.dto.BookAvailability;
import com.example.dto.BookInfo;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller("/api/v1")
public class OpenapiProblemsExampleController implements BooksApi{

    @Override
    public Mono<@NotNull List<@Valid BookInfo>> getAll() {
        return Mono.just(List.of(new BookInfo("Brave new world", BookAvailability.AVAILABLE)));
    }
}