public class Contato {
    private String nome;
    private String email;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Contato( String nome, String email) {
        setNome(nome);
        setEmail(email);
    }

    public static boolean isContato(Object objeto){ return objeto instanceof Contato; }
}