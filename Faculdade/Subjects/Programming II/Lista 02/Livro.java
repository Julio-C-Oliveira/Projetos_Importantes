public class Livro {
    private String titulo;
    private String autor;
    private Integer anoDePublicacao;

    public Livro(String titulo, String autor, Integer anoDePublicacao) {
        setTitulo(titulo);
        setAutor(autor);
        setAnoDePublicacao(anoDePublicacao);
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public Integer getAnoDePublicacao() { return anoDePublicacao; }
    public void setAnoDePublicacao(Integer anoDePublicacao) { this.anoDePublicacao = anoDePublicacao; }
}
