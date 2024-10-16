package org.motins;

import org.motins.config.DatabaseConfig;
import org.motins.entity.factoryAutorizada.Autorizada;
import org.motins.exception.dao.*;
import org.motins.exception.service.AutorizadaServiceException;
import org.motins.service.AutorizadaServiceImpl;
import org.motins.service.interfaces.IAutorizadaService;

public class Main {
    public static void main(String[] args) throws AutorizadaDaoException, PessoaJuridicaDaoException, VeiculoDaoException, TelefoneDaoException, SeguradoraDaoException {

        DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                "rm559221","jn100800");

        IAutorizadaService autorizadaService = AutorizadaServiceImpl.getInstance();
        Autorizada autorizada = new Autorizada(3, "PORTO SEGURO SP", "04.599.093/0001-91");

        try {
            autorizadaService.create(autorizada);
        } catch (AutorizadaServiceException e) {
            throw new RuntimeException(e);
        }

    }


}


