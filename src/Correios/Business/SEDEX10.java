package Correios.Business;

import Correios.Interfaces.Pagavel;

public class SEDEX10 implements Pagavel {

    private final String NOME = "SEDEX10";
    private final Double VALOR = 25.00;

    public String getNOME() {
        return NOME;
    }

    public Double getVALOR() {
        return VALOR;
    }
}
