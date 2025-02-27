package pokemonSection.attributes;

import pokemonSection.pokedex.Pokemon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PokemonAttributes {
    private static List<Pokemon> healthList = new ArrayList<>();
    private static List<Pokemon> attackList = new ArrayList<>();
    private static List<Pokemon> defenseList = new ArrayList<>();
    private static List<Pokemon> speedList = new ArrayList<>();
    private static List<Pokemon> dexterityList = new ArrayList<>();
    private static List<Pokemon> specialList = new ArrayList<>();

    public static List<Pokemon> getHealthList() {
        return healthList;
    }
    public static void setHealthList(List<Pokemon> healthList) {
        PokemonAttributes.healthList = healthList;
    }

    public static List<Pokemon> getAttackList() {
        return attackList;
    }
    public static void setAttackList(List<Pokemon> attackList) {
        PokemonAttributes.attackList = attackList;
    }

    public static List<Pokemon> getDefenseList() {
        return defenseList;
    }
    public static void setDefenseList(List<Pokemon> defenseList) {
        PokemonAttributes.defenseList = defenseList;
    }

    public static List<Pokemon> getSpeedList() {
        return speedList;
    }
    public static void setSpeedList(List<Pokemon> speedList) {
        PokemonAttributes.speedList = speedList;
    }

    public static List<Pokemon> getDexterityList() {
        return dexterityList;
    }
    public static void setDexterityList(List<Pokemon> dexterityList) {
        PokemonAttributes.dexterityList = dexterityList;
    }

    public static List<Pokemon> getSpecialList() {
        return specialList;
    }
    public static void setSpecialList(List<Pokemon> specialList) {
        PokemonAttributes.specialList = specialList;
    }

    public static void addPokemonToAttributesList(Pokemon pokemon) {
        PokemonAttributes.getHealthList().add(pokemon);
        PokemonAttributes.getAttackList().add(pokemon);
        PokemonAttributes.getDefenseList().add(pokemon);
        PokemonAttributes.getSpeedList().add(pokemon);
        PokemonAttributes.getDexterityList().add(pokemon);
        PokemonAttributes.getSpecialList().add(pokemon);
    }

    public static void updateLists() {
        PokemonAttributes.getHealthList().sort(Comparator.comparingInt(Pokemon::getHealthPoints).reversed());
        PokemonAttributes.getAttackList().sort(Comparator.comparingInt(Pokemon::getAttackPoints).reversed());
        PokemonAttributes.getDefenseList().sort(Comparator.comparingInt(Pokemon::getDefensivePoints).reversed());
        PokemonAttributes.getSpeedList().sort(Comparator.comparingInt(Pokemon::getSpeedPoints).reversed());
        PokemonAttributes.getDexterityList().sort(Comparator.comparingInt(Pokemon::getDexterityPoints).reversed());
        PokemonAttributes.getSpecialList().sort(Comparator.comparingInt(Pokemon::getSpecialPoints).reversed());
    }

    public static String pokemonBestAndWorstAttributesInString() {
        PokemonAttributes.updateLists();

        Pokemon pokemonMaxHealth = PokemonAttributes.getHealthList().getFirst();
        Pokemon pokemonMaxAttack = PokemonAttributes.getAttackList().getFirst();
        Pokemon pokemonMaxDefense = PokemonAttributes.getDefenseList().getFirst();
        Pokemon pokemonMaxSpeed = PokemonAttributes.getSpeedList().getFirst();
        Pokemon pokemonMaxDexterity = PokemonAttributes.getDexterityList().getFirst();
        Pokemon pokemonMaxSpecial = PokemonAttributes.getSpecialList().getFirst();

        Pokemon pokemonMinHealth = PokemonAttributes.getHealthList().getLast();
        Pokemon pokemonMinAttack = PokemonAttributes.getAttackList().getLast();
        Pokemon pokemonMinDefense = PokemonAttributes.getDefenseList().getLast();
        Pokemon pokemonMinSpeed = PokemonAttributes.getSpeedList().getLast();
        Pokemon pokemonMinDexterity = PokemonAttributes.getDexterityList().getLast();
        Pokemon pokemonMinSpecial = PokemonAttributes.getSpecialList().getLast();

        return String.format(
                "|------------------------------||------------------------------||------------------------------|\n" +
                "| Maior Vida:                  || Maior Ataque:                || Maior Defesa:                |\n" +
                "| Nome: %-22s || Nome: %-22s || Nome: %-22s |\n" +
                "| Pontos de Vida: %-12s || Pontos de Ataque: %-10s || Pontos de Defesa: %-10s |\n" +
                "|------------------------------||------------------------------||------------------------------|\n" +
                "| Maior Velocidade:            || Maior Destreza:              || Maior Especial:              |\n" +
                "| Nome: %-22s || Nome: %-22s || Nome: %-22s |\n" +
                "| Pontos de Velocidade: %-6s || Pontos de Destreza: %-8s || Pontos de Especial: %-8s |\n" +
                "|------------------------------||------------------------------||------------------------------|\n" +
                "|------------------------------||------------------------------||------------------------------|\n" +
                "| Menor Vida:                  || Menor Ataque:                || Menor Defesa:                |\n" +
                "| Nome: %-22s || Nome: %-22s || Nome: %-22s |\n" +
                "| Pontos de Vida: %-12s || Pontos de Ataque: %-10s || Pontos de Defesa: %-10s |\n" +
                "|------------------------------||------------------------------||------------------------------|\n" +
                "| Menor Velocidade:            || Menor Destreza:              || Menor Especial:              |\n" +
                "| Nome: %-22s || Nome: %-22s || Nome: %-22s |\n" +
                "| Pontos de Velocidade: %-6s || Pontos de Destreza: %-8s || Pontos de Especial: %-8s |\n" +
                "|------------------------------||------------------------------||------------------------------|\n",
                pokemonMaxHealth.getPokemonName(), pokemonMaxAttack.getPokemonName(), pokemonMaxDefense.getPokemonName(),
                pokemonMaxHealth.getHealthPoints(), pokemonMaxAttack.getAttackPoints(), pokemonMaxDefense.getDefensivePoints(),
                pokemonMaxSpeed.getPokemonName(), pokemonMaxDexterity.getPokemonName(), pokemonMaxSpecial.getPokemonName(),
                pokemonMaxSpeed.getSpeedPoints(), pokemonMaxDexterity.getDexterityPoints(), pokemonMaxSpecial.getSpecialPoints(),
                pokemonMinHealth.getPokemonName(), pokemonMinAttack.getPokemonName(), pokemonMinDefense.getPokemonName(),
                pokemonMinHealth.getHealthPoints(), pokemonMinAttack.getAttackPoints(), pokemonMinDefense.getDefensivePoints(),
                pokemonMinSpeed.getPokemonName(), pokemonMinDexterity.getPokemonName(), pokemonMinSpecial.getPokemonName(),
                pokemonMinSpeed.getSpeedPoints(), pokemonMinDexterity.getDexterityPoints(), pokemonMinSpecial.getSpecialPoints()
        );
    }
}