package pokemonSection.pokemonMoves;

import pokemonSection.StatusCondition;
import pokemonSection.Type;

public class MoveBase {
    private String moveName; // Nome do movimento.
    private short baseDamage; // Dano base do movimento.
    private byte remainingUses; // Número de vezes que a habilidade poderá ser utilizada.
    private Type moveType; // Tipo do movimento.
    private StatusCondition attackEffect; // Efeito do Ataque.
    // Adicionar o tempo do efeito.

    private MoveBase(String moveName, short baseDamage, byte remainingUses, Type moveType, StatusCondition attackEffect) {
        this.moveName = moveName;
        this.baseDamage = baseDamage;
        this.remainingUses = remainingUses;
        this.moveType = moveType;
        this.attackEffect = attackEffect;
    }

    public String getMoveName() {
        return moveName;
    }
    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }

    public short getBaseDamage() {
        return baseDamage;
    }
    public void setBaseDamage(short baseDamage) {
        this.baseDamage = baseDamage;
    }

    public byte getRemainingUses() {
        return remainingUses;
    }
    public void setRemainingUses(byte remainingUses) {
        this.remainingUses = remainingUses;
    }

    public Type getMoveType() {
        return moveType;
    }
    public void setMoveType(Type moveType) {
        this.moveType = moveType;
    }

    public StatusCondition getAttackEffect() {
        return attackEffect;
    }
    public void setAttackEffect(StatusCondition attackEffect) {
        this.attackEffect = attackEffect;
    }

    public static MoveBase createMove(String moveName, short baseDamage, byte remainingUses, Type moveType, StatusCondition attackEffect) {
        return new MoveBase(moveName, baseDamage, remainingUses, moveType, attackEffect);
    }
}
