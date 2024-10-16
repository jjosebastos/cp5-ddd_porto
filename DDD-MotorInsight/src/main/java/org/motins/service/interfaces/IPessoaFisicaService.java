package org.motins.service.interfaces;

import org.motins.entity.factoryCliente.PessoaFisica;
import org.motins.exception.service.PessoaFisicaServiceException;

import java.util.List;

public interface IPessoaFisicaService {
    //TODO: CREATE
    void create(PessoaFisica pessoaFisica) throws PessoaFisicaServiceException;
    //TODO: READ
    List<PessoaFisica> listAll() throws PessoaFisicaServiceException;
    //TODO: UPDATE
    void update(PessoaFisica pessoaFisica) throws PessoaFisicaServiceException;
    //TODO: DELETE
    void delete(int id) throws PessoaFisicaServiceException;

}
