package com.example.practice.services;

import com.example.practice.entities.Book;
import com.example.practice.entities.User;
import com.example.practice.repository.BookRepository;
import com.example.practice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;
    private UserRepository userRepository;

    public ResponseEntity<?> receivedBook(String bookSerialNo) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> optionalUser = userRepository.findByUsername(userDetails.getUsername());
        if (optionalUser.isPresent()) {
            Optional<Book> optionalBook = bookRepository.findBySerialNo(bookSerialNo);
            System.out.println(optionalBook);
            if (optionalBook.isPresent()) {
                Book existingBook = optionalBook.get();
                if (existingBook.getUser() == null) {
                    existingBook.setIssueDate(System.currentTimeMillis());
                    existingBook.setUser(optionalUser.get());
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(existingBook.getIssueDate());
                    calendar.add(Calendar.DAY_OF_WEEK, 7);
                    long submittedDate = calendar.getTimeInMillis();
                    existingBook.setSubmittedDate(submittedDate);
                    bookRepository.save(existingBook);
                    return ResponseEntity.ok().body("user is taking book:" + bookSerialNo);
                } else {
                    return ResponseEntity.ok().body("user already taken that serial number book");
                }
            } else {
                return ResponseEntity.status(404).body("book serial no is not found");
            }

        }
        return ResponseEntity.status(404).body("user is not found");
    }

}
