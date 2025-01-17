package com.example.client;

import com.example.clientone.controller.BooksClientV1Api;
import com.example.clientone.dto.BookInfoV1;
import com.example.clienttwo.controller.BooksClientV2Api;
import com.example.clienttwo.dto.BookInfoV2;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.client.annotation.Client;
import reactor.core.publisher.Mono;

import java.util.List;

@Client(id = "client-v2")
public interface ClientV2 extends BooksClientV2Api {}