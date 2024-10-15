package org.motins.service.interfaces;

import org.motins.entity.PessoaFisica;

import java.util.List;

public interface IPessoaFisicaService {
    //TODO: CREATE
    void create(PessoaFisica pessoaFisica);
    //TODO: READ
    List<PessoaFisica> listAll() ;
    //TODO: UPDATE
    void update(PessoaFisica pessoaFisica);
    //TODO: DELETE
    void delete(int id);
    //TODO: FIND BY ID
    PessoaFisica findById(int id);
}
