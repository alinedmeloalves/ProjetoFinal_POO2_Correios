package CorreiosProblema1.Teste;

import CorreiosProblema1.Interfaces.Cadastro;
import CorreiosProblema1.Modelo.Entrega;
import CorreiosProblema1.Modelo.Pessoa;
import CorreiosProblema1.Modelo.Postagem;
import CorreiosProblema1.Modelo.Produto;
import CorreiosProblema1.Repository.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import CorreiosProblema1.Repository.CadastroCliente;
import CorreiosProblema1.Repository.CadastroCarteiro;
import CorreiosProblema1.Repository.CadastroProduto;
import CorreiosProblema1.Repository.CadastroPostagem;
import CorreiosProblema1.Repository.CadastroEntrega;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> listaCliente = new ArrayList<>();
        List<Entrega> listaEntregas = new ArrayList<>();
        List<Postagem> listaPostagens = new ArrayList<>();
        List<Pessoa> listaCarteiro = new ArrayList<>();
        List<Produto> listaProdutos = new ArrayList<>();

        CadastroCliente cadastroCliente = new CadastroCliente();
        CadastroEntrega cadastroEntrega = new CadastroEntrega();
        CadastroPostagem cadastroPostagem = new CadastroPostagem();
        CadastroCarteiro cadastroCarteiro = new CadastroCarteiro();
        CadastroProduto cadastroProduto = new CadastroProduto();

        int opcao = 0;
        final int SAIR_DO_SISTEMA = 6;
        do {
            try {
                Scanner input = new Scanner(System.in);
                Cadastro cadastro;
                List lista;
                System.out.println("Olá, qual cadastro você gostaria de acessar?:\n" +
                        "1 - Cliente;\n" +
                        "2 - Carteiro;\n" +
                        "3 - Produto;\n" +
                        "4 - Postagem - Para cadastro necessário ID do produto, remetente e destinatario;\n" +
                        "5 - Entrega - Para cadastro necessário: ID da postagem e do carteiro;\n" +
                        "6 - Sair do sistema.");
                opcao = input.nextInt();
                switch (opcao) {
                    case 1:
                        cadastro = cadastroCliente;
                        lista = listaCliente;
                        List listaAux1 = null;
                        List listaAux2 = null;
                        Repository.cadastrar(cadastro, lista, listaAux1, listaAux2);
                        break;
                    case 2:
                        cadastro = cadastroCarteiro;
                        lista = listaCarteiro;
                        listaAux1 = null;
                        listaAux2 = null;
                        Repository.cadastrar(cadastro, lista, listaAux1, listaAux2);
                        break;
                    case 3:
                        cadastro = cadastroProduto;
                        lista = listaProdutos;
                        listaAux1 = null;
                        listaAux2 = null;
                        Repository.cadastrar(cadastro, lista, listaAux1, listaAux2);
                        break;
                    case 4:
                        cadastro = cadastroPostagem;
                        lista = listaPostagens;
                        listaAux1 = listaProdutos;
                        listaAux2 = listaCliente;
                        Repository.cadastrar(cadastro, lista, listaAux1, listaAux2);
                        break;
                    case 5:
                        cadastro = cadastroEntrega;
                        lista = listaEntregas;
                        listaAux1 = listaPostagens;
                        listaAux2 = listaCarteiro;
                        Repository.cadastrar(cadastro, lista, listaAux1, listaAux2);
                }
            } catch (Exception e) {
                System.err.println("OPÇÃO INVÁLIDA");
            }
        } while (opcao != SAIR_DO_SISTEMA);
    }
}
