import java.util.ArrayList;

public class Utilitarios {
    public Utilitarios() {}

    // Métodos:
    public static int retornarMaiorNumero(int numeroA, int numeroB) { return (numeroA > numeroB) ? numeroA : numeroB; };

    public static ArrayList<Integer> retornaDeAlgumNumeroAteZero(int numero) {
         ArrayList<Integer> antecessores = new ArrayList<Integer>();

         for (int i = numero; i >= 0; i--) antecessores.add(i);

         return antecessores;
    }

    public static ArrayList<Object> somaImparEMultiplicaPar(int inicio, int fim) {
        ArrayList<Object> resultados = new ArrayList<Object>();
        int soma = 0;
        long multiplicacao = 1;

        for (int i = inicio; i <= fim; i++) {
            if (i % 2 == 0) multiplicacao *= i;
            else soma += i;
        }

        resultados.add(soma);
        resultados.add(multiplicacao);

        return resultados;
    }

}
