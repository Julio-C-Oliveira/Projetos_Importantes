package calculadoraVS;


import java.math.BigDecimal; // Classe para manipular os pontos flutuantes
import java.math.RoundingMode; // Classe para arredondar os pontos flutuantes
import java.util.ArrayList; // Array adicionável


// Esta calculadora herda de CalculatorInterface, uma interface que obriga esta classe a ter essas funções abaixo (com Override)
public class Calculator implements CalculatorInterface {
    // Memória da calculadora
    private ArrayList<Double> memory = new ArrayList<Double>();
    // Double que usamos para armazenar o resultado nas funções
    private double result;

    // verifica se a memória está vazia
    @Override
    public boolean memoryIsEmpty(){
        return (memory.size() == 0) ? true : false;
    }

    // getter da memória
    @Override
    public ArrayList<Double> getMemory(){
        return memory;
    }

    // FUNÇÃO DE SOMA
    @Override
    public void sum(double termA, double termB){
        result = termA + termB;
        memory.add(result);
    }

    // FUNÇÃO DE DIFERENÇA
    @Override
    public void difference(double termA, double termB){
        result = termA - termB;
        memory.add(result);
    }

    // FUNÇÃO DE MULTIPLICAÇÃO
    @Override
    public void product(double factorA, double factorB){
        result = factorA * factorB;
        memory.add(result);
    }

    // FUNÇÃO DE DIVISÃO
    @Override
    public void quotient(double numerator, double divisor){
        // Verifica se divisor é zero antes de tudo
        if (divisor == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida.");
        }

        // Realiza a divisão e converte para BigDecimal
        BigDecimal resultDecimal = BigDecimal.valueOf(numerator).divide(BigDecimal.valueOf(divisor), 3, RoundingMode.HALF_UP);

        // Converte de volta para double para armazenar
        result = resultDecimal.doubleValue();

        // Armazena o resultado na memória
        memory.add(result);
    }

    // FUNÇÃO DE DIVISÃO INTEIRA
    @Override
    public void intQuotient(double numerator, double divisor){
        double rest = numerator % divisor;
        result = (numerator - rest)/divisor;
        memory.add(result);
    }

    // FUNÇÃO DE MÓDULO
    @Override
    public void rest(double numerator, double divisor){
        result = numerator % divisor;
        memory.add(result);
    }

    // FUNÇÃO DE EXPONENCIAÇÃO
    @Override
    public void exponential(double base, double exp){
        result = Math.pow(base, exp);
        memory.add(result);
    }

    // FUNÇÃO DE FATORIAL PARA CÁLCULO INTERNO (FATORIAL, ARRANJO, PERMUTAÇÃO)
    public double internFactorial(int toFactor){
        result = 1;
        for(int i = toFactor; i >= 2; i--){
            result *= i;
        }
        return result;
    }

    // FUNÇÃO DE FATORIAL
    @Override
    public void factorial(int toFactor){
        result = internFactorial(toFactor);
        memory.add(result);
    }

    // FUNÇÃO DE RADICIAÇÃO
    @Override
    public void root(int radicand, int index){
        result = Math.pow(radicand, 1.0/index);
        memory.add(result);
    }

    // FUNÇÃO DE TETO
    @Override
    public void ceiling(double toCeil){
        result = Math.ceil(toCeil);
        memory.add(result);
    }

    // FUNÇÃO DE PISO
    @Override
    public void floor(double toFloor){
        result = Math.floor(toFloor);
        memory.add(result);
    }

    // FUNÇÃO DE ARRANJO
    @Override
    public void arrangement(int n, int k){
        result = internFactorial(n)/internFactorial(n-k);
        memory.add(result);
    }

    // FUNÇÃO DE PERMUTAÇÃO COM REPETIÇÃO
    @Override
    public void permutation(int n, int[] repetitions){
        double denominator = 1;
        for (int i = 0; i < repetitions.length; i++) {
            System.out.println("denominador? " + repetitions[i]);
            denominator *= internFactorial(repetitions[i]);
        }
        double result = internFactorial(n)/denominator;
        memory.add(result);
    }

    // FUNÇÃO DE VERIFICAÇÃO DE PRIMO
    @Override
    public boolean checkIfPrime(int n){
        if (n <= 1)
            return false;

        for (int i = 2; i <= n / 2; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    //FUNÇÃO DE VERIFICAÇÃO DE QUADRADO PERFEITO
    @Override
    public boolean checkIfPerfectSquare(int n){
        if (n < 0) {
            return false;
        }
        result = Math.sqrt(n);
        return result == Math.floor(result);
    }
}
