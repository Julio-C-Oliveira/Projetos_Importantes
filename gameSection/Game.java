package gameSection;

import logSection.Log;
import pokemonSection.attributes.MoveBase;
import pokemonSection.attributes.PokemonAttributes;
import pokemonSection.constants.SideOfForce;
import pokemonSection.pokedex.*;
import turnSection.Turn;

import java.util.*;

// Players com os maiores atributos.
// Players com os menores atributos.
// Logs

// Métodos para Iniciar e Finalizar o jogo
// Gerência de Turnos

public class Game {
    // gameState, o que exatamente eu tenho que guardar aqui?
    int numberOfHeros;
    int numberOfVillains;
    ArrayList<Log> allLogs = new ArrayList<>();

    public int getNumberOfHeros() {
        return numberOfHeros;
    }
    public void setNumberOfHeros(int numberOfHeros) {
        this.numberOfHeros = numberOfHeros;
    }

    public int getNumberOfVillains() {
        return numberOfVillains;
    }
    public void setNumberOfVillains(int numberOfVillains) {
        this.numberOfVillains = numberOfVillains;
    }

    public ArrayList<Log> getAllLogs() {
        return allLogs;
    }
    public void setAllLogs(ArrayList<Log> allLogs) {
        this.allLogs = allLogs;
    }

    private void setDifficultyLevel(int level) {
        //  Nível padrão para héroi e vilão é 10

        PokeSOX.setSoxLevel((byte) 10);

        switch (level) {
            case 1: // Muito Fácil
                PokeRocket.setRocketLevel((byte) 8);
                break;
            case 2: // Fácil
                PokeRocket.setRocketLevel((byte) 9);
                break;
            case 3: // Normal
                PokeRocket.setRocketLevel((byte) 10);
                break;
            case 4: // Difícil
                PokeRocket.setRocketLevel((byte) 11);
                break;
            case 5: // Muito Difícil
                PokeRocket.setRocketLevel((byte) 12);
                break;
            case 6: // Extremamente Difícil
                PokeRocket.setRocketLevel((byte) 15);
                break;
            case 7: // Impossível
                PokeRocket.setRocketLevel((byte) 20);
                break;
            default:
                System.out.println("A opção escolhida é inválida, nível normal selecionado no lugar.\n");
                PokeRocket.setRocketLevel((byte) 10);
                break;
        }
    }
    private Map<String, Pokemon[]> generatePokemons(int numberOfHerosOnGame, int numberOfVillainsOnGame) {
        Map<String, Pokemon[]> pokemonsInstanceDict = new HashMap<>();
        Pokemon[] soxs = new Pokemon[numberOfHerosOnGame];
        Pokemon[] rockets = new Pokemon[numberOfVillainsOnGame];

        for (int i = 1; i <= numberOfHerosOnGame; i++) {
            soxs[i-1] = PokeSOX.takeAPokeSOX(
                    String.format("Hero - %03d", i),
                    (short) i,
                    PokemonUtils.selectRandomType(),
                    PokemonUtils.selectRandomType()
            );
        }
        for (int i = 1; i <= numberOfVillainsOnGame; i++) {
            rockets[i-1] = PokeRocket.takeAPokeRocket(
                    String.format("Villain - %03d", i),
                    (short) i,
                    PokemonUtils.selectRandomType(),
                    PokemonUtils.selectRandomType()
            );
        }

        pokemonsInstanceDict.put("Heros", soxs);
        pokemonsInstanceDict.put("Villains", rockets);
        return pokemonsInstanceDict;
    }

    private static boolean isThereAnyoneAlive(Pokemon[] pokemons) {
        int timeHealthPoints = 0;
        for (Pokemon pokemon : pokemons) timeHealthPoints += pokemon.getHealthPoints();
        return (timeHealthPoints > 0);
    }

    private static boolean isAlive(Pokemon pokemon) {
        return (pokemon.getHealthPoints() > 0);
    }

    private static Pokemon selectARandomPokemon(Pokemon[] pokemons) {
        Random random = new Random();
        return pokemons[random.nextInt(pokemons.length)];
    }

    public static Pokemon selectAPokemon(Pokemon[] pokemons) {
        Pokemon targetPokemon;
        do {
            targetPokemon = Game.selectARandomPokemon(pokemons);
        } while (!Game.isAlive(targetPokemon));
        return targetPokemon;
    }

    public static boolean anyoneHaveAMoveToUse(Pokemon[] pokemons) {
        int remaingMovesUses = 0;
        for (Pokemon pokemon : pokemons) remaingMovesUses += pokemon.pokemonRemaingMovementsUses();
        return (remaingMovesUses > 0);
    }

