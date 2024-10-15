package org.motins.dao;

import org.motins.entity.PessoaJuridica;
import org.motins.exception.dao.PessoaJuridicaDaoException;

import java.util.List;

public interface PessoaJuridicaDao {
    //TODO: CREATE
    void create(PessoaJuridica pessoaJuridica) throws PessoaJuridicaDaoException;
    //TODO: READ
    List<PessoaJuridica> readAll() throws PessoaJuridicaDaoException;
    //TODO: UPDATE
    void update(PessoaJuridica pessoaJuridica) throws PessoaJuridicaDaoException;
    //TODO: DELETE
    void delete(int id) throws PessoaJuridicaDaoException;
}
