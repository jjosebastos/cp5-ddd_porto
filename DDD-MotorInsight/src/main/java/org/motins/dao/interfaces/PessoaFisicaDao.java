package org.motins.dao.interfaces;

import org.motins.entity.cliente.PessoaFisica;
import org.motins.exception.dao.PessoaFisicaDaoException;

import java.util.List;

public interface PessoaFisicaDao {
    //TODO: CREATE
    void create(PessoaFisica pessoaFisica) throws PessoaFisicaDaoException;
    //TODO: READ
    List<PessoaFisica> readAll() throws PessoaFisicaDaoException;
    //TODO: UPDATE
    void update(PessoaFisica pessoaFisica) throws PessoaFisicaDaoException;
    //TODO: DELETE
    void delete(int id) throws PessoaFisicaDaoException;
}
