package org.motins.dao;

import entity.PessoaFisica;
import org.motins.exception.PessoaFisicaDaoException;

import java.util.List;

public interface PessoaFisicaDao {
    void create(PessoaFisica pessoaFisica) throws PessoaFisicaDaoException;
    List<PessoaFisica> readAll() throws PessoaFisicaDaoException;
    PessoaFisica readById(int id) throws PessoaFisicaDaoException;
    void update(PessoaFisica pessoaFisica) throws PessoaFisicaDaoException;
    void delete(int id) throws PessoaFisicaDaoException;
}
