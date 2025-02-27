package gameSection;

import pokemonSection.attributes.PokemonAttributes;
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

    public void addInstanceToTreeSet(Map<String, Pokemon[]> pokemonsInstanceDict, Set<Pokemon> pokemons) {
        System.out.printf("Número de Heróis: %d | Número de Vilões: %d\n\n", Arrays.stream(pokemonsInstanceDict.get("Heroes")).toList().size(), Arrays.stream(pokemonsInstanceDict.get("Villains")).toList().size());

        pokemons.addAll(Arrays.asList(pokemonsInstanceDict.get("Heroes")));
        pokemons.addAll(Arrays.asList(pokemonsInstanceDict.get("Villains")));
    }
    public void addInstanceToTreeSet(Map<String, Pokemon[]> pokemonsInstanceDict, List<Pokemon> pokemons) {
        System.out.printf("Número de Heróis: %d | Número de Vilões: %d\n\n", Arrays.stream(pokemonsInstanceDict.get("Heroes")).toList().size(), Arrays.stream(pokemonsInstanceDict.get("Villains")).toList().size());

        pokemons.addAll(Arrays.asList(pokemonsInstanceDict.get("Heroes")));
        pokemons.addAll(Arrays.asList(pokemonsInstanceDict.get("Villains")));
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

        // 5. Iniciando o Log:
        PokemonAttributes.updateLists();
        Log.startGameLog(PokemonAttributes.getSpeedList());

        // 6. Lógica das Batalhas:
        Turn turn = new Turn();

        while (gameState) {
            // 6.5. Lógica do Turno:
            Turn.setTurnCounter(Turn.getTurnCounter()+1);
            for (Pokemon chosenPokemon : PokemonAttributes.getSpeedList()) {
                turn.runTurn(chosenPokemon, heroesList, villainsList);
                if (!Game.gameState) break;
            }
        }

        // 7. Adicionando o final ao Log:
        Log.addTurnToGameLog();
        Log.endGameLog();
        Log.printGameLog();
    }
}
