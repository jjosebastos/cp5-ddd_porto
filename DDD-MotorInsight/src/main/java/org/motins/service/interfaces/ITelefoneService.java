package org.motins.service.interfaces;

import org.motins.entity.telefone.Telefone;
import org.motins.exception.service.TelefoneServiceException;

import java.util.List;

public interface ITelefoneService {
    void create(Telefone telefone) throws TelefoneServiceException;
    List<Telefone> findAll() throws TelefoneServiceException;
    void update(Telefone telefone) throws TelefoneServiceException;
    void delete(int id) throws TelefoneServiceException;

}
