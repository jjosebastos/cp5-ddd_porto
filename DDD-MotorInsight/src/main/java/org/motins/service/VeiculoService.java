package org.motins.service;

import org.motins.entity.Veiculo;
import org.motins.service.interfaces.IVeiculoService;

import java.util.List;

public class VeiculoService implements IVeiculoService {
    private static VeiculoService instance;
    private VeiculoService(){}

    public static VeiculoService getInstance(){
        if(instance == null){
            instance = new VeiculoService();
        }
        return instance;
    }

    @Override
    public void create(Veiculo veiculo) {

    }

    @Override
    public List<Veiculo> listAll() {
        return List.of();
    }

    @Override
    public void update(Veiculo veiculo) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Veiculo findById(int id) {
        return null;
    }
}
