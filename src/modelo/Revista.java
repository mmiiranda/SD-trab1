package modelo;
import  modelo.GestaoDeBiblioteca;
import java.util.ArrayList;
import java.util.List;  

public class Revista extends Publicacao {
    private int numeroEdicao;
    private String periodicidade;

    public Revista(String titulo, String autor, int anoPublicacao, int numeroEdicao, String periodicidade) {
        super(titulo, autor, anoPublicacao);
        this.numeroEdicao = numeroEdicao;
        this.periodicidade = periodicidade;
    }

    public int getNumeroEdicao() { return numeroEdicao; }
    public void setNumeroEdicao(int numeroEdicao) { this.numeroEdicao = numeroEdicao; }

    public String getPeriodicidade() { return periodicidade; }
    public void setPeriodicidade(String periodicidade) { this.periodicidade = periodicidade; }

    @Override
    public String toString() {
        return super.toString() + ", Nº Edição: " + numeroEdicao + ", Periodicidade: " + periodicidade;
    }
}
