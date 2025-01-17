package com.example.client;

import com.example.clientone.controller.BooksClientV1Api;
import com.example.clientone.dto.BookInfoV1;
import com.example.clienttwo.controller.BooksClientV2Api;
import com.example.clienttwo.dto.BookInfoV2;
import io.micronaut.http.annotation.Controller;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller("external/api/v2")
public class ClientV2 implements BooksClientV2Api {

    public Mono<List<BookInfoV2>> getAllV2() {
        return Mono.just(List.of(new BookInfoV2("Brave new world", "Haxley")));
    }
}