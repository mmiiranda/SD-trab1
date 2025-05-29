package modelo;
import modelo.GestaoDeBiblioteca;
import java.util.ArrayList;


import java.util.List;

public interface GestaoDeBiblioteca {
    void adicionarPublicacao(Publicacao p);
    void removerPublicacao(Publicacao p);
    List<Publicacao> buscarPorTitulo(String titulo);
    List<Publicacao> listarPublicacoes();
}
