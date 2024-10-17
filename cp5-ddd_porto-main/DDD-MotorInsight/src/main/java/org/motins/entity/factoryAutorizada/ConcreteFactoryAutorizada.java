package org.motins.entity.factoryAutorizada;

public class ConcreteFactoryAutorizada extends FactoryAutorizada {
    @Override
    public Autorizada createAutorizada(int idAutorizada, String nome, String cnpj) {
        return new ConcreteAutorizada(idAutorizada, nome, cnpj);
    }
}
