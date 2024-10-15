package org.motins.service.interfaces;

import org.motins.entity.Reparo;
import org.motins.exception.service.ReparoServiceException;

import java.util.List;

public interface IReparoService {
    //TODO: CREATE
    void create(Reparo reparo) throws ReparoServiceException;
    //TODO: READ
    List<Reparo> listAll() throws ReparoServiceException;
    //TODO: UPDATE
    void update(Reparo reparo) throws ReparoServiceException;
    //TODO: DELETE
    void delete(int id) throws ReparoServiceException;

}
