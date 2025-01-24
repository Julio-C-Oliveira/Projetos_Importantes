package Show;

public class CamaroteSuperior extends CamaroteInferior{
    private float valorAdicionalCamaroteSuperior;

    public CamaroteSuperior() {}
    public CamaroteSuperior(float valor, float valorAdicionalVip, String localizacao, float valorAdicionalCamaroteSuperior) {
        super(valor, valorAdicionalVip, localizacao);
        this.valorAdicionalCamaroteSuperior = valorAdicionalCamaroteSuperior;
    }

    public float getValorAdicionalCamaroteSuperior() { return valorAdicionalCamaroteSuperior; }
    public void setValorAdicionalCamaroteSuperior(float valorAdicionalCamaroteSuperior) { this.valorAdicionalCamaroteSuperior = valorAdicionalCamaroteSuperior; }

    public String imprimir_valor() { return "Valor do Ingresso: " + ( super.getValor() + super.getValorAdicional() + this.getValorAdicional()); }
    public String imprimir_localizacao() { return "\nLocalização do Camarote Superior: " + getLocalizacao();}
}
