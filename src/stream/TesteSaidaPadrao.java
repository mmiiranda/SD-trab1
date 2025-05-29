package stream;


import modelo.Livro;
import java.io.*;

import java.io.IOException;

public class TesteSaidaPadrao {
    public static void main(String[] args) {
        Livro[] livros = {
            new Livro("Dom Casmurro", "Machado de Assis", 1899, "Livraria Garnier", 256),
            new Livro("1984", "George Orwell", 1949, "Secker & Warburg", 328),
            new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, "Allen & Unwin", 1178)
        };

        try {
            System.out.println("=== TESTE SAÍDA PADRÃO (System.out) ===");
            LivroOutputStream out = new LivroOutputStream(livros, 3, 30, System.out);
            out.enviarDados();
        } catch (IOException e) {
            System.err.println("Erro ao enviar dados: " + e.getMessage());
        }
    }
}