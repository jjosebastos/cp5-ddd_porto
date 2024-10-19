package org.motins.service.interfaces;

import org.motins.entity.cliente.Cliente;
import org.motins.exception.service.ClienteServiceException;

import java.util.List;

public interface IClienteService {
    void create(Cliente cliente) throws ClienteServiceException;
    List<Cliente> listAll() throws ClienteServiceException ;
    void update(Cliente cliente) throws ClienteServiceException;
    void delete(int id) throws ClienteServiceException;

}
