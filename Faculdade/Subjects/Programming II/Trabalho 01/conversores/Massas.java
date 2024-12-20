package conversores;

import java.util.Scanner;

public class Massas {
    private final Scanner scanner = new Scanner(System.in);

    // Converte quilogramas (kg) para gramas (g)
    private float kgToG(float m) {
        return m / 0.001f; // 1 kg é equivalente a 1000 g
    }

    // Converte quilogramas (kg) para libras (lb)
    private float kgToLb(float m) {
        return m * 2.20f; // 1 kg é aproximadamente 2.20 lb
    }

    // Converte gramas (g) para quilogramas (kg)
    private float gToKg(float m) {
        return m / 1000f; // 1000 g é equivalente a 1 kg
    }

    // Converte gramas (g) para libras (lb)
    private float gToLb(float m) {
        return m / 453.59f; // 1 lb é aproximadamente 453.59 g
    }

    // Converte libras (lb) para quilogramas (kg)
    private float lbToKg(float m) {
        return m / 2.20f; // 1 lb é aproximadamente 0.45 kg (1/2.20)
    }

    // Converte libras (lb) para gramas (g)
    private float lbToG(float m) {
        return m * 453.59f; // 1 lb é aproximadamente 453.59 g
    }

    // Metodo principal para realizar a conversão de massas
    public void conversor() {
        System.out.println("Qual unidade você quer converter?\n" +
                "1- Gramas\n" +
                "2- Kg\n" +
                "3- lb");
        int unidade = scanner.nextInt(); // Lê a unidade de entrada do usuário

        System.out.println("Quanto você deseja converter?");
        float qte = scanner.nextFloat(); // Lê a quantidade a ser convertida

        // Realiza a conversão com base na unidade selecionada
        switch (unidade) {
            case 1: // Caso o usuário escolha gramas
                System.out.println("A massa em kg é: " + gToKg(qte)); // Converte de g para kg
                System.out.println("A massa em lb é: " + gToLb(qte)); // Converte de g para lb
                break;

            case 2: // Caso o usuário escolha quilogramas
                System.out.println("A massa em g é: " + kgToG(qte)); // Converte de kg para g
                System.out.println("A massa em lb é: " + kgToLb(qte)); // Converte de kg para lb
                break;

            case 3: // Caso o usuário escolha libras
                System.out.println("A massa em g é: " + lbToG(qte)); // Converte de lb para g
                System.out.println("A massa em kg é: " + lbToKg(qte)); // Converte de lb para kg
                break;

            default:
                // Caso o usuário insira uma opção inválida
                System.out.println("Opção inválida.");
        }
    }
}
