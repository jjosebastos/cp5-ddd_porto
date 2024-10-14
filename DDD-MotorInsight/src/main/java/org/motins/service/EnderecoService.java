package org.motins.service;

import org.motins.entity.Endereco;
import org.motins.service.interfaces.IEnderecoService;

import java.util.List;

public class EnderecoService implements IEnderecoService {

    private static EnderecoService instance;

    private EnderecoService() {}

    public static EnderecoService getInstance() {
        if (instance == null) {
            instance = new EnderecoService();
        }
        return instance;
    }

    @Override
    public void create(Endereco endereco) {

    }

    @Override
    public List<Endereco> listAll() {
        return List.of();
    }

    @Override
    public void update(Endereco endereco) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Endereco findById(int id) {
        return null;
    }
}
