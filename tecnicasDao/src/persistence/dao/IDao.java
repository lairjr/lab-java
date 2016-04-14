package persistence.dao;

import persistence.DaoException;

import java.util.List;

/**
 * Created by ljunior on 4/14/16.
 */
public interface IDao<T> {
    public List<T> getAll() throws DaoException;
    public T getById(String id) throws DaoException;
    public int insert(T obj) throws DaoException;
}
