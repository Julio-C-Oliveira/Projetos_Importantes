import calculadoraVJ.Calculadora;
import calculadoraVS.Calculator;
import calculadoraVS.Menu;
import conversores.Massas;
import conversores.Medidas;
import conversores.Moedas;
import conversores.Temperaturas;
import polinomio.Polinomio;
import validadorCPF.CPF;

public class Main {
    public static void main(String[] args) throws Exception {
        // Instanciando os conversores - Luiz.
        Moedas moedas = new Moedas();
        Medidas medidas = new Medidas();
        Massas massas = new Massas();
        Temperaturas temperaturas = new Temperaturas();

        // Utilizando as medidas - Luiz.
        moedas.conversor();
        medidas.conversor();
        temperaturas.conversor();
        massas.conversor();

        // Polinomio, instancia e utilização - Luiz.
        Polinomio polinomio = new Polinomio();
        polinomio.calcularRaizes();

        // CPF, intanciação e uso - Luiz.
        CPF cpf = new CPF("47666286325");
        System.out.println(cpf.getCPF());

        // Instancia e uso da calculadora - Sávio.
        Calculator calculator = new Calculator();
        Menu menu = new Menu(calculator);
        menu.operation();

        // Utilização da calculadora - Júlio.
        Calculadora.run();
    }
}