package tcp_json;

import modelo.Livro;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class ClienteJSON {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 1899, "Livraria Garnier", 256);
            Gson gson = new Gson();
            String json = gson.toJson(livro);

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            writer.println(json); // envia JSON
            String resposta = reader.readLine(); // recebe resposta
            System.out.println("Resposta do servidor: " + resposta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
