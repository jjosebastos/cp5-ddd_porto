package org.motins;

import org.motins.config.DatabaseConfig;
import org.motins.entity.cliente.Cliente;
import org.motins.entity.cliente.FactoryCliente;
import org.motins.entity.cliente.FactoryPessoaFisica;
import org.motins.entity.cliente.PessoaFisica;
import org.motins.exception.service.PessoaFisicaServiceException;
import org.motins.service.impl.ClienteService;
import org.motins.service.impl.PessoaFisicaService;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws PessoaFisicaServiceException {

        DatabaseConfig db = new DatabaseConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                "rm559221","jn100800");

        ClienteService clienteService = ClienteService.getInstance();

        Cliente cliente = FactoryCliente.create();
        cliente.setIdCliente(4);
        cliente.setTipoCliente("PF");
        cliente.setStatusCliente("0");


        PessoaFisica pf = FactoryPessoaFisica.create(cliente);
        pf.setNome("Nicolas Dobbeck");
        pf.setGenero("Masculino");
        pf.setDataNascimento(LocalDate.of(2004, 7, 26));
        pf.setNumeroCpf("001.994.909-11");
        pf.setIdCliente(4);

        PessoaFisicaService pfService = PessoaFisicaService.getInstance();

        pfService.create(pf);

        PessoaFisica pfAtt = FactoryPessoaFisica.create(cliente);
        pfAtt.setNome("Nicolas Dobbeck Mendes");
        pfAtt.setGenero("Masculino");
        pfAtt.setDataNascimento(LocalDate.of(2004, 7, 26));
        pfAtt.setNumeroCpf("410.190.108-16");
        pfAtt.setIdCliente(4);

        try {
            pfService.update(pfAtt);
        } catch (PessoaFisicaServiceException e) {
            throw new PessoaFisicaServiceException("Não foi possível atualizar a pessoa: ", e);
        }

        List<PessoaFisica> rsPf = pfService.listAll();
        for (PessoaFisica p : rsPf) {
            System.out.println(p.toString());
        }



    }


}


