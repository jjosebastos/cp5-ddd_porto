package org.motins.entity.cliente;

public class FactoryPessoaFisica {
    private FactoryPessoaFisica() {}
    public static PessoaFisica create(Cliente cliente) {
        if (cliente.getTipoCliente().equalsIgnoreCase("PF")){
            return new PessoaFisica();
        }
        return null;
    }
}
