package com.bookstore.service;

import com.bookstore.projection.AuthorNameAge;
import com.bookstore.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public List<AuthorNameAge> fetchFirst2ByBirthplace() {
        return authorRepository.findFirst2ByGenre("Anthology");
    }
}
