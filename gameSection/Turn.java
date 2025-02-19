package gameSection;

import pokemonSection.constants.SideOfForce;
import pokemonSection.pokedex.DataPokemonAttackClass;
import pokemonSection.pokedex.Pokemon;

public class Turn {
    private int turnCounter = 0;


    public int getTurnCounter() {
        return turnCounter;
    }
    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public void runTurn(Pokemon chosenPokemon, Pokemon[] heroesList, Pokemon[] villainsList) {
        this.setTurnCounter(this.getTurnCounter()+1);

        if (chosenPokemon.getAreInConditionToFight()){
            if (Game.howManyAreInConditionToFight(heroesList) <= 0) {
                Log.addResultToTurn(SideOfForce.DARK);
                Game.setGameState(false);
                return;
            } else if (Game.howManyAreInConditionToFight(villainsList) <= 0) {
                Log.addResultToTurn(SideOfForce.LUMINOUS);
                Game.setGameState(false);
                return;
            }

            Pokemon targetPokemon;
            if (chosenPokemon.getSideOfForce() == SideOfForce.DARK) {
                targetPokemon = Game.selectAPokemon(heroesList);
            } else {
                targetPokemon = Game.selectAPokemon(villainsList);
            }

            DataPokemonAttackClass resultOfAttack = chosenPokemon.carryOutAttack(targetPokemon);

            // Verificar se os pokémons estão em condição de lutar.
            Game.areFitToFight(targetPokemon);
            Game.areFitToFight(chosenPokemon);

            Log.saveAttack(resultOfAttack, turnCounter);
            Log.addAttackToTurn();
        }
    }
}
