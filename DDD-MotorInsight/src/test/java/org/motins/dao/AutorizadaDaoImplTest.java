package org.motins.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.motins.config.DatabaseConfig;
import org.motins.dao.impl.AutorizadaDaoImpl;
import org.motins.entity.autorizada.Autorizada;
import org.motins.exception.dao.AutorizadaDaoException;

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