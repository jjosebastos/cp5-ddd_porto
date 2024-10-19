package org.motins.entity.pagamento;


public class FactoryPagamento {
    private FactoryPagamento() {}
    public static Pagamento create() {
        return new Pagamento();
    }
}
