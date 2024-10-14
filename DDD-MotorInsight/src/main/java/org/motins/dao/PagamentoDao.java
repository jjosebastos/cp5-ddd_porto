package org.motins.dao;


import entity.Pagamento;
import org.motins.exception.PagamentoDaoException;

import java.sql.SQLException;
import java.util.List;

public interface PagamentoDao {
    //TODO: CREATE
    void create(Pagamento pagamento) throws PagamentoDaoException;

    //TODO: READ
    List<Pagamento> readAll() throws SQLException, PagamentoDaoException;

    //TODO: UPDATE
    void update(Pagamento pagamento) throws PagamentoDaoException;

    //TODO: DELETE
    void delete(int id) throws PagamentoDaoException;
}