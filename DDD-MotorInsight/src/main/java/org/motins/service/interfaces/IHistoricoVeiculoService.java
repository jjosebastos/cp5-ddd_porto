package org.motins.service.interfaces;

import org.motins.entity.historicoVeiculo.HistoricoVeiculo;
import org.motins.exception.service.HistoricoVeiculoServiceException;

import java.util.List;

public interface IHistoricoVeiculoService {
    void create(HistoricoVeiculo historicoVeiculo) throws HistoricoVeiculoServiceException;
    List<HistoricoVeiculo> listAll() throws HistoricoVeiculoServiceException;
    void update(HistoricoVeiculo historicoVeiculo) throws HistoricoVeiculoServiceException;
    void delete(int id) throws HistoricoVeiculoServiceException;
}
