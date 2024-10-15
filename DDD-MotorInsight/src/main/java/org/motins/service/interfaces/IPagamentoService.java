package org.motins.service.interfaces;

import org.motins.entity.Pagamento;
import org.motins.exception.service.PagamentoServiceException;

import java.util.List;

public interface IPagamentoService {
    //TODO: CREATE
    void create(Pagamento pagamento) throws PagamentoServiceException;
    //TODO: READ
    List<Pagamento> listAll() throws PagamentoServiceException ;
    //TODO: UPDATE
    void update(Pagamento pagamento) throws  PagamentoServiceException;
    //TODO: DELETE
    void delete(int id) throws PagamentoServiceException;

}
