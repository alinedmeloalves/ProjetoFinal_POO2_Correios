package CorreiosProblema1.Repository;

import CorreiosProblema1.Interfaces.Cadastro;
import CorreiosProblema1.Interfaces.Identificavel;
import CorreiosProblema1.Modelo.Produto;
import java.util.List;
import java.util.Scanner;

public class CadastroProduto implements Cadastro {

    @Override
    public void cadastra(List<Identificavel> listaProdutos, List<Identificavel> lista1,
                         List<Identificavel> lista2) {
        try {
            int i = Repository.getRepositoryID() + 1;
            Repository.setRepositoryID(i);
            Produto produto = new Produto();
            Scanner scanner = new Scanner(System.in);
            produto.setID(Repository.getRepositoryID());
            System.out.println("Informe o nome do produto:");
            produto.setNome(scanner.nextLine());
            System.out.println("Informe a descrição do produto:");
            produto.setDescricao(scanner.nextLine());
            System.out.println("Informe o prazo de entrega:");
            produto.setPrazo(scanner.nextInt());
            produto.setTipo(produto);
            produto.setValor();
            listaProdutos.add(produto);
            System.out.println("CADASTRO DO PRODUTO REALIZADO COM SUCESSO");
        } catch (Exception InputMismatchException) {
            System.err.println("ENTRADA INVÁLIDA");
        }
    }

}
