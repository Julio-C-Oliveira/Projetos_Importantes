package testSection;

import logSection.Log;
import turnSection.Turn;
import pokemonSection.Pokemon;
import pokemonSection.Type;

public class testBattle {
    static Log log = new Log();
    static Turn turn = new Turn();

    public static void testar() {
        Pokemon friend = Pokemon.takeAPokemon(
                "01",
                (short) 47,
                Type.NORMAL,
                Type.FIRE);
        Pokemon foe = Pokemon.takeAPokemon(
                "02",
                (short) 127,
                Type.WATER,
                Type.FIRE);
        
        String event;
        int priority = turn.getNextPokemon(friend, foe);
        if (priority == 1){
            event = turn.makeAction(foe, friend);
            log.appendLog(event);
        }

        for (int i = 0; i < 30; i++) {
            if (foe.getHealthPoints() <= 0){
                log.appendLog("O pokémon vencedor é: " + friend.getPokemonName());
                break;
            }
            
            if (friend.getHealthPoints() <= 0){
                log.appendLog("O pokémon vencedor é: " + foe.getPokemonName());
                break;
            }

            if (i%2 == priority){
                event = turn.makeAction(friend, foe);
            } else {
                event = turn.makeAction(foe, friend);
            }
            log.appendLog(event);
            
        }
    }
    public static void main(String[] args) {
        testar();
        log.showLog();
    }
}
