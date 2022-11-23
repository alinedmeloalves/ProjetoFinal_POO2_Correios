package CorreiosProblema1.Business;

import CorreiosProblema1.Interfaces.Pagavel;

public class RemessaComum implements Pagavel {
    private final String NOME = "Remessa Comum";

    private final Double VALOR = 5.00;

    public String getNOME() {
        return NOME;
    }

    public Double getVALOR() {
        return VALOR;
    }

}
