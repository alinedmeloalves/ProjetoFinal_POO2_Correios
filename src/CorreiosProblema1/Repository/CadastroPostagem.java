package CorreiosProblema1.Repository;

import CorreiosProblema1.Interfaces.Cadastro;
import CorreiosProblema1.Interfaces.Identificavel;
import CorreiosProblema1.Modelo.Cliente;
import CorreiosProblema1.Modelo.Postagem;
import CorreiosProblema1.Modelo.Produto;

import java.util.List;
import java.util.Scanner;

public class CadastroPostagem implements Cadastro {

    @Override
    public void cadastra(List<Identificavel> listaPostagens, List<Identificavel> listaProduto,
                         List<Identificavel> listaClientes) {
        try {
            int i = Repository.getRepositoryID() + 1;
            Repository.setRepositoryID(i);
            Postagem postagem = new Postagem();
            Scanner scanner = new Scanner(System.in);
            postagem.setID(Repository.getRepositoryID());
            postagem.setDataPost();
            System.out.println("Informe o ID do produto:");
            int inputProduto = scanner.nextInt();
            for (Identificavel produto : listaProduto) {
                if (produto.getID() == inputProduto) {
                    postagem.setProduto((Produto) produto);
                    System.out.println(produto);
                }
            }
            System.out.println("Informe o ID do remetente:");
            int inputRemetente = scanner.nextInt();
            for (Identificavel cliente : listaClientes) {
                if (cliente.getID() == inputRemetente) {
                    postagem.setRemetente((Cliente) cliente);
                    System.out.println(cliente);
                }
            }
            System.out.println("Informe o ID do destinatario:");
            int inputDestinatario = scanner.nextInt();
            for (Identificavel cliente : listaClientes) {
                if (cliente.getID() == inputDestinatario) {
                    postagem.setDestinatario((Cliente) cliente);
                    System.out.println(cliente);
                }
            }
            listaPostagens.add(postagem);
            System.out.println("CADASTRO DE POSTAGEM REALIZADO COM SUCESSO");
        } catch (Exception InputMismatchException) {
            System.err.println("ENTRADA INVÁLIDA");
        }
    }
}
