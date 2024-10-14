package org.motins.dao;

import entity.Endereco;
import org.motins.exception.EnderecoDaoException;
import java.sql.SQLException;
import java.util.List;

public interface EnderecoDao {

    //TODO: CREATE
    void create(Endereco endereco) throws EnderecoDaoException;

    //TODO: READ
    List<Endereco> readAll() throws SQLException, EnderecoDaoException;

    //TODO: UPDATE
    void update(Endereco endereco) throws EnderecoDaoException;

    //TODO: DELETE
    void delete(int id) throws EnderecoDaoException;
}