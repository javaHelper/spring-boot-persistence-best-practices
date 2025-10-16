package com.bookstore.service;

import com.bookstore.entity.Author;
import com.bookstore.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public void persistAuthor() {
        Author author = new Author();
        author.setName("Joana Nimar");
        author.setGenre("History");
        author.setAge(34);

        authorRepository.save(author);
    }

    public void displayAuthor() {
        Author author = authorRepository.findById(1L).orElseThrow();
        System.out.println(author);
    }
}
