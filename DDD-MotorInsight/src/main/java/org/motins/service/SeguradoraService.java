package org.motins.service;

import org.motins.config.DatabaseConfig;
import org.motins.dao.SeguradoraDao;
import org.motins.dao.SeguradoraDaoImpl;
import org.motins.entity.Seguradora;
import org.motins.exception.service.SeguradoraServiceException;
import org.motins.service.interfaces.ISeguradoraService;

import java.util.List;

public class SeguradoraService implements ISeguradoraService {

    private static SeguradoraService instance;
    DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
            "rm559221","jn100800");
    SeguradoraDao seguradoraDao = SeguradoraDaoImpl.getInstance(db);
    private SeguradoraService() {

    }
    public static SeguradoraService getInstance() {
        if (instance == null) {
            instance = new SeguradoraService();
        }
        return instance;
    }


    @Override
    public void create(Seguradora seguradora) throws SeguradoraServiceException {
        try {
            seguradoraDao.create(seguradora);
        } catch (Exception e) {
            throw new SeguradoraServiceException("Não foi posssível inserir em T_CON_SEGURADORA",e);
        }
    }

    @Override
    public List<Seguradora> listAll() throws SeguradoraServiceException {
        try {
            return seguradoraDao.readAll();
        } catch (Exception e) {
            throw new SeguradoraServiceException("Não foi posssível listar em T_CON_SEGURADORA",e);
        }
    }

    @Override
    public void update(Seguradora seguradora) throws SeguradoraServiceException {
        try {
             seguradoraDao.update(seguradora);
        } catch (Exception e) {
            throw new SeguradoraServiceException("Não foi posssível atualizar em T_CON_SEGURADORA",e);
        }
    }

    @Override
    public void delete(int id) throws SeguradoraServiceException {
        try {
           seguradoraDao.delete(id);
        } catch (Exception e) {
            throw new SeguradoraServiceException("Não foi posssível listar em T_CON_SEGURADORA",e);
        }
    }

}
