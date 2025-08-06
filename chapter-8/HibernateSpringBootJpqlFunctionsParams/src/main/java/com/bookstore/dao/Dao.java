package com.bookstore.dao;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class Dao<T, ID extends Serializable> implements GenericDao<T, ID> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public String fetchTitleAndPrice(String symbol, Instant instant) {

        String query = "SELECT concat_ws(b.title, :symbol, b.price, :instant) FROM Book b WHERE b.id = 1";
        return (String) entityManager.createQuery(query)
                .setParameter("symbol", symbol)
                .setParameter("instant", instant)
                .getSingleResult();
    }
}
