import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Primeira questão:
        System.out.println("Primeira Questão:");
        int dia = Utilitarios.validarSeAEntradaEUmInt(scanner, "Insira o número de um dia da semana: ");
        System.out.println(Classificador.diaDaSemana(dia));

        // Segunda questão:
        System.out.println("\nSegunda Questão:");
        System.out.print("Insira um mês: ");
        String mes = scanner.nextLine();
        System.out.println(Classificador.deQueSemestre(mes));

        // Terceira questão:
        System.out.println("\nTerceira Questão:");
        double primeiroValor = Utilitarios.validarSeAEntradaEUmDouble(scanner, "Insira o primeiro valor: ");
        double segundoValor = Utilitarios.validarSeAEntradaEUmDouble(scanner, "Insira o segundo valor: ");
        char operador = Utilitarios.validarSeAEntradaEUmaOperacaoBasica(scanner, "Insira o operador: ");
        System.out.println(Matematica.calcularOperacoesBasicas(primeiroValor, segundoValor, operador));

        // Quarta questão:
        System.out.println("\nQuarta Questão:");
        int numeroDeTermos = Utilitarios.validarSeAEntradaEUmInt(scanner, "Insira o numero de termos à serem calculados: ");
        System.out.println(Matematica.calcularConstante(numeroDeTermos));

        // Quinta questão:
        System.out.println("\nQuinta Questão:");
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.adicionarLivro("God of War", "Kratos", 2005);
        Utilitarios.exibirAcervo(biblioteca.getAcervo());
        biblioteca.adicionarLivro("Shadow of the Colossus");
        Utilitarios.exibirAcervo(biblioteca.getAcervo());
        biblioteca.adicionarLivro("Bleach", "Tite Kubo");
        Utilitarios.exibirAcervo(biblioteca.getAcervo());
    }
}