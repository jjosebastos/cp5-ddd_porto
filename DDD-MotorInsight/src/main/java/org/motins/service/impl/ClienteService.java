package org.motins.service.impl;

import org.motins.config.DatabaseConfig;
import org.motins.dao.interfaces.ClienteDao;
import org.motins.dao.impl.ClienteDaoImpl;
import org.motins.entity.cliente.Cliente;
import org.motins.entity.cliente.FactoryCliente;
import org.motins.exception.service.ClienteServiceException;
import org.motins.service.interfaces.IClienteService;

import java.util.List;

public class ClienteService implements IClienteService {

    private FactoryCliente factoryCliente;
    private static ClienteService instance;
    DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
            "rm559221","jn100800");
    ClienteDao clienteDao = ClienteDaoImpl.getInstance(db);

    ClienteService(){

    }

    private static ClienteService getInstance(){
        if(instance == null){
            instance = new ClienteService();
        }
        return instance;
    }


    @Override
    public void create(Cliente cliente) throws ClienteServiceException {
        try {

        }catch (Exception e){
            throw new ClienteServiceException("Não foi possivel criar em T_CON_CLIENTE", e);
        }
    }

    @Override
    public List<Cliente> listAll() throws ClienteServiceException {
        try {
            return clienteDao.readAll();
        } catch (Exception e) {
            throw new ClienteServiceException("Não foi possível listar em T_CON_CLIENTE",e);
        }
    }

    @Override
    public void update(Cliente cliente) throws ClienteServiceException {
        try {
            clienteDao.update(cliente);
        } catch (Exception e) {
            throw new ClienteServiceException("Não foi possível atualizar em T_CON_CLIENTE", e);
        }
    }

    @Override
    public void delete(int id) throws ClienteServiceException {
        try {
            clienteDao.delete(id);
        } catch (Exception e) {
            throw new ClienteServiceException("Não foi possível atualizar em T_CON_CLIENTE", e);
        }
    }


}
