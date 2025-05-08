package org.example;

import java.util.List;

public class ClasseTeste  {
    public static void main(String[] args) {
        RepositorioDePessoa repositorio = new PessoaCsvAdapter("C:/Users/vinic/Downloads/pessoas.csv");
        List<Pessoa> pessoas = repositorio.listarPessoas();

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
}