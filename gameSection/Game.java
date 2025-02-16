package gameSection;

import pokemonSection.attributes.AttributesWarehouse;
import pokemonSection.constants.Type;
import pokemonSection.pokedex.PokeRocket;
import pokemonSection.pokedex.PokeSOX;
import pokemonSection.pokedex.Pokemon;
import pokemonSection.pokedex.PokemonUtils;

import java.util.HashMap;
import java.util.Map;

// Players com os maiores atributos.
// Players com os menores atributos.
// Logs

// Métodos para Iniciar e Finalizar o jogo
// Gerência de Turnos

public class Game {
    // gameState, o que exatamente eu tenho que guardar aqui?
    int numberOfHeros;
    int numberOfVillains;

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
        pokemonsInstanceDict.put("Villains", soxs);
        return pokemonsInstanceDict;
    }

    public void run() {
        // 1. Settar o nível de dificuldade:
        this.setDifficultyLevel(3); // Adicionar input externo depois.

        // 2. Salvar o Número de Instâncias:
        setNumberOfHeros(PokeSOX.getNumberOfSOXs());
        setNumberOfVillains(PokeRocket.getNumberOfRockets());

        // 3. Criar os Inimigos e Aliados, definir por váriavel:
        Map<String, Pokemon[]> pokemonsInstanceDict = this.generatePokemons(10, 5);

        // 3. Selecionar dois por velocidade e enviar para o turno, rodar até uma das classes perder todos os seus pokémons. Após cada turno perguntar se deve continuar ou encerrar.

    }
}
