public class Matematica {
    public Matematica() {}

    public static long produto(int... numeros) {
        long resultado = 1;
        for (int numero : numeros) {
            resultado *= numero;
        }
        return resultado;
    }
}