    public void addInstanceToTreeSet(Map<String, Pokemon[]> pokemonsInstanceDict, Set<Pokemon> pokemons) {
        pokemons.addAll(Arrays.asList(pokemonsInstanceDict.get("Heros")));
        pokemons.addAll(Arrays.asList(pokemonsInstanceDict.get("Villains")));
    }

    public void run(int difficultLevel, int numberOfHerosToGenerate, int numberOfVillainsToGenerate) {
        // 0. Variáveis que serão utilizadas:
        DataPokemonAttackClass resultOfAttack;
        boolean gameState = true;

        String attackLog;
        StringBuilder turnLog = new StringBuilder();
        StringBuilder battleLog = new StringBuilder();
        StringBuilder gameLog = new StringBuilder();

        int turnCounter = 0;

        // 1. Settar o nível de dificuldade:
        this.setDifficultyLevel(difficultLevel);

        // 2. Criar os Inimigos e Aliados, definir por variável:
        Map<String, Pokemon[]> pokemonsInstanceDict = this.generatePokemons(numberOfHerosToGenerate, numberOfVillainsToGenerate);

        // 3. Salvar o Número de Instâncias:
        setNumberOfHeros(PokeSOX.getNumberOfSOXs());
        setNumberOfVillains(PokeRocket.getNumberOfRockets());

        // 4. Separar os heróis e vilões:
        Pokemon[] herosList = pokemonsInstanceDict.get("Heros");
        Pokemon[] villainsList = pokemonsInstanceDict.get("Villains");

        // 5. Ordenar por Velocidade:
        Set<Pokemon> speedOrderedPokemonsList = new TreeSet<>(Comparator.comparingInt(Pokemon::getSpeedPoints).reversed());

        // 6. Adicionar as Instâncias à lista:
        this.addInstanceToTreeSet(pokemonsInstanceDict, speedOrderedPokemonsList);

        // 7. Ordem de ataque:
        gameLog.append("##### Pokémons ordenados por velocidade #####\n");
        for (Pokemon pokemon : speedOrderedPokemonsList) {
            gameLog.append(String.format("Nome: %s\nPontos de Velocidade: %s\n\n", pokemon.getPokemonName(), pokemon.getSpeedPoints()));
        }

        // 8. Melhores e piores em campo, no ínicio:
        gameLog.append("|------------------------------||  Melhores e Piores em Campo  ||------------------------------|\n");
        gameLog.append(PokemonAttributes.pokemonBestAttributesInString());
        gameLog.append(PokemonAttributes.pokemonWorstAttributesInString()).append("\n");

        // 9. Lógica das Batalhas:

        gameLog.append("### BATALHA INICIADA ###\n\n");
        
        // Em uma execução não apareceu nada mais estava rodando, verificar a possibilidade de estar travando no loop de alguma forma.

        while (gameState) {

            // 9.5. Lógica do Turno:
            for (Pokemon chosenPokemon : speedOrderedPokemonsList) {
                turnCounter++;

                if (!isThereAnyoneAlive(herosList) || !anyoneHaveAMoveToUse(herosList)) {
                    turnLog.append(String.format("\nNível dos heróis: %02d\nNível dos vilões: %02d\n", PokeSOX.getSoxLevel(), PokeRocket.getRocketLevel()));
                    turnLog.append("\nOs heróis foram derrotados\nOs vilões venceram!!!\n");
                    gameState = false;
                    break;
                } else if (!isThereAnyoneAlive(villainsList) || !anyoneHaveAMoveToUse(villainsList)) {
                    turnLog.append(String.format("\nNível dos heróis: %02d\nNível dos vilões: %02d\n", PokeSOX.getSoxLevel(), PokeRocket.getRocketLevel()));
                    turnLog.append("\nOs vilões foram derrotados\nOs heróis venceram!!!\n");
                    gameState = false;
                    break;
                }

                if (chosenPokemon.getSideOfForce() == SideOfForce.DARK) {
                    resultOfAttack = chosenPokemon.carryOutAttack(Game.selectAPokemon(herosList));
                } else {
                    resultOfAttack = chosenPokemon.carryOutAttack(Game.selectAPokemon(villainsList));
                }

                attackLog = String.format(
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
                );

                turnLog.append(attackLog).append("\n");
            }
        }
        gameLog.append(turnLog);

        // 10. Melhores e piores em campo, no fim:
        gameLog.append("\n").append("|------------------------------||  Melhores e Piores em Campo  ||------------------------------|\n");
        gameLog.append(PokemonAttributes.pokemonBestAttributesInString());
        gameLog.append(PokemonAttributes.pokemonWorstAttributesInString());

        System.out.println(gameLog);
    }
}
