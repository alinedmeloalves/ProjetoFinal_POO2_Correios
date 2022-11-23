package CorreiosProblema1.Modelo;

import CorreiosProblema1.Interfaces.Identificavel;

import java.time.LocalDate;

public class Postagem implements Identificavel {

    private int ID;
    private Produto produto;
    private LocalDate dataPost = LocalDate.now();
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

    public void setDataPost() {
        this.dataPost = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Postagem - ID " + ID +
                ";\n" + produto +
                "\nData da postagem: " + dataPost +
                ";\nRemetente - " + remetente +
                "Destinatário - " + destinatario + ".\n";
    }
}
