package org.motins.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.motins.config.DatabaseConfig;
import org.motins.dao.AutorizadaDao;
import org.motins.entity.Autorizada;

import static org.junit.jupiter.api.Assertions.*;

class AutorizadaServiceImplTest {

    @BeforeEach
    void setUp() {
        DatabaseConfig db = new DatabaseConfig("", "rm559221", "10iasojdioadsmjsa");
        AutorizadaDao autorizadaDao = AutorizadaServiceImpl.getInstance().autorizadaDao;
        Autorizada autorizada = new Autorizada();
    }

    @Test
    void test_criacao_autorizada() {

    }

    @Test
    void test_read_autorizada() {

    }




}