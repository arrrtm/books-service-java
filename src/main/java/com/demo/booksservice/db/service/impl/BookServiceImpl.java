package com.demo.booksservice.db.service.impl;

import com.demo.booksservice.db.dao.BookRepository;
import com.demo.booksservice.db.entity.BookEntity;
import com.demo.booksservice.db.service.BookService;
import com.demo.booksservice.util.BookMapper;
import com.demo.booksservice.util.CustomResponseBody;
import com.demo.booksservice.util.CustomResponseStatus;
import com.demo.booksservice.web.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    final BookRepository bookRepository;
    final BookMapper mapper;

    @Override
    public CustomResponseBody<List<BookDto>> getAll() {
        List<BookEntity> books = this.bookRepository.findAll();

        if (books.isEmpty()) {
            return new CustomResponseBody<>(
                    CustomResponseStatus.NOT_FOUND, Collections.emptyList());
        }

        return new CustomResponseBody<>(
                CustomResponseStatus.SUCCESS,
                books.stream().map(mapper::toBookDto).toList()
        );
    }

    @Override
    public CustomResponseBody<BookDto> getBookByTitle(String title) {
        return new CustomResponseBody<>(
                CustomResponseStatus.SUCCESS,
                mapper.toBookDto(
                        this.bookRepository.findFirstByTitle(title).orElseThrow()
                )
        );
    }

    @Override
    public CustomResponseBody<BookDto> addBook(BookDto book) {
        return new CustomResponseBody<>(
                CustomResponseStatus.SUCCESS,
                mapper.toBookDto(this.bookRepository.save(mapper.toBookEntity(book)))
        );
    }

}