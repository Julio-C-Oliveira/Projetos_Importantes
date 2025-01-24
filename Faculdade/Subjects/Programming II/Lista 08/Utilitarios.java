import Show.CamaroteInferior;
import Show.CamaroteSuperior;
import Show.Ingresso;

import java.util.Scanner;

public class Utilitarios {
    public Utilitarios() {}
    public static int validarSeAEntradaEUmIntEEstaEmUmIntervalo(Scanner scanner, String texto, int inicio, int fim) {
        int opcaoInInt = Integer.MAX_VALUE;
        while (true) {
            System.out.print(texto);
            String opcaoInString = scanner.nextLine();
            try {
                opcaoInInt = Integer.parseInt(opcaoInString);
            } catch (NumberFormatException e) {
                System.out.println("O valor inserido não pode ser convertido para int");
            }
            if (opcaoInInt >= inicio && opcaoInInt <= fim) break;
            else System.out.println("O valor inserido está fora do intervalo disponivel");
        }

        return opcaoInInt;
    }

    public static void escolherIngresso(Scanner scanner, float valor, float valorAdicionalVip, float valorAdicionalCamaroteSupeior, String localizacaoCamaroteInferior, String localizacaoCamaroteSuperior) {
        int tipoDeIngresso = Utilitarios.validarSeAEntradaEUmIntEEstaEmUmIntervalo(scanner, "Escolha o tipo de ingresso:\n1 - Ingresso Normal\n2 - Ingresso VIP\nDigite a opção desejada: ", 1, 2);
        if (tipoDeIngresso == 1) {
            Ingresso ingresso = new Ingresso(valor);
            System.out.println(ingresso.imprimir_valor());
        }
        else {
            int tipoDeCamarote = Utilitarios.validarSeAEntradaEUmIntEEstaEmUmIntervalo(scanner, "Escolha o tipo de camarote:\n1 - Camarote Inferior\n2 - Camarote Superior\nDigite a opção desejada: ", 1, 2);
            if (tipoDeCamarote == 1) {
                CamaroteInferior camaroteInferior = new CamaroteInferior(valor, valorAdicionalVip, localizacaoCamaroteInferior);
                System.out.printf("%s\n%s\n",camaroteInferior.imprimir_localizacao(), camaroteInferior.imprimir_valor());
            }
            else {
                CamaroteSuperior camaroteSuperior = new CamaroteSuperior(valor, valorAdicionalVip, localizacaoCamaroteSuperior, valorAdicionalCamaroteSupeior);
                System.out.printf("%s\n%s\n\n",camaroteSuperior.imprimir_localizacao(), camaroteSuperior.imprimir_valor());
            }
        }
    }
}
