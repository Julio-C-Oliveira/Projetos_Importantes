package pokemonSection;

import java.util.Map;

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
    private MoveBase[] movements = new MoveBase[3];

    // Construtor privado para controlar a criação das instâncias.
    private Pokemon(String pokemonName, short healthPoints, short pokedexNumber, short attackPoints, short defensivePoints, short speedPoints, short specialPoints, PokemonStatus pokemonStatus, Type primaryType, Type secondaryType, MoveBase[] movements) {
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
        this.movements = movements;
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

    public PokemonStatus getPokemonStatus() {
        return pokemonStatus;
    }
    public void setPokemonStatus(PokemonStatus pokemonStatus) {
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

    public MoveBase[] getMovements() {
        return movements;
    }
    public void setMovements(MoveBase[] movements) {
        this.movements = movements;
    }

    // Funções da Classe:
    public static Pokemon takeAPokemon(String pokemonName, short pokedexNumber, Type primaryType, Type secondaryType) { // Cria uma instância de Pokémon.
        // Pegando as Estátisticas e Movimentos disponiveis:
        Map<Type, AttributesWarehouse> attributesDict = AttributesDefine.takePokemonAttributes();
        Map<Type, MoveBase[]> movementsDict = MoveGenerator.generateAllMoves();

        AttributesWarehouse specificAttributes = attributesDict.get(primaryType);
        MoveBase[] primaryMoves = movementsDict.get(primaryType);
        MoveBase[] secondaryMoves = movementsDict.get(secondaryType);

        // Geração aléatória das estátisticas.
        short healthPoints = PokemonUtils.defineRandomAttributeOnInterval(
                specificAttributes.maxHealthPoints,
                specificAttributes.minHealthPoints
        );
        short attackPoints = PokemonUtils.defineRandomAttributeOnInterval(
                specificAttributes.maxAttackPoints,
                specificAttributes.minAttackPoints
        );
        short defensivePoints = PokemonUtils.defineRandomAttributeOnInterval(
                specificAttributes.maxDefensivePoints,
                specificAttributes.minDefensivePoints
        );
        short speedPoints = PokemonUtils.defineRandomAttributeOnInterval(
                specificAttributes.maxSpeedPoints,
                specificAttributes.minSpeedPoints
        );
        short specialPoints = PokemonUtils.defineRandomAttributeOnInterval(
                specificAttributes.maxSpecialPoints,
                specificAttributes.minSpecialPoints
        );
        PokemonStatus pokemonStatus = new PokemonStatus();

        // Lógica da Escolha dos Movimentos que o Pókemon vai ter.
        MoveBase[] movements = new MoveBase[]{
                PokemonUtils.selectRandomMove(primaryMoves),
                PokemonUtils.selectRandomMove(secondaryMoves),
                PokemonUtils.selectRandomMove(primaryMoves, secondaryMoves) // deixar esse último aléatorio, podendo ser qualquer um dos dois tipos.
        };


        return new Pokemon(pokemonName, healthPoints, pokedexNumber, attackPoints, defensivePoints, speedPoints, specialPoints, pokemonStatus, primaryType, secondaryType, movements);
    }
    public Pokemon carryOutAttack(Pokemon target) {  // Seleciona um dos movimentos disponiveis e o utiliza.

        return null;
    }

    // Funções Sobrepostas:
    public String toString() {
        MoveBase[] movements = getMovements();
        return String.format("%s #%03d\nHP: %d\nATK: %d | DEF: %d\nSPEED: %d\nSPECIAL: %d\nSTATUS: %s\nTYPE: %s/%s\nFIRST MOVE: %s\nSECOND MOVE: %s\nTHIRD MOVE: %s",
                getPokemonName(),
                getPokedexNumber(),
                getHealthPoints(),
                getAttackPoints(),
                getDefensivePoints(),
                getSpeedPoints(),
                getSpecialPoints(),
                getPokemonStatus(),
                getPrimaryType(),
                getSecondaryType(),
                movements[0],
                movements[1],
                movements[2]);
    }
}