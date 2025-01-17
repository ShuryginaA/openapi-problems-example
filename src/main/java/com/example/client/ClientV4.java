package com.example.client;

import com.example.clientfour.controller.BooksClientV4Api;
import com.example.clientfour.dto.BookInfoV4;
import io.micronaut.http.annotation.Controller;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller("external/api/v4")
public class ClientV4 implements BooksClientV4Api {

    public Mono<List<BookInfoV4>> getAllV4() {
        return Mono.just(List.of(new BookInfoV4("Brave new world", "Haxley")));
    }
}