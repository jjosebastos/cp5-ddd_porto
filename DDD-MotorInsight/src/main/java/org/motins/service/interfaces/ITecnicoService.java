package org.motins.service.interfaces;

import org.motins.entity.tecnico.Tecnico;
import org.motins.exception.service.TecnicoServiceException;

import java.util.List;

public interface ITecnicoService {
    void create(Tecnico tecnico) throws TecnicoServiceException;
    List<Tecnico> findAll() throws TecnicoServiceException;
    void update(Tecnico tecnico) throws TecnicoServiceException;
    void delete(int id) throws TecnicoServiceException;

}
