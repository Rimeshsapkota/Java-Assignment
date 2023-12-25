package com.example.practice.bootstrap;

import com.example.practice.entities.Book;
import com.example.practice.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        if (bookRepository.count() == 0) {
            List<Book> bookList = Arrays.asList(
                    Book.builder().bookName("SCIENCE").bookSerialNo(UUID.randomUUID().toString()).build(),
                    Book.builder().bookName("SOCIAL").bookSerialNo(UUID.randomUUID().toString()).build(),
                    Book.builder().bookName("MICROPROSSESSOR").bookSerialNo(UUID.randomUUID().toString()).build()
            );
            bookRepository.saveAll(bookList);
        }
    }
}
