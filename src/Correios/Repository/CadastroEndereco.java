package Correios.Repository;

import Correios.Modelo.Endereco;
import java.util.List;
import java.util.Scanner;
/*
Não implementei a interface, pq essa classe precisava retornar um endereço dentro
do cadastro de cliente.
 */
public class CadastroEndereco {

    public Endereco cadastra(List<Endereco> listaEnderecos) {
        Endereco endereco = new Endereco();
        Scanner scanner = new Scanner(System.in);
        endereco.setID(listaEnderecos);
        System.out.println("Informe o logradouro:");
        endereco.setLogradouro(scanner.nextLine());
        System.out.println("Informe o número:");
        endereco.setNumero(scanner.nextLine());
        System.out.println("Informe o complemento:");
        endereco.setComplemento(scanner.nextLine());
        System.out.println("Informe o CEP:");
        endereco.setCep(scanner.nextLine());
        System.out.println("Informe o Estado:");
        endereco.setEstado(scanner.nextLine());
        listaEnderecos.add(endereco);
        System.out.println("CADASTRO DO ENDEREÇO REALIZADO COM SUCESSO");
        return endereco;
    }
}
