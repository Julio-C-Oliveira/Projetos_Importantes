package pokemonSection.pokemonMoves;

import pokemonSection.StatusCondition;
import pokemonSection.Type;

public class MoveBase {
    private String moveName; // Nome do movimento.
    private short baseDamage; // Dano base do movimento.
    private byte remainingUses; // Número de vezes que a habilidade poderá ser utilizada.
    private Type moveType; // Tipo do movimento.
    private StatusCondition moveEffectOnEnemy;// Efeito do Ataque no Inimigo.
    private StatusCondition moveEffectOnMe; // Efeito do Ataque no próprio pokémon.
    // Adicionar o tempo do efeito.

    private MoveBase(String moveName, short baseDamage, byte remainingUses, Type moveType, StatusCondition moveEffectOnEnemy, StatusCondition moveEffectOnMe) {
        this.moveName = moveName;
        this.baseDamage = baseDamage;
        this.remainingUses = remainingUses;
        this.moveType = moveType;
        this.moveEffectOnEnemy = moveEffectOnEnemy;
        this.moveEffectOnMe = moveEffectOnMe;
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

    public StatusCondition getMoveEffectOnEnemy() {
        return moveEffectOnEnemy;
    }
    public void setMoveEffectOnEnemy(StatusCondition moveEffectOnEnemy) {
        this.moveEffectOnEnemy = moveEffectOnEnemy;
    }

    public StatusCondition getMoveEffectOnMe() {
        return moveEffectOnMe;
    }
    public void setMoveEffectOnMe(StatusCondition moveEffectOnMe) {
        this.moveEffectOnMe = moveEffectOnMe;
    }

    public static MoveBase createMove(String moveName, short baseDamage, byte remainingUses, Type moveType, StatusCondition moveEffectOnEnemy, StatusCondition moveEffectOnMe) {
        return new MoveBase(moveName, baseDamage, remainingUses, moveType, moveEffectOnEnemy, moveEffectOnMe);
    }
}
