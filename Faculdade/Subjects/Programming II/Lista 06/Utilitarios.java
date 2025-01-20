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
    private static int[] calcularTamanhoDasListas(int[][] listas) {
        int tamanho = 0;
        int quantidadeDeListas = listas.length;
        int[] tamanhos = new int[listas.length];
        for (int[] lista : listas) tamanho += lista.length;
        for (int i = 0; i < quantidadeDeListas; i++) {
            tamanhos[i] = listas[i].length;
        }
        return tamanhos;
    }
    private static int somar(int[] lista) {
        int resultado = 0;
        for (int i : lista) resultado += i;
        return resultado;
    }
    private static DataClass identificarRepeticoes(int[] lista) {
        int tamanhoDaLista = lista.length;
        boolean[] duplicados = new boolean[tamanhoDaLista];
        int elementosUnicos = 0;
        for (int i = 0; i < tamanhoDaLista; i++) {
            if (!duplicados[i]) {
                elementosUnicos++;
                for (int j = i + 1; j < tamanhoDaLista; j++) {
                    if (lista[i] == lista[j]) {
                        duplicados[j] = true;
                    }
                }
            }
        }
        return new DataClass(new int[]{tamanhoDaLista, elementosUnicos}, duplicados);
    }
    private static int[] removerRepeticoes(int[] lista) {
        DataClass unicosERepetidos = identificarRepeticoes(lista);
        boolean[] repetidos = unicosERepetidos.getListaDeVerdadeOuFalso();
        int elementosUnicos = unicosERepetidos.getListaDeInteiros()[1];
        int tamanhoDaListaOriginal = unicosERepetidos.getListaDeInteiros()[0];
        int[] resultado = new int[elementosUnicos];
        int contador = 0;
        for (int i = 0; i < tamanhoDaListaOriginal; i++) {
            if (!repetidos[i]) {
                resultado[contador] = lista[i];
                contador++;
            }
        }
        return resultado;
    }
    private static int[] adicionarLista(int[][] listas) {
        int[] tamanhoDasListas = calcularTamanhoDasListas(listas);
        int numeroDeListas = tamanhoDasListas.length;
        int[] novaLista = new int[somar(tamanhoDasListas)];
        int contador = 0;
        for (int idxLista = 0; idxLista < numeroDeListas; idxLista++) {
            System.out.println("\nAcessando a lista: " + idxLista);
            System.out.println("Tamanho da Lista: " + tamanhoDasListas[idxLista]);
            for (int i = 0; i < tamanhoDasListas[idxLista]; i++) {
                novaLista[contador] = listas[idxLista][i];
                contador++;
            }
        }
        return novaLista;
    }
    public static int[] unir(int[]... listas) {
        int[] novaListaRep = adicionarLista(listas);
        return removerRepeticoes(novaListaRep);
    }
    public static void exibirLista(int[] lista) {
        System.out.println("Lista: ");
        for (int i : lista) System.out.print(i + " ");
        System.out.println();
    }
}
