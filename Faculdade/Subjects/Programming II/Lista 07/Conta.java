public class Conta {
    private Double saldo = 0.0;
    private Double limite = 0.0;

    public Conta() {}
    public Conta(Double saldo) { this.saldo = saldo; }
    public Conta(Double saldo, Double limite) { this.saldo = saldo; this.limite = limite; }

    public Double getSaldo() { return saldo; }
    public void setSaldo(Double saldo) { this.saldo = saldo; }
    public Double getLimite() { return limite; }
    public void setLimite(Double limite) { this.limite = limite; }

    public void deposito(Double valor) {
        setSaldo(getSaldo()+valor);
    }
    public void saque(Double valor) throws ContaExcecao {
        if (getSaldo() < valor) {
            throw new ContaExcecao("Saldo insuficiente para o saque.");
        }
        if (getSaldo() < getLimite()) {
            throw new ContaExcecao("Valor de saque superior ao limite pré-definido.");
        }
        setSaldo(getSaldo()-valor);
    }
}
