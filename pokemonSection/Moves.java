package pokemonSection;

public class Moves {
    private char[] moveName = new char[22]; // Nome do movimento.
    private short baseDamage; // Dano base do movimento.
    private byte remainingUses; // Número de vezes que a habilidade poderá ser utilizada.
    private Type moveType; // Tipo do movimento.

    public Moves(char[] moveName, short baseDamage, byte remainingUses, Type moveType) {
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
}
