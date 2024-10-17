package org.motins.entity.factoryCliente;

// Classe abstrata FactoryCliente que declara o método de criação
public abstract class FactoryCliente {
    public abstract Cliente createCliente(int idCliente, String tipoCliente, String statusCliente);

}
