package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Transactional(readOnly = true)
    Book findByTitle(String title);
}
