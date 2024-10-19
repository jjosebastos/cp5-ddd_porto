package org.motins.service.interfaces;

import org.motins.entity.veiculo.Veiculo;
import org.motins.exception.service.VeiculoServiceException;

import java.util.List;

public interface IVeiculoService {
    void create(Veiculo veiculo) throws VeiculoServiceException;
    List<Veiculo> listAll() throws VeiculoServiceException;
    void update(Veiculo veiculo) throws VeiculoServiceException;
    void delete(int id) throws VeiculoServiceException;

}
