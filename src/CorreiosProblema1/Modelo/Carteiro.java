package CorreiosProblema1.Modelo;

import CorreiosProblema1.Interfaces.Identificavel;

public class Carteiro extends Pessoa implements Identificavel {

    private String agencia;

    public Carteiro() {
    }

    public Carteiro(String nome, String cpf, String email, String agencia) {
        super(nome, cpf, email);
        this.agencia = agencia;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    @Override
    public int getID() {
        return super.getID();
    }

    @Override
    public String toString() {
        return "Carteiro " + super.toString() +
                "Agência: " + agencia + ".\n";
    }
}
