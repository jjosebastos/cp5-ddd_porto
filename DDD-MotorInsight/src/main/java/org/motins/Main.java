package org.motins;

import org.motins.config.DatabaseConfig;
import org.motins.entity.seguradora.FactorySeguradora;
import org.motins.entity.seguradora.Seguradora;
import org.motins.exception.service.SeguradoraServiceException;
import org.motins.service.impl.SeguradoraService;

import java.util.List;

public class Main {
    public static void main(String[] args) throws SeguradoraServiceException {

        DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                "rm559221","jn100800");

        SeguradoraService seguradoraService = SeguradoraService.getInstance();

        Seguradora seguradora = FactorySeguradora.create();
        seguradora.setIdSeguradora(3);
        seguradora.setNome("PORTO SEGURO BA");
        seguradora.setCnpj("04.095.044/0001-95");
        seguradora.setIdVeiculo(1);

        Seguradora seguradora2 = FactorySeguradora.create();
        seguradora2.setIdSeguradora(4);
        seguradora2.setNome("PORTO SEGURO BH");
        seguradora2.setCnpj("04.095.044/0001-91");
        seguradora2.setIdVeiculo(1);


        seguradoraService.create(seguradora);

        List<Seguradora> result = seguradoraService.listAll();
        for (Seguradora s : result) {
            System.out.println(s.toString());
        }

        seguradoraService.create(seguradora2);


        seguradoraService.delete(4);



    }


}


