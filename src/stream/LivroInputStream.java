package stream;

import modelo.Livro;

import java.io.*;

public class LivroInputStream extends InputStream {
    private final DataInputStream dis;
    private final int bytesPorAtributo;

    public LivroInputStream(InputStream origem, int bytesPorAtributo) {
        this.dis = new DataInputStream(origem);
        this.bytesPorAtributo = bytesPorAtributo;
    }

    @Override
    public int read() throws IOException {
        // não usado diretamente, mas precisa implementar
        return dis.read();
    }

    public Livro[] lerLivros() throws IOException {
        int qtd = dis.readInt();
        Livro[] livros = new Livro[qtd];

        for (int i = 0; i < qtd; i++) {
            String titulo = lerStringFixa(dis, bytesPorAtributo);
            String autor = lerStringFixa(dis, bytesPorAtributo);
            String editora = lerStringFixa(dis, bytesPorAtributo);
            int ano = dis.readInt();
            int paginas = dis.readInt();

            livros[i] = new Livro(titulo.trim(), autor.trim(), ano, editora.trim(), paginas);
        }

        return livros;
    }

    private String lerStringFixa(DataInputStream dis, int tamanho) throws IOException {
        byte[] buffer = new byte[tamanho];
        dis.readFully(buffer);
        return new String(buffer, "UTF-8");
    }
}
