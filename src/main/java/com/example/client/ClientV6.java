package com.example.client;

import com.example.clientfive.controller.BooksClientV5Api;
import com.example.clientone.controller.BooksClientV1Api;
import com.example.clientsix.controller.BooksClientV6Api;
import com.example.clientsix.dto.BookInfoV6;
import com.example.clientthree.controller.BooksClientV3Api;
import com.example.clientthree.dto.BookInfoV3;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.client.annotation.Client;
import reactor.core.publisher.Mono;

import java.util.List;

@Client(id = "client-v6")
public interface ClientV6 extends BooksClientV6Api {}