package org.motins.service.interfaces;

import org.motins.entity.factorySeguradora.Seguradora;
import org.motins.exception.service.SeguradoraServiceException;

import java.util.List;

public interface ISeguradoraService {

    //TODO: CREATE
    void create(Seguradora seguradora) throws SeguradoraServiceException;
    //TODO: READ
    List<Seguradora> listAll() throws SeguradoraServiceException;
    //TODO: UPDATE
    void update(Seguradora seguradora) throws SeguradoraServiceException;
    //TODO: DELETE
    void delete(int id) throws SeguradoraServiceException;
}
