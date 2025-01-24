package Animais;

public class Animal {
    private String nome;
    private float comprimento;
    private int numDePatas;
    private String cor;
    private String ambiente;
    private float velocidade;

    public Animal() {}

    public Animal(String nome, float comprimento, int numDePatas, String cor, String ambiente, float velocidade) {
        this.nome = nome;
        this.comprimento = comprimento;
        this.numDePatas = numDePatas;
        this.cor = cor;
        this.ambiente = ambiente;
        this.velocidade = velocidade;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public float getComprimento() { return comprimento; }
    public void setComprimento(float comprimento) { this.comprimento = comprimento; }
    public int getNumDePatas() { return numDePatas; }
    public void setNumDePatas(int numDePatas) { this.numDePatas = numDePatas; }
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public String getAmbiente() { return ambiente; }
    public void setAmbiente(String ambiente) { this.ambiente = ambiente; }
    public float getVelocidade() { return velocidade; }
    public void setVelocidade(float velocidade) { this.velocidade = velocidade; }

    public String toString() {
        return String.format("Animais.Animal: %s\nComprimento: %.2fm\nPatas: %d\nCor: %s\nAmbiente: %s\nVelocidade: %.2fm/s", getNome(), getComprimento(), getNumDePatas(), getCor(), getAmbiente(), getVelocidade());
    }
}
