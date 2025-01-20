public class DataClass {
    private int inteiro;
    private int[] listaDeInteiros;
    private boolean verdadeOuFalso;
    private boolean[] listaDeVerdadeOuFalso;

    public DataClass() {
    }
    public DataClass(int inteiro) {
        this.inteiro = inteiro;
    }
    public DataClass(int[] listaDeInteiros) {
        this.listaDeInteiros = listaDeInteiros;
    }
    public DataClass(boolean verdadeOuFalso) {
        this.verdadeOuFalso = verdadeOuFalso;
    }
    public DataClass(boolean[] listaDeVerdadeOuFalso) {
        this.listaDeVerdadeOuFalso = listaDeVerdadeOuFalso;
    }
    public DataClass(int inteiro, boolean[] listaDeVerdadeOuFalso) {
        this.inteiro = inteiro;
        this.listaDeVerdadeOuFalso = listaDeVerdadeOuFalso;
    }
    public DataClass(int[] listaDeInteiros, boolean[] listaDeVerdadeOuFalso) {
        this.listaDeInteiros = listaDeInteiros;
        this.listaDeVerdadeOuFalso = listaDeVerdadeOuFalso;
    }

    public int getInteiro() {
        return inteiro;
    }

    public void setInteiro(int inteiro) {
        this.inteiro = inteiro;
    }

    public boolean[] getListaDeVerdadeOuFalso() {
        return listaDeVerdadeOuFalso;
    }

    public void setListaDeVerdadeOuFalso(boolean[] listaDeVerdadeOuFalso) {
        this.listaDeVerdadeOuFalso = listaDeVerdadeOuFalso;
    }

    public boolean isVerdadeOuFalso() {
        return verdadeOuFalso;
    }

    public void setVerdadeOuFalso(boolean verdadeOuFalso) {
        this.verdadeOuFalso = verdadeOuFalso;
    }

    public int[] getListaDeInteiros() {
        return listaDeInteiros;
    }

    public void setListaDeInteiros(int[] listaDeInteiros) {
        this.listaDeInteiros = listaDeInteiros;
    }
}
