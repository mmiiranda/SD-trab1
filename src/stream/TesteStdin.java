package stream;

import modelo.Livro;
import java.io.*;

public class TesteStdin {
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando leitura do System.in...");

            LivroInputStream in = new LivroInputStream(System.in, 30);

            Livro[] livros = in.lerLivros();

            System.out.println("=== LIVROS LIDOS ===");
            for (Livro l : livros) {
                System.out.println(l);
            }

        } catch (IOException e) {
            e.printStackTrace(); // 👈 isso mostra a causa real (stacktrace)
            System.err.println("Erro ao ler do System.in: " + e.getMessage());
        }
    }
}
