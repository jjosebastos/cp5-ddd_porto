package org.motins.dao;

import org.motins.entity.factoryCliente.Cliente;
import org.motins.exception.dao.ClienteDaoException;
import java.util.List;

public interface ClienteDao {
    //TODO: CREATE
    void create(Cliente cliente) throws ClienteDaoException;
    //TODO: READ
    List<Cliente> readAll() throws ClienteDaoException;
    //TODO: UPDATE
    void update(Cliente cliente) throws ClienteDaoException;
    //TODO: DELETE
    void delete(int id) throws ClienteDaoException;
}