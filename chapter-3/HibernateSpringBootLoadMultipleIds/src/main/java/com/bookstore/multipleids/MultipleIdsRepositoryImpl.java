package com.bookstore.multipleids;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public abstract class MultipleIdsRepositoryImpl<T, ID extends Serializable>
        implements MultipleIdsRepository<T, ID> {

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> entityClass;

    public MultipleIdsRepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<T> fetchByMultipleIds(List<ID> ids) {
        Session session = entityManager.unwrap(Session.class);
        MultiIdentifierLoadAccess<T> multiLoadAccess = session.byMultipleIds(entityClass);
        return multiLoadAccess.multiLoad(ids);
    }

    @Override
    public List<T> fetchInBatchesByMultipleIds(List<ID> ids, int batchSize) {
        return getMultiLoadAccess().withBatchSize(batchSize).multiLoad(ids);
    }

    @Override
    public List<T> fetchBySessionCheckMultipleIds(List<ID> ids) {
        return getMultiLoadAccess().enableSessionCheck(true).multiLoad(ids);
    }

    @Override
    public List<T> fetchInBatchesBySessionCheckMultipleIds(List<ID> ids, int batchSize) {
        return getMultiLoadAccess().enableSessionCheck(true)
                .withBatchSize(batchSize).multiLoad(ids);
    }

    private MultiIdentifierLoadAccess<T> getMultiLoadAccess() {
        Session session = entityManager.unwrap(Session.class);
        return session.byMultipleIds(entityClass);
    }

}
