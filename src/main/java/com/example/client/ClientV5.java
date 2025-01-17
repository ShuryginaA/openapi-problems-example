package com.example.client;

import com.example.clientfive.controller.BooksClientV5Api;
import com.example.clientfive.dto.BookInfoV5;
import io.micronaut.http.annotation.Controller;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller("external/api/v5")
public class ClientV5 implements BooksClientV5Api {

    public Mono<List<BookInfoV5>> getAllV5() {
        return Mono.just(List.of(new BookInfoV5("Brave new world", "Oldos Haksli")));
    }
}