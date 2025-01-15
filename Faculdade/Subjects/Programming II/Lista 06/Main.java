import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Questão 01 - inverter número:
        System.out.println("Primeira Questão: ");
        System.out.println(Utilitarios.inverterNumero(1.2345));

        // Questão 02 - usar argumento de comprimento váriavel:
        System.out.println("\nSegunda Questão: ");
        System.out.println(Matematica.produto(0, 1));
        System.out.println(Matematica.produto(1, 3, 4, 5));
        System.out.println(Matematica.produto(7, 8, 9));
        System.out.println(Matematica.produto(1, 5,2, 54));
        System.out.println(Matematica.produto(1, 9,56, 3, 78, 9));

        // Questão 03 - unir duas listas:
        System.out.println("\nTerceira Questão: ");
        ArrayList<Integer> lista1 = Utilitarios.adicionarValoresPorIntervalo(1, 5);
        ArrayList<Integer> lista2 = Utilitarios.adicionarValoresPorIntervalo(6, 10);
        System.out.println(Utilitarios.unir(lista1, lista2));
    }
}