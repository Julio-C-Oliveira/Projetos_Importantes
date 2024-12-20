import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contato> contatos = new ArrayList<Contato>();

    public Agenda() {}

    public ArrayList<Contato> getContatos() { return contatos; }
    public void setContatos(ArrayList<Contato> contatos) { this.contatos = contatos; }

    public boolean addContato(Contato contatoNovo){
        if (contatoNovo == null) return false;
        else {
            this.contatos.add(contatoNovo);
            return true;
        }
    }
    protected Object buscarIndiceDoContato(String nomeDoContato){
        contatos = this.getContatos();
        for (int i = 0; i < contatos.size(); i++ ) if (contatos.get(i).getNome().equals(nomeDoContato)) return i;
        return null;
    }
    public boolean deleteContato(String nomeDoContato){
        Object indexDoContato = this.buscarIndiceDoContato(nomeDoContato);

        if (indexDoContato instanceof Integer){
            int index = (Integer) indexDoContato;
            getContatos().remove(index);
            return true;
        }
        return false;
    }
    public Contato buscarContato(String nomeDoContato){
        for (Contato contato : this.getContatos()){
            if (contato.getNome().equals(nomeDoContato)) return contato;
        }
        return null;
    }
}
