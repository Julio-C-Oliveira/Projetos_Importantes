package logSection;

import java.util.ArrayList;

import pokemonSection.pokedex.PokeRocket;
import pokemonSection.pokedex.PokeSOX;
import pokemonSection.pokedex.Pokemon;


public class BattleLog extends Log{
    public BattleLog() {
        super();
    }

    // Grava no log de batalha o instante atual da batalha + modificação de string para agradar aos olhos
    public void recordBattleInstant(Pokemon friend, Pokemon foe){
        ArrayList<String> pokemonView = new ArrayList<String>();
        String pokemon1Str = friend.toString();
        String pokemon2Str = foe.toString();

        String[] lines1 = pokemon1Str.split("\n");
        String[] lines2 = pokemon2Str.split("\n");

        int maxLines = Math.max(lines1.length, lines2.length);

        int maxsize = 0;
        for (String string : lines1) {
            if (maxsize < string.length()) {
                maxsize = string.length();
            }
        }
        String versus = " | ";
        for (int i = 0; i < maxLines; i++) {
            // Adiciona as linhas com o preenchimento de espaços corretamente
            String line1 = (i < lines1.length) ? lines1[i] : " ";
            String line2 = (i < lines2.length) ? lines2[i] : " ";
            
            // Mantém os espaços no começo de cada linha e adiciona a linha no formato desejado
            pokemonView.add(line1 + " ".repeat(maxsize - line1.length()) + versus + line2);
        }
        
        // Gera a string final, removendo os caracteres desnecessários
        String finalString = String.join("\n", pokemonView).replaceAll("[\\[\\],]", "");
        appendLog(finalString);
    }

    public void recordPokemonInstances(){
        // Acessar o número de Instâncias Criadas:
        appendLog("\nSOXs: " + PokeSOX.getNumberOfSOXs() + "\nRockets: " + PokeRocket.getNumberOfRockets() + "\n");
    }
    
}
