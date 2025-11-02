package com.bookstore.service;

import com.bookstore.repository.AuthorRepository;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public List<Tuple> fetchAuthors() {
        return authorRepository.fetchAuthors();
    }
}
