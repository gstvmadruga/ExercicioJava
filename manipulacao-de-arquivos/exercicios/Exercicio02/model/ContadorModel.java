package model;

import java.io.*;

public class ContadorPalavrasModel {
    private final String nomeArquivo = "dados.txt";

    public int contarPalavras() throws IOException {
        FileReader fileReader = new FileReader(nomeArquivo);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int totalPalavras = 0;
        String linha;

        while ((linha = bufferedReader.readLine()) != null) {
            String[] palavras = linha.trim().split("\\s+");
            totalPalavras += palavras.length;
        }

        bufferedReader.close();
        return totalPalavras;
    }
}
