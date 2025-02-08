import pokemonSection.Pokemon;
import pokemonSection.PokemonStatus;
import pokemonSection.StatusCondition;
import pokemonSection.Type;

public class Main {
    public static void main(String[] args) {
        Pokemon pokemon1 = Pokemon.takeAPokemon(
                "Pikachu",
                (short) 450,
                (short) 47,
                (short) 100,
                (short) 95,
                (short) 50,
                (short) 25,
                new PokemonStatus(),
                Type.ELETRIC,
                Type.ELETRIC);
        Pokemon pokemon2 = Pokemon.takeAPokemon(
                "Pikachu",
                (short) 350,
                (short) 100,
                (short) 70,
                (short) 95,
                (short) 70,
                (short) 30,
                new PokemonStatus(),
                Type.POISON,
                Type.NORMAL);


        System.out.println(pokemon1);
        System.out.println();
        System.out.println(pokemon2);


    }
}