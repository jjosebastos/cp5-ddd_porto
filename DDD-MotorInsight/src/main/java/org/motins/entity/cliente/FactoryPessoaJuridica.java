package org.motins.entity.cliente;

import org.motins.entity.seguradora.FactorySeguradora;

public class FactoryPessoaJuridica {
    private FactoryPessoaJuridica() {}
    public static PessoaJuridica create(Cliente cliente) {
        if (cliente.getTipoCliente().equalsIgnoreCase("PJ")){
            return new PessoaJuridica();
        }
        return null;
    }
}
