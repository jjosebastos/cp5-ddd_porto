package org.motins.service.interfaces;

import org.motins.entity.Autorizada;

import java.util.List;

public interface IAutorizadaService {
    //TODO: CREATE
    void create(Autorizada autorizada);
    //TODO: READ
    List<Autorizada> listAll();
    //TODO: UPDATE
    void update(Autorizada autorizada) ;
    //TODO: DELETE
    void delete(int id);
    //TODO: FIND BY ID
    Autorizada findById(int id);

}
