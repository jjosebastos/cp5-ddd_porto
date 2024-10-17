package org.motins.entity.factoryCliente;

public abstract class Cliente {

    private int idCliente;
    private String tipoCliente;
    private String statusCliente;

    public Cliente(int idCliente, String tipoCliente, String statusCliente) {
        super();
        this.idCliente = idCliente;
        setTipoCliente(tipoCliente);
        this.statusCliente = statusCliente;
    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente.toUpperCase();
    }

    public String getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(String statusCliente) {
        this.statusCliente = statusCliente;
    }

    public abstract void build();

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", tipoCliente='" + tipoCliente + '\'' +
                ", statusCliente='" + statusCliente + '\'' +
                '}';
    }
}
