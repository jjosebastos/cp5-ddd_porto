package org.motins.service.interfaces;

import org.motins.entity.pessoa.PessoaJuridica;

import java.util.List;

public interface IPessoaJuridicaService {
    //TODO: CREATE
    void create(PessoaJuridica pessoaJuridica);
    //TODO: READ
    List<PessoaJuridica> listAll();
    //TODO: UPDATE
    void update(PessoaJuridica pessoaJuridica);
    //TODO: DELETE
    void delete(int id);
    //TODO: FIND BY ID
    PessoaJuridica findById(int id);
}
