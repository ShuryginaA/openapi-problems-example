package com.example.client;

import com.example.clientsix.controller.BooksClientV6Api;
import com.example.clientsix.dto.BookInfoV6;
import com.example.clientthree.controller.BooksClientV3Api;
import com.example.clientthree.dto.BookInfoV3;
import io.micronaut.http.annotation.Controller;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller("external/api/v6")
public class ClientV6 implements BooksClientV6Api {

    public Mono<List<BookInfoV6>> getAllV6() {
        return Mono.just(List.of(new BookInfoV6("Brave new world", "Oldos Haksli")));
    }
}