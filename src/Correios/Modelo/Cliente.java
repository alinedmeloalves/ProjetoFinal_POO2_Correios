package Correios.Modelo;

import Correios.Interfaces.Identificavel;
import java.io.Serializable;

public class Cliente extends Pessoa implements Identificavel, Serializable {

    private static final long serialVersionUID = 1L;

    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String email, Endereco endereco) {
        super(nome, cpf, email);
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    @Override
    public String toString() {
        return super.toString() +
                "Endereço: " + endereco;
    }
}
