package modelo;

import java.io.Serializable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.DataOutputStream;


public class Livro extends Publicacao {
    private String editora;
    private int numeroPaginas;

    public Livro(String titulo, String autor, int anoPublicacao, String editora, int numeroPaginas) {
        super(titulo, autor, anoPublicacao);
        this.editora = editora;
        this.numeroPaginas = numeroPaginas;
    }

    public String getEditora() { return editora; }
    public void setEditora(String editora) { this.editora = editora; }

    public int getNumeroPaginas() { return numeroPaginas; }
    public void setNumeroPaginas(int numeroPaginas) { this.numeroPaginas = numeroPaginas; }

    @Override
    public String toString() {
        return super.toString() + ", Editora: " + editora + ", Nº Páginas: " + numeroPaginas;
    }
}
