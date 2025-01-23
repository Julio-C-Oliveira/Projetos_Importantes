import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ContaExcecao {
        // Questão 01:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Preencha 3 valores no array na posição desejada.");
        String[] posicao = {"primeira", "segunda", "terceira"};
        int[] valores = new int[3];

        String texto1;
        String texto2;
        for (String i : posicao) {
            texto1 = "Diga a " + i + " posição: ";
            int idx = Utilitarios.validarSeAEntradaEUmIntEEstaEmUmIntervalo(scanner, texto1, 0, valores.length-1);
            texto2 = "Diga o valor da posição " + idx + ": ";
            int val = Utilitarios.validarSeAEntradaEUmInt(scanner, texto2);
            valores[idx] = val;
        }
        System.out.print("Os 3 valores são: ");
        for (int v : valores)
            System.out.print(v + " ");
        scanner.close();

        // Questão 02:
        Conta c = new Conta();
        c.deposito(100.0);
        c.setLimite(50.0);
        c.saque(110.0);
    }
}