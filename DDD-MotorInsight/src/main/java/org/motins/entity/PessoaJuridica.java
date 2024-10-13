package org.motins.entity;

public class PessoaJuridica extends Cliente{

    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String inscricaoEstadual;

    public PessoaJuridica(int idCliente, String tipoCliente, String statusCliente, String cnpj, String razaoSocial, String nomeFantasia, String inscricaoEstadual) {
        super(idCliente, tipoCliente, statusCliente);
        setCnpj(cnpj);
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public boolean isCnpjValido(String cnpj){
        return cnpj.length() == 18;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
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

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }


    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj='" + cnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", inscricaoEstadual='" + inscricaoEstadual + '\'' +
                '}';
    }
}