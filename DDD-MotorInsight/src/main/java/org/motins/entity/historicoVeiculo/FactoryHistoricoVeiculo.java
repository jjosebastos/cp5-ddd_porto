package org.motins.entity.historicoVeiculo;


public class FactoryHistoricoVeiculo {
    private FactoryHistoricoVeiculo() {}
    public static HistoricoVeiculo create() {
        return new HistoricoVeiculo();
    }
}
