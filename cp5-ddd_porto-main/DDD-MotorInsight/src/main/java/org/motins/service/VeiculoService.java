package org.motins.service;

import org.motins.config.DatabaseConfig;
import org.motins.dao.VeiculoDao;
import org.motins.dao.VeiculoDaoImpl;
import org.motins.entity.factoryVeiculo.Veiculo;
import org.motins.exception.service.VeiculoServiceException;
import org.motins.service.interfaces.IVeiculoService;

import java.util.List;

public class VeiculoService implements IVeiculoService {
    private static VeiculoService instance;
    DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
            "rm559221","jn100800");
    VeiculoDao veiculoDao = VeiculoDaoImpl.getInstance(db);

    private VeiculoService(){}


    public static VeiculoService getInstance(){
        if(instance == null){
            instance = new VeiculoService();
        }
        return instance;
    }


    @Override
    public void create(Veiculo veiculo) throws VeiculoServiceException {
        try {
            veiculoDao.create(veiculo);
        } catch (Exception e) {
            throw new VeiculoServiceException("Não foi possível criar em T_CON_VEICULO", e);
        }
    }

    @Override
    public List<Veiculo> listAll() throws VeiculoServiceException {
        try {
            return veiculoDao.readAll();
        } catch (Exception e) {
            throw new VeiculoServiceException("Não foi possível listar em T_CON_VEICULO", e);
        }
    }

    @Override
    public void update(Veiculo veiculo) throws VeiculoServiceException {
        try {
            veiculoDao.update(veiculo);
        } catch (Exception e) {
            throw new VeiculoServiceException("Não foi possível atualizar em T_CON_VEICULO", e);
        }
    }

    @Override
    public void delete(int id) throws VeiculoServiceException {
        try {
            veiculoDao.delete(id);
        } catch (Exception e) {
            throw new VeiculoServiceException("Não foi possível excluir em T_CON_VEICULO", e);
        }
    }
}
