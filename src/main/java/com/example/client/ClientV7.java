package com.example.client;

import com.example.clientseven.controller.BooksClientV7Api;
import com.example.clientseven.dto.BookInfoV7;
import com.example.clientthree.controller.BooksClientV3Api;
import com.example.clientthree.dto.BookInfoV3;
import io.micronaut.http.annotation.Controller;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller("external/api/v7")
public class ClientV7 implements BooksClientV7Api {

    public Mono<List<BookInfoV7>> getAllV7() {
        return Mono.just(List.of(new BookInfoV7("Brave new world", "Haxley")));
    }
}