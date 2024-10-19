package org.motins.dao.interfaces;

import org.motins.entity.Telefone;
import org.motins.exception.dao.TelefoneDaoException;

import java.util.List;

public interface TelefoneDao {

    //TODO: CREATE
    void create(Telefone telefone) throws TelefoneDaoException;

    //TODO: READ
    List<Telefone> readAll() throws  TelefoneDaoException;

    //TODO: UPDATE
    void update(Telefone telefone) throws TelefoneDaoException;

    //TODO: DELETE
    void delete(int id) throws TelefoneDaoException;
}