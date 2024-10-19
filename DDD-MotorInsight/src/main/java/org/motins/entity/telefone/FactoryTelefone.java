package org.motins.entity.telefone;



public class FactoryTelefone {
    private FactoryTelefone() {}
    public static Telefone create() {
        return new Telefone();
    }
}
