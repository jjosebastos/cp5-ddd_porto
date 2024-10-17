package org.motins.service.interfaces;

import org.motins.entity.factoryVeiculo.Veiculo;
import org.motins.exception.service.VeiculoServiceException;

import java.util.List;

public interface IVeiculoService {
    //TODO: CREATE
    void create(Veiculo veiculo) throws VeiculoServiceException;
    //TODO: READ
    List<Veiculo> listAll() throws VeiculoServiceException;
    //TODO: UPDATE
    void update(Veiculo veiculo) throws VeiculoServiceException;
    //TODO: DELETE
    void delete(int id) throws VeiculoServiceException;

}
