/*
* Requisitos da Classe:
* [x] - Conter um atributo para o nome do Player.
* [x] - Conter um atributo para os pontos de vida (HP).
* [x] - Conter um atributo para o dano de ataque.
* [x] - Conter um atributo para defesa/resistência.
* [x] - Conter um atributo para destreza/precisão.
* [x] - Conter um atributo para velocidade.
* [] - Conter um método abstrato realizarAtaque() para obrigar as subclasses a implantar o método.
*
* Ideias para a Classe:
* [x] - Inserir limitação na quantia de caracteres.
* [] - Inserir limitação de caracteres válidos.
* */

package Characters;

abstract class Player {
    private char[] name = new char[22];
    private short[] healthPoints = new short[5];
    private short[] attackPoints = new short[3];
    private short[] defensivePoints = new short[2];
    private byte precision = 0;
    private byte speed = 0;

    public Player() {}

    public char[] getName() {
        return name;
    }
    public void setName(char[] name) {
        this.name = name;
    }

    public short[] getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(short[] healthPoints) {
        this.healthPoints = healthPoints;
    }

    public short[] getAttackPoints() {
        return attackPoints;
    }
    public void setAttackPoints(short[] attackPoints) {
        this.attackPoints = attackPoints;
    }

    public short[] getDefensivePoints() {
        return defensivePoints;
    }
    public void setDefensivePoints(short[] defensivePoints) {
        this.defensivePoints = defensivePoints;
    }

    public byte getPrecision() {
        return precision;
    }
    public void setPrecision(byte precision) {
        this.precision = precision;
    }

    public byte getSpeed() {
        return speed;
    }
    public void setSpeed(byte speed) {
        this.speed = speed;
    }

    abstract void realizar_ataque();
}
