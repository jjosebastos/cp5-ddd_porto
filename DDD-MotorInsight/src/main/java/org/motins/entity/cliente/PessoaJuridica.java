package org.motins.entity.cliente;

public class PessoaJuridica extends Cliente {

    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;

    public PessoaJuridica(int idCliente, String tipoCliente, String statusCliente, String cnpj, String razaoSocial, String nomeFantasia) {
        super(idCliente, tipoCliente, statusCliente);
        setCnpj(cnpj);
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }


    public PessoaJuridica(){
        super();
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


    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj='" + cnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", inscricaoEstadual='" + '\'' +
                '}';
    }

}