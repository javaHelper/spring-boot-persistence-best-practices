package com.bookstore.dao;

import com.bookstore.dto.AuthorDtoNoSetters;
import com.bookstore.dto.AuthorDtoWithSetters;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class Dao implements AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<AuthorDtoNoSetters> fetchAuthorsNoSetters() {
        Query query = entityManager
                .createQuery("SELECT a.name as name, a.age as age FROM Author a")
                .unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(
                        new AliasToBeanConstructorResultTransformer(
                                AuthorDtoNoSetters.class.getConstructors()[0]
                        )
                );

        List<AuthorDtoNoSetters> authors = query.getResultList();

        return authors;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AuthorDtoWithSetters> fetchAuthorsWithSetters() {
        Query query = entityManager
                .createQuery("SELECT a.name as name, a.age as age FROM Author a")
                .unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(
                        Transformers.aliasToBean(AuthorDtoWithSetters.class)
                );

        List<AuthorDtoWithSetters> authors = query.getResultList();

        return authors;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
