package pokemonSection.attributes;

import pokemonSection.pokedex.Pokemon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PokemonBestAttributes {
    private static PriorityQueue<Pokemon> healthMaxHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
        public int compare(Pokemon pokemon01, Pokemon pokemon02) {
            return Integer.compare(pokemon01.getHealthPoints(), pokemon02.getHealthPoints());
        }
    });
    private static PriorityQueue<Pokemon> attackMaxHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
        public int compare(Pokemon pokemon01, Pokemon pokemon02) {
            return Integer.compare(pokemon01.getAttackPoints(), pokemon02.getAttackPoints());
        }
    });
    private static PriorityQueue<Pokemon> defenseMaxHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
        public int compare(Pokemon pokemon01, Pokemon pokemon02) {
            return Integer.compare(pokemon01.getDefensivePoints(), pokemon02.getDefensivePoints());
        }
    });
    private static PriorityQueue<Pokemon> speedMaxHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
        public int compare(Pokemon pokemon01, Pokemon pokemon02) {
            return Integer.compare(pokemon01.getSpeedPoints(), pokemon02.getSpeedPoints());
        }
    });
    private static PriorityQueue<Pokemon> dexterityMaxHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
        public int compare(Pokemon pokemon01, Pokemon pokemon02) {
            return Integer.compare(pokemon01.getDexterityPoints(), pokemon02.getDexterityPoints());
        }
    });
    private static PriorityQueue<Pokemon> specialMaxHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
        public int compare(Pokemon pokemon01, Pokemon pokemon02) {
            return Integer.compare(pokemon01.getSpecialPoints(), pokemon02.getSpecialPoints());
        }
    });

    public static PriorityQueue<Pokemon> getHealthMaxHeap() {
        return healthMaxHeap;
    }
    public static void setHealthMaxHeap(PriorityQueue<Pokemon> healthMaxHeap) {
        PokemonBestAttributes.healthMaxHeap = healthMaxHeap;
    }

    public static PriorityQueue<Pokemon> getAttackMaxHeap() {
        return attackMaxHeap;
    }
    public static void setAttackMaxHeap(PriorityQueue<Pokemon> attackMaxHeap) {
        PokemonBestAttributes.attackMaxHeap = attackMaxHeap;
    }

    public static PriorityQueue<Pokemon> getDefenseMaxHeap() {
        return defenseMaxHeap;
    }
    public static void setDefenseMaxHeap(PriorityQueue<Pokemon> defenseMaxHeap) {
        PokemonBestAttributes.defenseMaxHeap = defenseMaxHeap;
    }

    public static PriorityQueue<Pokemon> getSpeedMaxHeap() {
        return speedMaxHeap;
    }
    public static void setSpeedMaxHeap(PriorityQueue<Pokemon> speedMaxHeap) {
        PokemonBestAttributes.speedMaxHeap = speedMaxHeap;
    }

    public static PriorityQueue<Pokemon> getDexterityMaxHeap() {
        return dexterityMaxHeap;
    }
    public static void setDexterityMaxHeap(PriorityQueue<Pokemon> dexterityMaxHeap) {
        PokemonBestAttributes.dexterityMaxHeap = dexterityMaxHeap;
    }

    public static PriorityQueue<Pokemon> getSpecialMaxHeap() {
        return specialMaxHeap;
    }
    public static void setSpecialMaxHeap(PriorityQueue<Pokemon> specialMaxHeap) {
        PokemonBestAttributes.specialMaxHeap = specialMaxHeap;
    }

    public static void addPokemonToAttibutesHeaps(Pokemon pokemon) {
        PokemonBestAttributes.getHealthMaxHeap().add(pokemon);
        PokemonBestAttributes.getAttackMaxHeap().add(pokemon);
        PokemonBestAttributes.getDefenseMaxHeap().add(pokemon);
        PokemonBestAttributes.getSpeedMaxHeap().add(pokemon);
        PokemonBestAttributes.getDexterityMaxHeap().add(pokemon);
        PokemonBestAttributes.getSpecialMaxHeap().add(pokemon);
    }

    public static void updateAttributesHeaps() {
        Pokemon pokemon = PokemonBestAttributes.getHealthMaxHeap().poll();
        PokemonBestAttributes.getHealthMaxHeap().add(pokemon);

        pokemon = PokemonBestAttributes.getAttackMaxHeap().poll();
        PokemonBestAttributes.getAttackMaxHeap().add(pokemon);

        pokemon = PokemonBestAttributes.getDefenseMaxHeap().poll();
        PokemonBestAttributes.getDefenseMaxHeap().add(pokemon);

        pokemon = PokemonBestAttributes.getSpeedMaxHeap().poll();
        PokemonBestAttributes.getSpeedMaxHeap().add(pokemon);

        pokemon = PokemonBestAttributes.getDexterityMaxHeap().poll();
        PokemonBestAttributes.getDexterityMaxHeap().add(pokemon);

        pokemon = PokemonBestAttributes.getSpecialMaxHeap().poll();
        PokemonBestAttributes.getSpecialMaxHeap().add(pokemon);
    }

    public static String pokemonBestAttributes() {
        PokemonBestAttributes.updateAttributesHeaps();

        Pokemon pokemonMaxHealth = PokemonBestAttributes.getHealthMaxHeap().peek();
        Pokemon pokemonMaxAttack = PokemonBestAttributes.getAttackMaxHeap().peek();
        Pokemon pokemonMaxDefense = PokemonBestAttributes.getDefenseMaxHeap().peek();
        Pokemon pokemonMaxSpeed = PokemonBestAttributes.getSpeedMaxHeap().peek();
        Pokemon pokemonMaxDexterity = PokemonBestAttributes.getDexterityMaxHeap().peek();
        Pokemon pokemonMaxSpecial = PokemonBestAttributes.getSpecialMaxHeap().peek();

        return String.format("### Pokémons com os melhores atributos em Campo:\n# Maior Vida:\nNome: %s\nPontos de Vida: %s\n\n# Maior Ataque:\nNome: %s\nPontos de Ataque: %s\n\n# Maior Defesa:\nNome: %s\nPontos de Defesa: %s\n\n# Maior Velocidade:\nNome: %s\nPontos de Velocidade: %s\n\n# Maior Destreza:\nNome: %s\nPontos de Destreza: %s\n\n#Maior Especial:\nNome: %s\nPontos de Especial: %s\n\n",
                pokemonMaxHealth.getPokemonName(),
                pokemonMaxHealth.getHealthPoints(),
                pokemonMaxAttack.getPokemonName(),
                pokemonMaxAttack.getAttackPoints(),
                pokemonMaxDefense.getPokemonName(),
                pokemonMaxDefense.getDefensivePoints(),
                pokemonMaxSpeed.getPokemonName(),
                pokemonMaxSpeed.getSpeedPoints(),
                pokemonMaxDexterity.getPokemonName(),
                pokemonMaxDexterity.getDexterityPoints(),
                pokemonMaxSpecial.getPokemonName(),
                pokemonMaxSpecial.getSpecialPoints());
    }
}
