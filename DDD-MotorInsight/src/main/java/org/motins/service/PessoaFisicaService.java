package org.motins.service;

import org.motins.config.DatabaseConfig;
import org.motins.dao.PagamentoDaoImpl;
import org.motins.dao.PessoaFisicaDao;
import org.motins.dao.PessoaFisicaDaoImpl;

import org.motins.entity.PessoaFisica;
import org.motins.service.interfaces.IPessoaFisicaService;

import java.util.List;

public class PessoaFisicaService implements IPessoaFisicaService {

    private static PessoaFisicaService instance;
    DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
            "rm559221","jn100800");
    PessoaFisicaDao pagamentoDao = PessoaFisicaDaoImpl.getInstance(db);

    private PessoaFisicaService() {}

    public static PessoaFisicaService getInstance() {
        if (instance == null) {
            instance = new PessoaFisicaService();
        }
        return instance;
    }


    @Override
    public void create(PessoaFisica pessoaFisica) throws PessoaFisicaServiceException{
        try {
            pagamentoDao.create(pessoaFisica);
        } catch (Exception e) {
            throw new PessoaFisicaServiceException("Não foi possível criar em T_CON_PESSOA_FISICA", e);
        }
    }

    @Override
    public List<PessoaFisica> listAll() throws PessoaFisicaServiceException {
        try {
            return pagamentoDao.readAll();
        } catch (Exception e) {
            throw new PessoaFisicaServiceException("Não foi possível criar em T_CON_PESSOA_FISICA", e);
        }
    }

    @Override
    public void update(PessoaFisica pessoaFisica) throws PessoaFisicaServiceException {
        try {
            pagamentoDao.update(pessoaFisica);
        } catch (Exception e) {
            throw new PessoaFisicaServiceException("Não foi possível criar em T_CON_PESSOA_FISICA", e);
        }
    }

    @Override
    public void delete(int id) throws PessoaFisicaServiceException{
        try {
            pagamentoDao.delete(id);
        } catch (Exception e) {
            throw new PessoaFisicaServiceException("Não foi possível criar em T_CON_PESSOA_FISICA", e);
        }
    }


}
