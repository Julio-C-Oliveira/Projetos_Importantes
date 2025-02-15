package turnSection;

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
        String friendWins = "O Vencedor é o Pokémon:\n" + friend.toString() + "\n\nO Perdedor é o Pokémon:\n" + foe.toString();
        String foeWins = "O Vencedor é o Pokémon:\n" + foe.toString() + "\n\nO Perdedor é o Pokémon:\n" + friend.toString();

        friendAttacks = getPokemonAction(friend, foe); // Amigo ataca.
        turnAction.setFriendAction(friendAttacks); // Salva ataque aliado.
        // Se pokémon inimigo morre...
        if (verifyIfDead(foe)){
            turnAction.setIsDead(friendWins); // Salva morte do inimigo e declara amigo vencedor
            return turnAction;
        }
        
        foeAttacks = getPokemonAction(foe, friend); // Inimigo ataca primeiro.
        turnAction.setFoeAction(foeAttacks); // Salva ataque inimigo.
        // Se pokémon amigo morre...
        if (verifyIfDead(friend)){
            turnAction.setIsDead(foeWins); // Salva morte do amigo e declara inimigo vencedor
            return turnAction;
        }

        return turnAction;
    }


    public boolean verifyIfDead(Pokemon pokemon){
        if (pokemon.getHealthPoints() <= 0)
            return true;
        return false;
    }

    public int getCurrentTurn(){
        return countTurn;
    }

}