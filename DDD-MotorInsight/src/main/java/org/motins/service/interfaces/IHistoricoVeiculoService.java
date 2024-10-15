package org.motins.service.interfaces;

import org.motins.entity.HistoricoVeiculo;
import org.motins.exception.service.HistoricoVeiculoServiceException;

import java.util.List;

public interface IHistoricoVeiculoService {
    //TODO: CREATE
    void create(HistoricoVeiculo historicoVeiculo) throws HistoricoVeiculoServiceException;
    //TODO: READ
    List<HistoricoVeiculo> listAll() throws HistoricoVeiculoServiceException;
    //TODO: UPDATE
    void update(HistoricoVeiculo historicoVeiculo) throws HistoricoVeiculoServiceException;
    //TODO: DELETE
    void delete(int id) throws HistoricoVeiculoServiceException;
}
