package org.motins.entity.veiculo;



public class FactoryVeiculo {
    private FactoryVeiculo() {}
    public static Veiculo create() {
        return new Veiculo();
    }
}