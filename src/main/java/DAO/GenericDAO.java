package DAO;

import java.util.Collection;

public interface GenericDAO<T, K> {
    
    public Collection<T> findAll();

    public T findOne(T t);

    public T findById(K id);

    public void update(T entity);
    
    public void delete(T entity);

    public void deleteByKey(K id);

    public void create(T entity);
    
}
