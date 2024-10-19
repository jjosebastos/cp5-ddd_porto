package org.motins.entity.historicoVeiculo;
import org.motins.entity.veiculo.Veiculo;

public class FactoryHistoricoVeiculo {
    private FactoryHistoricoVeiculo() {}
    public static HistoricoVeiculo create() {
        return new HistoricoVeiculo();
    }
}
