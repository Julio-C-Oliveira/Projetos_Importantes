package calculadoraVJ;

import java.util.Scanner;

// Classe criada para conter algumas funções que não se enquadram nas outras.
public class Utilitarios {
    public Utilitarios() {}

    // Recebe uma lista de strings e verifica se todas podem ser convertidas para double.
    public static boolean validarListaDouble(String[] entradas) {
        int contador = 0;
        for (String entrada : entradas) {
            try {
                Double.parseDouble(entrada);
                contador++;
            } catch (NumberFormatException _) {}
        }
        return contador == entradas.length;
    }
    // Recebe uma entrada do usuário e verifica se a entrada é valida e pode ser convertida para double.
    public static Double[] receberEValidarMultiplasEntradasDouble(Scanner scanner) {
        Double[] valores;
        while (true) {
            System.out.print("Insira os números separados por vírgula [,].\nPara números decimais utilize o [.] para separar a parte inteira da imaginária: ");
            String[] entradas = scanner.nextLine().split(",");
            valores = new Double[entradas.length];

            if (Utilitarios.validarListaDouble(entradas)) {
                for (int i = 0; i < entradas.length; i++) {
                    valores[i] = Double.parseDouble(entradas[i]);
                }
                break;
            }
        }
        return valores;
    }
    // Recebe uma entrada do usuário, divide as senteças e verifica se todas as entradas podem ser convertidas para int.
    public static int[] receberEValidarMultiplasEntradasInt(Scanner scanner) {
        int[] valores;
        while (true) {
            System.out.print("Insira os números separados por vírgula [,]: ");
            String[] entradas = scanner.nextLine().split(",");
            valores = new int[entradas.length];

            if (Utilitarios.validarListaDouble(entradas)) {
                for (int i = 0; i < entradas.length; i++) {
                    valores[i] = Integer.parseInt(entradas[i]);
                }
                break;
            }
        }
        return valores;
    }
    // Recebe uma entrada do usuário e verifica se a entrada é valida e pode ser convertida para short.
    public static short validarSeAEntradaEUmShort(Scanner scanner, String texto) {
        short opcaoInShort = 999;
        while (true) {
            System.out.print(texto);
            String opcaoInString = scanner.nextLine();
            try {
                opcaoInShort = Short.parseShort(opcaoInString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Não foi inserido um numeral.");
            }
        }
        return opcaoInShort;
    }
    // Recebe uma entrada do usuário e verifica se a entrada é valida e pode ser convertida para int.
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
    // Recebe uma entrada do usuário e verifica se a entrada é valida e pode ser convertida para double.
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
    // Recebe uma entrada do usuário, pega somente a primeira letra e a transforma em maiusculo.
    public static char pegarPrimeiraLetraEmUppercaseDaEntrada(Scanner scanner) {
        System.out.print("Encerrar? Sim ou Não [S/N]: ");
        String opcaoEncerrar = scanner.nextLine();
        opcaoEncerrar = opcaoEncerrar.toUpperCase();
        return opcaoEncerrar.substring(0, 1).charAt(0);
    }
}
