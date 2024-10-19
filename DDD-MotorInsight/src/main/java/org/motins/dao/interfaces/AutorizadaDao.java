package org.motins.dao.interfaces;

import org.motins.entity.autorizada.Autorizada;
import org.motins.exception.dao.AutorizadaDaoException;

import java.util.List;

public interface AutorizadaDao {

    //TODO: CREATE
    void create(Autorizada autorizada) throws AutorizadaDaoException;

    //TODO: READ
    List<Autorizada> readAll() throws AutorizadaDaoException;

    //TODO: UPDATE
    void update(Autorizada Autorizada) throws AutorizadaDaoException;

    //TODO: DELETE
    void delete(int id) throws AutorizadaDaoException;
}
