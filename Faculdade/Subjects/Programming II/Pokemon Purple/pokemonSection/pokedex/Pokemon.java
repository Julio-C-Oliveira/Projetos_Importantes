package pokemonSection.pokedex;

import pokemonSection.attributes.*;
import pokemonSection.constants.Effectiveness;
import pokemonSection.constants.SideOfForce;
import pokemonSection.constants.StatusCondition;
import pokemonSection.constants.Type;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Pokemon {
    // Atributos base dos pokémons.
    private String pokemonName;
    private short healthPoints; // Limitado à 700.
    private short pokedexNumber; // Limitado à 386.
    private short attackPoints; // Limitado à 400.
    private short defensivePoints; // Limitado à 500.
    private short speedPoints; // Limitado à 350.
    private short dexterityPoints; // Limitado à 350.
    private short specialPoints; // Limitado à 500.
    private PokemonStatus pokemonStatus; // Condição do pokémon, sleep, poisoned, etc...
    private Type primaryType; // Tipo do Pokémon.
    private Type secondaryType; // Tipo do Pokémon.
    private MoveBase[] movements = new MoveBase[3];
    private byte level;
    private SideOfForce sideOfForce;
    private boolean areInConditionToFight;

    // Construtor privado para controlar a criação das instâncias.
    protected Pokemon(String pokemonName, short healthPoints, short pokedexNumber, short attackPoints, short defensivePoints, short speedPoints, short dexterityPoints, short specialPoints, PokemonStatus pokemonStatus, Type primaryType, Type secondaryType, MoveBase[] movements, byte level, SideOfForce sideOfForce) {
        this.pokemonName = pokemonName;
        this.healthPoints = healthPoints;
        this.pokedexNumber = pokedexNumber;
        this.attackPoints = attackPoints;
        this.defensivePoints = defensivePoints;
        this.speedPoints = speedPoints;
        this.dexterityPoints = dexterityPoints;
        this.specialPoints = specialPoints;
        this.pokemonStatus = pokemonStatus;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.movements = movements;
        this.level = level;
        this.sideOfForce = sideOfForce;
        this.areInConditionToFight = true;
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

    public short getDexterityPoints() {
        return dexterityPoints;
    }
    public void setDexterityPoints(short dexterityPoints) {
        this.dexterityPoints = dexterityPoints;
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

    public byte getLevel() {
        return level;
    }
    public void setLevel(byte level) {
        this.level = level;
    }

    public SideOfForce getSideOfForce() {
        return sideOfForce;
    }
    public void setSideOfForce(SideOfForce sideOfForce) {
        this.sideOfForce = sideOfForce;
    }

    public boolean getAreInConditionToFight() {
        return areInConditionToFight;
    }
    public void setAreInConditionToFight(boolean areInConditionToFight) {
        this.areInConditionToFight = areInConditionToFight;
    }

    // Funções da Classe:
    protected static Pokemon takeAPokemon(String pokemonName, short pokedexNumber, Type primaryType, Type secondaryType, byte level, SideOfForce sideOfForce) { // Cria uma instância de Pokémon.
        // Pegando as Estatísticas e Movimentos disponíveis:
        Map<Type, AttributesWarehouse> attributesDict = AttributesDefine.takePokemonAttributes();
        Map<Type, MoveBase[]> movementsDict = MoveGenerator.generateAllMoves();

        AttributesWarehouse specificAttributes = attributesDict.get(primaryType);
        MoveBase[] primaryMoves = movementsDict.get(primaryType);
        MoveBase[] secondaryMoves = movementsDict.get(secondaryType);

        // Geração aleatória das estatísticas.
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
        short dexterityPoints = PokemonUtils.defineRandomAttributeOnInterval(
                specificAttributes.maxDexterityPoints,
                specificAttributes.minDexterityPoints
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

        // Instanciando
        Pokemon pokemon = new Pokemon(pokemonName, healthPoints, pokedexNumber, attackPoints, defensivePoints, speedPoints, dexterityPoints, specialPoints, pokemonStatus, primaryType, secondaryType, movements, level, sideOfForce);

        // Adicionando ele no heap para ser ordenado
        PokemonAttributes.addPokemonToAttributesList(pokemon);

        return pokemon;
    }

    public void definePokemonStatus(PokemonStatus pokemonStatus, StatusCondition movementEffect, int effectTime) {
        if (pokemonStatus.getEffects().contains(movementEffect)) {
            int index = pokemonStatus.getEffects().indexOf(movementEffect);

            ArrayList<Byte> times = pokemonStatus.getTime();
            byte newTime = (byte) (Math.ceil((double) times.get(index) + effectTime)/2);
            times.set(index, newTime);
            pokemonStatus.setTime(times);

        } else {
            pokemonStatus.addStatus(movementEffect, (byte) effectTime);
        }
    }

    public int pokemonRemaingMovementsUses() {
        int remaingMovesUses = 0;
        for (MoveBase move : this.getMovements()) remaingMovesUses += move.getRemainingUses();
        return remaingMovesUses;
    }

    public DataPokemonAttackClass carryOutAttack(Pokemon target) {  // Seleciona um dos movimentos disponiveis e o utiliza.
        DataPokemonAttackClass resultOfAttack = new DataPokemonAttackClass();

        int damageInflicted;

        MoveBase selectedMovement;

        do {
            selectedMovement = PokemonUtils.selectRandomMove(this.getMovements());
        } while (selectedMovement.getRemainingUses() <= 0);
        selectedMovement.setRemainingUses((byte) (selectedMovement.getRemainingUses()-1));

        // 4.1 Retorno pro Log.
        resultOfAttack.pokemonAggressor = this.getPokemonName();
        resultOfAttack.pokemonAssaulted = target.getPokemonName();
        resultOfAttack.skillUsed = selectedMovement.toString();
        resultOfAttack.remainingUses = selectedMovement.getRemainingUses();
        resultOfAttack.healthPointsBeforeAttack = target.getHealthPoints();

        //  1. Verificar se o outro pókemon tem imunidade ou não
        if (target.pokemonStatus.getEffects().contains(StatusCondition.IMMUNITY)) {
            int index = target.pokemonStatus.getEffects().indexOf(StatusCondition.IMMUNITY);
            ArrayList<StatusCondition> effects = target.pokemonStatus.getEffects();
            ArrayList<Byte> times = target.pokemonStatus.getTime();

            // Descontar os usos de imunidade
            if ((times.get(index) - 1) <= 0) {
                effects.remove(index);
                times.remove(index);
            } else {
                times.set(index, (byte) (times.get(index) - 1));
            }

            resultOfAttack.hitLevel = Effectiveness.ERROU;
            resultOfAttack.inflictedDamage = 0;
            resultOfAttack.healthPointsAfterAttack = target.getHealthPoints();
            return resultOfAttack;
        }

        // 2. Se o ataque vai acertar ou não. vou usar essa lógica: destreza do inimigo / (destreza do inimigo + velocidade) * 100
        double enemyDeviateChance = ((double) target.getDexterityPoints() / (target.getDexterityPoints() + this.getSpeedPoints()) * 100);
        Random random = new Random();
        double myLuckToHit = random.nextDouble() * 100;

        if (enemyDeviateChance > myLuckToHit) {
            resultOfAttack.hitLevel = Effectiveness.ERROU;
            resultOfAttack.inflictedDamage = 0;
            resultOfAttack.healthPointsAfterAttack = target.getHealthPoints();
            return resultOfAttack;
        }

        // 3. Se o ataque vai ser critico ou não. vou usar essa lógica: (defesa do inimigo + destreza do inimigo) / (ataque + velocidade * 2) * 100
        double notCriticizeChance = ((double) (this.getDefensivePoints() + this.getDexterityPoints()) / (target.getAttackPoints() + target.getSpeedPoints() * 2) * 100);
        double myLuckToCriticize = random.nextDouble() * 100;

        if (notCriticizeChance > myLuckToCriticize) {
            // Cálculo do dano causado: (meu ataque + meu poder / 2) / defesa do inimigo
            // Tinha esquecido do dano da habilidade, vou mudar para: ((Meu ataque / defesa do inimigo) * Poder do Ataque)
            // damageInflicted = (this.getAttackPoints() * this.getSpecialPoints() / 2) / target.getDefensivePoints();

            damageInflicted = (int) ( ((float) this.getLevel() / target.getLevel()) * ((float) this.getAttackPoints() / target.getDefensivePoints()) * selectedMovement.getBaseDamage());
            resultOfAttack.hitLevel = Effectiveness.ACERTOU;
        } else {
            // Cálculo do dano crítico causado: (meu ataque + meu poder) / defesa do inimigo
            // Tinha esquecido do dano da habilidade, vou mudar para: ((Meu ataque + Meu Especial / defesa do inimigo) * Poder do Ataque)
            //damageInflicted = (this.getAttackPoints() * this.getSpecialPoints()) / target.getDefensivePoints();

            damageInflicted = (int) ( ((float) this.getLevel() / target.getLevel()) * (((float) this.getAttackPoints() + this.getSpecialPoints()) / target.getDefensivePoints()) * selectedMovement.getBaseDamage());
            resultOfAttack.hitLevel = Effectiveness.CRITICAL_HIT;
        }

        // 4.2 Retorno pro Log.
        resultOfAttack.inflictedDamage = damageInflicted;

        // 5. Atualizar a vida do inimigo.
        target.setHealthPoints((short) (target.getHealthPoints() - damageInflicted));

        // 4.3 Retorno pro Log.
        resultOfAttack.healthPointsAfterAttack = target.getHealthPoints();
        resultOfAttack.effectOnAttackToEnemy = selectedMovement.getMoveEffectOnEnemy();
        resultOfAttack.effectOnAttackToMe = selectedMovement.getMoveEffectOnMe();

        // 6. Efeitos Colaterais do Ataque:
        // Em mim, tenho que verificar se o efeito já existe.
        this.definePokemonStatus(this.getPokemonStatus(), selectedMovement.getMoveEffectOnMe(), selectedMovement.getTimeOfMoveEffectOnMe());

        // No Inimigo
        target.definePokemonStatus(target.getPokemonStatus(), selectedMovement.getMoveEffectOnEnemy(), selectedMovement.getTimeOfMoveEffectOnEnemy());

        return resultOfAttack;
    }

    // Funções Sobrepostas:
    public String toString() {
        MoveBase[] movements = getMovements();
        return String.format("%s #%03d\nHP: %d\nATK: %d | DEF: %d\nSPEED: %d\nDEXTERITY: %d\nSPECIAL: %d\nSTATUS: %s\nTYPE: %s/%s\nFIRST MOVE: %s\nSECOND MOVE: %s\nTHIRD MOVE: %s",
                getPokemonName(),
                getPokedexNumber(),
                getHealthPoints(),
                getAttackPoints(),
                getDefensivePoints(),
                getSpeedPoints(),
                getDexterityPoints(),
                getSpecialPoints(),
                getPokemonStatus(),
                getPrimaryType(),
                getSecondaryType(),
                movements[0],
                movements[1],
                movements[2]);
    }
}
