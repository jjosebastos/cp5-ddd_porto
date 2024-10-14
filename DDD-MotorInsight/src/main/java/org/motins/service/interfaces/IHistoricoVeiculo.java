package org.motins.service.interfaces;

import org.motins.service.HistoricoVeiculo;

import java.util.List;

public interface IHistoricoVeiculo {
    //TODO: CREATE
    void create(HistoricoVeiculo historicoVeiculo);
    //TODO: READ
    List<HistoricoVeiculo> listAll();
    //TODO: UPDATE
    void update(HistoricoVeiculo historicoVeiculo);
    //TODO: DELETE
    void delete(int id) ;
    //TODO: FIND BY ID
    HistoricoVeiculo findById(int id);
}
