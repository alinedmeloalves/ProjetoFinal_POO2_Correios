package Correios.Repository;

import Correios.Resouces.GerenteDeDados;
import Correios.Interfaces.Cadastravel;
import Correios.Interfaces.Identificavel;
import Correios.Modelo.Carteiro;
import Correios.Modelo.Entrega;
import Correios.Modelo.Postagem;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class CadastroEntrega implements Cadastravel {


    @Override
    public void cadastra(List<Identificavel> listaEntregas, List<Identificavel> listaPostagens
            , List<Identificavel> listaCarteiro, String nomeDoArquivo) {
        try {
            GerenteDeDados gerenteDeDados = new GerenteDeDados();
            Entrega entrega = new Entrega();
            Scanner scanner = new Scanner(System.in);

            Repository.setRepositoryID(listaEntregas);
            entrega.setID(Repository.getRepositoryID());
            entrega.setDataEntrega();
            System.out.println("Informe o ID da postagem:");
            int inputPostagem = scanner.nextInt();
            listaPostagens.stream().filter(postagem -> postagem.getID() == inputPostagem).
                    forEach(postagem -> {
                        entrega.setPostagem((Postagem) postagem);
                        System.out.println(postagem);
                    });
            System.out.println("Informe o ID do carteiro:");
            int inputCarteiro = scanner.nextInt();
            listaCarteiro.stream().filter(carteiro -> carteiro.getID() == inputCarteiro).
                    forEach(carteiro -> {
                        entrega.setCarteiro((Carteiro) carteiro);
                        System.out.println(carteiro);
                    });
            entrega.setDentroPrazo();
            gerenteDeDados.cadastrarObjeto(listaEntregas,entrega,nomeDoArquivo);
            System.out.println("CADASTRO DE ENTREGA REALIZADO COM SUCESSO");
        } catch (Exception InputMismatchException) {
            System.err.println("ENTRADA INVÁLIDA");
        }
    }

}
