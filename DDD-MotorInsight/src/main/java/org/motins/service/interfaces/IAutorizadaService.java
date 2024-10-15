package org.motins.service.interfaces;

import org.motins.entity.Autorizada;
import org.motins.entity.Cliente;
import org.motins.exception.service.AutorizadaServiceException;

import java.util.List;

public interface IAutorizadaService {
    //TODO: CREATE
    void create(Autorizada autorizada) throws AutorizadaServiceException;
    //TODO: READ
    List<Autorizada> listAll() throws AutorizadaServiceException;
    //TODO: UPDATE
    void update(Autorizada autorizada) throws AutorizadaServiceException;
    //TODO: DELETE
    void delete(int id) throws AutorizadaServiceException;


}
