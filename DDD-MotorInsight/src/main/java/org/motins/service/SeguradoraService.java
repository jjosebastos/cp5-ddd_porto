package org.motins.service;

import org.motins.entity.Seguradora;
import org.motins.service.interfaces.ISeguradoraService;

import java.util.List;

public class SeguradoraService implements ISeguradoraService {

    private static SeguradoraService instance;
    private SeguradoraService() {

    }
    public static SeguradoraService getInstance() {
        if (instance == null) {
            instance = new SeguradoraService();
        }
        return instance;
    }


    @Override
    public void create(Seguradora seguradora) {

    }

    @Override
    public List<Seguradora> listAll() {
        return List.of();
    }

    @Override
    public void update(Seguradora seguradora) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Seguradora findById(int id) {
        return null;
    }
}
