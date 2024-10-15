package org.motins.service;

import org.motins.dao.AutorizadaDaoImpl;
import org.motins.entity.Autorizada;
import org.motins.service.interfaces.IAutorizadaService;

import java.util.List;

public class AutorizadaService implements IAutorizadaService {

    private static AutorizadaService instance;
    private AutorizadaDaoImpl autorizadaDao;
    private Autorizada autorizada;
    private AutorizadaService(){}

    public static AutorizadaService getInstance(){
        if(instance == null){
            instance = new AutorizadaService();
        }
        return instance;
    }


    @Override
    public void create(Autorizada autorizada) {

    }

    @Override
    public List<Autorizada> listAll() {
        return
                List.of();
    }

    @Override
    public void update(Autorizada autorizada) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Autorizada findById(int id) {
        return null;
    }
}
