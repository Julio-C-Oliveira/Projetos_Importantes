package calculadoraVS;

import java.util.ArrayList;

// Interface da calculadora que a obriga a implementar essas funções
public interface CalculatorInterface {
    public boolean memoryIsEmpty();
    public ArrayList<Double> getMemory();
    public void sum(double termA, double termB);
    public void difference(double a, double b);
    public void product(double factorA, double factorB);
    public void quotient(double numerator, double divisor);
    public void intQuotient(double numerator, double divisor);
    public void rest(double numerator, double divisor);
    public void exponential(double base, double exp);
    public void root(int radicand, int index);
    public void factorial(int toFactor);
    public void arrangement(int n, int k);
    public void permutation(int n, int[] repetitions);
    public void floor(double toFloor);
    public void ceiling(double toCeil);
    public boolean checkIfPrime(int n);
    public boolean checkIfPerfectSquare(int n);
}