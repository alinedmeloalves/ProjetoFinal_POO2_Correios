package Correios.Modelo;

import Correios.Interfaces.Identificavel;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Entrega implements Identificavel, Serializable {

    private static final long serialVersionUID = 1L;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private int ID;
    private Postagem postagem;
    private LocalDate dataEntrega;
    private boolean dentroPrazo;
    private Carteiro carteiro;

    public Entrega() {
    }

    public Entrega(Postagem postagem, Carteiro carteiro) {
        this.dataEntrega = LocalDate.now();
        this.postagem = postagem;
        this.carteiro = carteiro;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega() {
        this.dataEntrega = LocalDate.now();
    }

    public boolean isDentroPrazo() {
        return dentroPrazo;
    }

    public void setDentroPrazo() {
        long diasEntrega = ChronoUnit.DAYS.between(postagem.getDataPost(), this.dataEntrega);
        this.dentroPrazo = diasEntrega <= postagem.getProduto().getPrazo();
    }

    public Carteiro getCarteiro() {
        return carteiro;
    }

    public void setCarteiro(Carteiro carteiro) {
        this.carteiro = carteiro;
    }


    @Override
    public String toString() {
        return "Entrega - ID " + ID +
                postagem +
                "Data de entrega: " + dataEntrega.format(formatter) +
                ";\nEstá dentro do prazo: " + dentroPrazo +
                ";\n" + carteiro;
    }
}
