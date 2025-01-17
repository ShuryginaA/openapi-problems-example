package com.example.client;

import com.example.clientone.controller.BooksClientV1Api;
import io.micronaut.http.client.annotation.Client;

@Client(id = "client-v1")
public interface ClientV1 extends BooksClientV1Api {}