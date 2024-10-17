package org.motins.entity.factoryAutorizada;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Tecnico {
    private int idTecnico;
    private String nome;
    private LocalDate dataNascimento;
    private String matricula;
    private Integer idAutorizada;

    public Tecnico(int idTecnico, String nome, LocalDate dataNascimento, String matricula, Integer idAutorizada) {
        this.idTecnico = idTecnico;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.matricula = matricula;
        this.idAutorizada = idAutorizada;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if(isDataNascimentoValid(dataNascimento)){
            this.dataNascimento = dataNascimento;
        }
        throw new RuntimeException("Idade inválida");
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getIdAutorizada() {
        return idAutorizada;
    }

    public void setIdAutorizada(Integer idAutorizada) {
        this.idAutorizada = idAutorizada;
    }

    public boolean isDataNascimentoValid(LocalDate dataNasc){
        LocalDate dataAtual = LocalDate.now();
        int idade = Period.between(dataNasc, dataAtual).getYears();
        return  idade >= 18;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "idTecnico=" + idTecnico +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", matricula='" + matricula + '\'' +
                ", idAutorizada=" + idAutorizada +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tecnico tecnico = (Tecnico) o;
        return idTecnico == tecnico.idTecnico && Objects.equals(nome, tecnico.nome) && Objects.equals(dataNascimento, tecnico.dataNascimento) && Objects.equals(matricula, tecnico.matricula) && Objects.equals(idAutorizada, tecnico.idAutorizada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTecnico, nome, dataNascimento, matricula, idAutorizada);
    }
}