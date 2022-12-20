package Correios.Repository;

import Correios.Interfaces.Identificavel;

import java.util.List;
import java.util.Scanner;

public class GerenteRepository {

    public static void consultarID(List<Identificavel> lista) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Informe o ID do item desejado:");
            int inputID = input.nextInt();
            lista.stream().filter(id -> id.getID() == inputID).forEach(System.out::println);

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
