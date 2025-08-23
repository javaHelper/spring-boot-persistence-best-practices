package com.bookstore.service;

import com.bookstore.entity.Author;
import com.bookstore.entity.Book;
import com.bookstore.repository.AuthorRepository;
import com.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    
    @Transactional(readOnly = true)
    public void fetchBooksAndAuthors() {
        List<Book> books = bookRepository.findAll();

        for (Book book : books) {
            Author author = book.getAuthor();
            System.out.println("Book: " + book.getTitle() + " Author: " + author.getName());
        }
    }
    
    @Transactional(readOnly = true)
    public void fetchAuthorsAndBooks() {
        List<Author> authors = authorRepository.findAll();

        for (Author author: authors) {
            List<Book> books = author.getBooks();
            System.out.println("Author: " + author.getName() + " Books: " + books);
        }
    }
}
