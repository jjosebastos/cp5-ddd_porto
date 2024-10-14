package org.motins.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.motins.config.DatabaseConfig;
import org.motins.entity.Autorizada;
import org.motins.entity.Cliente;
import org.motins.exception.AutorizadaDaoException;

import static org.junit.jupiter.api.Assertions.*;

class AutorizadaDaoImplTest {

    DatabaseConfig db;
    AutorizadaDaoImpl autorizadaDao;
    Autorizada autorizada;
    @BeforeEach
    public void setUp(){
        autorizada = new Autorizada(1, "CARFIX", "01.100.094/0001-94");
        autorizadaDao = AutorizadaDaoImpl.getInstance(db);
    }

    @Test
    void insert_autorizado_dao() throws AutorizadaDaoException {
        autorizadaDao.create(autorizada);
    }

}