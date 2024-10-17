package org.motins.entity.factoryAutorizada;

public abstract class FactoryAutorizada {
    public abstract Autorizada createAutorizada(int idAutorizada, String nome, String cnpj);
}
