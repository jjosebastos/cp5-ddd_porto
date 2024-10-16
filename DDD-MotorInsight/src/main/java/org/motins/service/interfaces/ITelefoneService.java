package org.motins.service.interfaces;

import org.motins.entity.factoryTelefone.Telefone;
import org.motins.exception.service.TelefoneServiceException;

import java.util.List;

public interface ITelefoneService {
    //TODO: CREATE
    void create(Telefone telefone) throws TelefoneServiceException;
    //TODO: READ
    List<Telefone> findAll() throws TelefoneServiceException;
    //TODO: UPDATE
    void update(Telefone telefone) throws TelefoneServiceException;
    //TODO: DELETE
    void delete(int id) throws TelefoneServiceException;

}
