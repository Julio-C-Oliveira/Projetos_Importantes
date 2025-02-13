package pokemonSection;

import pokemonSection.attributes.PokemonBestAttributes;
import pokemonSection.constants.Type;
import pokemonSection.pokedex.DataPokemonAttackClass;
import pokemonSection.pokedex.PokeRocket;
import pokemonSection.pokedex.PokeSOX;
import pokemonSection.pokedex.Pokemon;

public class TestesParaPokemon {
    public static void testar() {
        /* Settar o Nível dos Vilões e dos Heróis, isso é uma constante.
        *  Heróis deixei settado em 5.
        *  Acho que uma boa definição de dificuldade está em:
        *  - Muito Fácil: Settar nível 8 para os vilões.
        *  - Fácil: Settar nível 9 para os vilões.
        *  - Médio: Settar nível 10 para os vilões.
        *  - Difícil: Settar nível 11 para os vilões.
        *  - Muito Difícil: Settar nível 12 para os vilões.
        */
        PokeSOX.setSoxLevel((byte) 10); // Nível dos heróis, padrão 10, limite 127.
        PokeRocket.setRocketLevel((byte) 10); // Nível dos heróis, padrão 10, limite 127.

        Pokemon pokemon1 = PokeSOX.takeAPokeSOX(
                "SOX - 01",
                (short) 47,
                Type.NORMAL,
                Type.FIRE);
        Pokemon pokemon2 = PokeRocket.takeAPokeRocket(
                "Rocket - 01",
                (short) 127,
                Type.WATER,
                Type.FIRE);

        System.out.println(pokemon1 + "\n");
        System.out.println(pokemon2 + "\n");

//        System.out.println("SEM IMUNIDADE:");
//        for (int i = 0; i < 20; i++) System.out.println(pokemon1.carryOutAttack(pokemon2) + "\n");
//        System.out.println(pokemon1 + "\n");
//        System.out.println(pokemon2 + "\n");

//        System.out.println("COM IMUNIDADE:");
//        pokemon2.getPokemonStatus().getEffects().add(StatusCondition.IMMUNITY);
//        System.out.println(pokemon1.carryOutAttack(pokemon2) + "\n");

        Pokemon[] pokemons = {pokemon1, pokemon2};
        for (int i = 0; i < 100; i++) {
            DataPokemonAttackClass resultOfAttack = pokemons[i%2].carryOutAttack(pokemons[(i+1)%2]);

            System.out.printf("Resultado do Ataque: %s\nHabilidade Utilizada: %s | Usos restantes: %s\nDano Infligido: %d\nVida do Inimigo: %d\nVida após o Ataque: %d\n\n", resultOfAttack.hitLevel, resultOfAttack.skillUsed, resultOfAttack.remainingUses, resultOfAttack.inflictedDamage, resultOfAttack.healthPointsBeforeAttack, resultOfAttack.healthPointsAfterAttack);

            if (pokemons[(i+1)%2].getHealthPoints() <= 0) {
                System.out.println("O Vencedor é o Pokémon:\n" + pokemons[i%2]);
                System.out.println("\nO Perdedor é o Pokémon:\n" + pokemons[(i+1)%2]);

                System.out.println("\nRodada Final: " + i);
                break;
            }
        }

        // Acessar o número de Instâncias Criadas:
        System.out.println("\nSOXs: " + PokeSOX.getNumberOfSOXs());
        System.out.println("Rockets: " + PokeRocket.getNumberOfRockets());

        // Verificando se a função de ordenação está funcionando
        System.out.println(PokemonBestAttributes.pokemonBestAttributes());
    }
}
