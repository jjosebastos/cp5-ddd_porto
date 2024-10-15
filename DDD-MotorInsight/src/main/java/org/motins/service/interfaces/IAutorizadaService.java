package org.motins.service.interfaces;

import org.motins.entity.Autorizada;
import org.motins.exception.AutorizadaDaoException;
import org.motins.exception.service.AutorizadaServiceException;

import java.sql.SQLException;
import java.util.List;

public interface IAutorizadaService {
    //TODO: CREATE
    void create(Autorizada autorizada) throws AutorizadaServiceException;
    //TODO: UPDATE
    void update(Autorizada autorizada) throws AutorizadaServiceException;
    //TODO: DELETE
    void delete(int id) throws AutorizadaServiceException;
    //TODO: FIND BY ID
    Autorizada findById(int id) throws AutorizadaServiceException;

}
