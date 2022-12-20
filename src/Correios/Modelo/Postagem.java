package Correios.Modelo;

import Correios.Interfaces.Identificavel;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Postagem implements Identificavel, Serializable {

    private static final long serialVersionUID = 1L;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private int ID;
    private Produto produto;
    private LocalDate dataPost;
    private Cliente remetente;

    private Cliente destinatario;

    public Postagem() {
    }

    public Postagem(Produto produto, Cliente remetente, Cliente destinatario) {
        this.produto = produto;
        this.dataPost = LocalDate.now();
        this.remetente = remetente;
        this.destinatario = destinatario;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public LocalDate getDataPost() {
        return dataPost;
    }

    public void setDataPost() {
        this.dataPost = LocalDate.now();
    }

    public Cliente getRemetente() {
        return remetente;
    }

    public void setRemetente(Cliente remetente) {
        this.remetente = remetente;
    }

    public Cliente getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Cliente destinatario) {
        this.destinatario = destinatario;
    }



    @Override
    public String toString() {
        return "Postagem - ID " + ID +
                ";\n" + produto +
                "\nData da postagem: " + dataPost.format(formatter) +
                ";\nRemetente - " + remetente +
                "Destinatário - " + destinatario + ".\n";
    }
}
