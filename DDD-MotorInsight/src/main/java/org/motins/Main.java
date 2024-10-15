package org.motins;

import org.motins.config.DatabaseConfig;
import org.motins.dao.AutorizadaDaoImpl;
import org.motins.dao.PessoaJuridicaDao;
import org.motins.dao.PessoaJuridicaDaoImpl;
import org.motins.entity.Autorizada;
import org.motins.entity.Cliente;
import org.motins.entity.PessoaJuridica;
import org.motins.exception.AutorizadaDaoException;
import org.motins.exception.PessoaJuridicaDaoException;

public class Main {
    public static void main(String[] args) throws AutorizadaDaoException, PessoaJuridicaDaoException {

        DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                "rm559221","jn100800");

        PessoaJuridicaDao pessoaJuridica = PessoaJuridicaDaoImpl.getInstance(db);

        PessoaJuridica pj = new PessoaJuridica(1, "PJ" , "ativo", "05.054.045/0001-95", "CARFIX", "CARFIX LTDA", "");


        pessoaJuridica.create(pj);



    }
}
