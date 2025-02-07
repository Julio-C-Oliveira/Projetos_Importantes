package pokemonSection;

public interface PokemonBase {
    // Atributos base dos pokémons.

    char[] pokemonName = new char[22];
    short healthPoints = 0; // Limitado à 700.
    short pokedexNumber = 0; // Limitado à 386.
    short attackPoints = 0; // Limitado à 400.
    short defensivePoints = 0; // Limitado à 500.
    short speedPoints = 0; // Limitado à 350.
    short specialPoints = 0; // Limitado à 500.
    StatusCondition status = null; // Condição do pokémon, sleep, poisoned e etc...
    Type primaryType = null; // Tipo do Pokémon.
    Type secondaryType = null; // Tipo do Pokémon.

    // Funções relacionadas aos pokémons que todos deverão ter
    PokemonBase takeAPokemon();
    boolean carryOutAttack(PokemonBase target);
    boolean uniqueClassSkill(PokemonBase target);
}