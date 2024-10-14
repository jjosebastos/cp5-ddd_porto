package org.motins.service;

import org.motins.service.interfaces.IHistoricoVeiculo;

import java.util.List;

public class HistoricoVeiculo implements IHistoricoVeiculo {

    private static HistoricoVeiculo instance;

    private HistoricoVeiculo(){}

    public static HistoricoVeiculo getInstance(){
        if(instance == null){
            instance = new HistoricoVeiculo();
        }
        return instance;
    }


    @Override
    public void create(HistoricoVeiculo historicoVeiculo) {

    }

    @Override
    public List<HistoricoVeiculo> listAll() {
        return List.of();
    }

    @Override
    public void update(HistoricoVeiculo historicoVeiculo) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public HistoricoVeiculo findById(int id) {
        return null;
    }
}
