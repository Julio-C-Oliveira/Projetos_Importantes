package pokemonSection.attributes;

public class AttributesWarehouse {
    public short maxHealthPoints;
    public short minHealthPoints;
    public short maxAttackPoints;
    public short minAttackPoints;
    public short maxDefensivePoints;
    public short minDefensivePoints;
    public short maxSpeedPoints;
    public short minSpeedPoints;
    public short maxDexterityPoints;
    public short minDexterityPoints;
    public short maxSpecialPoints;
    public short minSpecialPoints;

    public AttributesWarehouse(short maxHealthPoints, short minHealthPoints, short maxAttackPoints, short minAttackPoints, short maxDefensivePoints, short minDefensivePoints, short maxSpeedPoints, short minSpeedPoints, short maxDexterityPoints, short minDexterityPoints, short maxSpecialPoints, short minSpecialPoints) {
        this.maxHealthPoints = maxHealthPoints;
        this.minHealthPoints = minHealthPoints;
        this.maxAttackPoints = maxAttackPoints;
        this.minAttackPoints = minAttackPoints;
        this.maxDefensivePoints = maxDefensivePoints;
        this.minDefensivePoints = minDefensivePoints;
        this.maxSpeedPoints = maxSpeedPoints;
        this.minSpeedPoints = minSpeedPoints;
        this.maxDexterityPoints = maxDexterityPoints;
        this.minDexterityPoints = minDexterityPoints;
        this.maxSpecialPoints = maxSpecialPoints;
        this.minSpecialPoints = minSpecialPoints;
    }
}
