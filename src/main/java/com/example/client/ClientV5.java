package com.example.client;

import com.example.clientfive.controller.BooksClientV5Api;
import io.micronaut.http.client.annotation.Client;

@Client(id = "client-v5")
public interface ClientV5 extends BooksClientV5Api {}