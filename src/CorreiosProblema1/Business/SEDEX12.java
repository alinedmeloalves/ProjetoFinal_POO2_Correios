package CorreiosProblema1.Business;

import CorreiosProblema1.Interfaces.Pagavel;

public class SEDEX12 implements Pagavel {

    private final String NOME = "SEDEX12";
    private final Double VALOR = 20.00;

    public String getNOME() {
        return NOME;
    }

    public Double getVALOR() {
        return VALOR;
    }
}
