package org.motins.dao.interfaces;

import org.motins.entity.cliente.PessoaJuridica;
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
