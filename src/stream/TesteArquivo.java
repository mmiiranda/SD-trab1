package stream;

import modelo.Livro;
import java.io.*;

public class TesteArquivo {
    public static void main(String[] args) {
        Livro[] livros = {
            new Livro("Dom Casmurro", "Machado de Assis", 1899, "Livraria Garnier", 256),
            new Livro("1984", "George Orwell", 1949, "Secker & Warburg", 328),
            new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, "Allen & Unwin", 1178)
        };

        try (FileOutputStream fos = new FileOutputStream("data/livros.dat")) {
            
            LivroOutputStream out = new LivroOutputStream(livros,3,30, fos);
            
            out.enviarDados();
            System.out.println("Dados enviados conforme especificação!");
        } catch (IOException e){
            System.err.println("Erro: " + e.getMessage());
        }
    }
}