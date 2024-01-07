package com.demo.booksservice.web.controller.impl;

import com.demo.booksservice.db.service.BookService;
import com.demo.booksservice.util.CustomResponseBody;
import com.demo.booksservice.web.controller.BookController;
import com.demo.booksservice.web.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class BookControllerImpl implements BookController {

    final BookService bookService;

    @Override
    public CustomResponseBody<List<BookDto>> getAll() {
        return this.bookService.getAll();
    }

    @Override
    public CustomResponseBody<BookDto> getBookByTitle(String title) {
        return this.bookService.getBookByTitle(title);
    }

    @Override
    public CustomResponseBody<BookDto> addBook(BookDto book) {
        return this.bookService.addBook(book);
    }

}