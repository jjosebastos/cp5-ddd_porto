package org.motins.entity.cliente;

public class ConcretePessoa extends FactoryCliente {
    @Override
    public Cliente createCliente(String tipo) {
        if (tipo.equalsIgnoreCase("pj")){
            return new PessoaJuridica();
        } else if(tipo.equalsIgnoreCase("pf")) {
            return new PessoaFisica();
        }
        return null;
    }
}
