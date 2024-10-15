package org.motins.service.interfaces;

import org.motins.entity.Tecnico;
import org.motins.exception.service.TecnicoServiceException;
import org.motins.service.TecnicoService;

import java.util.List;

public interface ITecnicoService {
    //TODO: CREATE
    void create(Tecnico tecnico) throws TecnicoServiceException;
    //TODO: READ
    List<Tecnico> findAll() throws TecnicoServiceException;
    //TODO: UPDATE
    void update(Tecnico tecnico) throws TecnicoServiceException;
    //TODO: DELETE
    void delete(int id) throws TecnicoServiceException;

}
