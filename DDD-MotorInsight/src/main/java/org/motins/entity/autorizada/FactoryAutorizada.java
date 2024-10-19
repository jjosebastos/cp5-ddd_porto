package org.motins.entity.autorizada;

import org.motins.entity.seguradora.Seguradora;

public class FactoryAutorizada {
    private FactoryAutorizada() {}
    public static Autorizada create() {
        return new Autorizada();
    }
}
