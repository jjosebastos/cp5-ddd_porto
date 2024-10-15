package org.motins.service;

import org.motins.config.DatabaseConfig;
import org.motins.dao.PagamentoDao;
import org.motins.dao.PagamentoDaoImpl;
import org.motins.entity.Pagamento;
import org.motins.exception.service.PagamentoServiceException;
import org.motins.service.interfaces.IPagamentoService;

import java.util.List;

public class PagamentoServiceImpl implements IPagamentoService {
    private static PagamentoServiceImpl instance;

    DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
            "rm559221","jn100800");

    PagamentoDao pagamentoDao = PagamentoDaoImpl.getInstance(db);
    private PagamentoServiceImpl() {}

    public static PagamentoServiceImpl getInstance() {
        if (instance == null) {
            instance = new PagamentoServiceImpl();
        }
        return instance;
    }


    @Override
    public void create(Pagamento pagamento) throws PagamentoServiceException {

    }

    @Override
    public List<Pagamento> listAll() throws PagamentoServiceException {
        return List.of();
    }

    @Override
    public void update(Pagamento pagamento) throws PagamentoServiceException {

    }

    @Override
    public void delete(int id) throws PagamentoServiceException {

    }
}
