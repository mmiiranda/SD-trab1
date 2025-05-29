package tcp_json;

import modelo.Livro;
import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorJSON {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Servidor esperando conexão...");

            Socket cliente = server.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter writer = new PrintWriter(cliente.getOutputStream(), true);
            Gson gson = new Gson();

            String json = reader.readLine();
            Livro recebido = gson.fromJson(json, Livro.class);

            System.out.println("Livro recebido:");
            System.out.println(recebido);

            writer.println("{\"status\": \"OK\", \"mensagem\": \"Livro recebido com sucesso!\"}");

            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
