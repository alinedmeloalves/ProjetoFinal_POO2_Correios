package Correios.Interfaces;
import java.io.IOException;
import java.util.List;

public interface Cadastravel {

    void cadastra(List<Identificavel> lista, List<Identificavel> lista2, List<Identificavel> lista3, String nomeDoArquivo) throws IOException;

}