package org.motins.service.interfaces;

import org.motins.entity.PessoaJuridica;

import java.util.List;

public interface IPessoaJuridicaService {
    //TODO: CREATE
    void create(PessoaJuridica pessoaJuridica) throws PessoaJuridicaServiceException;
    //TODO: READ
    List<PessoaJuridica> listAll() throws PessoaJuridicaServiceException;
    //TODO: UPDATE
    void update(PessoaJuridica pessoaJuridica) throws PessoaJuridicaServiceException;
    //TODO: DELETE
    void delete(int id) throws PessoaJuridicaServiceException;

}
