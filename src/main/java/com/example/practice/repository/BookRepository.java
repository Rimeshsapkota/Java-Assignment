package com.example.practice.repository;

import com.example.practice.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.bookSerialNo = :bookSerialNo")
    Optional<Book> findBySerialNo(@Param("bookSerialNo") String bookSerialNo);



}
