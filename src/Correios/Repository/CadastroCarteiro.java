package Correios.Repository;

import Correios.Resouces.GerenteDeDados;
import Correios.Interfaces.Cadastravel;
import Correios.Interfaces.Identificavel;
import Correios.Modelo.Carteiro;
import java.util.List;
import java.util.Scanner;

public class CadastroCarteiro implements Cadastravel {

        @Override
    public void cadastra(List<Identificavel> listaCarteiro, List<Identificavel> lista2,
                         List<Identificavel> lista3, String nomeDoArquivo) {
            GerenteDeDados gerenteDeDados = new GerenteDeDados();
            Carteiro carteiro = new Carteiro();
            Scanner scanner = new Scanner(System.in);
            Repository.setRepositoryID(listaCarteiro);
            carteiro.setID(Repository.getRepositoryID());
            System.out.println("Informe o nome do carteiro:");
            carteiro.setNome(scanner.nextLine());
            System.out.println("Informe o CPF:");
            carteiro.setCpf(scanner.nextLine());
            System.out.println("Informe o e-mail:");
            carteiro.setEmail(scanner.nextLine());
            System.out.println("Informe a agência:");
            carteiro.setAgencia(scanner.nextLine());
            gerenteDeDados.cadastrarObjeto(listaCarteiro,carteiro,nomeDoArquivo);
            System.out.println("CADASTRO DO CARTEIRO REALIZADO COM SUCESSO");
    }
}
