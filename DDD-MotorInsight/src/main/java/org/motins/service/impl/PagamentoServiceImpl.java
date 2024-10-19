package org.motins.service.impl;

import org.motins.config.DatabaseConfig;
import org.motins.dao.interfaces.PagamentoDao;
import org.motins.dao.impl.PagamentoDaoImpl;
import org.motins.entity.Pagamento;
import org.motins.exception.service.PagamentoServiceException;
import org.motins.service.interfaces.IPagamentoService;

import java.util.List;

public class PagamentoServiceImpl implements IPagamentoService {
    private static PagamentoServiceImpl instance;

    DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
            "rm559221","jn100800");

    public PagamentoDao pagamentoDao = PagamentoDaoImpl.getInstance(db);
    private PagamentoServiceImpl() {}

    public static PagamentoServiceImpl getInstance() {
        if (instance == null) {
            instance = new PagamentoServiceImpl();
        }
        return instance;
    }


    @Override
    public void create(Pagamento pagamento) throws PagamentoServiceException {
        try {
            pagamentoDao.create(pagamento);
        } catch (Exception e) {
            throw new PagamentoServiceException("Não foi possivel criar em T_CON_PAGAMENTO",e);
        }
    }

    @Override
    public List<Pagamento> listAll() throws PagamentoServiceException {
        try {
            return pagamentoDao.readAll();
        } catch (Exception e) {
            throw new PagamentoServiceException("Não foi possível listar os pagamentos", e);
        }
    }

    @Override
    public void update(Pagamento pagamento) throws PagamentoServiceException {
        try {
            pagamentoDao.update(pagamento);
        } catch (Exception e) {
            throw new PagamentoServiceException("Não foi possível atualizar em T_CON_PAGAMENTO", e);
        }
    }

    @Override
    public void delete(int id) throws PagamentoServiceException {
        try{
            pagamentoDao.delete(id);
        } catch (Exception e){
            throw new PagamentoServiceException("Não foi possível atualizar em T_CON_PAGAMENTO", e);
        }
    }
}
