package org.motins.service;

import org.motins.entity.pessoa.PessoaFisica;
import org.motins.service.interfaces.IPessoaFisicaService;

import java.util.List;

public class PessoaFisicaService implements IPessoaFisicaService {

    private static PessoaFisicaService instance;

    private PessoaFisicaService() {}

    public static PessoaFisicaService getInstance() {
        if (instance == null) {
            instance = new PessoaFisicaService();
        }
        return instance;
    }


    @Override
    public void create(PessoaFisica pessoaFisica) {

    }

    @Override
    public List<PessoaFisica> listAll() {
        return List.of();
    }

    @Override
    public void update(PessoaFisica pessoaFisica) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public PessoaFisica findById(int id) {
        return null;
    }
}
