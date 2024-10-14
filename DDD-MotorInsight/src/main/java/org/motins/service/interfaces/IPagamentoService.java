package org.motins.service.interfaces;

import org.motins.entity.Pagamento;

import java.util.List;

public interface IPagamentoService {
    //TODO: CREATE
    void create(Pagamento pagamento) ;
    //TODO: READ
    List<Pagamento> listAll() ;
    //TODO: UPDATE
    void update(Pagamento pagamento);
    //TODO: DELETE
    void delete(int id);
    //TODO: FIND BY ID
    Pagamento findById(int id);
}
