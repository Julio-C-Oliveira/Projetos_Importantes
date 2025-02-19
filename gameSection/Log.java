package gameSection;

import pokemonSection.attributes.PokemonAttributes;
import pokemonSection.constants.SideOfForce;
import pokemonSection.pokedex.DataPokemonAttackClass;
import pokemonSection.pokedex.PokeRocket;
import pokemonSection.pokedex.PokeSOX;
import pokemonSection.pokedex.Pokemon;

import java.util.List;

public class Log {
    private static String attackLog;
    private static StringBuilder turnLog = new StringBuilder();
    private static StringBuilder battleLog = new StringBuilder();
    private static StringBuilder gameLog = new StringBuilder();

    public static String getAttackLog() {
        return Log.attackLog;
    }
    public static void setAttackLog(String attackLog) {
        Log.attackLog = attackLog;
    }

    public static StringBuilder getTurnLog() {
        return Log.turnLog;
    }
    public static void setTurnLog(StringBuilder turnLog) {
        Log.turnLog = turnLog;
    }

    public static StringBuilder getBattleLog() {
        return Log.battleLog;
    }
    public static void setBattleLog(StringBuilder battleLog) {
        Log.battleLog = battleLog;
    }

    public static StringBuilder getGameLog() {
        return Log.gameLog;
    }
    public static void setGameLog(StringBuilder gameLog) {
        Log.gameLog = gameLog;
    }

    public static void saveAttack(DataPokemonAttackClass resultOfAttack, int turnCounter) {
        Log.setAttackLog(String.format(
                "|----------------------| Turno: %05d |----------------------|\n" +
                "| %s usou %s!\n" +
                "| Resultado do Ataque: %s\n" +
                "| Usos restantes: %d\n" +
                "| Dano Infligido: %d\n" +
                "| Vida de %s: %d\n" +
                "| Vida após o Ataque: %d\n" +
                "|------------------------------------------------------------|",
                turnCounter,
                resultOfAttack.pokemonAggressor,
                resultOfAttack.skillUsed,
                resultOfAttack.hitLevel,
                resultOfAttack.remainingUses,
                resultOfAttack.inflictedDamage,
                resultOfAttack.pokemonAssaulted,
                resultOfAttack.healthPointsBeforeAttack,
                resultOfAttack.healthPointsAfterAttack
        ));
    }

    public static void addAttackToTurn() {
        Log.getTurnLog().append(Log.getAttackLog()).append("\n");
    }

    public static void addResultToTurn(SideOfForce whoWins) {
        if (whoWins == SideOfForce.DARK) {
            Log.getTurnLog().append(String.format("\nNível dos heróis: %02d\nNível dos vilões: %02d\n", PokeSOX.getSoxLevel(), PokeRocket.getRocketLevel()));
            Log.getTurnLog().append("\nOs heróis foram derrotados\nOs vilões venceram!!!\n");
        } else {
            Log.getTurnLog().append(String.format("\nNível dos heróis: %02d\nNível dos vilões: %02d\n", PokeSOX.getSoxLevel(), PokeRocket.getRocketLevel()));
            Log.getTurnLog().append("\nOs vilões foram derrotados\nOs heróis venceram!!!\n");
        }
    }

    public static void startGameLog(List<Pokemon> speedOrderedPokemonsList) {
        // 7. Ordem de ataque:
        Log.getGameLog().append("##### Pokémons ordenados por velocidade #####\n");
        for (Pokemon pokemon : speedOrderedPokemonsList) {
            Log.getGameLog().append(String.format("Nome: %s\nPontos de Velocidade: %s\n\n", pokemon.getPokemonName(), pokemon.getSpeedPoints()));
        }

        // 8. Melhores e piores em campo, no ínicio:
        Log.getGameLog().append("|------------------------------||  Melhores e Piores em Campo  ||------------------------------|\n");
        Log.getGameLog().append(PokemonAttributes.pokemonBestAndWorstAttributesInString()).append("\n");

        Log.getGameLog().append("### BATALHA INICIADA ###\n\n");
    }
    public static void addTurnToGameLog() {
        Log.getGameLog().append(Log.getTurnLog());
    }
    public static void endGameLog() {
        // 8. Melhores e piores em campo, no final:
        Log.getGameLog().append("\n").append("|------------------------------||  Melhores e Piores em Campo  ||------------------------------|\n");
        Log.getGameLog().append(PokemonAttributes.pokemonBestAndWorstAttributesInString());
    }
    public static void printGameLog() {
        System.out.println(Log.getGameLog());
    }
}
