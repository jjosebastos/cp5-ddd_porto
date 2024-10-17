package org.motins.entity.factorySeguradora;

public class ConcreteFactorySeguradora extends FactorySeguradora {
    @Override
    public Seguradora createSeguradora(int idSeguradora, String nome, String cnpj, int idVeiculo) {
        return new ConcreteSeguradora(idSeguradora, nome, cnpj, idVeiculo);
    }
}
