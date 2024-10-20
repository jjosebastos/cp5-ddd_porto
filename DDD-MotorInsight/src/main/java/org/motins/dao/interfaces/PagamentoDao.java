package org.motins.dao.interfaces;


import org.motins.entity.pagamento.Pagamento;
import org.motins.exception.dao.PagamentoDaoException;

import java.util.List;

public interface PagamentoDao {
    //TODO: CREATE
    void create(Pagamento pagamento) throws PagamentoDaoException;

    //TODO: READ
    List<Pagamento> readAll() throws PagamentoDaoException;

    //TODO: UPDATE
    void update(Pagamento pagamento) throws PagamentoDaoException;

    //TODO: DELETE
    void delete(int id) throws PagamentoDaoException;
}