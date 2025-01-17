package com.example.client;

import com.example.clientone.controller.BooksClientV1Api;
import com.example.clientone.dto.BookInfoV1;
import io.micronaut.http.annotation.Controller;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller("external/api/v1")
public class ClientV1 implements BooksClientV1Api {

    public Mono<List<BookInfoV1>> getAllV1() {
        return Mono.just(List.of(new BookInfoV1("Brave new world", "Oldos Haksli")));
    }
}