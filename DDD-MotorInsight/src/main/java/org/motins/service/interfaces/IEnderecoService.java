package org.motins.service.interfaces;

import org.motins.entity.Endereco;
import org.motins.exception.dao.EnderecoDaoException;
import org.motins.exception.service.EnderecoServiceException;
import org.motins.service.EnderecoService;

import java.sql.SQLException;
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


