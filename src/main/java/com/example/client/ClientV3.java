package com.example.client;

import com.example.clientthree.controller.BooksClientV3Api;
import com.example.clientthree.dto.BookInfoV3;
import io.micronaut.http.annotation.Controller;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller("external/api/v3")
public class ClientV3 implements BooksClientV3Api {

    public Mono<List<BookInfoV3>> getAllV3() {
        return Mono.just(List.of(new BookInfoV3("Brave new world", "Oldos Haksli")));
    }
}