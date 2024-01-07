package com.demo.booksservice.util;

import com.demo.booksservice.db.entity.BookEntity;
import com.demo.booksservice.web.dto.BookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookEntity toBookEntity(BookDto bookDto);

    BookDto toBookDto(BookEntity bookEntity);

}