package com.demo.booksservice.web.controller;

import com.demo.booksservice.util.CustomResponseBody;
import com.demo.booksservice.web.dto.BookDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookController {

    @GetMapping("books")
    CustomResponseBody<List<BookDto>> getAll();

    @GetMapping("books/{title}")
    CustomResponseBody<BookDto> getBookByTitle(@PathVariable("title") String title);

    @PostMapping("books")
    CustomResponseBody<BookDto> addBook(@RequestBody BookDto book);

}