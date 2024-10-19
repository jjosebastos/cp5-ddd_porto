package org.motins.service.impl;

import org.motins.config.DatabaseConfig;
import org.motins.dao.interfaces.ReparoDao;
import org.motins.dao.impl.ReparoDaoImpl;
import org.motins.entity.reparo.Reparo;
import org.motins.exception.service.ReparoServiceException;
import org.motins.service.interfaces.IReparoService;

import java.util.List;

public class ReparoService implements IReparoService {
    private static ReparoService instance;

    DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
            "rm559221","jn100800");
    ReparoDao reparoDao = ReparoDaoImpl.getInstance(db);

    private ReparoService() {}
    public static ReparoService getInstance() {
        if (instance == null) {
            instance = new ReparoService();
        }
        return instance;
    }


    @Override
    public void create(Reparo reparo) throws ReparoServiceException {
        try {
            reparoDao.create(reparo);
        } catch (Exception e) {
            throw new ReparoServiceException("Erro ao criar reparo em T_CON_REPARO", e);
        }
    }

    @Override
    public List<Reparo> listAll() throws ReparoServiceException {
        try {
            return reparoDao.readAll();
        } catch (Exception e) {
            throw new ReparoServiceException("Erro ao listar reparo em T_CON_REPARO", e);
        }
    }

    @Override
    public void update(Reparo reparo) throws ReparoServiceException {
        try {
            reparoDao.update(reparo);
        } catch (Exception e) {
            throw new ReparoServiceException("Erro ao atualizar eparo em T_CON_REPARO", e);
        }
    }

    @Override
    public void delete(int id) throws ReparoServiceException {
        try {
            reparoDao.delete(id);
        } catch (Exception e) {
            throw new ReparoServiceException("Erro ao excluir reparo em T_CON_REPARO", e);
        }
    }
}
