import java.util.ArrayList;
import java.util.Scanner;

public class Utilitarios {
    public Utilitarios() {}

    public static int validarSeAEntradaEUmInt(Scanner scanner, String texto) {
        int opcaoInInt = 999;
        while (true) {
            System.out.print(texto);
            String opcaoInString = scanner.nextLine();
            try {
                opcaoInInt = Integer.parseInt(opcaoInString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Não foi inserido um numeral.");
            }
        }
        return opcaoInInt;
    }

    public static Double validarSeAEntradaEUmDouble(Scanner scanner, String texto) {
        Double opcaoInDouble = 999.0;
        while (true) {
            System.out.print(texto);
            String opcaoInString = scanner.nextLine();
            try {
                opcaoInDouble = Double.parseDouble(opcaoInString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Não foi inserido um numeral.");
            }
        }
        return opcaoInDouble;
    }

    public static char validarSeAEntradaEUmaOperacaoBasica(Scanner scanner, String texto) {
        char operador = ' ';
        while (true) {
            System.out.print(texto);
            String opcaoInString = scanner.nextLine();
            opcaoInString = opcaoInString.trim();
            operador = opcaoInString.substring(0, 1).charAt(0);

            if (operador == '+' || operador == '-' || operador == '*' || operador == '/') return operador;
        }
    }

    public static void exibirAcervo(ArrayList<Livro> acervo) {
        for (Livro livro : acervo) {
            System.out.printf("Titulo: %s, Autor: %s, Ano de Publicação: %s\n", livro.getTitulo(), livro.getAutor(), livro.getAnoDePublicacao());
        }
        System.out.println();
    }
}