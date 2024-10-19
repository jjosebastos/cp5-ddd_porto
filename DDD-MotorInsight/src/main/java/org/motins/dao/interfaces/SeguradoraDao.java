package org.motins.dao.interfaces;


import org.motins.entity.seguradora.Seguradora;
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
