import Animais.Animal;
import Animais.Mamifero;
import Animais.Peixe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Questão 03:
        System.out.println("----------------------");
        Animal animal = new Animal("Camelo", 1.5f, 4, "Amarelo", "Terra", 2.0f);
        System.out.println(animal.toString());
        System.out.println("----------------------");
        Mamifero mamifero = new Mamifero("Urso", 1.8f, 4, "Vermelho", "Terra", 0.5f, "Mel");
        System.out.println(mamifero.toString());
        System.out.println("----------------------");
        Peixe peixe = new Peixe("Tubarão", 3.0f, 0, "Cinzento", "Mar", 1.5f, "Barbatanas e cauda");
        System.out.println(peixe.toString());
        System.out.println("----------------------");

        // Questão 04:
        Utilitarios.escolherIngresso(new Scanner(System.in), 15.0f, 10.0f, 10.0f, "Bloco 01", "Bloco 02");
    }
}