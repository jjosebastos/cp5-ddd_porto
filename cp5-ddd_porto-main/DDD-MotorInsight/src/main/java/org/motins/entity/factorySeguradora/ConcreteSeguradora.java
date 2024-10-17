package org.motins.entity.factorySeguradora;

public class ConcreteSeguradora extends Seguradora {
    private int idSeguradora;
    private String nome;
    private String cnpj;
    private int idVeiculo;

    public ConcreteSeguradora(int idSeguradora, String nome, String cnpj, int idVeiculo) {
        super();
        this.idSeguradora = idSeguradora;
        this.nome = nome;
        setCnpj(cnpj);
        this.idVeiculo = idVeiculo;
    }

    public boolean isCnpjValido(String cnpj) {
        if (cnpj.length() == 18) {
            return true;
        } else {
            throw new RuntimeException("CNPJ inválido.");
        }
    }

    public int getIdSeguradora() {
        return idSeguradora;
    }

    public void setIdSeguradora(int idSeguradora) {
        this.idSeguradora = idSeguradora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        if (isCnpjValido(cnpj)) {
            this.cnpj = cnpj;
        }
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    @Override
    public void build() {
        System.out.println("Seguradora criada: " + this.toString());
    }

    @Override
    public String toString() {
        return "Seguradora{" +
                "idSeguradora=" + idSeguradora +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", idVeiculo=" + idVeiculo +
                '}';
    }
}
