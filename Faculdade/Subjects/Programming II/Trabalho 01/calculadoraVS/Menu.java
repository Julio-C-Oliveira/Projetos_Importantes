package calculadoraVS;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    // Chama a interface da calculadora
    private final Calculator calculator;
    // Instancia o scanner para acessar o console (input de usuário)
    private Scanner scan = new Scanner(System.in);
    // Um limite definido que jamais será alcançado em um vetor
    int impossibleNumber = -1;

    // Construtor do Menu recebe qualquer calculadora que atenda à interface
    public Menu(Calculator calculator) {
        this.calculator = calculator;
    }

    // Mostra a memória da calculadora
    private ArrayList<String> showMemory(){
        ArrayList<String> memoryToShow = new ArrayList<String>();
        for(double element : calculator.getMemory()){
            String stringDoubleElement = String.valueOf(element);
            // verificação se o sufixo for qualquer coisa .0, armazena-se um inteiro
            if(stringDoubleElement.endsWith(".0")){
                String stringIntElement = String.valueOf(Math.round(element));
                memoryToShow.add(stringIntElement);
                // do contrário, armazena-se um double mesmo
            } else {
                memoryToShow.add(stringDoubleElement);
            }
        }
        return memoryToShow;
    }

    // função que pergunta ao usuário se este deseja utilizar um valor da memória
    private int loadFromMemory(){
        // se a memória estiver vazia, retorna o número impossível
        if (calculator.memoryIsEmpty()){
            return impossibleNumber;
        }
        System.out.print("Carregar da memória? (S/s)");
        String load = scan.next();
        if (load.matches("[Ss]")) {
            showMemory();
            // pergunta ao usuário qual o valor na memória deseja usar
            System.out.print("Insira o index da lista de 1 a n: ");
            int index = scan.nextInt();
            return index;
        }
        return impossibleNumber;
    }

    // exibe o menu de opções
    private void showMenu(){
        System.out.println("*--------- MENU ----------*");
        System.out.println("| Finalizar programa (0)  |");
        System.out.println("| Soma (+)                |");
        System.out.println("| Diferença (-)           |");
        System.out.println("| Multiplicação (*)       |");
        System.out.println("| Divisão (/)             |");
        System.out.println("| Divisão Inteira (//)    |");
        System.out.println("| Resto (%)               |");
        System.out.println("| Exponencial (^)         |");
        System.out.println("| Fatorial(!)             |");
        System.out.println("| (A)rranjo               |");
        System.out.println("| (Per)mutação            |");
        System.out.println("| Piso (F)                |");
        System.out.println("| Teto (C)                |");
        System.out.println("| Raiz (R)                |");
        System.out.println("| (P)rimo                 |");
        System.out.println("| Quadrado Perfeito (SQP) |");
        System.out.println("*-------------------------*");
        System.out.println("MEMÓRIA: " + showMemory());
        System.out.print("*-> ");
    }

    // switch de operações da lista
    public void operation() {
        boolean end = false;

        // calculadora roda indefinidamente até o término do programa (recebe 0)
        // Algumas funções podem acessar a memória, então é necessário um if-else para verificar
        while (!end) {
            showMenu();
            String userInput = scan.next();
            double a, b;
            int toFactorial, radicand, index, memoryIndex;
            switch (userInput) {
                case "0":
                    end = true;
                    break;

                // ADIÇÂO
                case "+":
                    memoryIndex = loadFromMemory();
                    if (memoryIndex == impossibleNumber) {
                        System.out.print("Primeiro termo: ");
                        a = scan.nextDouble();
                        System.out.print("Segundo termo: ");
                        b = scan.nextDouble();
                        calculator.sum(a, b);
                    } else {
                        System.out.print("Segundo termo: ");
                        b = scan.nextDouble();
                        a = calculator.getMemory().get(memoryIndex  - 1);
                        calculator.sum(a, b);
                    }
                    break;

                // SUBTRAÇÃO
                case "-":
                    memoryIndex = loadFromMemory();
                    if (memoryIndex == impossibleNumber) {
                        System.out.print("Primeiro termo: ");
                        a = scan.nextDouble();
                        System.out.print("Segundo termo: ");
                        b = scan.nextDouble();
                        calculator.difference(a, b);
                    } else {
                        System.out.print("Segundo termo: ");
                        b = scan.nextDouble();
                        a = calculator.getMemory().get(memoryIndex  - 1);
                        calculator.difference(a, b);
                    }
                    break;

                // MULTIPLICAÇÃO
                case "*":
                    memoryIndex = loadFromMemory();
                    if (memoryIndex == impossibleNumber){
                        System.out.print("Primeiro fator: ");
                        a = scan.nextDouble();
                        System.out.print("Segundo fator: ");
                        b = scan.nextDouble();
                        calculator.product(a, b);
                    } else {
                        System.out.print("Segundo fator: ");
                        b = scan.nextDouble();
                        a = calculator.getMemory().get(memoryIndex  - 1);
                        calculator.product(a, b);
                    }
                    break;

                // DIVISÃO
                case "/":
                    memoryIndex = loadFromMemory();
                    if (memoryIndex == impossibleNumber) {
                        System.out.print("Numerador: ");
                        a = scan.nextDouble();
                        System.out.print("Divisor: ");
                        b = scan.nextDouble();
                        calculator.quotient(a, b);
                    } else {
                        System.out.print("Divisor: ");
                        b = scan.nextDouble();
                        a = calculator.getMemory().get(memoryIndex  - 1);
                        calculator.quotient(a, b);
                    }
                    break;

                // DIVISÃO INTEIRA
                case "//":
                    memoryIndex = loadFromMemory();
                    if (memoryIndex == impossibleNumber){
                        System.out.print("Numerador: ");
                        a = scan.nextDouble();
                        System.out.print("Divisor: ");
                        b = scan.nextDouble();
                        calculator.intQuotient(a, b);
                    } else {
                        System.out.print("Divisor: ");
                        b = scan.nextDouble();
                        a = calculator.getMemory().get(memoryIndex  - 1);
                        calculator.intQuotient(a, b);
                    }
                    break;

                // RESTO DA DIVISÃO
                case "%":
                    memoryIndex = loadFromMemory();
                    if (memoryIndex == impossibleNumber) {
                        System.out.print("Numerador: ");
                        a = scan.nextDouble();
                        System.out.print("Divisor: ");
                        b = scan.nextDouble();
                        calculator.rest(a, b);
                    } else {
                        System.out.print("Divisor: ");
                        b = scan.nextDouble();
                        a = calculator.getMemory().get(memoryIndex  - 1);
                        calculator.rest(a, b);
                    }
                    break;

                // EXPONENCIAÇÃO
                case "^":
                    memoryIndex = loadFromMemory();
                    if (memoryIndex == impossibleNumber) {
                        System.out.print("Base: ");
                        a = scan.nextDouble();
                        System.out.print("Expoente: ");
                        b = scan.nextDouble();
                        calculator.exponential(a, b);
                    } else {
                        System.out.print("Expoente: ");
                        b = scan.nextDouble();
                        a = calculator.getMemory().get(memoryIndex  - 1);
                        calculator.exponential(a, b);
                    }
                    break;

                // RADICIAÇÃO
                case "R":
                    memoryIndex = loadFromMemory();
                    if (memoryIndex == impossibleNumber){
                        System.out.print("Radicando: ");
                        radicand = scan.nextInt();
                        System.out.print("Índice: ");
                        index = scan.nextInt();
                        calculator.root(radicand, index);
                    } else {
                        System.out.print("Índice: ");
                        index = scan.nextInt();
                        radicand = calculator.getMemory().get(memoryIndex  - 1).intValue();
                        calculator.root(radicand, index);
                    }
                    break;

                // FATORIAL
                case "!":
                    memoryIndex = loadFromMemory();
                    if (memoryIndex == impossibleNumber){
                        System.out.print("Fatorial de: ");
                        toFactorial = scan.nextInt();
                        System.out.println("MEU FATORIAL: " + toFactorial);
                        calculator.factorial(toFactorial);
                    } else {
                        System.out.print("Índice: ");
                        index = scan.nextInt();
                        toFactorial = calculator.getMemory().get(memoryIndex  - 1).intValue();
                        calculator.factorial(toFactorial);
                    }
                    break;

                // ARRANJO
                case "A":
                    System.out.print("Digite o fatorial no numerador: ");
                    toFactorial = scan.nextInt();
                    System.out.print("Digite o número de objetos selecionados: ");
                    index = scan.nextInt();
                    calculator.arrangement(toFactorial, index);
                    break;

                // PERMUTAÇÃO
                case "Per":
                    System.out.print("Digite o fatorial no numerador: ");
                    toFactorial = scan.nextInt();
                    System.out.println("Digite a quantidade de elementos repetidos");
                    System.out.print("Ex. BANANA = 6!/(2!*3!)\nElementos repetidos: ");
                    index = scan.nextInt();
                    int[] repetitions = new int[index];
                    for (int i = 0; i < repetitions.length; i++) {
                        System.out.println("Agora digite o valor da repetição: ");
                        repetitions[i] = scan.nextInt();
                    }
                    calculator.permutation(toFactorial, repetitions);
                    break;

                // PISO
                case "F":
                    memoryIndex = loadFromMemory();
                    if (memoryIndex == impossibleNumber) {
                        System.out.print("Piso: ");
                        a = scan.nextDouble();
                        calculator.floor(a);
                    } else {
                        System.out.print("Piso: ");
                        index = scan.nextInt();
                        a = calculator.getMemory().get(memoryIndex  - 1);
                        calculator.floor(a);
                    }
                    break;

                // TETO
                case "C":
                    memoryIndex = loadFromMemory();
                    if (memoryIndex == impossibleNumber){
                        System.out.print("Teto: ");
                        a = scan.nextDouble();
                        calculator.ceiling(a);
                    } else {
                        System.out.print("Teto: ");
                        index = scan.nextInt();
                        a = calculator.getMemory().get(memoryIndex  - 1);
                        calculator.floor(a);
                    }
                    break;

                // VERIFICA SE É PRIMO
                case "P":
                    System.out.print("Digite um número para verificar sua primalidade: ");
                    index = scan.nextInt();
                    if(calculator.checkIfPrime(index)){
                        System.out.println("O número " + index + " é primo");
                    } else {
                        System.out.println("O número " + index + " NÃO é primo");
                    }
                    break;

                // VERIFICA SE É QUADRADO PERFEITO
                case "SQP":
                    System.out.print("Digite um número para verificar se é um quadrado perfeito: ");
                    index = scan.nextInt();
                    if(calculator.checkIfPerfectSquare(index)){
                        System.out.println("O número " + index + " é quadrado perfeito de "+ Math.pow(index, 1.0/2));
                    } else {
                        System.out.println("O número " + index + " NÃO é quadrado perfeito");
                    }
                    break;

                // qualquer outro case que não as operações propostas, chama o MENU
                default:
                    showMenu();
                    break;
            }
        }
    }

}
