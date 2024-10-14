package org.motins.service;

import org.motins.entity.Tecnico;
import org.motins.service.interfaces.ITecnicoService;

import java.util.List;

public class TecnicoService implements ITecnicoService {

    private static TecnicoService instance;

    private TecnicoService() {}

    public static TecnicoService getInstance() {
        if (instance == null) {
            instance = new TecnicoService();
        }
        return instance;
    }


    @Override
    public void create(Tecnico tecnico) {

    }

    @Override
    public List<Tecnico> findAll() {
        return List.of();
    }

    @Override
    public void update(Tecnico tecnico) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Tecnico findById(int id) {
        return null;
    }
}

