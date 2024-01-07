package com.demo.booksservice.db.service;

import com.demo.booksservice.util.CustomResponseBody;
import com.demo.booksservice.web.dto.BookDto;

import java.util.List;

public interface BookService {

    CustomResponseBody<List<BookDto>> getAll();

    CustomResponseBody<BookDto> getBookByTitle(String title);

    CustomResponseBody<BookDto> addBook(BookDto book);

}