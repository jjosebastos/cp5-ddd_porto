package org.motins.service;

import org.motins.entity.Tecnico;
import org.motins.entity.Telefone;
import org.motins.service.interfaces.ITelefoneService;

import java.util.List;

public class TelefoneService implements ITelefoneService {
    private static TelefoneService instance;
    private TelefoneService() {}
    public static TelefoneService getInstance() {
        if (instance == null) {
            instance = new TelefoneService();
        }
        return instance;
    }


    @Override
    public void create(Telefone telefone) {

    }

    @Override
    public List<Tecnico> findAll() {
        return List.of();
    }

    @Override
    public void update(Telefone telefone) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Telefone findById(int id) {
        return null;
    }
}
