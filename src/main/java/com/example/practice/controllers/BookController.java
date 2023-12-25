package com.example.practice.controllers;

import com.example.practice.entities.Book;
import com.example.practice.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class BookController {
    private final BookService bookService;

    @PostMapping("/bookTakenByUser")
    public ResponseEntity<?> bookTakenByUser(@RequestBody Map<String, String> request){
        String bookSerialNo = request.get("bookSerialNo");
        return bookService.receivedBook(bookSerialNo);
    }
}
