package org.motins.dao;

import org.motins.entity.factoryAutorizada.Tecnico;
import org.motins.exception.dao.TecnicoDaoException;

import java.sql.SQLException;
import java.util.List;

public interface TecnicoDao {

    //TODO: CREATE
    void create(Tecnico tecnico) throws TecnicoDaoException;

    //TODO: READ
    List<Tecnico> readAll() throws SQLException, TecnicoDaoException;

    //TODO: UPDATE
    void update(Tecnico tecnico) throws TecnicoDaoException;

    //TODO: DELETE
    void delete(int id) throws TecnicoDaoException;
}