package persistence.dao;

import persistence.DaoException;
import persistence.dto.ProductCodeDto;

import java.util.List;

/**
 * Created by ljunior on 4/14/16.
 */
public interface IDao<T> {
    List<T> getAll() throws DaoException;
    T getById(String id) throws DaoException;
    int insert(T obj) throws DaoException;
}
