package com.example.client;

import com.example.clientone.controller.BooksClientV1Api;
import com.example.clientseven.controller.BooksClientV7Api;
import com.example.clientseven.dto.BookInfoV7;
import com.example.clientthree.controller.BooksClientV3Api;
import com.example.clientthree.dto.BookInfoV3;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.client.annotation.Client;
import reactor.core.publisher.Mono;

import java.util.List;

@Client(id = "client-v7")
public interface ClientV7 extends BooksClientV7Api {}