// public class testBattle {
//     static Log log = new Log();
//     static Turn turn = new Turn();

//     public static void testar() {
//         Pokemon friend = Pokemon.takeAPokemon(
//                 "01",
//                 (short) 47,
//                 Type.NORMAL,
//                 Type.FIRE);
//         Pokemon foe = Pokemon.takeAPokemon(
//                 "02",
//                 (short) 127,
//                 Type.WATER,
//                 Type.FIRE);
        
//         String event;
//         int priority = turn.getNextPokemon(friend, foe);
//         if (priority == 1){
//             event = turn.makeAction(foe, friend);
//             log.appendLog(event);
//         }

//         for (int i = 0; i < 30; i++) {
//             if (foe.getHealthPoints() <= 0){
//                 log.appendLog("O pokémon vencedor é: " + friend.getPokemonName());
//                 break;
//             }
            
//             if (friend.getHealthPoints() <= 0){
//                 log.appendLog("O pokémon vencedor é: " + foe.getPokemonName());
//                 break;
//             }

//             if (i%2 == priority){
//                 event = turn.makeAction(friend, foe);
//             } else {
//                 event = turn.makeAction(foe, friend);
//             }
//             log.appendLog(event);
            
//         }
//     }
//     public static void main(String[] args) {
//         testar();
//         log.showLog();
//     }
// }

package testSection;

import logSection.AttributeLog;
import turnSection.Turn;
import logSection.BattleLog;
import pokemonSection.pokedex.PokeRocket;
import pokemonSection.pokedex.PokeSOX;
import pokemonSection.pokedex.Pokemon;
import pokemonSection.constants.Type;


public class TestesParaPokemon {
    public static void testar() {
        BattleLog battleLog = new BattleLog(); // Instanciando um log para gravar a batalha.
        AttributeLog attributeLog = new AttributeLog(); // Instanciando um log para gravar atributos por turno.
        Turn turn = new Turn(); // Intanciando um turno para gerenciar a batalha.
        /* Settar o Nível dos Vilões e dos Heróis, isso é uma constante.
        *  Heróis deixei settado em 5.
        *  Acho que uma boa definição de dificuldade está em:
        *  - Muito Fácil: Settar nível 8 para os vilões.
        *  - Fácil: Settar nível 9 para os vilões.
        *  - Médio: Settar nível 10 para os vilões.
        *  - Difícil: Settar nível 11 para os vilões.
        *  - Muito Difícil: Settar nível 12 para os vilões.
        *  - Extremament Difiícil: Settar nível 15 para os vilões.
        *  - Impossível: Settar nível 20 para os vilões.
        */
        PokeSOX.setSoxLevel((byte) 10); // Nível dos heróis, padrão 10, limite 127.
        PokeRocket.setRocketLevel((byte) 10); // Nível dos heróis, padrão 10, limite 127.

        Pokemon friend = PokeSOX.takeAPokeSOX(
                "SOX - 01",
                (short) 47,
                Type.NORMAL,
                Type.FIRE);
        
        Pokemon foe = PokeRocket.takeAPokeRocket(
                "Rocket - 01",
                (short) 127,
                Type.WATER,
                Type.FIRE);
        
        battleLog.recordBattleInstant(friend, foe);
        attributeLog.recordCurrentBestAttributes(turn.getCurrentTurn());
        
        String battleEvent;
        int priority = turn.getNextPokemon(friend, foe);
        if (priority == 1){
            battleEvent = turn.makeAction(foe, friend);
            battleLog.appendLog(battleEvent);
            attributeLog.recordCurrentBestAttributes(turn.getCurrentTurn());
        }


        for (int i = 0; i < 100; i++) {
            if (turn.verifyIfDead(friend)){
                battleEvent = "O Vencedor é o Pokémon:\n" + foe.getPokemonName() + "\nO Perdedor é o Pokémon:\n" + friend.getPokemonName();
                battleLog.appendLog(battleEvent);
                break;
            }
            if (turn.verifyIfDead(foe)){
                battleEvent = "O Vencedor é o Pokémon:\n" + friend.getPokemonName() + "\nO Perdedor é o Pokémon:\n" + foe.getPokemonName();
                battleLog.appendLog(battleEvent);
                break;
            }

            if (i%2 == priority){
                battleEvent = turn.makeAction(friend, foe);
            } else {
                battleEvent = turn.makeAction(foe, friend);
            }
            battleLog.appendLog(battleEvent);
            attributeLog.recordCurrentBestAttributes(turn.getCurrentTurn());
        }

        attributeLog.showLog();
        battleLog.showLog();
    }

    public static void main(String[] args) {
        testar();
    }
}