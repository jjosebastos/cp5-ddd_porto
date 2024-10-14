package org.motins.dao;

import entity.PessoaJuridica;
import org.motins.exception.PessoaJuridicaDaoException;

import java.util.List;

public interface PessoaJuridicaDao {
    void create(PessoaJuridica pessoaJuridica) throws PessoaJuridicaDaoException;
    List<PessoaJuridica> readAll() throws PessoaJuridicaDaoException;
    PessoaJuridica readById(int id) throws PessoaJuridicaDaoException;
    void update(PessoaJuridica pessoaJuridica) throws PessoaJuridicaDaoException;
    void delete(int id) throws PessoaJuridicaDaoException;
}
