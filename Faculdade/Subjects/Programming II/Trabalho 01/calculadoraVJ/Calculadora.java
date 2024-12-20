package calculadoraVJ;

import java.util.Scanner;

// Classe criada para armazenar as funções relacionadas a calculadora.
public class Calculadora {
    public Calculadora() {}

    // Função utilizada para fazer a adição de vários números.
    private Double adicao(Double[] numeros) {
        Double soma = 0.0;
        for (Double numero : numeros) soma += numero;
        return soma;
    }
    // Função utilizada para fazer a subtração entre dois números.
    private Double subtrair(Double numero1, Double numero2){ return numero1 - numero2; }
    // Função utilizada para multiplicar vários números.
    private Double multiplicacao(Double[] numeros){
        Double multiplicacao = 1.0;
        for (Double numero : numeros) multiplicacao *= numero;
        return multiplicacao;
    }
    // Função utilizada para fazer a divisão entre dois números.
    private Double divisao(Double numero1, Double numero2){ return numero1 / numero2; }
    // Função utilizada para fazer a exponenciação.
    private Double exponenciacao(Double base, Double expoente){
        Double resultado = 1.0;
        for (int i = 0; i < expoente; i++) {
            resultado *= base;
        }
        return resultado;
    }
    // Função utilizada para realizar a divisão entre dois inteiros e retornar um número inteiro.
    private int divisaoInteira(int numero1, int numero2){ return numero1 / numero2; }
    // Função para retornar o resto entre a divisão de dois números.
    private int resto(int numero1, int numero2){ return numero1 % numero2; }
    // Função para obter o fatorial de um número.
    private long fatorial(int numero){
        long resultado = 1;
        for (int i = 1; i <= numero; i++) resultado *= i;
        return resultado;
    }
    // Função para realizar o cálculo do arranjo entre um total e os números escolhidos.
    private long arranjo(int total, int escolhidos){
        long resultado = 1;
        for (int i = total-escolhidos+1; i <= total; i++) {
            resultado *= i;
        }
        return resultado;
    }
    // Função para realizar a permutação entre um total e alguns números repetidos.
    private long permutacao(int total, int[] repeticoes){
        long resultado = fatorial(total);
        for (int rep : repeticoes) {
            resultado /= fatorial(rep);
        }
        return resultado;
    }
    // Função para retornar o piso que é o menor número inteiro mais próximo do valor atual.
    private int piso(Double numero){ return (int) numero.doubleValue(); }
    // Função para retornar o teto que é o maior número inteiro mais próximo do valor atual.
    private int teto(Double numero){
        int valorInteiro = (int) numero.doubleValue();
        double valorImaginario = numero - valorInteiro;
        if (valorImaginario == 0.0) return (int) numero.doubleValue();
        else return (int) numero.doubleValue() + 1;
    }
    // Função utilizada para calcular raizes.
    private Double raiz(Double base, Double expoente){
        if (expoente <= 0) {
            return null;
        }
        else return Math.pow(base, (1/expoente));
    }
    // Função utilizada para verificar se um número é primo ou não.
    private boolean validarNumeroPrimo(int numero){
        if (numero == 0 || numero == 1 || numero == -1) return false;
        numero = (numero < 0) ? numero*-1 : numero;
        if(raiz((double) numero, 2.0) == null) return false;
        else {
            double raiz = raiz((double) numero, 2.0);
            for (int i = 2; i <= raiz; i++) if (numero % i == 0) return false;
        }
        return true;
    }
    // Função utilizada para verificar se um número é um quadrado perfeito ou não.
    private boolean validarQuadradoPerfeito(int numero){
        if (raiz((double) numero, 2.0) == null) return false;
        else {
            double raiz = raiz((double) numero, 2.0);
            return raiz * raiz == numero;
        }
    }

