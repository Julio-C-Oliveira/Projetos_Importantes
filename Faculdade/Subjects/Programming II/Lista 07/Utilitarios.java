import java.util.Scanner;

public class Utilitarios {
    public Utilitarios() {}

    // Recebe uma entrada do usuário e verifica se a entrada é valida e pode ser convertida para int.
    public static int validarSeAEntradaEUmInt(Scanner scanner, String texto) {
        int opcaoInInt = Integer.MAX_VALUE;
        while (true) {
            System.out.print(texto);
            String opcaoInString = scanner.nextLine();
            try {
                opcaoInInt = Integer.parseInt(opcaoInString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("O valor inserido não pode ser convertido para int");
            }
        }
        return opcaoInInt;
    }

    public static int validarSeAEntradaEUmIntEEstaEmUmIntervalo(Scanner scanner, String texto, int inicio, int fim) {
        int opcaoInInt = Integer.MAX_VALUE;
        while (true) {
            System.out.print(texto);
            String opcaoInString = scanner.nextLine();
            try {
                opcaoInInt = Integer.parseInt(opcaoInString);
            } catch (NumberFormatException e) {
                System.out.println("O valor inserido não pode ser convertido para int");
            }
            if (opcaoInInt >= inicio && opcaoInInt <= fim) break;
            else System.out.println("O valor inserido está fora do intervalo do vetor");
        }

        return opcaoInInt;
    }
}
