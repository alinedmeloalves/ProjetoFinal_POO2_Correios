package CorreiosProblema1.Repository;

import CorreiosProblema1.Interfaces.Cadastro;
import CorreiosProblema1.Interfaces.Identificavel;
import CorreiosProblema1.Modelo.Carteiro;
import java.util.List;
import java.util.Scanner;

public class CadastroCarteiro implements Cadastro {

    @Override
    public void cadastra(List<Identificavel> listaCarteiro, List<Identificavel> lista2, List<Identificavel> lista3) {
            int i = Repository.getRepositoryID() + 1;
            Repository.setRepositoryID(i);
            Carteiro carteiro = new Carteiro();
            Scanner scanner = new Scanner(System.in);
            carteiro.setID(Repository.getRepositoryID());
            System.out.println("Informe o nome do carteiro:");
            carteiro.setNome(scanner.nextLine());
            System.out.println("Informe o CPF:");
            carteiro.setCpf(scanner.nextLine());
            System.out.println("Informe o e-mail:");
            carteiro.setEmail(scanner.nextLine());
            System.out.println("Informe a agência:");
            carteiro.setAgencia(scanner.nextLine());
            listaCarteiro.add(carteiro);
            System.out.println("CADASTRO DO CARTEIRO REALIZADO COM SUCESSO");
    }
}
