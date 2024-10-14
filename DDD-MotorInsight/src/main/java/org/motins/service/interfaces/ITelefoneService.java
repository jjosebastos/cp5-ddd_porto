package org.motins.service.interfaces;

import org.motins.entity.Telefone;

import java.util.List;

public interface ITelefoneService {
    //TODO: CREATE
    void create(Telefone telefone);
    //TODO: READ
    List<Telefone> findAll();
    //TODO: UPDATE
    void update(Telefone telefone);
    //TODO: DELETE
    void delete(int id);
    //TODO: FIND BY ID
    Telefone findById(int id);
}
