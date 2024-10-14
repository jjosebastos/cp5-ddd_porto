package org.motins.dao;


import entity.Seguradora;
import org.motins.exception.SeguradoraDaoException;

import java.sql.SQLException;
import java.util.List;

public interface SeguradoraDao {

    //TODO: CREATE
    void create(Seguradora seguradora) throws SeguradoraDaoException;

    //TODO: READ
    List<Seguradora> readAll() throws SQLException, SeguradoraDaoException;

    //TODO: UPDATE
    void update(Seguradora Seguradora) throws SeguradoraDaoException;

    //TODO: DELETE
    void delete(int id) throws SeguradoraDaoException;
}
