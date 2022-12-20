package Correios.Modelo;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public class Endereco implements Serializable{

    private static final long serialVersionUID = 1L;

    private int ID;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String estado;

    public Endereco() {
    }

    public Endereco(String logradouro, String numero, String complemento, String cep, String estado) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.estado = estado;
    }

    public int getID() {
        return ID;
    }

    public void setID(List<Endereco> listaEnderecos) {

        if(listaEnderecos.stream().max(Comparator.comparingInt(Endereco::getID)).isPresent()) {
            int Id = listaEnderecos.stream().max(Comparator.comparingInt(Endereco::getID)).get().getID();
            this.ID = Id++;
        }else {
            this.ID = 0;
        }
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  "ID: " + ID +
                ";\n" + logradouro + ", nº " + numero + ". Compl: " + complemento +
                ".\nCEP: " + cep + ". Estado: " + estado + ".\n";
    }
}
