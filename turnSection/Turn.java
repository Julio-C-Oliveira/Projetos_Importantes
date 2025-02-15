package turnSection;

import pokemonSection.pokedex.Pokemon;
import pokemonSection.pokedex.DataPokemonAttackClass;

public class Turn {
    private int countTurn = 0;

    public int getNextPokemon(Pokemon friend, Pokemon foe){
        if (friend.getSpeedPoints() >= foe.getSpeedPoints()){
            return 0;
        } else {
            return 1;
        }
    }

    public String makeAction(Pokemon friend, Pokemon foe){
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
        ++countTurn,
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

    public boolean verifyIfDead(Pokemon pokemon){
        if (pokemon.getHealthPoints() <= 0)
            return true;
        return false;
    }

    public int getCurrentTurn(){
        return countTurn;
    }

}