package pokemonSection.attributes;

import pokemonSection.constants.StatusCondition;
import pokemonSection.constants.Type;

public class MoveBase {
    private String moveName; // Nome do movimento.
    private short baseDamage; // Dano base do movimento.
    private byte remainingUses; // Número de vezes que a habilidade poderá ser utilizada.
    private Type moveType; // Tipo do movimento.
    private StatusCondition moveEffectOnEnemy;// Efeito do Movimento no Inimigo.
    private byte timeOfMoveEffectOnEnemy; // Tempo do efeito do movimento no Inimigo.
    private StatusCondition moveEffectOnMe; // Efeito do Movimento no próprio pokémon.
    private byte timeOfMoveEffectOnMe; // Tempo do efeito do movimento em si mesmo.

    private MoveBase(String moveName, short baseDamage,
                     byte remainingUses, Type moveType,
                     StatusCondition moveEffectOnEnemy,
                     byte timeOfMoveEffectOnEnemy,
                     StatusCondition moveEffectOnMe,
                     byte timeOfMoveEffectOnMe) {

        this.moveName = moveName;
        this.baseDamage = baseDamage;
        this.remainingUses = remainingUses;
        this.moveType = moveType;
        this.moveEffectOnEnemy = moveEffectOnEnemy;
        this.timeOfMoveEffectOnEnemy = timeOfMoveEffectOnEnemy;
        this.moveEffectOnMe = moveEffectOnMe;
        this.timeOfMoveEffectOnMe = timeOfMoveEffectOnMe;
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

    public byte getTimeOfMoveEffectOnEnemy() {
        return timeOfMoveEffectOnEnemy;
    }
    public void setTimeOfMoveEffectOnEnemy(byte timeOfMoveEffectOnEnemy) {
        this.timeOfMoveEffectOnEnemy = timeOfMoveEffectOnEnemy;
    }

    public StatusCondition getMoveEffectOnMe() {
        return moveEffectOnMe;
    }
    public void setMoveEffectOnMe(StatusCondition moveEffectOnMe) {
        this.moveEffectOnMe = moveEffectOnMe;
    }

    public byte getTimeOfMoveEffectOnMe() {
        return timeOfMoveEffectOnMe;
    }
    public void setTimeOfMoveEffectOnMe(byte timeOfMoveEffectOnMe) {
        this.timeOfMoveEffectOnMe = timeOfMoveEffectOnMe;
    }

    public static MoveBase createMove(String moveName, short baseDamage,
                                      byte remainingUses, Type moveType,
                                      StatusCondition moveEffectOnEnemy,
                                      byte timeOfMoveEffectOnEnemy,
                                      StatusCondition moveEffectOnMe, byte timeOfMoveEffectOnMe) {

        return new MoveBase(moveName, baseDamage, remainingUses, moveType, moveEffectOnEnemy, timeOfMoveEffectOnEnemy, moveEffectOnMe, timeOfMoveEffectOnMe);
    }

    public String toString() {
        return String.format("%s", getMoveName().toUpperCase());
    }
}
