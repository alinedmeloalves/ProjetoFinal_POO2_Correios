package CorreiosProblema1.Repository;

import CorreiosProblema1.Interfaces.Cadastro;
import CorreiosProblema1.Interfaces.Identificavel;
import CorreiosProblema1.Modelo.Carteiro;
import CorreiosProblema1.Modelo.Entrega;
import CorreiosProblema1.Modelo.Postagem;

import java.util.List;
import java.util.Scanner;

public class CadastroEntrega implements Cadastro {
    @Override
    public void cadastra(List<Identificavel> listaEntregas, List<Identificavel> listaPostagens
            , List<Identificavel> listaCarteiro) {
        try {
            int i = Repository.getRepositoryID() + 1;
            Repository.setRepositoryID(i);
            Entrega entrega = new Entrega();
            Scanner scanner = new Scanner(System.in);
            entrega.setID(Repository.getRepositoryID());
            entrega.setDataEntrega();
            System.out.println("Informe o ID da postagem:");
            int inputPostagem = scanner.nextInt();
            for (Identificavel postagem : listaPostagens) {
                if (postagem.getID() == inputPostagem) {
                    entrega.setPostagem((Postagem) postagem);
                    System.out.println(postagem);
                }
            }
            System.out.println("Informe o ID do carteiro:");
            int inputCarteiro = scanner.nextInt();
            for (Identificavel carteiro : listaCarteiro) {
                if (carteiro.getID() == inputCarteiro) {
                    entrega.setCarteiro((Carteiro) carteiro);
                    System.out.println(carteiro);
                }
            }
            entrega.setDentroPrazo();
            listaEntregas.add(entrega);
            System.out.println("CADASTRO DE ENTREGA REALIZADO COM SUCESSO");
        } catch (Exception InputMismatchException) {
            System.err.println("ENTRADA INVÁLIDA");
        }
    }

}
