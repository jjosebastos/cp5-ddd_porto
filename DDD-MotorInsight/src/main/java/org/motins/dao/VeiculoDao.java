package org.motins.dao;

import org.motins.entity.Veiculo;
import org.motins.exception.dao.VeiculoDaoException;

import java.util.List;

public interface VeiculoDao {

    //TODO: CREATE
    void create(Veiculo veiculo) throws VeiculoDaoException;

    //TODO: READ
    List<Veiculo> readAll() throws VeiculoDaoException;

    //TODO: UPDATE
    void update(Veiculo veiculo) throws  VeiculoDaoException;

    //TODO: DELETE
    void delete(int id) throws  VeiculoDaoException;

    class ClienteDao {
    }
}
