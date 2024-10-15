package org.motins.dao;

import org.motins.entity.HistoricoVeiculo;
import org.motins.exception.dao.HistoricoVeiculoDaoException;

import java.sql.SQLException;
import java.util.List;

public interface HistoricoVeiculoDao {
    //TODO: CREATE
    void create(HistoricoVeiculo historicoVeiculo) throws HistoricoVeiculoDaoException;

    //TODO: READ
    List<HistoricoVeiculo> readAll() throws SQLException, HistoricoVeiculoDaoException;

    //TODO: UPDATE
    void update(HistoricoVeiculo historicoVeiculo) throws HistoricoVeiculoDaoException;

    //TODO: DELETE
    void delete(int idHistorico) throws HistoricoVeiculoDaoException;
}
