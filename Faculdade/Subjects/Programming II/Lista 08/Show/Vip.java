package Show;

public class Vip extends Ingresso{
    private float valorAdicional;

    public Vip() {}
    public Vip(float valor, float valorAdicionalVip) {
        super(valor);
        this.valorAdicional = valorAdicionalVip;
    }

    public float getValorAdicional() { return valorAdicional; }
    public void setValorAdicional(float valorAdicional) { this.valorAdicional = valorAdicional; }

    public String imprimir_valor() { return "Valor do Ingresso: " + ( getValor() + getValorAdicional()); }
}
