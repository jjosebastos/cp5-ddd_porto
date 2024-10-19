package org.motins.service.impl;

import org.motins.config.DatabaseConfig;
import org.motins.dao.impl.TecnicoDaoImpl;
import org.motins.dao.interfaces.TecnicoDao;
import org.motins.entity.tecnico.Tecnico;
import org.motins.exception.service.TecnicoServiceException;
import org.motins.service.interfaces.ITecnicoService;

import java.util.List;

public class TecnicoService implements ITecnicoService {

    private static TecnicoService instance;
    DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
            "rm559221","jn100800");

    TecnicoDao tecnicoDao = TecnicoDaoImpl.getInstance(db);
    private TecnicoService() {}

    public static TecnicoService getInstance() {
        if (instance == null) {
            instance = new TecnicoService();
        }
        return instance;
    }


    @Override
    public void create(Tecnico tecnico) throws TecnicoServiceException {
        try {
            tecnicoDao.create(tecnico);
        } catch (Exception e){
            throw new TecnicoServiceException("Não foi possível criar em T_CON_TECNICO",e);
        }
    }

    @Override
    public List<Tecnico> findAll() throws TecnicoServiceException {
        try {
            return tecnicoDao.readAll();
        } catch (Exception e){
            throw new TecnicoServiceException("Não foi possível criar em T_CON_TECNICO",e);
        }
    }

    @Override
    public void update(Tecnico tecnico) throws TecnicoServiceException {
        try {
            tecnicoDao.update(tecnico);
        } catch (Exception e){
            throw new TecnicoServiceException("Não foi possível atualizar em T_CON_TECNICO",e);
        }
    }

    @Override
    public void delete(int id) throws TecnicoServiceException {
        try {
            tecnicoDao.delete(id);
        } catch (Exception e){
            throw new TecnicoServiceException("Não foi possível excluir em T_CON_TECNICO",e);
        }
    }
}

