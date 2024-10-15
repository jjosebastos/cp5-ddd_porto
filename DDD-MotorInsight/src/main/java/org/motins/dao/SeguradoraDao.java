package org.motins.dao;


import org.motins.entity.Seguradora;
import org.motins.exception.dao.SeguradoraDaoException;

import java.util.List;

public interface SeguradoraDao {

    //TODO: CREATE
    void create(Seguradora seguradora) throws SeguradoraDaoException;

    //TODO: READ
    List<Seguradora> readAll() throws SeguradoraDaoException;

    //TODO: UPDATE
    void update(Seguradora Seguradora) throws SeguradoraDaoException;

    //TODO: DELETE
    void delete(int id) throws SeguradoraDaoException;
}
