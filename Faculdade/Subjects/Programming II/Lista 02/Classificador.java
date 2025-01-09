public class Classificador {
    public Classificador() { }

    public static String diaDaSemana(int diaEmNumero) {
        return switch (diaEmNumero) {
            case 1 -> "Domingo";
            case 2 -> "Segunda-Feira";
            case 3 -> "Terça-Feira";
            case 4 -> "Quarta-Feira";
            case 5 -> "Quinta-Feira";
            case 6 -> "Sexta-Feira";
            case 7 -> "Sábado";
            default -> "O Número inserido não é válido";
        };
    }
    public static String deQueSemestre(String mes) {
        mes = mes.toUpperCase();
        mes = mes.trim();

        return switch (mes) {
            case "JANEIRO" -> "Primeiro Semestre";
            case "FEVEREIRO" -> "Primeiro Semestre";
            case "MARÇO" -> "Primeiro Semestre";
            case "ABRIL" -> "Primeiro Semestre";
            case "MAIO" -> "Primeiro Semestre";
            case "JUNHO" -> "Primeiro Semestre";
            case "JULHO" -> "Segundo Semestre";
            case "AGOSTO" -> "Segundo Semestre";
            case "SETEMBRO" -> "Segundo Semestre";
            case "OUTUBRO" -> "Segundo Semestre";
            case "NOVEMBRO" -> "Segundo Semestre";
            case "DEZEMBRO" -> "Segundo Semestre";
            default -> "O mês inserido não é válido";
        };
    }
}
