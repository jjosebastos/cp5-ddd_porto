package org.motins.service.interfaces;

import org.motins.entity.Endereco;

import java.util.List;

public interface IEnderecoService {

    //TODO: CREATE
    void create(Endereco endereco);
    //TODO: READ
    List<Endereco> listAll();
    //TODO: UPDATE
    void update(Endereco endereco);
    //TODO: DELETE
    void delete(int id);
    //TODO: FIND BY ID
    Endereco findById(int id);
}


