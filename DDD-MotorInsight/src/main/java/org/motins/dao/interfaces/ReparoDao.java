package org.motins.dao.interfaces;

import org.motins.entity.reparo.Reparo;
import org.motins.exception.dao.ReparoDaoException;

import java.util.List;

public interface ReparoDao {
    //TODO: CREATE
    void create(Reparo reparo) throws ReparoDaoException;
    //TODO: READ
    List<Reparo> readAll() throws ReparoDaoException;
    //TODO: UPDATE
    void update(Reparo reparo) throws ReparoDaoException;
    //TODO: DELETE
    void delete(int idReparo) throws ReparoDaoException;
}
