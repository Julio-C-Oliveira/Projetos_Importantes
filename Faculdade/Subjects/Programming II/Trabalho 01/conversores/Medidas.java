package conversores;

import java.util.Scanner;

public class Medidas {
    private final Scanner scan = new Scanner(System.in);

    // Converte metros (m) para centímetros (cm)
    private float mCm(float valor) {
        return valor * 100; // 1 metro = 100 centímetros
    }

    // Converte metros (m) para milímetros (mm)
    private float mMm(float valor) {
        return valor * 1000; // 1 metro = 1000 milímetros
    }

    // Converte metros (m) para pés (ft)
    private float mFt(float valor) {
        return valor * 3.28084f; // 1 metro = aproximadamente 3.28084 pés
    }

    // Converte metros (m) para polegadas (in)
    private float mIn(float valor) {
        return valor * 39.3701f; // 1 metro = aproximadamente 39.3701 polegadas
    }

    // Converte centímetros (cm) para metros (m)
    private float cmM(float valor) {
        return valor / 100; // 100 centímetros = 1 metro
    }

    // Converte centímetros (cm) para milímetros (mm)
    private float cmMm(float valor) {
        return valor * 10; // 1 centímetro = 10 milímetros
    }

    // Converte milímetros (mm) para metros (m)
    private float mmM(float valor) {
        return valor / 1000; // 1000 milímetros = 1 metro
    }

    // Converte milímetros (mm) para centímetros (cm)
    private float mmCm(float valor) {
        return valor / 10; // 10 milímetros = 1 centímetro
    }

    // Converte pés (ft) para metros (m)
    private float ftM(float valor) {
        return valor / 3.28084f; // 1 pé = aproximadamente 0.3048 metros (1/3.28084)
    }

    // Converte pés (ft) para polegadas (in)
    private float ftIn(float valor) {
        return valor * 12; // 1 pé = 12 polegadas
    }

    // Converte polegadas (in) para metros (m)
    private float inM(float valor) {
        return valor / 39.3701f; // 1 polegada = aproximadamente 0.0254 metros (1/39.3701)
    }

    // Converte polegadas (in) para pés (ft)
    private float inFt(float valor) {
        return valor / 12; // 12 polegadas = 1 pé
    }

    // Método principal para realizar a conversão de medidas
    public void conversor() {
        // Solicita ao usuário o valor da medida que deseja converter
        System.out.print("Digite o valor da medida: ");
        float valor = scan.nextFloat();

        // Solicita ao usuário a unidade de origem
        System.out.println("Selecione a unidade de origem:");
        System.out.println("1 - Metro");
        System.out.println("2 - Centimetro");
        System.out.println("3 - Milimetro");
        System.out.println("4 - Pe");
        System.out.println("5 - Polegada");

        int origem = scan.nextInt(); // Lê a escolha da unidade de origem

        // Realiza as conversões com base na unidade de origem
        switch (origem) {
            case 1: // Metro
                System.out.println("De Metro para Centimetro: " + mCm(valor) + " cm");
                System.out.println("De Metro para Milimetro: " + mMm(valor) + " mm");
                System.out.println("De Metro para Pe: " + mFt(valor) + " ft");
                System.out.println("De Metro para Polegada: " + mIn(valor) + " in");
                break;

            case 2: // Centímetro
                System.out.println("De Centimetro para Metro: " + cmM(valor) + " m");
                System.out.println("De Centimetro para Milimetro: " + cmMm(valor) + " mm");
                System.out.println("De Centimetro para Pe: " + mFt(cmM(valor)) + " ft");
                System.out.println("De Centimetro para Polegada: " + mIn(cmM(valor)) + " in");
                break;

            case 3: // Milímetro
                System.out.println("De Milimetro para Metro: " + mmM(valor) + " m");
                System.out.println("De Milimetro para Centimetro: " + mmCm(valor) + " cm");
                System.out.println("De Milimetro para Pe: " + mFt(mmM(valor)) + " ft");
                System.out.println("De Milimetro para Polegada: " + mIn(mmM(valor)) + " in");
                break;

            case 4: // Pé
                System.out.println("De Pe para Metro: " + ftM(valor) + " m");
                System.out.println("De Pe para Centimetro: " + mCm(ftM(valor)) + " cm");
                System.out.println("De Pe para Milimetro: " + mMm(ftM(valor)) + " mm");
                System.out.println("De Pe para Polegada: " + ftIn(valor) + " in");
                break;

            case 5: // Polegada
                System.out.println("De Polegada para Metro: " + inM(valor) + " m");
                System.out.println("De Polegada para Centimetro: " + mCm(inM(valor)) + " cm");
                System.out.println("De Polegada para Milimetro: " + mMm(inM(valor)) + " mm");
                System.out.println("De Polegada para Pe: " + inFt(valor) + " ft");
                break;

            default:
                // Caso o usuário insira uma opção inválida
                System.out.println("Opção inválida!");
                break;
        }
    }
}
