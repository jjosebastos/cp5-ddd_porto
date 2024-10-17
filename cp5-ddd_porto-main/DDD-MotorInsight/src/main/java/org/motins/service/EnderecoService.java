package org.motins.service;

import org.motins.config.DatabaseConfig;
import org.motins.dao.EnderecoDao;
import org.motins.dao.EnderecoDaoImpl;
import org.motins.entity.factoryEndereco.Endereco;
import org.motins.exception.dao.EnderecoDaoException;
import org.motins.exception.service.EnderecoServiceException;
import org.motins.service.interfaces.IEnderecoService;

import java.sql.SQLException;
import java.util.List;

public class EnderecoService implements IEnderecoService {

    DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
            "rm559221","jn100800");
    private static EnderecoService instance;
    EnderecoDao enderecoDao = EnderecoDaoImpl.getInstance(db);

    private EnderecoService() {}

    public static EnderecoService getInstance() {
        if (instance == null) {
            instance = new EnderecoService();
        }
        return instance;
    }

    @Override
    public void create(Endereco endereco) throws EnderecoServiceException {
        try {
            enderecoDao.create(endereco);
        } catch (Exception e){
            throw new EnderecoServiceException("Não foi possivel criar em T_CON_ENDERECO", e);
        }

    }

    @Override
    public List<Endereco> listAll() throws EnderecoServiceException {
        try {
            return enderecoDao.readAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new EnderecoServiceException("Não foi possivel listar em T_CON_ENDERECO", e);
        }
    }

    @Override
    public void update(Endereco endereco) throws EnderecoServiceException {
        try {
            enderecoDao.update(endereco);
        } catch (Exception e) {
            throw new EnderecoServiceException("Não foi possivel atualizar em T_CON_ENDERECO", e);     }
    }

    @Override
    public void delete(int id) throws EnderecoServiceException {
        try {
            enderecoDao.delete(id);
        } catch (EnderecoDaoException e) {
            throw new EnderecoServiceException("Não foi possivel excluir em T_CON_ENDERECO",e);
        }
    }
}
