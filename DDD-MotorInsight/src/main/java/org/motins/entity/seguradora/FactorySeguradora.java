package org.motins.entity.seguradora;

public class FactorySeguradora {
    private FactorySeguradora() {}
    public static Seguradora create() {
        return new Seguradora();
    }
}
