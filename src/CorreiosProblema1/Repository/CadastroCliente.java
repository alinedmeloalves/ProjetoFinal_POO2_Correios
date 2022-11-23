package CorreiosProblema1.Repository;

import CorreiosProblema1.Interfaces.Cadastro;
import CorreiosProblema1.Interfaces.Identificavel;
import CorreiosProblema1.Modelo.Cliente;
import CorreiosProblema1.Modelo.Endereco;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroCliente implements Cadastro{

    @Override
    public void cadastra(List<Identificavel> listaCliente, List<Identificavel> lista2, List<Identificavel> lista3) {
        int i = Repository.getRepositoryID() + 1;
        Repository.setRepositoryID(i);
        CadastroEndereco endereco = new CadastroEndereco();
        List<Endereco> ListaEndereco = new ArrayList<>();
        Cliente cliente = new Cliente();
        Scanner scanner = new Scanner(System.in);
        cliente.setID(Repository.getRepositoryID());
        System.out.println("Informe o nome:");
        cliente.setNome(scanner.nextLine());
        System.out.println("Informe o CPF:");
        cliente.setCpf(scanner.nextLine());
        System.out.println("Informe o e-mail:");
        cliente.setEmail(scanner.nextLine());
        System.out.println("Agora, vamos cadastrar o endereco:");
        cliente.setEndereco(endereco.cadastra(ListaEndereco));
        listaCliente.add(cliente);
        System.out.println("CADASTRO DO CLIENTE REALIZADO COM SUCESSO");
    }
}
