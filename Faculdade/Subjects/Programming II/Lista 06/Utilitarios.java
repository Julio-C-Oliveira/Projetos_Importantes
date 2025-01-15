import java.util.ArrayList;

public class Utilitarios {
    public Utilitarios() {}

    private static ArrayList<Character> doubleParaCharArraylist(Double numero) {
        String numeroEmStr = numero.toString();
        char[] vetor = numeroEmStr.toCharArray();
        ArrayList<Character> listaDeCaracteres = new ArrayList<>();
        for (char caractere : vetor) {
            listaDeCaracteres.add(caractere);
        }
        return listaDeCaracteres;
    }
    private static double charArrayListParaDouble(ArrayList<Character> lista) {
        StringBuilder intEmString = new StringBuilder();
        for (char c : lista) {
            intEmString.append(c);
        }
        return Double.parseDouble(intEmString.toString());
    }

    private static ArrayList<Character> inverterArray(ArrayList<Character> lista) {
        ArrayList<Character> novaLista = new ArrayList<Character>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            novaLista.add(lista.get(i));
        }
        return novaLista;
    }

    public static double inverterNumero(Double numero) {
        ArrayList<Character> listaDeCaracteres = doubleParaCharArraylist(numero);
        int indexPontoFlutuante = listaDeCaracteres.indexOf('.');
        listaDeCaracteres = inverterArray(listaDeCaracteres);
        listaDeCaracteres.remove(Character.valueOf('.'));
        listaDeCaracteres.add(indexPontoFlutuante, '.');
        return charArrayListParaDouble(listaDeCaracteres);
    }

    public static ArrayList<Integer> adicionarValoresPorIntervalo(int inicio, int fim) {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = inicio; i <= fim; i++) {
            lista.add(i);
        }
        return lista;
    }
    public static ArrayList<Integer> unir(ArrayList<Integer>... listas) {
        ArrayList<Integer> novaLista = new ArrayList<>();
        for (ArrayList<Integer> lista : listas) {
            for (int inteiro : lista) {
                novaLista.add(inteiro);
            }
        }
        return novaLista;
    }
}
