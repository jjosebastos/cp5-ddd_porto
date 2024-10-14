package org.motins.service.interfaces;

import org.motins.entity.Tecnico;

import java.util.List;

public interface ITecnicoService {
    //TODO: CREATE
    void create(Tecnico tecnico);
    //TODO: READ
    List<Tecnico> findAll();
    //TODO: UPDATE
    void update(Tecnico tecnico);
    //TODO: DELETE
    void delete(int id);
    //TODO: FIND BY ID
    Tecnico findById(int id);
}
