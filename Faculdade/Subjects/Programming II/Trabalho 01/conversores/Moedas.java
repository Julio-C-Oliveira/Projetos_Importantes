package conversores;

import java.util.Scanner;

public class Moedas {
    private final Scanner scanner = new Scanner(System.in);

    // Métodos de conversão de Real para outras moedas
    private float realToDolar(float valor) {
        return valor / 6.09f; // Taxa de câmbio fictícia: 1 Dólar = 6.09 Reais
    }

    private float realToEuro(float valor) {
        return valor / 6.33f; // Taxa de câmbio fictícia: 1 Euro = 6.33 Reais
    }

    private float realToLibra(float valor) {
        return valor / 7.66f; // Taxa de câmbio fictícia: 1 Libra = 7.66 Reais
    }

    // Métodos de conversão de Dólar para outras moedas
    private float dolarToReal(float valor) {
        return valor / 0.166f; // Taxa de câmbio fictícia: 1 Real = 0.166 Dólares
    }

    private float dolarToLibra(float valor) {
        return valor / 1.27f; // Taxa de câmbio fictícia: 1 Libra = 1.27 Dólares
    }

    private float dolarToEuro(float valor) {
        return valor / 1.05f; // Taxa de câmbio fictícia: 1 Euro = 1.05 Dólares
    }

    // Métodos de conversão de Euro para outras moedas
    private float euroToReal(float valor) {
        return valor / 0.16f; // Taxa de câmbio fictícia: 1 Real = 0.16 Euros
    }

    private float euroToDolar(float valor) {
        return valor / 0.95f; // Taxa de câmbio fictícia: 1 Dólar = 0.95 Euros
    }

    private float euroToLibra(float valor) {
        return valor / 1.21f; // Taxa de câmbio fictícia: 1 Libra = 1.21 Euros
    }

    // Métodos de conversão de Libra para outras moedas
    private float libraToReal(float valor) {
        return valor / 0.13f; // Taxa de câmbio fictícia: 1 Real = 0.13 Libras
    }

    private float libraToDolar(float valor) {
        return valor / 0.79f; // Taxa de câmbio fictícia: 1 Dólar = 0.79 Libras
    }

    private float libraToEuro(float valor) {
        return valor / 0.83f; // Taxa de câmbio fictícia: 1 Euro = 0.83 Libras
    }

    // Método principal para realizar as conversões de moedas
    public void conversor() {
        // Solicita ao usuário a quantidade de dinheiro que deseja converter
        System.out.println("Quanto você tem?");
        float qte = scanner.nextFloat();

        // Solicita ao usuário a moeda de origem
        System.out.println("Qual moeda você tem? ");
        System.out.println("1-Real\n2-Dólar\n3-Euro\n4-Libra");
        int moeda = scanner.nextInt();



        // Processa a conversão com base nas escolhas do usuário
        switch (moeda) {
            case 1: // Caso a moeda de origem seja Real
                // Solicita ao usuário a moeda de destino
                System.out.println("Você deseja converter para qual moeda?");
                System.out.println("1-Dólar\n2-Libra\n3-Euro");
                int convertida1 = scanner.nextInt();

                switch (convertida1) {
                    case 1:
                        System.out.println("Você receberá " + realToDolar(qte));
                        break;
                    case 2:
                        System.out.println("Você receberá " + realToLibra(qte));
                        break;
                    case 3:
                        System.out.println("Você receberá " + realToEuro(qte));
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
                break;

            case 2: // Caso a moeda de origem seja Dólar
                // Solicita ao usuário a moeda de destino
                System.out.println("Você deseja converter para qual moeda?");
                System.out.println("1-Libra\n2-Euro\n3-Real");
                int convertida2 = scanner.nextInt();

                switch (convertida2) {
                    case 1:
                        System.out.println("Você receberá " + dolarToReal(qte));
                        break;
                    case 2:
                        System.out.println("Você receberá " + dolarToLibra(qte));
                        break;
                    case 3:
                        System.out.println("Você receberá " + dolarToEuro(qte));
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
                break;
            case 3: // Caso a moeda de origem seja Euro
                // Solicita ao usuário a moeda de destino
                System.out.println("Você deseja converter para qual moeda?");
                System.out.println("1-Real\n2-Libra\n4-Dólar");
                int convertida3 = scanner.nextInt();

                switch (convertida3) {
                    case 1:
                        System.out.println("Você receberá " + euroToReal(qte));
                        break;
                    case 2:
                        System.out.println("Você receberá " + euroToLibra(qte));
                        break;
                    case 3:
                        System.out.println("Você receberá " + euroToDolar(qte));
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
                break;

            case 4: // Caso a moeda de origem seja Libra
                // Solicita ao usuário a moeda de destino
                System.out.println("Você deseja converter para qual moeda?");
                System.out.println("1-Real\n2-Dólar\n4-Euro");
                int convertida4 = scanner.nextInt();

                switch (convertida4) {
                    case 1:
                        System.out.println("Você receberá " + libraToReal(qte));
                        break;
                    case 2:
                        System.out.println("Você receberá " + libraToDolar(qte));
                        break;
                    case 3:
                        System.out.println("Você receberá " + libraToEuro(qte));
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
                break;

            default:
                // Caso a moeda de origem seja inválida
                System.out.println("Opção inválida.");
        }
    }
}
