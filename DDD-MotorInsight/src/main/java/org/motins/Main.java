package org.motins;

import org.motins.config.DatabaseConfig;
import org.motins.dao.*;
import org.motins.entity.*;
import org.motins.exception.dao.*;

import java.util.List;

public class Main {
    public static void main(String[] args) throws AutorizadaDaoException, PessoaJuridicaDaoException, VeiculoDaoException, TelefoneDaoException, SeguradoraDaoException {

        DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                "rm559221","jn100800");

        PessoaJuridicaDao pjDao = PessoaJuridicaDaoImpl.getInstance(db);

        PessoaJuridica pj = new PessoaJuridica(4, "PJ", "1", "04.045.304/0001-94", "CARFIX TESTE", "CARFIX TESTE LTDA", "10039");
        pjDao.create(pj);

        List<PessoaJuridica> result = pjDao.readAll();
        for (PessoaJuridica pes: result) {
            System.out.println(pes.toString());
        }


    }

}
