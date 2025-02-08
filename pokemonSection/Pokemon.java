package pokemonSection;

public class Pokemon {
    // Atributos base dos pokémons.
    private String pokemonName;
    private short healthPoints; // Limitado à 700.
    private short pokedexNumber; // Limitado à 386.
    private short attackPoints; // Limitado à 400.
    private short defensivePoints; // Limitado à 500.
    private short speedPoints; // Limitado à 350.
    private short specialPoints; // Limitado à 500.
    private PokemonStatus pokemonStatus; // Condição do pokémon, sleep, poisoned e etc...
    private Type primaryType; // Tipo do Pokémon.
    private Type secondaryType; // Tipo do Pokémon.

    // Construtor privado para controlar a criação das instâncias.
    private Pokemon(String pokemonName, short healthPoints, short pokedexNumber, short attackPoints, short defensivePoints, short speedPoints, short specialPoints, PokemonStatus pokemonStatus, Type primaryType, Type secondaryType) {
        this.pokemonName = pokemonName;
        this.healthPoints = healthPoints;
        this.pokedexNumber = pokedexNumber;
        this.attackPoints = attackPoints;
        this.defensivePoints = defensivePoints;
        this.speedPoints = speedPoints;
        this.specialPoints = specialPoints;
        this.pokemonStatus = pokemonStatus;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
    }

    // Getters e Setters da Classe.
    public String getPokemonName() {
        return pokemonName;
    }
    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public short getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(short healthPoints) {
        this.healthPoints = healthPoints;
    }

    public short getPokedexNumber() {
        return pokedexNumber;
    }
    public void setPokedexNumber(short pokedexNumber) {
        this.pokedexNumber = pokedexNumber;
    }

    public short getAttackPoints() {
        return attackPoints;
    }
    public void setAttackPoints(short attackPoints) {
        this.attackPoints = attackPoints;
    }

    public short getDefensivePoints() {
        return defensivePoints;
    }
    public void setDefensivePoints(short defensivePoints) {
        this.defensivePoints = defensivePoints;
    }

    public short getSpeedPoints() {
        return speedPoints;
    }
    public void setSpeedPoints(short speedPoints) {
        this.speedPoints = speedPoints;
    }

    public short getSpecialPoints() {
        return specialPoints;
    }
    public void setSpecialPoints(short specialPoints) {
        this.specialPoints = specialPoints;
    }

    public PokemonStatus getStatus() {
        return pokemonStatus;
    }
    public void setStatus(PokemonStatus pokemonStatus) {
        this.pokemonStatus = pokemonStatus;
    }

    public Type getPrimaryType() {
        return primaryType;
    }
    public void setPrimaryType(Type primaryType) {
        this.primaryType = primaryType;
    }

    public Type getSecondaryType() {
        return secondaryType;
    }
    public void setSecondaryType(Type secondaryType) {
        this.secondaryType = secondaryType;
    }


    // Funções da Classe:
    public static Pokemon takeAPokemon(String pokemonName, short healthPoints, short pokedexNumber, short attackPoints, short defensivePoints, short speedPoints, short specialPoints, PokemonStatus pokemonStatus, Type primaryType, Type secondaryType) { // Cria uma instância de Pokémon.
        return new Pokemon(pokemonName, healthPoints, pokedexNumber, attackPoints, defensivePoints, speedPoints, specialPoints, pokemonStatus, primaryType, secondaryType);
    }
    public Pokemon carryOutAttack(Pokemon target) {  // Seleciona um dos movimentos disponiveis e o utiliza.
        return null;
    }

    // Funções Sobrepostas:
    public String toString() {
        return String.format("%s #%03d\nHP: %d\nATK: %d | DEF: %d\nSPEED: %d\nSPECIAL: %d\nSTATUS: %s\nTYPE: %s/%s",
                getPokemonName(),
                getPokedexNumber(),
                getHealthPoints(),
                getAttackPoints(),
                getDefensivePoints(),
                getSpeedPoints(),
                getSpecialPoints(),
                getStatus(),
                getPrimaryType(),
                getSecondaryType());
    }
}