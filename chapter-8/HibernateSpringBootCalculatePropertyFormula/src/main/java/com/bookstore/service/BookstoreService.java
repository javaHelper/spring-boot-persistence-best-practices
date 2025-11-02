package com.bookstore.service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookstoreService {
         
    private final BookRepository bookRepository;

    public void fetchBooks() {
        List<Book> books = bookRepository.findAll();
        
        books.forEach(System.out::println);
    }
}
