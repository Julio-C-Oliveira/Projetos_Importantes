import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Primeira questão:
        int dia = Utilitarios.validarSeAEntradaEUmInt(scanner, "Insira o número de um dia da semana: ");
        System.out.println(Classificador.diaDaSemana(dia));

        // Segunda questão:
        System.out.print("Insira um mês: ");
        String mes = scanner.nextLine();
        System.out.println(Classificador.deQueSemestre(mes));
        System.out.println();

        // Terceira questão:
        double primeiroValor = Utilitarios.validarSeAEntradaEUmDouble(scanner, "Insira o primeiro valor: ");
        double segundoValor = Utilitarios.validarSeAEntradaEUmDouble(scanner, "Insira o segundo valor: ");
        char operador = Utilitarios.validarSeAEntradaEUmaOperacaoBasica(scanner, "Insira o operador: ");
        System.out.println(Matematica.calcularOperacoesBasicas(primeiroValor, segundoValor, operador));
        System.out.println();

        // Quarta questão:
        int numeroDeTermos = Utilitarios.validarSeAEntradaEUmInt(scanner, "Insira o numero de termos á serem calculados: ");
        System.out.println(Matematica.calcularConstante(numeroDeTermos));

        // Quinta questão:
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.adicionarLivro("God of War", "Kratos", 2005);
        Utilitarios.exibirAcervo(biblioteca.getAcervo());
        biblioteca.adicionarLivro("Shadow of the Colossus");
        Utilitarios.exibirAcervo(biblioteca.getAcervo());
        biblioteca.adicionarLivro("Bleach", "Tite Kubo");
        Utilitarios.exibirAcervo(biblioteca.getAcervo());
    }
}