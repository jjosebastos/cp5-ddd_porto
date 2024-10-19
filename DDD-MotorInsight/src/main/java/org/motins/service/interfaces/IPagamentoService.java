package org.motins.service.interfaces;

import org.motins.entity.pagamento.Pagamento;
import org.motins.exception.service.PagamentoServiceException;

import java.util.List;

public interface IPagamentoService {
    void create(Pagamento pagamento) throws PagamentoServiceException;
    List<Pagamento> listAll() throws PagamentoServiceException ;
    void update(Pagamento pagamento) throws  PagamentoServiceException;
    void delete(int id) throws PagamentoServiceException;

}
