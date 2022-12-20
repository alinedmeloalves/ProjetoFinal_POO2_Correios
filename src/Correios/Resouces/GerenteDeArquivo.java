package Correios.Resouces;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GerenteDeArquivo {
    private String caminhoArquivo = "src/Correios/BancoDeDados/";
    private String caminhoBackUp = "src/Correios/BackupDeDados/";


    public GerenteDeArquivo() {
    }

    public File getArquivoBanco(String nomeDoArquivo) {
        return Path.of(caminhoArquivo + nomeDoArquivo).toFile();
    }

    public void criarNovoArquivoBanco(String nomeDoArquivo) throws IOException {
        File novoArquivo = new File(caminhoArquivo + nomeDoArquivo);
        if(novoArquivo.createNewFile()){
            System.out.println("Arquivo criado com sucesso");
        }else {
            System.out.println("Arquivo não criado");
        }
    }

    public void apagarArquivoDeBanco(String nomeDoArquivo){
        Path path = Path.of(caminhoArquivo + nomeDoArquivo);
        File arquivo = path.toFile();
        if(arquivo.delete()){
            System.out.println("Arquivo deletado com sucesso");
        }else {
            System.out.println("Arquivo não deletado");
        }
    }

    public void fazerBackUpArquivoDeBanco(String nomeDoArquivo) throws IOException{
        Files.copy(Path.of(caminhoArquivo + nomeDoArquivo), Path.of(caminhoBackUp + nomeDoArquivo));
        if(Files.exists(Path.of(caminhoBackUp + nomeDoArquivo))){
            System.out.println("Backup feito com sucesso");
        } else {
            System.out.println("Backup não realizado");
        }
    }
}
