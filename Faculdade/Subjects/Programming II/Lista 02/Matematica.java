public class Matematica {
    public Matematica() { }

    private static double fatorial(int numero){
        if (numero > 0) {
            double resultado = 1;
            for (int i = 1; i <= numero; i++) resultado *= i;
            return resultado;
        }
        else if (numero == 0) return 1.0;
        else return 0.0;
    }

    public static Double calcularOperacoesBasicas(Double primeiroNumero, Double segundoNumero, char operador) {
        return switch (operador) {
            case '+' -> primeiroNumero + segundoNumero;
            case '-' -> primeiroNumero - segundoNumero;
            case '*' -> primeiroNumero * segundoNumero;
            case '/' -> primeiroNumero / segundoNumero;
            default -> null;
        };
    }
    public static Double calcularConstante(int numeroDeTermos) {
        double constante = 0.0;
        for (int i = 0; i <= numeroDeTermos; i++) {
            constante += 1.0/fatorial(i);
        }
        return constante;
    }
}
