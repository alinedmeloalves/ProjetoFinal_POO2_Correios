package Correios.Repository;

import Correios.Resouces.GerenteDeArquivo;
import Correios.Resouces.GerenteDeDados;
import Correios.Interfaces.Cadastravel;
import Correios.Interfaces.Identificavel;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Repository {

    private static int repositoryID;

    public static int getRepositoryID() {
        return repositoryID;
    }

    public static void setRepositoryID(List<Identificavel> lista) {
        if(lista.stream().max(Comparator.comparingInt(Identificavel::getID)).isPresent()){
            int ID = lista.stream().max(Comparator.comparingInt(Identificavel::getID)).get().getID();
            repositoryID = ID++;
        }else {
            repositoryID = 0;
        }
    }

    public static void cadastrar(Cadastravel cadastro, List<Identificavel> lista, List<Identificavel> lista1,
                                 List<Identificavel> lista2, String nomeDoArquivo) throws IOException {

        final int VOLTAR = 8;
        int opcao = 0;
        do {
//            try {
                GerenteDeArquivo gerenteDeArquivo = new GerenteDeArquivo();
                GerenteDeDados gerenteDeDados = new GerenteDeDados();
                Scanner input = new Scanner(System.in);
                System.out.println("O que você deseja fazer?\n" +
                                   "1 - Cadastrar;\n" +
                                   "2 - Consultar pelo ID;\n" +
                                   "3 - Visualizar cadastrados;\n" +
                                   "4 - Editar item;\n" +
                                   "5 - Deletar item cadastrado;\n" +
                                   "6 - Limpar cadastros;\n" +
                                   "7 - Fazer backup do cadastro;\n" +
                                   "8 - Voltar.");
                opcao = input.nextInt();
                switch (opcao) {
                    case 1:
                        cadastro.cadastra(lista, lista1, lista2, nomeDoArquivo);
                        break;
                    case 2:
                        GerenteRepository.consultarID(lista);
                        break;
                    case 3:
                        GerenteRepository.imprimirLista(lista);
                        break;
                    case 4:
                        gerenteDeDados.editarObjeto(cadastro, lista, lista1, lista2, nomeDoArquivo);
                        break;
                    case 5:
                        gerenteDeDados.deletarObjeto(lista,nomeDoArquivo);
                        break;
                    case 6:
                        gerenteDeArquivo.apagarArquivoDeBanco(nomeDoArquivo);
                        break;
                    case 7:
                        gerenteDeArquivo.fazerBackUpArquivoDeBanco(nomeDoArquivo);
                        break;
                }
//            } catch (Exception InputMismatchException) {
//                System.err.println("ENTRADA INVÁLIDA1");
//            }
        } while (opcao != VOLTAR);
    }
}