    // Função utilizada para rodar a calculadora.
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        boolean estado = true;
        final String opcoes = """
                    [1] - Adição.
                    [2] - Subtração.
                    [3] - Multiplicação.
                    [4] - Divisão.
                    [5] - Exponeneciação.
                    [6] - Divisão Inteira.
                    [7] - Resto da Divisão.
                    [8] - Fatorial e Permutação Simples.
                    [9] - Arranjos.
                    [10] - Permutação Composta.
                    [11] - Piso.
                    [12] - Teto.
                    [13] - Raízes de Grau n.
                    [14] - Validador de Número Primo.
                    [15] - Validador de Quadrado Perfeito.""";
        while (estado){
            System.out.println(opcoes);
            Calculadora calculadora = new Calculadora();
            short opcaoInShort = Utilitarios.validarSeAEntradaEUmShort(scanner, "Insira sua opção: ");
            switch (opcaoInShort) {
                case 1:
                    Double[] numerosAdicao = Utilitarios.receberEValidarMultiplasEntradasDouble(scanner);
                    System.out.println("Resultado: " + calculadora.adicao(numerosAdicao));
                    break;
                case 2:
                    Double numero1Sub = Utilitarios.validarSeAEntradaEUmDouble(scanner, "Insira o primeiro número: ");
                    Double numero2Sub = Utilitarios.validarSeAEntradaEUmDouble(scanner, "Insira o segundo número: ");
                    System.out.println("Resultado: " + calculadora.subtrair(numero1Sub, numero2Sub));
                    break;
                case 3:
                    Double[] numerosMultiplicacao = Utilitarios.receberEValidarMultiplasEntradasDouble(scanner);
                    System.out.println("Resultado: " + calculadora.multiplicacao(numerosMultiplicacao));
                    break;
                case 4:
                    Double numero1div = Utilitarios.validarSeAEntradaEUmDouble(scanner, "Insira o primeiro número: ");
                    Double numero2div = Utilitarios.validarSeAEntradaEUmDouble(scanner, "Insira o segundo número: ");
                    System.out.println("Resultado: " + calculadora.divisao(numero1div, numero2div));
                    break;
                case 5:
                    Double numero1exp = Utilitarios.validarSeAEntradaEUmDouble(scanner, "Insira a base: ");
                    Double numero2exp = Utilitarios.validarSeAEntradaEUmDouble(scanner, "Insira o expoente: ");
                    System.out.println("Resultado: " + calculadora.exponenciacao(numero1exp, numero2exp));
                    break;
                case 6:
                    int numero1divI = Utilitarios.validarSeAEntradaEUmInt(scanner, "Insira o primeiro número: ");
                    int numero2divI = Utilitarios.validarSeAEntradaEUmInt(scanner, "Insira o segundo número: ");
                    System.out.println("Resultado: " + calculadora.divisaoInteira(numero1divI, numero2divI));
                    break;
                case 7:
                    int numero1rest = Utilitarios.validarSeAEntradaEUmInt(scanner, "Insira o primeiro número: ");
                    int numero2rest = Utilitarios.validarSeAEntradaEUmInt(scanner, "Insira o segundo número: ");
                    System.out.println("Resultado: " + calculadora.resto(numero1rest, numero2rest));
                    break;
                case 8:
                    int numeroFatorial = Utilitarios.validarSeAEntradaEUmInt(scanner, "Insira um número: ");
                    System.out.println("Resultado: " + calculadora.fatorial(numeroFatorial));
                    break;
                case 9:
                    int numeroArranjoTotal = Utilitarios.validarSeAEntradaEUmInt(scanner, "Insira o número total de elementos: ");
                    int numeroArranjoEscolhidos = Utilitarios.validarSeAEntradaEUmInt(scanner, "Insira o número de elementos a serem escolhidos: ");
                    System.out.println("Resultado: " + calculadora.arranjo(numeroArranjoTotal, numeroArranjoEscolhidos));
                    break;
                case 10:
                    try {
                        int numeroTotal = Utilitarios.validarSeAEntradaEUmInt(scanner, "Insira o número total de elementos: ");
                        int[] numeroDeRepeticoes = Utilitarios.receberEValidarMultiplasEntradasInt(scanner);
                        System.out.println(calculadora.permutacao(numeroTotal, numeroDeRepeticoes));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 11:
                    Double numeroPiso = Utilitarios.validarSeAEntradaEUmDouble(scanner, "Insira um número: ");
                    System.out.println("Resultado: " + calculadora.piso(numeroPiso));
                    break;
                case 12:
                    Double numeroTeto = Utilitarios.validarSeAEntradaEUmDouble(scanner, "Insira um número: ");
                    System.out.println("Resultado: " + calculadora.teto(numeroTeto));
                    break;
                case 13:
                    double numero1raiz = Utilitarios.validarSeAEntradaEUmDouble(scanner, "Insira a base: ");
                    double numero2raiz = Utilitarios.validarSeAEntradaEUmDouble(scanner, "Insira a raiz: ");
                    System.out.println("Resultado: " + calculadora.raiz(numero1raiz, numero2raiz));
                    break;
                case 14:
                    int numeroPrimo = Utilitarios.validarSeAEntradaEUmInt(scanner, "Insira um número: ");
                    if (calculadora.validarNumeroPrimo(numeroPrimo)) System.out.printf("O número %d é primo.\n", numeroPrimo);
                    else System.out.printf("O número %d não é primo.\n", numeroPrimo);
                    break;
                case 15:
                    int quadradoPerfeito = Utilitarios.validarSeAEntradaEUmInt(scanner, "Insira um número: ");
                    if (calculadora.validarQuadradoPerfeito(quadradoPerfeito)) System.out.printf("O número %d é um quadrado perfeito.\n", quadradoPerfeito);
                    else System.out.printf("O número %d não é quadrado perfeito.\n", quadradoPerfeito);
                    break;
                default:
                    System.out.println("A opção inserida é inválida.");
                    break;
            }
            if (Utilitarios.pegarPrimeiraLetraEmUppercaseDaEntrada(scanner) == 'S') break;
        }
    }
}
