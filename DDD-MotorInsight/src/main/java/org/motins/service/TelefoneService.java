package org.motins.service;

import org.motins.config.DatabaseConfig;
import org.motins.dao.TecnicoDao;
import org.motins.dao.TecnicoDaoImpl;
import org.motins.dao.TelefoneDao;
import org.motins.dao.TelefoneDaoImpl;
import org.motins.entity.Telefone;
import org.motins.exception.service.TelefoneServiceException;
import org.motins.service.interfaces.ITelefoneService;

import java.util.List;

public class TelefoneService implements ITelefoneService {
    private static TelefoneService instance;

    DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
            "rm559221","jn100800");

    TelefoneDao telefoneDao = TelefoneDaoImpl.getInstance(db);

    private TelefoneService() {}
    public static TelefoneService getInstance() {
        if (instance == null) {
            instance = new TelefoneService();
        }
        return instance;
    }


    @Override
    public void create(Telefone telefone) throws TelefoneServiceException {
        try {
            telefoneDao.create(telefone);
        } catch (Exception e) {
            throw new TelefoneServiceException("Não foi possível criar em T_CON_TELEFONE", e);
        }
    }

    @Override
    public List<Telefone> findAll() throws TelefoneServiceException {
        try {
            return telefoneDao.readAll();
        } catch (Exception e) {
            throw new TelefoneServiceException("Não foi possível listar em T_CON_TELEFONE", e);
        }
    }

    @Override
    public void update(Telefone telefone) throws TelefoneServiceException {
        try {
            telefoneDao.update(telefone);
        } catch (Exception e) {
            throw new TelefoneServiceException("Não foi possível atualizar em T_CON_TELEFONE", e);
        }
    }

    @Override
    public void delete(int id) throws TelefoneServiceException {
        try {
             telefoneDao.delete(id);
        } catch (Exception e) {
            throw new TelefoneServiceException("Não foi possível excluir em T_CON_TELEFONE", e);
        }
    }
}
