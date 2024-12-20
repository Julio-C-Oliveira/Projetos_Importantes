package conversores;

import java.util.Scanner;

public class Temperaturas {
    private final Scanner scanner = new Scanner(System.in);

    // Converte Celsius para Fahrenheit
    private float celsiusToFahrenheit(float temp) {
        return (temp * 1.8f) + 32; // Fórmula: (C * 1.8) + 32
    }

    // Converte Celsius para Kelvin
    private float celsiusToKelvin(float temp) {
        return temp + 273.15f; // Fórmula: C + 273.15
    }

    // Converte Fahrenheit para Celsius
    private float fahrenheitToCelsius(float temp) {
        return (temp - 32) * 5 / 9; // Fórmula: (F - 32) * 5/9
    }

    // Converte Fahrenheit para Kelvin
    private float fahrenheitToKelvin(float temp) {
        return (temp - 32) * 5 / 9 + 273.15f; // Fórmula: (F - 32) * 5/9 + 273.15
    }

    // Converte Kelvin para Celsius
    private float kelvinToCelsius(float temp) {
        return temp - 273.15f; // Fórmula: K - 273.15
    }

    // Converte Kelvin para Fahrenheit
    private float kelvinToFahrenheit(float temp) {
        return (temp - 273.15f) * 1.8f + 32; // Fórmula: (K - 273.15) * 1.8 + 32
    }

    public void conversor() {
        // Solicita ao usuário a unidade de origem
        System.out.println("Qual temperatura você quer converter? ");
        System.out.println("1- Celsius\n2- Fahrenheit\n3- Kelvin");
        int caso = scanner.nextInt();

        // Solicita ao usuário a temperatura a ser convertida
        System.out.println("Quantos graus você quer converter? ");
        float temp = scanner.nextFloat();

        // Processa a conversão com base na unidade de origem
        switch (caso) {
            case 1: // Caso a unidade seja Celsius
                System.out.println("Para qual você quer converter? \n1- Fahrenheit\n2- Kelvin");
                int convertidaC = scanner.nextInt();
                if (convertidaC == 1) {
                    // Converte para Fahrenheit
                    System.out.println("A temperatura em Fahrenheit: " + celsiusToFahrenheit(temp));
                } else {
                    // Converte para Kelvin
                    System.out.println("A temperatura em Kelvin: " + celsiusToKelvin(temp));
                }
                break;

            case 2: // Caso a unidade seja Fahrenheit
                System.out.println("Para qual unidade você deseja converter? \n1- Celsius\n2- Kelvin");
                int convertidaF = scanner.nextInt();
                if (convertidaF == 1) {
                    // Converte para Celsius
                    System.out.println("A temperatura em Celsius: " + fahrenheitToCelsius(temp));
                } else {
                    // Converte para Kelvin
                    System.out.println("A temperatura em Kelvin: " + fahrenheitToKelvin(temp));
                }
                break;

            case 3: // Caso a unidade seja Kelvin
                System.out.println("Para qual unidade você quer converter? \n1- Celsius\n2- Fahrenheit");
                int convertidaK = scanner.nextInt();
                if (convertidaK == 1) {
                    // Converte para Celsius
                    System.out.println("A temperatura em Celsius: " + kelvinToCelsius(temp));
                } else {
                    // Converte para Fahrenheit
                    System.out.println("A temperatura em Fahrenheit: " + kelvinToFahrenheit(temp));
                }
                break;

            default:
                // Caso o usuário insira uma opção inválida
                System.out.println("Opção inválida.");
        }
    }
}
