package org.motins.service;

import org.motins.entity.pessoa.Cliente;
import org.motins.service.interfaces.IClienteService;

import java.util.List;

public class ClienteService implements IClienteService {

    private static ClienteService instance;
    private ClienteService(){

    }

    private static ClienteService getInstance(){
        if(instance == null){
            instance = new ClienteService();
        }
        return instance;
    }


    @Override
    public void create(Cliente cliente) {

    }

    @Override
    public List<Cliente> listAll() {
        return List.of();
    }

    @Override
    public void update(Cliente cliente) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Cliente findById(int id) {
        return null;
    }
}
