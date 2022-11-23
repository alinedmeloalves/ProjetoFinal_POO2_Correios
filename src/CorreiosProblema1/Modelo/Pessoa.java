package CorreiosProblema1.Modelo;

import CorreiosProblema1.Repository.Repository;

public abstract class Pessoa extends Repository {

    private int ID;
    private String nome;
    private String cpf;
    private String email;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID " + ID +
                ";\nNome: " + nome +
                ";\nCPF: " + cpf +
                ";\nE-mail: " + email + ";\n";
    }
}
