package Correios.Repository;

import Correios.Resouces.GerenteDeDados;
import Correios.Interfaces.Cadastravel;
import Correios.Interfaces.Identificavel;
import Correios.Modelo.Cliente;
import Correios.Modelo.Endereco;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroCliente implements Cadastravel {

    @Override
    public void cadastra(List<Identificavel> listaCliente, List<Identificavel> lista2,
                         List<Identificavel> lista3, String nomeDoArquivo) throws IOException {
        GerenteDeDados gerenteDeDados = new GerenteDeDados();
        CadastroEndereco endereco = new CadastroEndereco();
        List<Endereco> ListaEndereco = new ArrayList<>();
        Cliente cliente = new Cliente();
        Scanner scanner = new Scanner(System.in);

        Repository.setRepositoryID(listaCliente);
        cliente.setID(Repository.getRepositoryID());
        System.out.println("Informe o nome:");
        cliente.setNome(scanner.nextLine());
        System.out.println("Informe o CPF:");
        cliente.setCpf(scanner.nextLine());
        System.out.println("Informe o e-mail:");
        cliente.setEmail(scanner.nextLine());
        System.out.println("Agora, vamos cadastrar o endereco:");
        cliente.setEndereco(endereco.cadastra(ListaEndereco));
        gerenteDeDados.cadastrarObjeto(listaCliente, cliente, nomeDoArquivo);
        System.out.println("CADASTRO DO CLIENTE REALIZADO COM SUCESSO");
    }
}
