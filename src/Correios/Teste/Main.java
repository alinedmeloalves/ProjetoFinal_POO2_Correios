package Correios.Teste;

import Correios.Resouces.GerenteDeArquivo;
import Correios.Interfaces.Cadastravel;
import Correios.Modelo.Entrega;
import Correios.Modelo.Pessoa;
import Correios.Modelo.Postagem;
import Correios.Modelo.Produto;
import Correios.Repository.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Correios.Repository.CadastroCliente;
import Correios.Repository.CadastroCarteiro;
import Correios.Repository.CadastroProduto;
import Correios.Repository.CadastroPostagem;
import Correios.Repository.CadastroEntrega;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Pessoa> listaClientes = new ArrayList<>();
        List<Entrega> listaEntregas = new ArrayList<>();
        List<Postagem> listaPostagens = new ArrayList<>();
        List<Pessoa> listaCarteiros = new ArrayList<>();
        List<Produto> listaProdutos = new ArrayList<>();

        CadastroCliente cadastroCliente = new CadastroCliente();
        CadastroEntrega cadastroEntrega = new CadastroEntrega();
        CadastroPostagem cadastroPostagem = new CadastroPostagem();
        CadastroCarteiro cadastroCarteiro = new CadastroCarteiro();
        CadastroProduto cadastroProduto = new CadastroProduto();

        GerenteDeArquivo arquivoClientes = new GerenteDeArquivo();
        GerenteDeArquivo arquivoEntregas = new GerenteDeArquivo();
        GerenteDeArquivo arquivoPostagens = new GerenteDeArquivo();
        GerenteDeArquivo arquivoCarteiros = new GerenteDeArquivo();
        GerenteDeArquivo arquivoProdutos = new GerenteDeArquivo();

        arquivoClientes.criarNovoArquivoBanco("arquivoClientes.txt");
        arquivoEntregas.criarNovoArquivoBanco("arquivoEntregas.txt");
        arquivoPostagens.criarNovoArquivoBanco("arquivoPostagens.txt");
        arquivoCarteiros.criarNovoArquivoBanco("arquivoCarteiros.txt");
        arquivoProdutos.criarNovoArquivoBanco("arquivoProdutos.txt");


        int opcao = 0;
        final int SAIR_DO_SISTEMA = 6;
        do {
//            try {
                Scanner input = new Scanner(System.in);
                Cadastravel cadastro;
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
                        lista = listaClientes;
                        List listaAux1 = null;
                        List listaAux2 = null;
                        Repository.cadastrar(cadastro, lista, listaAux1, listaAux2, "arquivoClientes.txt");
                        break;
                    case 2:
                        cadastro = cadastroCarteiro;
                        lista = listaCarteiros;
                        listaAux1 = null;
                        listaAux2 = null;
                        Repository.cadastrar(cadastro, lista, listaAux1, listaAux2, "arquivoCarteiros.txt");
                        break;
                    case 3:
                        cadastro = cadastroProduto;
                        lista = listaProdutos;
                        listaAux1 = null;
                        listaAux2 = null;
                        Repository.cadastrar(cadastro, lista, listaAux1, listaAux2, "arquivoProdutos.txt");
                        break;
                    case 4:
                        cadastro = cadastroPostagem;
                        lista = listaPostagens;
                        listaAux1 = listaProdutos;
                        listaAux2 = listaClientes;
                        Repository.cadastrar(cadastro, lista, listaAux1, listaAux2, "arquivoPostagens.txt");
                        break;
                    case 5:
                        cadastro = cadastroEntrega;
                        lista = listaEntregas;
                        listaAux1 = listaPostagens;
                        listaAux2 = listaCarteiros;
                        Repository.cadastrar(cadastro, lista, listaAux1, listaAux2, "arquivoEntregas.txt");
                        break;
                }
//            } catch (Exception e) {
//                System.err.println("OPÇÃO INVÁLIDA");
//            }
        } while (opcao != SAIR_DO_SISTEMA);
    }
}
