package org.motins.dao.interfaces;

import org.motins.entity.cliente.Cliente;
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