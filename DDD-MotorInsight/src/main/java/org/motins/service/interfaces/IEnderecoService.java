package org.motins.service.interfaces;

import org.motins.entity.factoryEndereco.Endereco;
import org.motins.exception.service.EnderecoServiceException;

import java.util.List;

public interface IEnderecoService {

    //TODO: CREATE
    void create(Endereco endereco) throws EnderecoServiceException;
    //TODO: READ
    List<Endereco> listAll() throws EnderecoServiceException;
    //TODO: UPDATE
    void update(Endereco endereco) throws EnderecoServiceException;
    //TODO: DELETE
    void delete(int id) throws EnderecoServiceException;

}


