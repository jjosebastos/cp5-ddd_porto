package org.motins.service.interfaces;

import org.motins.entity.Reparo;

import java.util.List;

public interface IReparoService {
    //TODO: CREATE
    void create(Reparo reparo);
    //TODO: READ
    List<Reparo> listAll();
    //TODO: UPDATE
    void update(Reparo reparo);
    //TODO: DELETE
    void delete(int id) ;
    //TODO: FIND BY ID
    Reparo findById(int id);
}
