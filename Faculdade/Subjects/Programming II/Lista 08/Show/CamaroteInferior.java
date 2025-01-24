package Show;

public class CamaroteInferior extends Vip {
    private String localizacao;

    public CamaroteInferior() {}
    public CamaroteInferior(float valor, float valorAdicionalVip, String localizacao) {
        super(valor, valorAdicionalVip);
        this.localizacao = localizacao;
    }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public String imprimir_localizacao() { return "\nLocalização do Camarote Inferior: " + getLocalizacao();}
}
