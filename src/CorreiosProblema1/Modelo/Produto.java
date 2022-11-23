package CorreiosProblema1.Modelo;

import CorreiosProblema1.Business.RemessaComum;
import CorreiosProblema1.Business.SEDEX10;
import CorreiosProblema1.Business.SEDEX12;
import CorreiosProblema1.Interfaces.Identificavel;
import CorreiosProblema1.Interfaces.Pagavel;

public class Produto implements Identificavel {
    private int ID;
    private String nome;
    private String descricao;
    private int prazo;
    private Double valor;
    private Pagavel tipo;

    public Produto() {
    }

    public Produto(String nome, String descricao, int prazo, Double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.prazo = prazo;
        this.valor = valor;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        if (this.prazo > 15) {
            System.out.println("Prazo inválido");
        }else{
            this.prazo = prazo;
        }
    }

    public Double getValor() {
        return valor;
    }

    public void setValor() {
        this.valor = this.getTipo().getVALOR();
    }

    public Pagavel getTipo() {
        return tipo;
    }

    public void setTipo(Produto produto) {
        if (this.getPrazo() == 0){
            this.tipo = new SEDEX10();
        }else if (this.getPrazo() == 1) {
            this.tipo = new SEDEX12();
        }else if (this.getPrazo() > 1 && produto.getPrazo() <= 15) {
            this.tipo = new RemessaComum();
        }
    }

    @Override
    public String toString() {
        return "Produto - ID " + ID +
                ";\nNome: " + nome + '\'' +
                ";\nDescrição: " + descricao +
                ";\nTipo: " + tipo.getNOME() +
                ";\nPrazo: " + prazo +
                ";\nValor=" + valor + ".\n";
    }
}
