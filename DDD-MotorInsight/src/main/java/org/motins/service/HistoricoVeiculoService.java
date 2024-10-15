package org.motins.service;

import org.motins.config.DatabaseConfig;
import org.motins.dao.HistoricoVeiculoDao;
import org.motins.dao.HistoricoVeiculoDaoImpl;
import org.motins.entity.HistoricoVeiculo;
import org.motins.exception.service.HistoricoVeiculoServiceException;
import org.motins.service.interfaces.IHistoricoVeiculoService;

import java.util.List;

public class HistoricoVeiculoService implements IHistoricoVeiculoService {

    private static HistoricoVeiculoService instance;
    DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
            "rm559221","jn100800");
    HistoricoVeiculoDao historicoVeiculoDao = HistoricoVeiculoDaoImpl.getInstance(db);
    private HistoricoVeiculoService(){}

    public static HistoricoVeiculoService getInstance(){
        if(instance == null){
            instance = new HistoricoVeiculoService();
        }
        return instance;
    }


    @Override
    public void create(HistoricoVeiculo historicoVeiculo) throws HistoricoVeiculoServiceException {
        try {
            historicoVeiculoDao.create(historicoVeiculo);
        }  catch (Exception e) {
            throw new HistoricoVeiculoServiceException("Não foi possível criar em T_CON_HISTORICO_VEICULO", e);
        }

    }

    @Override
    public List<HistoricoVeiculo> listAll() throws HistoricoVeiculoServiceException {
        try {
            return historicoVeiculoDao.readAll();
        } catch (Exception e) {
            throw new HistoricoVeiculoServiceException("Não foi possível listar em T_CON_HISTORICO_VEICULO", e);
        }

    }

    @Override
    public void update(HistoricoVeiculo historicoVeiculo) throws HistoricoVeiculoServiceException {
        try {
            historicoVeiculoDao.update(historicoVeiculo);
        } catch (Exception e) {
            throw new HistoricoVeiculoServiceException("Não foi possível atualizar em T_CON_HISTORICO_VEICULO", e);
        }
    }

    @Override
    public void delete(int id) throws HistoricoVeiculoServiceException {
        try{
            historicoVeiculoDao.delete(id);
        } catch (Exception e) {
            throw new HistoricoVeiculoServiceException("Não foi possível excluir em T_CON_HISTORICO_VEICULO", e);
        }
    }
}
