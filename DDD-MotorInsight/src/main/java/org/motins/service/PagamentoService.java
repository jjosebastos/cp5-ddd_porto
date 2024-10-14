package org.motins.service;

public class PagamentoService {
    private static PagamentoService instance;

    private PagamentoService() {}

    public static PagamentoService getInstance() {
        if (instance == null) {
            instance = new PagamentoService();
        }
        return instance;
    }



}
