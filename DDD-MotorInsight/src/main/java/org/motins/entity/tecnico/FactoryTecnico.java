package org.motins.entity.tecnico;



public class FactoryTecnico {
    private FactoryTecnico() {}
    public static Tecnico create() {
        return new Tecnico();
    }
}
