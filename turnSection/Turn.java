package turnSection;

import pokemonSection.Pokemon;
import pokemonSection.DataPokemonAttackClass;

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
        
        event = String.format("""
        | Turno: %d
        | %s usou %s!
        | Resultado do Ataque: %s
        | Usos restantes: %d
        | Dano Infligido: %d
        | Vida de %s: %d
        | Vida após o Ataque: %d
        --------------------------------------------------------------------
        """,
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

}

// event = String.format("Turno: %d\n" +
// "Evento: " +  
// "Resultado do Ataque: %s\n" +
// "Habilidade Utilizada: %s | Usos restantes: %s\n" +
// "Dano Infligido: %d\n" +
// "Vida do Inimigo: %d\n" +
// "Vida após o Ataque: %d\n\n", 
// ++countTurn,
// resultOfAttack.hitLevel,
// resultOfAttack.skillUsed, 
// resultOfAttack.remainingUses, 
// resultOfAttack.inflictedDamage, 
// resultOfAttack.healthPointsBeforeAttack, 
// resultOfAttack.healthPointsAfterAttack);
// return event;