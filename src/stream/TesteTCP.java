package stream;

import modelo.Livro;
import java.io.*;
import java.net.Socket;

public class TesteTCP {
    public static void main(String[] args) {
        Livro[] livros = {
            new Livro("Dom Casmurro", "Machado de Assis", 1899, "Livraria Garnier", 256),
            new Livro("1984", "George Orwell", 1949, "Secker & Warburg", 328),
            new Livro("O Senhor dos Aneis", "J.R.R. Tolkien", 1954, "Allen & Unwin", 1178)
        };

        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("=== TESTE TCP (Cliente) ===");

            LivroOutputStream out = new LivroOutputStream(livros, livros.length, 40, socket.getOutputStream());
            out.enviarDados();

            socket.shutdownOutput(); 

            System.out.println("Dados enviados para o servidor TCP!");
        } catch (IOException e) {
            System.err.println("Erro TCP: " + e.getMessage());
            System.err.println("Certifique-se de que o servidor está rodando na porta 12345.");
        }
    }
}
