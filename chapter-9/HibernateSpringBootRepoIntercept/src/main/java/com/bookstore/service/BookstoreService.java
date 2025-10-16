package com.bookstore.service;

import com.bookstore.entity.Author;
import com.bookstore.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    @Transactional
    public void updateAuthor() {
        Author author = authorRepository.findById(1L).orElseThrow();
        author.setAge(49);
    }
}
