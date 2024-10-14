package org.motins.dao;

import entity.Cliente;
import org.motins.exception.ClienteDaoException;
import java.util.List;

public interface ClienteDao {
    void create(Cliente cliente) throws ClienteDaoException;
    List<Cliente> readAll() throws ClienteDaoException;
    Cliente readById(int id) throws ClienteDaoException;
    void update(Cliente cliente) throws ClienteDaoException;
    void delete(int id) throws ClienteDaoException;
}