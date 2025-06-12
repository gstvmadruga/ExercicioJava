package model;

import java.io.*;

public class TextoModel {
    private final String nomeArquivo = "texto.txt";

    public void gravarTexto(String texto) throws IOException {
        FileWriter fileWriter = new FileWriter(nomeArquivo);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(texto);
        bufferedWriter.close();
    }

    public String lerTexto() throws IOException {
        FileReader fileReader = new FileReader(nomeArquivo);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder conteudo = new StringBuilder();
        String linha;

        while ((linha = bufferedReader.readLine()) != null) {
            conteudo.append(linha).append("\n");
        }

        bufferedReader.close();

        return conteudo.toString();
    }
}
