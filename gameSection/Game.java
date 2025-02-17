package gameSection;

import logSection.Log;
import pokemonSection.pokedex.PokeRocket;
import pokemonSection.pokedex.PokeSOX;
import pokemonSection.pokedex.Pokemon;
import pokemonSection.pokedex.PokemonUtils;
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
            case 2: // Fácil
                PokeRocket.setRocketLevel((byte) 9);
            case 3: // Normal
                PokeRocket.setRocketLevel((byte) 10);
            case 4: // Difícil
                PokeRocket.setRocketLevel((byte) 11);
            case 5: // Muito Difícil
                PokeRocket.setRocketLevel((byte) 12);
            case 6: // Extremamente Difícil
                PokeRocket.setRocketLevel((byte) 15);
            case 7: // Impossível
                PokeRocket.setRocketLevel((byte) 20);
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

    public void addInstanceToHeap(Map<String, Pokemon[]> pokemonsInstanceDict, PriorityQueue<Pokemon> pokemonHerosHeap, PriorityQueue<Pokemon> pokemonVillainsHeap) {
        pokemonHerosHeap.addAll(Arrays.asList(pokemonsInstanceDict.get("Heros")));
        pokemonVillainsHeap.addAll(Arrays.asList(pokemonsInstanceDict.get("Villains")));
    }

    public void run(int difficultLevel, int numberOfHerosToGenerate, int numberOfVillainsToGenerate) {
        // 1. Settar o nível de dificuldade:
        this.setDifficultyLevel(difficultLevel); // Adicionar input externo depois.

        // 2. Criar os Inimigos e Aliados, definir por váriavel:
        Map<String, Pokemon[]> pokemonsInstanceDict = this.generatePokemons(numberOfHerosToGenerate, numberOfVillainsToGenerate);

        // 3. Salvar o Número de Instâncias:
        setNumberOfHeros(PokeSOX.getNumberOfSOXs());
        setNumberOfVillains(PokeRocket.getNumberOfRockets());

        // 4. Selecionar dois por velocidade e enviar para o turno, rodar até uma das classes perder todos os seus pokémons. Após cada turno perguntar se deve continuar ou encerrar.
        // 4.1 Criar os Heaps:
        PriorityQueue<Pokemon> speedMaxHeapHeros = new PriorityQueue<>(new Comparator<Pokemon>() {
            public int compare(Pokemon pokemon01, Pokemon pokemon02) {
                return Integer.compare(pokemon02.getSpeedPoints(), pokemon01.getSpeedPoints());
            }
        });
        PriorityQueue<Pokemon> speedMaxHeapVillains = new PriorityQueue<>(new Comparator<Pokemon>() {
            public int compare(Pokemon pokemon01, Pokemon pokemon02) {
                return Integer.compare(pokemon02.getSpeedPoints(), pokemon01.getSpeedPoints());
            }
        });

        // 4.2 Adicionar as Instâncias ao Heap:
        this.addInstanceToHeap(pokemonsInstanceDict, speedMaxHeapHeros, speedMaxHeapVillains);

        // 4.3 Pegar os melhores e mandar pro Turno:
        Pokemon hero;
        Pokemon villain;
        int counter = 1;

        while (!speedMaxHeapHeros.isEmpty() && !speedMaxHeapVillains.isEmpty()) {
            hero = speedMaxHeapHeros.poll();
            villain = speedMaxHeapVillains.poll();

            System.out.printf("##### BATALHA POKÉMON %03d #####\n\n", counter); // Isso tem que ser adicionado ao Log.
            this.getAllLogs().add(Turn.runTurn(hero, villain));
            counter++;
        }

        // Verificar quem ganhou a batalha por críterios:
        // 1. Qual equipe tem mais personagens vivos, ou seja, com a vida acima de 0.
        // 2. Quantia de vida.
        // 3. Sorteio.
    }
}
