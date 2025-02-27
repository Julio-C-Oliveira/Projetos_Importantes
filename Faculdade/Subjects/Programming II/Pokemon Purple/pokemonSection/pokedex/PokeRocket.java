package pokemonSection.pokedex;

import pokemonSection.attributes.MoveBase;
import pokemonSection.constants.SideOfForce;
import pokemonSection.constants.Type;

public class PokeRocket extends Pokemon{
    private static byte numberOfRockets;
    private static byte rocketLevel;
    private static final SideOfForce sideOfForce = SideOfForce.DARK;

    protected PokeRocket(String pokemonName, short healthPoints, short pokedexNumber, short attackPoints, short defensivePoints, short speedPoints, short dexterityPoints, short specialPoints, PokemonStatus pokemonStatus, Type primaryType, Type secondaryType, MoveBase[] movements) {
        super(pokemonName, healthPoints, pokedexNumber, attackPoints, defensivePoints, speedPoints, dexterityPoints, specialPoints, pokemonStatus, primaryType, secondaryType, movements, PokeRocket.getRocketLevel(), PokeRocket.sideOfForce);
    }

    public static byte getNumberOfRockets() {
        return numberOfRockets;
    }
    public static void setNumberOfRockets(byte numberOfRockets) {
        PokeRocket.numberOfRockets = numberOfRockets;
    }

    public static byte getRocketLevel() {
        return rocketLevel;
    }
    public static void setRocketLevel(byte rocketLevel) {
        PokeRocket.rocketLevel = rocketLevel;
    }

    public static Pokemon takeAPokeRocket(String pokemonName, short pokedexNumber, Type primaryType, Type secondaryType) {
        PokeRocket.setNumberOfRockets((byte) (PokeRocket.getNumberOfRockets() + 1));
        return Pokemon.takeAPokemon(pokemonName, pokedexNumber, primaryType, secondaryType, PokeRocket.getRocketLevel(), PokeRocket.sideOfForce);
    }
}
