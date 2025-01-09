import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> acervo = new ArrayList<Livro>();

    public ArrayList<Livro> getAcervo() { return acervo; }
    public void setAcervo(ArrayList<Livro> acervo) { this.acervo = acervo; }

    public Biblioteca() {}

    public void adicionarLivro(String nome) { this.acervo.add(new Livro(nome, null, null)); }
    public void adicionarLivro(String nome, String autor) { this.acervo.add(new Livro(nome, autor, null)); }
    public void adicionarLivro(String nome, String autor, int ano) { this.acervo.add(new Livro(nome, autor, ano)); }
}
