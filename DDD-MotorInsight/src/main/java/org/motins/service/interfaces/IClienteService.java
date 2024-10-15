package org.motins.service.interfaces;

import org.motins.entity.Cliente;

import java.util.List;

public interface IClienteService {
    //TODO: CREATE
    void create(Cliente cliente);
    //TODO: READ
    List<Cliente> listAll();
    //TODO: UPDATE
    void update(Cliente cliente);
    //TODO: DELETE
    void delete(int id);
    //TODO: FIND BY ID
    Cliente findById(int id);
}
