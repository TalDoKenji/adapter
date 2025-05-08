package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PessoaCsvAdapter implements RepositorioDePessoa {

    private final String caminhoArquivo;

    public PessoaCsvAdapter(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    @Override
    public List<Pessoa> listarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            boolean isFirstLine = true;

            while ((linha = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] partes = linha.split(",");
                if (partes.length >= 3) {
                    String nome = partes[0].trim();
                    int idade = Integer.parseInt(partes[1].trim());
                    String email = partes[2].trim();

                    pessoas.add(new Pessoa(nome, idade, email));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return pessoas;
    }
}