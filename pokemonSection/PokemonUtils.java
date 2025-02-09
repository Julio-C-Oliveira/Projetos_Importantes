package pokemonSection;

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
}
