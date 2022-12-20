package Correios.Resouces;

import Correios.Interfaces.Cadastravel;
import Correios.Interfaces.Identificavel;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class GerenteDeDados {
    public GerenteDeArquivo gerenteDeArquivo = new GerenteDeArquivo();

    public void cadastrarObjeto(List<Identificavel> lista, Identificavel objeto, String nomeDoArquivo) {
        File file = gerenteDeArquivo.getArquivoBanco(nomeDoArquivo);
        lista.add(objeto);
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
           for(Identificavel item : lista) {
            out.writeObject(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        carregarDados(lista, nomeDoArquivo);
    }

    public void carregarDados(List<Identificavel> lista, String nomeDoArquivo) {
        lista.clear();
        File file = gerenteDeArquivo.getArquivoBanco(nomeDoArquivo);
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            while (file.length() != 0) {
                Object objeto = in.readObject();
                if (objeto instanceof Identificavel) {
                    lista.add((Identificavel) objeto);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarObjeto(List<Identificavel> lista, String nomeDoArquivo) {
        File file = gerenteDeArquivo.getArquivoBanco(nomeDoArquivo);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o ID do item:");
        int inputID = scanner.nextInt();
        lista.stream().filter(item -> item.getID() == inputID).
                forEach(item -> {
                    lista.remove(item);
                });
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
            for(Identificavel item : lista) {
                out.writeObject(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        carregarDados(lista, nomeDoArquivo);
    }

    public void editarObjeto(Cadastravel cadastro, List<Identificavel> lista, List<Identificavel> lista1,
                             List<Identificavel> lista2, String nomeDoArquivo) {
        File file = gerenteDeArquivo.getArquivoBanco(nomeDoArquivo);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o ID do item:");
        int inputID = scanner.nextInt();
        lista.stream().filter(item -> item.getID() == inputID).
                forEach(item -> {
                    lista.remove(item);
                    try {
                        cadastro.cadastra(lista, lista1, lista2, nomeDoArquivo);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
            for(Identificavel item : lista) {
                out.writeObject(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        carregarDados(lista, nomeDoArquivo);
    }
}
