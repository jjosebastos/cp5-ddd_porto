package org.motins.entity.factoryCliente;

public class ConcreteFactoryCliente extends FactoryCliente {
    @Override
    public Cliente createCliente(int idCliente, String tipoCliente, String statusCliente) {
        return new ConcreteCliente(idCliente, tipoCliente, statusCliente);
    }
}
