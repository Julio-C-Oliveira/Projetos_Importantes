package Animais;

public class Peixe extends Animal {
    private String caracteristicas;

    public Peixe() {}
    public Peixe(String nome, float comprimento, int numDePatas, String cor, String ambiente, float velocidade) {
        super(nome, comprimento, numDePatas, cor, ambiente, velocidade);
    }
    public Peixe(String nome, float comprimento, int numDePatas, String cor, String ambiente, float velocidade, String caracteristicas) {
        super(nome, comprimento, numDePatas, cor, ambiente, velocidade);
        this.caracteristicas = caracteristicas;
    }

    public String getCaracteristicas() { return caracteristicas; }
    public void setCaracteristicas(String caracteristicas) { this.caracteristicas = caracteristicas; }

    public String toString() {
        return String.format("%s\nCaracteristica: %s", super.toString(), getCaracteristicas());
    }
}
