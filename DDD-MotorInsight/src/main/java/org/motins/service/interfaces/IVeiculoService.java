package org.motins.service.interfaces;

import org.motins.entity.Veiculo;

import java.util.List;

public interface IVeiculoService {
    //TODO: CREATE
    void create(Veiculo veiculo);
    //TODO: READ
    List<Veiculo> listAll();
    //TODO: UPDATE
    void update(Veiculo veiculo);
    //TODO: DELETE
    void delete(int id) ;
    //TODO: FIND BY ID
    Veiculo findById(int id);
}
