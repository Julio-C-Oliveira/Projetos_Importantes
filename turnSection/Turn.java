package turnSection;

import logSection.Log;
import pokemonSection.pokedex.Pokemon;
import pokemonSection.pokedex.DataPokemonAttackClass;

public class Turn {
    private int countTurn = 0;

    public int getPriorityAttack(Pokemon friend, Pokemon foe){
        if (friend.getSpeedPoints() >= foe.getSpeedPoints()){
            return 0;
        } else {
            return 1;
        }
    }

    private String getPokemonAction(Pokemon friend, Pokemon foe){
        String event;
        DataPokemonAttackClass resultOfAttack = friend.carryOutAttack(foe);
        
        event = String.format(
        "--------------------------------------------------------------------" +
        "| Turno: %d\n" + 
        "| %s usou %s!\n" + 
        "| Resultado do Ataque: %s\n" + 
        "| Usos restantes: %d\n" + 
        "| Dano Infligido: %d\n" + 
        "| Vida de %s: %d\n" + 
        "| Vida após o Ataque: %d\n" +
        "--------------------------------------------------------------------"
        ,
        countTurn,
        friend.getPokemonName(),
        resultOfAttack.skillUsed,
        resultOfAttack.hitLevel,
        resultOfAttack.remainingUses,
        resultOfAttack.inflictedDamage,
        foe.getPokemonName(),
        resultOfAttack.healthPointsBeforeAttack,
        resultOfAttack.healthPointsAfterAttack);
        return event;
    }

    public TurnAction commitTurn(Pokemon friend, Pokemon foe){
        ++countTurn;
        TurnAction turnAction = new TurnAction();
        String foeAttacks;
        String friendAttacks;
        String friendWins = "O Vencedor é o Pokémon:\n" + friend + "\n\nO Perdedor é o Pokémon:\n" + foe;
        String foeWins = "O Vencedor é o Pokémon:\n" + foe + "\n\nO Perdedor é o Pokémon:\n" + friend;

        friendAttacks = getPokemonAction(friend, foe); // Amigo ataca.
        System.out.println(friend.pokemonRemaingMovementsUses());
        turnAction.setFriendAction(friendAttacks); // Salva ataque aliado.
        // Se pokémon inimigo morre...
        if (verifyIfDead(foe) || foe.pokemonRemaingMovementsUses() <= 0){
            turnAction.setIsDead(friendWins); // Salva morte do inimigo e declara amigo vencedor
            return turnAction;
        }
        
        foeAttacks = getPokemonAction(foe, friend); // Inimigo ataca primeiro.
        System.out.println(foe.pokemonRemaingMovementsUses());
        turnAction.setFoeAction(foeAttacks); // Salva ataque inimigo.
        // Se pokémon amigo morre...
        if (verifyIfDead(friend) || friend.pokemonRemaingMovementsUses() <= 0){
            turnAction.setIsDead(foeWins); // Salva morte do amigo e declara inimigo vencedor
            return turnAction;
        }

        return turnAction;
    }

    public boolean verifyIfDead(Pokemon pokemon){
        return pokemon.getHealthPoints() <= 0;
    }

    public int getCurrentTurn(){
        return countTurn;
    }

    public static Log runTurn(Pokemon hero, Pokemon villain) {
        Log log = new Log(); // Instanciando um log para gravar batalhas e atributos por turno
        Turn turn = new Turn(); // Intanciando um turno para gerenciar a batalha.

        log.recordBattleInstant(hero, villain);
        log.recordCurrentBestAttributes(turn.getCurrentTurn());

        TurnAction turnActionResult = new TurnAction(); // Classe temporária para salvar estado do jogo.
        int priority = turn.getPriorityAttack(hero, villain);
        if (priority == 1){
            turnActionResult = turn.commitTurn(villain, hero);
            log.recordCurrentBestAttributes(turn.getCurrentTurn());
            log.appendLog(turnActionResult.getFoeAction());
            if (turn.verifyIfDead(hero)){
                log.appendLog(turnActionResult.getIsDead());
            }
        }

        int counter = 0;
        int SHIFTLIMIT = 150;

        while (true) {
            turnActionResult = turn.commitTurn(hero, villain);
            log.appendLog(turnActionResult.getFriendAction());
            if (turn.verifyIfDead(villain) || villain.pokemonRemaingMovementsUses() < 1){
                log.appendLog(turnActionResult.getIsDead());
                break;
            }

            log.appendLog(turnActionResult.getFoeAction());
            if (turn.verifyIfDead(hero) || hero.pokemonRemaingMovementsUses() < 1){
                log.appendLog(turnActionResult.getIsDead());
                break;
            }

            if (counter >= SHIFTLIMIT) break;

            log.recordCurrentBestAttributes(turn.getCurrentTurn());
            counter++;
        }

        log.recordCurrentBestAttributes(turn.getCurrentTurn());
        log.showLog();

        return log;
    }

}