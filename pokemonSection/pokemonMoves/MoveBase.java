package pokemonSection.pokemonMoves;

import pokemonSection.Type;

public class MoveBase {
    private char[] moveName; // Nome do movimento.
    private short baseDamage; // Dano base do movimento.
    private byte remainingUses; // Número de vezes que a habilidade poderá ser utilizada.
    private Type moveType; // Tipo do movimento.

    private MoveBase(char[] moveName, short baseDamage, byte remainingUses, Type moveType) {
        this.moveName = moveName;
        this.baseDamage = baseDamage;
        this.remainingUses = remainingUses;
        this.moveType = moveType;
    }

    public char[] getMoveName() {
        return moveName;
    }
    public void setMoveName(char[] moveName) {
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


    public static MoveBase createMove(char[] moveName, short baseDamage, byte remainingUses, Type moveType) {
        return new MoveBase(moveName, baseDamage, remainingUses, moveType);
    }
}
