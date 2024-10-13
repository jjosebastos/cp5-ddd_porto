package org.motins.entity;

public class Autorizada {
    private int idAutorizada;
    private String nome;
    private String cnpj;

    public Autorizada(int idAutorizada, String nome, String cnpj) {
        this.idAutorizada = idAutorizada;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Autorizada() {
    }

    public boolean isCnpjValido(String cnpj) {
        return cnpj.length() == 18;
    }

    public int getIdAutorizada() {
        return idAutorizada;
    }

    public void setIdAutorizada(int idAutorizada) {
        this.idAutorizada = idAutorizada;
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
        if(isCnpjValido(cnpj)){
            this.cnpj = cnpj;
        } else {
            throw new RuntimeException("CNPJ inválido");
        }

    }


    @Override
    public String toString() {
        return "Autorizada{" +
                "idAutorizada=" + idAutorizada +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }

}