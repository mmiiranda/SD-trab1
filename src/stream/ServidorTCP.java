package stream;

import modelo.Livro;
import stream.LivroInputStream;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class ServidorTCP {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("=== SERVIDOR TCP (Porta 12345) ===");
            System.out.println("Aguardando conexão...");

            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado!");

            LivroInputStream in = new LivroInputStream(socket.getInputStream(), 40);
            Livro[] livros = in.lerLivros();

            System.out.println("=== LIVROS RECEBIDOS ===");
            for (int i = 0; i < livros.length; i++) {
                System.out.println("\nLivro " + (i + 1) + ":");
                System.out.println(livros[i]); 
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
