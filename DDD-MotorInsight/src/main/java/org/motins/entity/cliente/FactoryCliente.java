package org.motins.entity.cliente;

public class FactoryCliente{
    private FactoryCliente(){}
        public static Cliente create() {
        return new Cliente();
    }
}
