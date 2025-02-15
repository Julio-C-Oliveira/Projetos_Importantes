package testSection;

import turnSection.Turn;
import turnSection.TurnAction;
import logSection.Log;
import pokemonSection.pokedex.PokeRocket;
import pokemonSection.pokedex.PokeSOX;
import pokemonSection.pokedex.Pokemon;
import pokemonSection.constants.Type;


public class TestesParaPokemon {
    public static void testar() {
        Log log = new Log(); // Instanciando um log para gravar batalhas e atributos por turno
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
        
        log.recordBattleInstant(friend, foe);
        log.recordCurrentBestAttributes(turn.getCurrentTurn());
        
        TurnAction turnActionResult = new TurnAction(); // Classe temporária para salvar estado do jogo.
        int priority = turn.getPriorityAttack(friend, foe);
        if (priority == 1){
            turnActionResult = turn.commitTurn(foe, friend);
            log.recordCurrentBestAttributes(turn.getCurrentTurn());
            log.appendLog(turnActionResult.getFoeAction());
            if (turn.verifyIfDead(friend)){
                log.appendLog(turnActionResult.getIsDead());
            }
        }

        for (int i = 0; i < 100; i++) {
            turnActionResult = turn.commitTurn(friend, foe);
            log.appendLog(turnActionResult.getFriendAction());
            if (turn.verifyIfDead(foe)){
                log.appendLog(turnActionResult.getIsDead());
                break;
            }
            
            log.appendLog(turnActionResult.getFoeAction());
            if (turn.verifyIfDead(friend)){
                log.appendLog(turnActionResult.getIsDead());
                break;
            }
            log.recordCurrentBestAttributes(turn.getCurrentTurn());
        }
        
        log.recordCurrentBestAttributes(turn.getCurrentTurn());
        log.showLog();
    }
}
