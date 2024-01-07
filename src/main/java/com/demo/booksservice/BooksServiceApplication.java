package com.demo.booksservice;

import com.demo.booksservice.db.dao.BookRepository;
import com.demo.booksservice.db.entity.BookEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class BooksServiceApplication implements CommandLineRunner {

    final BookRepository bookRepository;

    public static void main(String[] args) {
        log.info("Book Service is Starting...");
        SpringApplication.run(BooksServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        this.bookRepository.saveAllAndFlush(List.of(
                BookEntity.builder().title("1984").author("George Orwell").build(),
                BookEntity.builder().title("A Confederacy of Dunces").author("John Kennedy Toole").build(),
                BookEntity.builder().title("A Game of Thrones").author("George R. R. Martin").build()
        ));
    }
}