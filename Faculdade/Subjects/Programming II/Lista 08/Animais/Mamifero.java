package Animais;

public class Mamifero extends Animal {
    private String alimento;

    public Mamifero() {}
    public Mamifero(String nome, float comprimento, int numDePatas, String cor, String ambiente, float velocidade) {
        super(nome, comprimento, numDePatas, cor, ambiente, velocidade);
    }
    public Mamifero(String nome, float comprimento, int numDePatas, String cor, String ambiente, float velocidade, String alimento) {
        super(nome, comprimento, numDePatas, cor, ambiente, velocidade);
        this.alimento = alimento;
    }

    public String getAlimento() { return alimento; }
    public void setAlimento(String alimento) { this.alimento = alimento; }

    public String toString() {
        return String.format("%s\nAlimento: %s", super.toString(), getAlimento());
    }
}
