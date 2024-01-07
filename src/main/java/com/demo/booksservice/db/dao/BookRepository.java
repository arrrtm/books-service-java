package com.demo.booksservice.db.dao;

import com.demo.booksservice.db.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    Optional<BookEntity> findFirstByTitle(String title);

}