import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Questão 03 - Recebe dois números e imprime o maior:
        System.out.println("Questão 03:");
        System.out.println(Utilitarios.retornarMaiorNumero(2, 3));

        // Questão 04 - Recebe um número inteiro e imprime em ordem decrescente o valor até o número 0:
        System.out.println("\nQuestão 04:");
        for (Integer numero: Utilitarios.retornaDeAlgumNumeroAteZero(7)) System.out.println(numero);

        // Questão 05 - Imprima na nela a soma dos números ímpares entre 1 a 30 e a multiplicação entre 1 e 30:
        System.out.println("\nQuestão 05:");
        int inicio = 1, fim = 30;
        ArrayList<Object> resultados = Utilitarios.somaImparEMultiplicaPar(inicio, fim);
        System.out.printf("Soma dos Números Ímpares de %s até %s: %s\n", inicio, fim, resultados.get(0));
        System.out.printf("Multiplicação dos Números Pares de %s até %s: %s\n", inicio, fim, resultados.get(1));

        // Questão 06 - Troque o valor de duas váriaveis primitivas e em seguida faça isso sem utilizar um auxiliar:
        System.out.println("\nQuestão 06:");
        // Primeiro com auxiliar
        int primeiroValor = 1, segundoValor = 2, auxiliar;

        auxiliar = primeiroValor;
        primeiroValor = segundoValor;
        segundoValor = auxiliar;

        System.out.println("Primeiro Valor: " + primeiroValor);
        System.out.println("Segundo Valor: " + segundoValor);

        // Sem auxiliar utilizando a operação de ou exclusivo entre as váriaveis
        primeiroValor = 1;
        segundoValor = 2;

        primeiroValor = primeiroValor ^ segundoValor;
        segundoValor = primeiroValor ^ segundoValor;
        primeiroValor = primeiroValor ^ segundoValor;

        System.out.println("Primeiro Valor: " + primeiroValor);
        System.out.println("Segundo Valor: " + segundoValor);

        // Questão 07 - Contato e Agenda:
        System.out.println("\nQuestão 07:");
        Agenda agenda = new Agenda();

        agenda.addContato(new Contato("Júlio", "julio@gmail.com"));
        agenda.addContato(new Contato("Felipe", "felipe@gmail.com"));
        agenda.addContato(new Contato("Yuri", "yuri@gmail.com"));
        agenda.addContato(new Contato("Arthur", "arthur@gmail.com"));
        agenda.addContato(new Contato("David", "david@gmail.com"));
        agenda.addContato(new Contato("Polyana", "polyana@gmail.com"));

        String alvo = "Júlio";
        Contato contatoRecebido = agenda.buscarContato(alvo);

        if (Contato.isContato(contatoRecebido)) System.out.printf("Contato: %s\nNome: %s\nE-mail: %s\n", contatoRecebido, contatoRecebido.getNome(), contatoRecebido.getEmail());
        else System.out.println("O contato referido é inexistente, verifique se a escrita do nome está correta.");

        alvo = "Júlio";
        boolean resposta = agenda.deleteContato(alvo);
        contatoRecebido = agenda.buscarContato(alvo);

        if (!resposta) System.out.printf("\nContato: %s\nNome: %s\nE-mail: %s\n", contatoRecebido, contatoRecebido.getNome(), contatoRecebido.getEmail());
        else System.out.println("\nO contato referido é inexistente, verifique se a escrita do nome está correta.");
    }
}