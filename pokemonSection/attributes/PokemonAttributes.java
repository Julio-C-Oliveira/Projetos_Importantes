package pokemonSection.attributes;

import pokemonSection.pokedex.Pokemon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PokemonAttributes {
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
        PokemonAttributes.healthMaxHeap = healthMaxHeap;
    }

    public static PriorityQueue<Pokemon> getAttackMaxHeap() {
        return attackMaxHeap;
    }
    public static void setAttackMaxHeap(PriorityQueue<Pokemon> attackMaxHeap) {
        PokemonAttributes.attackMaxHeap = attackMaxHeap;
    }

    public static PriorityQueue<Pokemon> getDefenseMaxHeap() {
        return defenseMaxHeap;
    }
    public static void setDefenseMaxHeap(PriorityQueue<Pokemon> defenseMaxHeap) {
        PokemonAttributes.defenseMaxHeap = defenseMaxHeap;
    }

    public static PriorityQueue<Pokemon> getSpeedMaxHeap() {
        return speedMaxHeap;
    }
    public static void setSpeedMaxHeap(PriorityQueue<Pokemon> speedMaxHeap) {
        PokemonAttributes.speedMaxHeap = speedMaxHeap;
    }

    public static PriorityQueue<Pokemon> getDexterityMaxHeap() {
        return dexterityMaxHeap;
    }
    public static void setDexterityMaxHeap(PriorityQueue<Pokemon> dexterityMaxHeap) {
        PokemonAttributes.dexterityMaxHeap = dexterityMaxHeap;
    }

    public static PriorityQueue<Pokemon> getSpecialMaxHeap() {
        return specialMaxHeap;
    }
    public static void setSpecialMaxHeap(PriorityQueue<Pokemon> specialMaxHeap) {
        PokemonAttributes.specialMaxHeap = specialMaxHeap;
    }

    public static PriorityQueue<Pokemon> getHealthMinHeap() {
        return healthMinHeap;
    }
    public static void setHealthMinHeap(PriorityQueue<Pokemon> healthMinHeap) {
        PokemonAttributes.healthMinHeap = healthMinHeap;
    }

    public static PriorityQueue<Pokemon> getAttackMinHeap() {
        return attackMinHeap;
    }
    public static void setAttackMinHeap(PriorityQueue<Pokemon> attackMinHeap) {
        PokemonAttributes.attackMinHeap = attackMinHeap;
    }

    public static PriorityQueue<Pokemon> getDefenseMinHeap() {
        return defenseMinHeap;
    }
    public static void setDefenseMinHeap(PriorityQueue<Pokemon> defenseMinHeap) {
        PokemonAttributes.defenseMinHeap = defenseMinHeap;
    }

    public static PriorityQueue<Pokemon> getSpeedMinHeap() {
        return speedMinHeap;
    }
    public static void setSpeedMinHeap(PriorityQueue<Pokemon> speedMinHeap) {
        PokemonAttributes.speedMinHeap = speedMinHeap;
    }

    public static PriorityQueue<Pokemon> getDexterityMinHeap() {
        return dexterityMinHeap;
    }
    public static void setDexterityMinHeap(PriorityQueue<Pokemon> dexterityMinHeap) {
        PokemonAttributes.dexterityMinHeap = dexterityMinHeap;
    }

    public static PriorityQueue<Pokemon> getSpecialMinHeap() {
        return specialMinHeap;
    }
    public static void setSpecialMinHeap(PriorityQueue<Pokemon> specialMinHeap) {
        PokemonAttributes.specialMinHeap = specialMinHeap;
    }

    public static void addPokemonToAttributesHeaps(Pokemon pokemon) {
        PokemonAttributes.getHealthMaxHeap().add(pokemon);
        PokemonAttributes.getAttackMaxHeap().add(pokemon);
        PokemonAttributes.getDefenseMaxHeap().add(pokemon);
        PokemonAttributes.getSpeedMaxHeap().add(pokemon);
        PokemonAttributes.getDexterityMaxHeap().add(pokemon);
        PokemonAttributes.getSpecialMaxHeap().add(pokemon);

        PokemonAttributes.getHealthMinHeap().add(pokemon);
        PokemonAttributes.getAttackMinHeap().add(pokemon);
        PokemonAttributes.getDefenseMinHeap().add(pokemon);
        PokemonAttributes.getSpeedMinHeap().add(pokemon);
        PokemonAttributes.getDexterityMinHeap().add(pokemon);
        PokemonAttributes.getSpecialMinHeap().add(pokemon);
    }

    public static void updateAttributesHeaps() {
        Pokemon pokemon = PokemonAttributes.getHealthMaxHeap().poll();
        PokemonAttributes.getHealthMaxHeap().add(pokemon);

        pokemon = PokemonAttributes.getAttackMaxHeap().poll();
        PokemonAttributes.getAttackMaxHeap().add(pokemon);

        pokemon = PokemonAttributes.getDefenseMaxHeap().poll();
        PokemonAttributes.getDefenseMaxHeap().add(pokemon);

        pokemon = PokemonAttributes.getSpeedMaxHeap().poll();
        PokemonAttributes.getSpeedMaxHeap().add(pokemon);

        pokemon = PokemonAttributes.getDexterityMaxHeap().poll();
        PokemonAttributes.getDexterityMaxHeap().add(pokemon);

        pokemon = PokemonAttributes.getSpecialMaxHeap().poll();
        PokemonAttributes.getSpecialMaxHeap().add(pokemon);

        pokemon = PokemonAttributes.getHealthMinHeap().poll();
        PokemonAttributes.getHealthMinHeap().add(pokemon);

        pokemon = PokemonAttributes.getAttackMinHeap().poll();
        PokemonAttributes.getAttackMinHeap().add(pokemon);

        pokemon = PokemonAttributes.getDefenseMinHeap().poll();
        PokemonAttributes.getDefenseMinHeap().add(pokemon);

        pokemon = PokemonAttributes.getSpeedMinHeap().poll();
        PokemonAttributes.getSpeedMinHeap().add(pokemon);

        pokemon = PokemonAttributes.getDexterityMinHeap().poll();
        PokemonAttributes.getDexterityMinHeap().add(pokemon);

        pokemon = PokemonAttributes.getSpecialMinHeap().poll();
        PokemonAttributes.getSpecialMinHeap().add(pokemon);
    }

    public static String pokemonBestAttributesInString() {
        PokemonAttributes.updateAttributesHeaps();

        Pokemon pokemonMaxHealth = PokemonAttributes.getHealthMaxHeap().peek();
        Pokemon pokemonMaxAttack = PokemonAttributes.getAttackMaxHeap().peek();
        Pokemon pokemonMaxDefense = PokemonAttributes.getDefenseMaxHeap().peek();
        Pokemon pokemonMaxSpeed = PokemonAttributes.getSpeedMaxHeap().peek();
        Pokemon pokemonMaxDexterity = PokemonAttributes.getDexterityMaxHeap().peek();
        Pokemon pokemonMaxSpecial = PokemonAttributes.getSpecialMaxHeap().peek();

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
        PokemonAttributes.updateAttributesHeaps();

        Pokemon pokemonMinHealth = PokemonAttributes.getHealthMinHeap().peek();
        Pokemon pokemonMinAttack = PokemonAttributes.getAttackMinHeap().peek();
        Pokemon pokemonMinDefense = PokemonAttributes.getDefenseMinHeap().peek();
        Pokemon pokemonMinSpeed = PokemonAttributes.getSpeedMinHeap().peek();
        Pokemon pokemonMinDexterity = PokemonAttributes.getDexterityMinHeap().peek();
        Pokemon pokemonMinSpecial = PokemonAttributes.getSpecialMinHeap().peek();

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
        PokemonAttributes.updateAttributesHeaps();

        Pokemon pokemonMaxHealth = PokemonAttributes.getHealthMaxHeap().peek();
        Pokemon pokemonMaxAttack = PokemonAttributes.getAttackMaxHeap().peek();
        Pokemon pokemonMaxDefense = PokemonAttributes.getDefenseMaxHeap().peek();
        Pokemon pokemonMaxSpeed = PokemonAttributes.getSpeedMaxHeap().peek();
        Pokemon pokemonMaxDexterity = PokemonAttributes.getDexterityMaxHeap().peek();
        Pokemon pokemonMaxSpecial = PokemonAttributes.getSpecialMaxHeap().peek();

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
        PokemonAttributes.updateAttributesHeaps();

        Pokemon pokemonMinHealth = PokemonAttributes.getHealthMinHeap().peek();
        Pokemon pokemonMinAttack = PokemonAttributes.getAttackMinHeap().peek();
        Pokemon pokemonMinDefense = PokemonAttributes.getDefenseMinHeap().peek();
        Pokemon pokemonMinSpeed = PokemonAttributes.getSpeedMinHeap().peek();
        Pokemon pokemonMinDexterity = PokemonAttributes.getDexterityMinHeap().peek();
        Pokemon pokemonMinSpecial = PokemonAttributes.getSpecialMinHeap().peek();

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
