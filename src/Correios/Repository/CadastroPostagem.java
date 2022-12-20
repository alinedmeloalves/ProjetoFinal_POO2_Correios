package Correios.Repository;

import Correios.Resouces.GerenteDeDados;
import Correios.Interfaces.Cadastravel;
import Correios.Interfaces.Identificavel;
import Correios.Modelo.Cliente;
import Correios.Modelo.Postagem;
import Correios.Modelo.Produto;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class CadastroPostagem implements Cadastravel {

    @Override
    public void cadastra(List<Identificavel> listaPostagens, List<Identificavel> listaProduto,
                         List<Identificavel> listaClientes, String nomeDoArquivo) {
        try {
            GerenteDeDados gerenteDeDados = new GerenteDeDados();
            Postagem postagem = new Postagem();
            Scanner scanner = new Scanner(System.in);

            Repository.setRepositoryID(listaPostagens);
            postagem.setID(Repository.getRepositoryID());
            postagem.setDataPost();
            System.out.println("Informe o ID do produto:");
            int inputProduto = scanner.nextInt();
            listaProduto.stream().filter(produto -> produto.getID() == inputProduto).
                    forEach(produto -> {
                        postagem.setProduto((Produto) produto);
                        System.out.println(produto);
                    });
            System.out.println("Informe o ID do remetente:");
            int inputRemetente = scanner.nextInt();
            listaClientes.stream().filter(cliente -> cliente.getID() == inputRemetente).
                    forEach(cliente -> {
                        postagem.setRemetente((Cliente) cliente);
                        System.out.println(cliente);
                    });
            System.out.println("Informe o ID do destinatario:");
            int inputDestinatario = scanner.nextInt();
            listaClientes.stream().filter(cliente -> cliente.getID() == inputDestinatario).
                    forEach(cliente -> {
                        postagem.setDestinatario((Cliente) cliente);
                        System.out.println(cliente);
                    });
            gerenteDeDados.cadastrarObjeto(listaPostagens,postagem,nomeDoArquivo);
            System.out.println("CADASTRO DE POSTAGEM REALIZADO COM SUCESSO");
        } catch (Exception InputMismatchException) {
            System.err.println("ENTRADA INVÁLIDA");
        }
    }
}
