package org.motins.service.interfaces;

import org.motins.entity.endereco.Endereco;
import org.motins.exception.service.EnderecoServiceException;

import java.util.List;

public interface IEnderecoService {
    void create(Endereco endereco) throws EnderecoServiceException;
    List<Endereco> listAll() throws EnderecoServiceException;
    void update(Endereco endereco) throws EnderecoServiceException;
    void delete(int id) throws EnderecoServiceException;

}


