package org.motins.service;

import org.motins.config.DatabaseConfig;
import org.motins.dao.AutorizadaDao;
import org.motins.dao.AutorizadaDaoImpl;
import org.motins.entity.Autorizada;
import org.motins.exception.dao.AutorizadaDaoException;
import org.motins.exception.service.AutorizadaServiceException;
import org.motins.service.interfaces.IAutorizadaService;

import java.util.List;

public class AutorizadaServiceImpl implements IAutorizadaService {

    private static AutorizadaServiceImpl instance;

    DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
            "rm559221","jn100800");

    AutorizadaDao autorizadaDao = AutorizadaDaoImpl.getInstance(db);
    private AutorizadaServiceImpl(){}

    public static AutorizadaServiceImpl getInstance(){
        if(instance == null){
            instance = new AutorizadaServiceImpl();
        }
        return instance;
    }


    @Override
    public void create(Autorizada autorizada) throws AutorizadaServiceException {
        try {
            autorizadaDao.create(autorizada);
        } catch (AutorizadaDaoException e){
            throw new AutorizadaServiceException("Erro ao criar em autorizada",e);
        }

    }

    @Override
    public List<Autorizada> listAll() throws AutorizadaServiceException {
        try {
            return autorizadaDao.readAll();
        } catch (Exception e) {
            throw new AutorizadaServiceException("Erro ao listar em autorizada",e);
        }
    }

    @Override
    public void update(Autorizada autorizada) throws AutorizadaServiceException {
        try {
            autorizadaDao.update(autorizada);
        } catch (AutorizadaDaoException e){
            throw new AutorizadaServiceException("Erro ao atualizar em autorizada", e);
        }

    }

    @Override
    public void delete(int id) throws AutorizadaServiceException{
        try {
            autorizadaDao.delete(id);
        } catch (AutorizadaDaoException e){
            throw new AutorizadaServiceException("Erro ao atualizar em autorizada", e);
        }
    }


}
