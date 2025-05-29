import java.util.ArrayList;
import java.util.List;

public class Biblioteca implements GestaoDeBiblioteca {
    private String nome;
    private List<Publicacao> acervo;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.acervo = new ArrayList<>();
    }

    @Override
    public void adicionarPublicacao(Publicacao p) {
        acervo.add(p);
    }

    @Override
    public void removerPublicacao(Publicacao p) {
        acervo.remove(p);
    }

    @Override
    public List<Publicacao> buscarPorTitulo(String titulo) {
        List<Publicacao> encontrados = new ArrayList<>();
        for (Publicacao p : acervo) {
            if (p.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }

    @Override
    public List<Publicacao> listarPublicacoes() {
        return acervo;
    }

    public String getNome() {
        return nome;
    }
}