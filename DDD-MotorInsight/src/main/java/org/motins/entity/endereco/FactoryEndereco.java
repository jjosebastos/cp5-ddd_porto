package org.motins.entity.endereco;


public class FactoryEndereco {
    private FactoryEndereco() {}
    public static Endereco create() {
        return new Endereco();
    }
}
