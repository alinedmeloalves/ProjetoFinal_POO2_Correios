package CorreiosProblema1.Repository;

import CorreiosProblema1.Interfaces.Cadastro;
import CorreiosProblema1.Interfaces.Identificavel;

import java.util.List;
import java.util.Scanner;

public class Repository {
    private static int RepositoryID;

    public static int getRepositoryID() {
        return RepositoryID;
    }

    public static void setRepositoryID(int repositoryID) {
        RepositoryID = repositoryID;
    }

    public static void cadastrar(Cadastro cadastro, List<Identificavel> lista, List<Identificavel> lista1, List<Identificavel> lista2) {
        final int VOLTAR = 5;
        int opcao = 0;
        do {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("O que você deseja fazer?\n" +
                        "1 - Cadastrar;\n" +
                        "2 - Consultar pelo ID;\n" +
                        "3 - Visualizar cadastrados;\n" +
                        "4 - Limpar cadastros;\n" +
                        "5 - Voltar.");
                opcao = input.nextInt();
                switch (opcao) {
                    case 1:
                        cadastro.cadastra(lista, lista1, lista2);
                        break;
                    case 2:
                        consultarID(lista);
                        break;
                    case 3:
                        imprimirLista(lista);
                        break;
                    case 4:
                        lista.clear();
                        System.out.println("CADASTRO APAGADO COM SUCESSO!");
                        break;
                }
            } catch (Exception InputMismatchException) {
                System.err.println("ENTRADA INVÁLIDA");
            }
        } while (opcao != VOLTAR);
    }


    public static void consultarID(List<Identificavel> lista) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Informe o ID do item desejado:");
            int inputID = input.nextInt();
            for (Identificavel id : lista) {
                if (id.getID() == inputID) {
                    System.out.println(id);
                }
            }
        } catch (Exception InputMismatchException) {
            System.err.println("ENTRADA INVÁLIDA");
        }
    }

        public static void imprimirLista (List<Identificavel> lista){
            if (lista.isEmpty()) {
                System.out.println("CADASTRO VAZIO");
            } else {
                System.out.println(lista);
            }
        }
}


