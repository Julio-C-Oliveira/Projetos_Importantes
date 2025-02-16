package pokemonSection.pokedex;

import pokemonSection.attributes.MoveBase;
import pokemonSection.constants.Type;

import java.util.Random;

public class PokemonUtils {
    public PokemonUtils() {}

    public static short defineRandomAttributeOnInterval(short end, short start){
        Random random = new Random();
        short attribute;

        attribute = (short) ((short) random.nextInt((end + 1) - start) + start);
        return attribute;
    }

    public static MoveBase[] mergeMoveLists(MoveBase[] primaryMovements, MoveBase[] secondaryMovements) {
        MoveBase[] mergedMoves = new MoveBase[primaryMovements.length + secondaryMovements.length];

        for (int i = 0; i < primaryMovements.length; i++) mergedMoves[i] = primaryMovements[i];
        for (int i = 0; i < secondaryMovements.length; i++) mergedMoves[primaryMovements.length + i] = secondaryMovements[i];

        return mergedMoves;
    }

    public static MoveBase selectRandomMove(MoveBase[] movements) {
        Random random = new Random();
        return movements[random.nextInt(movements.length)];
    }

    public static MoveBase selectRandomMove(MoveBase[] primaryMovements, MoveBase[] secondaryMovements) {
        Random random = new Random();
        MoveBase[] movements = PokemonUtils.mergeMoveLists(primaryMovements, secondaryMovements);
        return movements[random.nextInt(movements.length)];
    }

    public static Type[] getAllTypes() {
        return new Type[]{Type.NORMAL,
                Type.FIRE,
                Type.WATER,
                Type.GRASS,
                Type.ELETRIC,
                Type.ICE,
                Type.FIGHTING,
                Type.POISON,
                Type.GROUND,
                Type.FLYING,
                Type.PSYCHIC,
                Type.BUG,
                Type.ROCK,
                Type.GHOST,
                Type.DRAGON,
                Type.DARK,
                Type.STEEL};
    }

    public static Type selectRandomType() {
        Random random = new Random();
        Type[] allTypes = PokemonUtils.getAllTypes();
        return allTypes[random.nextInt(allTypes.length)];
    }
}
