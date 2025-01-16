package com.example;

import io.micronaut.http.annotation.*;

@Controller("/openapi-problems-example")
public class OpenapiProblemsExampleController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}