package Show;

public class Ingresso {
    private float valor;

    public Ingresso() {}
    public Ingresso(float valor) { this.valor = valor; }

    public float getValor() { return valor; }
    public void setValor(float valor) { this.valor = valor; }

    public String imprimir_valor() { return "\nValor do Ingresso Normal: " + getValor(); }
}
