package com.bookstore.service;

import org.springframework.stereotype.Service;

import com.bookstore.entity.Author;
import com.bookstore.repository.AuthorRepository;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void persistAuthor() {
        Author author = new Author();
        author.setName("Joana Nimar");
        author.setGenre("History");
        author.setAge(34);
        
        authorRepository.save(author);
    }
    
    public void displayAuthor() {
        
        Author author = authorRepository.findById(1L).orElse(null);
        
        System.out.println(author);
    }
}
