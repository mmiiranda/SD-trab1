package stream;

import modelo.Livro;
import java.io.*;

public class TesteArquivoLeitura {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("livros.dat")) {
            LivroInputStream in = new LivroInputStream(fis, 30);
            Livro[] livros = in.lerLivros();

            for (Livro l : livros) {
                System.out.println(l);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler do arquivo: " + e.getMessage());
        }
    }
}
