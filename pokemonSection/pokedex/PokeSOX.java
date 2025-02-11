package pokemonSection.pokedex;

import pokemonSection.attributes.MoveBase;
import pokemonSection.constants.Type;

public class PokeSOX extends Pokemon {
    private static byte numberOfSOXs;

    protected PokeSOX(String pokemonName, short healthPoints, short pokedexNumber, short attackPoints, short defensivePoints, short speedPoints, short dexterityPoints, short specialPoints, PokemonStatus pokemonStatus, Type primaryType, Type secondaryType, MoveBase[] movements) {
        super(pokemonName, healthPoints, pokedexNumber, attackPoints, defensivePoints, speedPoints, dexterityPoints, specialPoints, pokemonStatus, primaryType, secondaryType, movements);
    }

    public static byte getNumberOfSOXs() {
        return numberOfSOXs;
    }
    public static void setNumberOfSOXs(byte numberOfSOXs) {
        PokeSOX.numberOfSOXs = numberOfSOXs;
    }

    public static Pokemon takeAPokeSOX(String pokemonName, short pokedexNumber, Type primaryType, Type secondaryType) {
        PokeSOX.setNumberOfSOXs((byte) (PokeSOX.getNumberOfSOXs() + 1));
        return Pokemon.takeAPokemon(pokemonName, pokedexNumber, primaryType, secondaryType);
    }
}
