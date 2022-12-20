package Correios.Repository;

import Correios.Resouces.GerenteDeDados;
import Correios.Interfaces.Cadastravel;
import Correios.Interfaces.Identificavel;
import Correios.Modelo.Produto;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class CadastroProduto implements Cadastravel {

    @Override
    public void cadastra(List<Identificavel> listaProdutos, List<Identificavel> lista1,
                         List<Identificavel> lista2, String nomeDoArquivo) {
        try {
            GerenteDeDados gerenteDeDados = new GerenteDeDados();
            Produto produto = new Produto();
            Scanner scanner = new Scanner(System.in);

            Repository.setRepositoryID(listaProdutos);
            produto.setID(Repository.getRepositoryID());
            System.out.println("Informe o nome do produto:");
            produto.setNome(scanner.nextLine());
            System.out.println("Informe a descrição do produto:");
            produto.setDescricao(scanner.nextLine());
            System.out.println("Informe o prazo de entrega:");
            produto.setPrazo(scanner.nextInt());
            produto.setTipo(produto);
            produto.setValor();
            gerenteDeDados.cadastrarObjeto(listaProdutos,produto,nomeDoArquivo);
            System.out.println("CADASTRO DO PRODUTO REALIZADO COM SUCESSO");
        } catch (Exception InputMismatchException) {
            System.err.println("ENTRADA INVÁLIDA");
        }
    }

}
