package org.motins.entity.factoryEndereco;

public class Endereco {

    private int idEndereco;
    private String rua;
    private String numeroEndereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String complemento;
    private int idCliente;
    private int idAutorizada;
    private int idSeguradora;

    public Endereco(){}
    public Endereco(int idEndereco, String rua, String numeroEndereco ,String bairro, String cidade, String uf,
                    String cep, String complemento, int idCliente, int idAutorizada, int idSeguradora) {
        this.idEndereco = idEndereco;
        this.rua = rua;
        this.numeroEndereco = numeroEndereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        setCep(cep);
        this.complemento = complemento;
        this.idCliente = idCliente;
        this.idAutorizada = idAutorizada;
        this.idSeguradora = idSeguradora;

    }


    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Boolean isCepValido(String cep) {
        return cep.matches("\\d{5}-\\d{3}");
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdAutorizada() {
        return idAutorizada;
    }

    public void setIdAutorizada(int idAutorizada) {
        this.idAutorizada = idAutorizada;
    }

    public int getIdSeguradora() {
        return idSeguradora;
    }

    public void setIdSeguradora(int idSeguradora) {
        this.idSeguradora = idSeguradora;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "idEndereco=" + idEndereco +
                ", rua='" + rua + '\'' +
                ", numeroEndereco='" + numeroEndereco + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", complemento='" + complemento + '\'' +
                ", idCliente=" + idCliente +
                ", idAutorizada=" + idAutorizada +
                ", idSeguradora=" + idSeguradora +
                '}';
    }
}
