package polinomio;

import java.util.Scanner;

public class Polinomio {
    private final Scanner scanner = new Scanner(System.in); // Scanner para entrada de dados do usuário

    // Método para calcular as raízes de uma equação quadrática
    public void calcularRaizes() {
        System.out.print("Considerando o formato ax² + bx + c\n");

        // Solicita ao usuário o valor do coeficiente 'a'
        System.out.print("Qual o valor de a? \n");
        double a = scanner.nextDouble();

        // Solicita ao usuário o valor do coeficiente 'b'
        System.out.print("Qual o valor de b? \n");
        double b = scanner.nextDouble();

        // Solicita ao usuário o valor do coeficiente 'c'
        System.out.print("Qual o valor de c? \n");
        double c = scanner.nextDouble();

        // Calcula o discriminante (delta) da equação quadrática
        double delta = Math.pow(b, 2) - (4 * a * c);

        // Verifica se as raízes são reais ou complexas
        if (delta < 0) {
            // Quando delta é negativo, as raízes são complexas
            System.out.println("As raízes são complexas e não podem ser calculadas.");
        } else {
            // Quando delta é não negativo, as raízes podem ser calculadas
            delta = Math.sqrt(delta); // Calcula a raiz quadrada de delta
            double x1 = (-b + delta) / (2 * a); // Calcula a primeira raiz
            // Variáveis para os coeficientes e raízes da equação
            double x2 = (-b - delta) / (2 * a); // Calcula a segunda raiz

            // Exibe as raízes
            System.out.println("x1: " + x1);
            System.out.println("x2: " + x2);
        }
    }
}
