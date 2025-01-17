package com.example.client;

import com.example.clientfour.controller.BooksClientV4Api;
import com.example.clientfour.dto.BookInfoV4;
import com.example.clientone.controller.BooksClientV1Api;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.client.annotation.Client;
import reactor.core.publisher.Mono;

import java.util.List;

@Client(id = "client-v4")
public interface ClientV4 extends BooksClientV4Api {}