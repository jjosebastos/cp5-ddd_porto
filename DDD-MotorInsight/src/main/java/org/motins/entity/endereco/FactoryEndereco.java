package org.motins.entity.endereco;

import org.motins.entity.autorizada.Autorizada;

public class FactoryEndereco {
    private FactoryEndereco() {}
    public static Endereco create() {
        return new Endereco();
    }
}
