package org.motins.service;

public class ReparoService {
    private static ReparoService instance;
    private ReparoService() {}
    public static ReparoService getInstance() {
        if (instance == null) {
            instance = new ReparoService();
        }
        return instance;
    }


}
