package org.motins.service.interfaces;

import org.motins.entity.Seguradora;

import java.util.List;

public interface ISeguradoraService {

    //TODO: CREATE
    void create(Seguradora seguradora);
    //TODO: READ
    List<Seguradora> listAll();
    //TODO: UPDATE
    void update(Seguradora seguradora);
    //TODO: DELETE
    void delete(int id) ;
    //TODO: FIND BY ID
    Seguradora findById(int id);
}
