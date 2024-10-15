package org.motins.service.interfaces;

import org.motins.entity.Cliente;
import org.motins.exception.service.ClienteServiceException;

import java.util.List;

public interface IClienteService {
    //TODO: CREATE
    void create(Cliente cliente) throws ClienteServiceException;
    //TODO: READ
    List<Cliente> listAll() throws ClienteServiceException ;
    //TODO: UPDATE
    void update(Cliente cliente) throws ClienteServiceException;
    //TODO: DELETE
    void delete(int id) throws ClienteServiceException;

}
