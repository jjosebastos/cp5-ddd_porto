package org.motins.entity.factorySeguradora;

public abstract class FactorySeguradora {
    public abstract Seguradora createSeguradora(int idSeguradora, String nome, String cnpj, int idVeiculo);
}
