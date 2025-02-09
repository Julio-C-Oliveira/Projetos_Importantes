package pokemonSection;

public class TestesParaPokemon {
    public static void testar() {
        Pokemon pokemon1 = Pokemon.takeAPokemon(
                "01",
                (short) 47,
                Type.NORMAL,
                Type.FIRE);
        Pokemon pokemon2 = Pokemon.takeAPokemon(
                "02",
                (short) 127,
                Type.WATER,
                Type.FIRE);


        System.out.println(pokemon1);
        System.out.println();
        System.out.println(pokemon2);
        System.out.println();

        pokemon1.carryOutAttack(pokemon2);

        System.out.println(pokemon1);
        System.out.println();
        System.out.println(pokemon2);
        System.out.println();
    }
}
