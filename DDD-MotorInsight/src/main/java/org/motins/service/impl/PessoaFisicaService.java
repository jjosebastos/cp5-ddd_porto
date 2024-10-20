package org.motins.service.impl;

import org.motins.config.DatabaseConfig;
import org.motins.dao.interfaces.PessoaFisicaDao;
import org.motins.dao.impl.PessoaFisicaDaoImpl;

import org.motins.entity.cliente.PessoaFisica;

import org.motins.exception.service.PessoaFisicaServiceException;
import org.motins.service.interfaces.IPessoaFisicaService;

import java.util.List;

public class PessoaFisicaService implements IPessoaFisicaService {

    private static PessoaFisicaService instance;
        DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
            "rm559221","jn100800");
    PessoaFisicaDao pessoaFisicaDao = PessoaFisicaDaoImpl.getInstance(db);

    private PessoaFisicaService() {}

    public static PessoaFisicaService getInstance() throws PessoaFisicaServiceException {
        if (instance == null) {
            instance = new PessoaFisicaService();
        }
        return instance;
    }

    @Override
    public void create(PessoaFisica pessoaFisica) throws PessoaFisicaServiceException{
        try {
            pessoaFisicaDao.create(pessoaFisica);
        } catch (Exception e) {
            throw new PessoaFisicaServiceException("Não foi possível criar em T_CON_PESSOA_FISICA", e);
        }
    }

    @Override
    public List<PessoaFisica> listAll() throws PessoaFisicaServiceException {
        try {
            return pessoaFisicaDao.readAll();
        } catch (Exception e) {
            throw new PessoaFisicaServiceException("Não foi possível listar em T_CON_PESSOA_FISICA", e);
        }
    }

    @Override
    public void update(PessoaFisica pessoaFisica) throws PessoaFisicaServiceException {
        try {
            pessoaFisicaDao.update(pessoaFisica);
        } catch (Exception e) {
            throw new PessoaFisicaServiceException("Não foi possível atualizar em T_CON_PESSOA_FISICA", e);
        }
    }

    @Override
    public void delete(int id) throws PessoaFisicaServiceException{
        try {
            pessoaFisicaDao.delete(id);
        } catch (Exception e) {
            throw new PessoaFisicaServiceException("Não foi possível excluir em T_CON_PESSOA_FISICA", e);
        }
    }


}
