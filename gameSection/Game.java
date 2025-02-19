package gameSection;

import pokemonSection.constants.SideOfForce;
import pokemonSection.pokedex.*;

import java.util.*;

public class Game {
    private int numberOfHeros;
    private int numberOfVillains;
    private ArrayList<Log> allLogs = new ArrayList<>();
    private static boolean gameState = true;

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

    public static boolean isGameState() {
        return gameState;
    }
    public static void setGameState(boolean gameState) {
        Game.gameState = gameState;
    }

    private void setDifficultyLevel(int level) {
        //  Nível padrão para herói e vilão é 10

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

        pokemonsInstanceDict.put("Heroes", soxs);
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
        pokemons.addAll(Arrays.asList(pokemonsInstanceDict.get("Heroes")));
        pokemons.addAll(Arrays.asList(pokemonsInstanceDict.get("Villains")));
    }

    public static void areFitToFight(Pokemon pokemon) {
        if (pokemon.pokemonRemaingMovementsUses() <= 0 || pokemon.getHealthPoints() <= 0) pokemon.setAreInConditionToFight(false);
    }

    public static int howManyAreInConditionToFight(Pokemon[] pokemons) {
        int inConditionToFight = 0;
        for (Pokemon pokemon : pokemons) inConditionToFight += (pokemon.getAreInConditionToFight()) ? 1 : 0;
        return inConditionToFight;
    }

    public void run(int difficultLevel, int numberOfHeroesToGenerate, int numberOfVillainsToGenerate) {
        // 1. Settar o nível de dificuldade:
        this.setDifficultyLevel(difficultLevel);

        // 2. Criar os Inimigos e Aliados, definir por variável:
        Map<String, Pokemon[]> pokemonsInstanceDict = this.generatePokemons(numberOfHeroesToGenerate, numberOfVillainsToGenerate);

        // 3. Salvar o Número de Instâncias:
        setNumberOfHeros(PokeSOX.getNumberOfSOXs());
        setNumberOfVillains(PokeRocket.getNumberOfRockets());

        // 4. Separar os heróis e vilões:
        Pokemon[] heroesList = pokemonsInstanceDict.get("Heroes");
        Pokemon[] villainsList = pokemonsInstanceDict.get("Villains");

        // 5. Ordenar por Velocidade:
        Set<Pokemon> speedOrderedPokemonsList = new TreeSet<>(Comparator.comparingInt(Pokemon::getSpeedPoints).reversed());

        // 6. Adicionar as Instâncias à lista:
        this.addInstanceToTreeSet(pokemonsInstanceDict, speedOrderedPokemonsList);

        // 7. Iniciando o Log:
        Log.startGameLog(speedOrderedPokemonsList);

        // 8. Lógica das Batalhas:
        Turn turn = new Turn();
        Pokemon targetPokemon;
        DataPokemonAttackClass resultOfAttack;

        while (gameState) {
            // 8.5. Lógica do Turno:
            for (Pokemon chosenPokemon : speedOrderedPokemonsList) {
                turn.runTurn(chosenPokemon, heroesList, villainsList);
            }
        }
        Log.addTurnToGameLog();
        Log.endGameLog();
        Log.printGameLog();
    }
}
