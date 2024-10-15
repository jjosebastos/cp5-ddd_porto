package org.motins.service;

import org.motins.config.DatabaseConfig;
import org.motins.dao.PessoaFisicaDao;
import org.motins.dao.PessoaFisicaDaoImpl;
import org.motins.dao.PessoaJuridicaDao;
import org.motins.dao.PessoaJuridicaDaoImpl;
import org.motins.entity.PessoaJuridica;
import org.motins.exception.service.PessoaJuridicaServiceException;
import org.motins.service.interfaces.IPessoaJuridicaService;

import java.util.List;

public class PessoaJuridicaService implements IPessoaJuridicaService {

    private static PessoaJuridicaService instance;
    DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
            "rm559221","jn100800");
    PessoaJuridicaDao pessoaJuridicaDao = PessoaJuridicaDaoImpl.getInstance(db);

    private PessoaJuridicaService(){}

    public static PessoaJuridicaService getInstance(){
        if(instance == null){
            instance = new PessoaJuridicaService();
        }
        return instance;
    }


    @Override
    public void create(PessoaJuridica pessoaJuridica) throws PessoaJuridicaServiceException{
        try {
            pessoaJuridicaDao.create(pessoaJuridica);
        } catch (Exception e) {
            throw new PessoaJuridicaServiceException("Não foi possível criar em T_CON_PESSOA_JURIDICA", e);
        }
    }

    @Override
    public List<PessoaJuridica> listAll() throws PessoaJuridicaServiceException{
        try {
            return pessoaJuridicaDao.readAll();
        } catch (Exception e) {
            throw new PessoaJuridicaServiceException("Não foi possível listar em T_CON_PESSOA_JURIDICA", e);
        }
    }

    @Override
    public void update(PessoaJuridica pessoaJuridica) throws PessoaJuridicaServiceException{
        try {
            pessoaJuridicaDao.update(pessoaJuridica);
        } catch (Exception e){
            throw new PessoaJuridicaServiceException("Não foi possível listar em T_CON_PESSOA_JURIDICA", e);
        }
    }

    @Override
    public void delete(int id) throws PessoaJuridicaServiceException{
        try {
            pessoaJuridicaDao.delete(id);
        } catch (Exception e){
            throw new PessoaJuridicaServiceException("Não foi possível listar em T_CON_PESSOA_JURIDICA", e);
        }
    }
}
