package org.motins.entity.factoryAutorizada;

public class ConcreteAutorizada extends Autorizada {
    private int idAutorizada;
    private String nome;
    private String cnpj;

    public ConcreteAutorizada(int idAutorizada, String nome, String cnpj) {
        this.idAutorizada = idAutorizada;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    @Override
    public void build() {
        System.out.println("Autorizada criada: ID = " + idAutorizada + ", Nome = " + nome + ", CNPJ = " + cnpj);
    }
}
