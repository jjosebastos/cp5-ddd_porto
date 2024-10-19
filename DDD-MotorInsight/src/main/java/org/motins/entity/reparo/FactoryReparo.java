package org.motins.entity.reparo;


public class FactoryReparo {
    private FactoryReparo() {}
    public static Reparo create() {
        return new Reparo();
    }
}