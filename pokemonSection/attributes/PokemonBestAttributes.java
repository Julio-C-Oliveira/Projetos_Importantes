package pokemonSection.attributes;

import pokemonSection.pokedex.Pokemon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PokemonBestAttributes {
    private static PriorityQueue<Pokemon> healthMaxHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
        public int compare(Pokemon pokemon01, Pokemon pokemon02) {
            return Integer.compare(pokemon02.getHealthPoints(), pokemon01.getHealthPoints()); // O antigo era, mas inverti pra virar um heap máximo return Integer.compare(pokemon01.getHealthPoints(), pokemon02.getHealthPoints())
        }
    });
    private static PriorityQueue<Pokemon> attackMaxHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
        public int compare(Pokemon pokemon01, Pokemon pokemon02) {
            return Integer.compare(pokemon02.getAttackPoints(), pokemon01.getAttackPoints());
        }
    });
    private static PriorityQueue<Pokemon> defenseMaxHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
        public int compare(Pokemon pokemon01, Pokemon pokemon02) {
            return Integer.compare(pokemon02.getDefensivePoints(), pokemon01.getDefensivePoints());
        }
    });
    private static PriorityQueue<Pokemon> speedMaxHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
        public int compare(Pokemon pokemon01, Pokemon pokemon02) {
            return Integer.compare(pokemon02.getSpeedPoints(), pokemon01.getSpeedPoints());
        }
    });
    private static PriorityQueue<Pokemon> dexterityMaxHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
        public int compare(Pokemon pokemon01, Pokemon pokemon02) {
            return Integer.compare(pokemon02.getDexterityPoints(), pokemon01.getDexterityPoints());
        }
    });
    private static PriorityQueue<Pokemon> specialMaxHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
        public int compare(Pokemon pokemon01, Pokemon pokemon02) {
            return Integer.compare(pokemon02.getSpecialPoints(), pokemon01.getSpecialPoints());
        }
    });
    private static PriorityQueue<Pokemon> healthMinHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
        public int compare(Pokemon pokemon01, Pokemon pokemon02) {
            return Integer.compare(pokemon01.getHealthPoints(), pokemon02.getHealthPoints()); // O antigo era, mas inverti pra virar um heap máximo return Integer.compare(pokemon01.getHealthPoints(), pokemon02.getHealthPoints())
        }
    });
    private static PriorityQueue<Pokemon> attackMinHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
        public int compare(Pokemon pokemon01, Pokemon pokemon02) {
            return Integer.compare(pokemon01.getAttackPoints(), pokemon02.getAttackPoints());
        }
    });
    private static PriorityQueue<Pokemon> defenseMinHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
        public int compare(Pokemon pokemon01, Pokemon pokemon02) {
            return Integer.compare(pokemon01.getDefensivePoints(), pokemon02.getDefensivePoints());
        }
    });
    private static PriorityQueue<Pokemon> speedMinHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
        public int compare(Pokemon pokemon01, Pokemon pokemon02) {
            return Integer.compare(pokemon01.getSpeedPoints(), pokemon02.getSpeedPoints());
        }
    });
    private static PriorityQueue<Pokemon> dexterityMinHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
        public int compare(Pokemon pokemon01, Pokemon pokemon02) {
            return Integer.compare(pokemon01.getDexterityPoints(), pokemon02.getDexterityPoints());
        }
    });
    private static PriorityQueue<Pokemon> specialMinHeap = new PriorityQueue<>(new Comparator<Pokemon>() {
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

    public static PriorityQueue<Pokemon> getHealthMinHeap() {
        return healthMinHeap;
    }
    public static void setHealthMinHeap(PriorityQueue<Pokemon> healthMinHeap) {
        PokemonBestAttributes.healthMinHeap = healthMinHeap;
    }

    public static PriorityQueue<Pokemon> getAttackMinHeap() {
        return attackMinHeap;
    }
    public static void setAttackMinHeap(PriorityQueue<Pokemon> attackMinHeap) {
        PokemonBestAttributes.attackMinHeap = attackMinHeap;
    }

    public static PriorityQueue<Pokemon> getDefenseMinHeap() {
        return defenseMinHeap;
    }
    public static void setDefenseMinHeap(PriorityQueue<Pokemon> defenseMinHeap) {
        PokemonBestAttributes.defenseMinHeap = defenseMinHeap;
    }

    public static PriorityQueue<Pokemon> getSpeedMinHeap() {
        return speedMinHeap;
    }
    public static void setSpeedMinHeap(PriorityQueue<Pokemon> speedMinHeap) {
        PokemonBestAttributes.speedMinHeap = speedMinHeap;
    }

    public static PriorityQueue<Pokemon> getDexterityMinHeap() {
        return dexterityMinHeap;
    }
    public static void setDexterityMinHeap(PriorityQueue<Pokemon> dexterityMinHeap) {
        PokemonBestAttributes.dexterityMinHeap = dexterityMinHeap;
    }

    public static PriorityQueue<Pokemon> getSpecialMinHeap() {
        return specialMinHeap;
    }
    public static void setSpecialMinHeap(PriorityQueue<Pokemon> specialMinHeap) {
        PokemonBestAttributes.specialMinHeap = specialMinHeap;
    }

    public static void addPokemonToAttributesHeaps(Pokemon pokemon) {
        PokemonBestAttributes.getHealthMaxHeap().add(pokemon);
        PokemonBestAttributes.getAttackMaxHeap().add(pokemon);
        PokemonBestAttributes.getDefenseMaxHeap().add(pokemon);
        PokemonBestAttributes.getSpeedMaxHeap().add(pokemon);
        PokemonBestAttributes.getDexterityMaxHeap().add(pokemon);
        PokemonBestAttributes.getSpecialMaxHeap().add(pokemon);

        PokemonBestAttributes.getHealthMinHeap().add(pokemon);
        PokemonBestAttributes.getAttackMinHeap().add(pokemon);
        PokemonBestAttributes.getDefenseMinHeap().add(pokemon);
        PokemonBestAttributes.getSpeedMinHeap().add(pokemon);
        PokemonBestAttributes.getDexterityMinHeap().add(pokemon);
        PokemonBestAttributes.getSpecialMinHeap().add(pokemon);
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

        pokemon = PokemonBestAttributes.getHealthMinHeap().poll();
        PokemonBestAttributes.getHealthMinHeap().add(pokemon);

        pokemon = PokemonBestAttributes.getAttackMinHeap().poll();
        PokemonBestAttributes.getAttackMinHeap().add(pokemon);

        pokemon = PokemonBestAttributes.getDefenseMinHeap().poll();
        PokemonBestAttributes.getDefenseMinHeap().add(pokemon);

        pokemon = PokemonBestAttributes.getSpeedMinHeap().poll();
        PokemonBestAttributes.getSpeedMinHeap().add(pokemon);

        pokemon = PokemonBestAttributes.getDexterityMinHeap().poll();
        PokemonBestAttributes.getDexterityMinHeap().add(pokemon);

        pokemon = PokemonBestAttributes.getSpecialMinHeap().poll();
        PokemonBestAttributes.getSpecialMinHeap().add(pokemon);
    }

    public static String pokemonBestAttributesInString() {
        PokemonBestAttributes.updateAttributesHeaps();

        Pokemon pokemonMaxHealth = PokemonBestAttributes.getHealthMaxHeap().peek();
        Pokemon pokemonMaxAttack = PokemonBestAttributes.getAttackMaxHeap().peek();
        Pokemon pokemonMaxDefense = PokemonBestAttributes.getDefenseMaxHeap().peek();
        Pokemon pokemonMaxSpeed = PokemonBestAttributes.getSpeedMaxHeap().peek();
        Pokemon pokemonMaxDexterity = PokemonBestAttributes.getDexterityMaxHeap().peek();
        Pokemon pokemonMaxSpecial = PokemonBestAttributes.getSpecialMaxHeap().peek();

        return String.format("# Maior Vida:\nNome: %s\nPontos de Vida: %s\n\n# Maior Ataque:\nNome: %s\nPontos de Ataque: %s\n\n# Maior Defesa:\nNome: %s\nPontos de Defesa: %s\n\n# Maior Velocidade:\nNome: %s\nPontos de Velocidade: %s\n\n# Maior Destreza:\nNome: %s\nPontos de Destreza: %s\n\n#Maior Especial:\nNome: %s\nPontos de Especial: %s\n",
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

    public static String pokemonWorstAttributesInString() {
        PokemonBestAttributes.updateAttributesHeaps();

        Pokemon pokemonMinHealth = PokemonBestAttributes.getHealthMinHeap().peek();
        Pokemon pokemonMinAttack = PokemonBestAttributes.getAttackMinHeap().peek();
        Pokemon pokemonMinDefense = PokemonBestAttributes.getDefenseMinHeap().peek();
        Pokemon pokemonMinSpeed = PokemonBestAttributes.getSpeedMinHeap().peek();
        Pokemon pokemonMinDexterity = PokemonBestAttributes.getDexterityMinHeap().peek();
        Pokemon pokemonMinSpecial = PokemonBestAttributes.getSpecialMinHeap().peek();

        return String.format("# Menor Vida:\nNome: %s\nPontos de Vida: %s\n\n# Menor Ataque:\nNome: %s\nPontos de Ataque: %s\n\n# Menor Defesa:\nNome: %s\nPontos de Defesa: %s\n\n# Menor Velocidade:\nNome: %s\nPontos de Velocidade: %s\n\n# Menor Destreza:\nNome: %s\nPontos de Destreza: %s\n\n# Menor Especial:\nNome: %s\nPontos de Especial: %s\n",
                pokemonMinHealth.getPokemonName(),
                pokemonMinHealth.getHealthPoints(),
                pokemonMinAttack.getPokemonName(),
                pokemonMinAttack.getAttackPoints(),
                pokemonMinDefense.getPokemonName(),
                pokemonMinDefense.getDefensivePoints(),
                pokemonMinSpeed.getPokemonName(),
                pokemonMinSpeed.getSpeedPoints(),
                pokemonMinDexterity.getPokemonName(),
                pokemonMinDexterity.getDexterityPoints(),
                pokemonMinSpecial.getPokemonName(),
                pokemonMinSpecial.getSpecialPoints());
    }

    public static Map<String, DataAttributesClass> pokemonBestAttributesInDict() {
        PokemonBestAttributes.updateAttributesHeaps();

        Pokemon pokemonMaxHealth = PokemonBestAttributes.getHealthMaxHeap().peek();
        Pokemon pokemonMaxAttack = PokemonBestAttributes.getAttackMaxHeap().peek();
        Pokemon pokemonMaxDefense = PokemonBestAttributes.getDefenseMaxHeap().peek();
        Pokemon pokemonMaxSpeed = PokemonBestAttributes.getSpeedMaxHeap().peek();
        Pokemon pokemonMaxDexterity = PokemonBestAttributes.getDexterityMaxHeap().peek();
        Pokemon pokemonMaxSpecial = PokemonBestAttributes.getSpecialMaxHeap().peek();

        Map<String, DataAttributesClass> bestAttributesDict = new HashMap<>();

        bestAttributesDict.put("Health", new DataAttributesClass(
                pokemonMaxHealth.getPokemonName(),
                pokemonMaxHealth.getHealthPoints()
        ));
        bestAttributesDict.put("Attack", new DataAttributesClass(
                pokemonMaxAttack.getPokemonName(),
                pokemonMaxAttack.getAttackPoints()
        ));
        bestAttributesDict.put("Defense", new DataAttributesClass(
                pokemonMaxDefense.getPokemonName(),
                pokemonMaxDefense.getDefensivePoints()
        ));
        bestAttributesDict.put("Speed", new DataAttributesClass(
                pokemonMaxSpeed.getPokemonName(),
                pokemonMaxSpeed.getSpeedPoints()
        ));
        bestAttributesDict.put("Dexterity", new DataAttributesClass(
                pokemonMaxDexterity.getPokemonName(),
                pokemonMaxDexterity.getDexterityPoints()
        ));
        bestAttributesDict.put("Special", new DataAttributesClass(
                pokemonMaxSpecial.getPokemonName(),
                pokemonMaxSpecial.getSpecialPoints()
        ));

        return bestAttributesDict;
    }

    public static Map<String, DataAttributesClass> pokemonWorstAttributesInDict() {
        PokemonBestAttributes.updateAttributesHeaps();

        Pokemon pokemonMinHealth = PokemonBestAttributes.getHealthMinHeap().peek();
        Pokemon pokemonMinAttack = PokemonBestAttributes.getAttackMinHeap().peek();
        Pokemon pokemonMinDefense = PokemonBestAttributes.getDefenseMinHeap().peek();
        Pokemon pokemonMinSpeed = PokemonBestAttributes.getSpeedMinHeap().peek();
        Pokemon pokemonMinDexterity = PokemonBestAttributes.getDexterityMinHeap().peek();
        Pokemon pokemonMinSpecial = PokemonBestAttributes.getSpecialMinHeap().peek();

        Map<String, DataAttributesClass> worstAttributesDict = new HashMap<>();

        worstAttributesDict.put("Health", new DataAttributesClass(
                pokemonMinHealth.getPokemonName(),
                pokemonMinHealth.getHealthPoints()
        ));
        worstAttributesDict.put("Attack", new DataAttributesClass(
                pokemonMinAttack.getPokemonName(),
                pokemonMinAttack.getAttackPoints()
        ));
        worstAttributesDict.put("Defense", new DataAttributesClass(
                pokemonMinDefense.getPokemonName(),
                pokemonMinDefense.getDefensivePoints()
        ));
        worstAttributesDict.put("Speed", new DataAttributesClass(
                pokemonMinSpeed.getPokemonName(),
                pokemonMinSpeed.getSpeedPoints()
        ));
        worstAttributesDict.put("Dexterity", new DataAttributesClass(
                pokemonMinDexterity.getPokemonName(),
                pokemonMinDexterity.getDexterityPoints()
        ));
        worstAttributesDict.put("Special", new DataAttributesClass(
                pokemonMinSpecial.getPokemonName(),
                pokemonMinSpecial.getSpecialPoints()
        ));

        return worstAttributesDict;
    }
}
