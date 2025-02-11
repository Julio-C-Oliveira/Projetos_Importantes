package pokemonSection.pokedex;

import pokemonSection.constants.Effectiveness;
import pokemonSection.constants.StatusCondition;

public class DataPokemonAttackClass {
    public Effectiveness hitLevel = null;
    public String skillUsed = null;
    public Byte remainingUses = null;
    public Integer inflictedDamage = null;
    public Short healthPointsBeforeAttack = null;
    public Short healthPointsAfterAttack = null;
    public StatusCondition effectOnAttackToEnemy = null;
    public StatusCondition effectOnAttackToMe = null;
}
