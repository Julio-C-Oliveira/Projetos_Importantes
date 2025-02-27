package pokemonSection.pokedex;

import pokemonSection.constants.StatusCondition;

import java.util.ArrayList;

public class PokemonStatus {
    private ArrayList<StatusCondition> effects;
    private ArrayList<Byte> times;

    public PokemonStatus() {
        this.effects = new ArrayList<StatusCondition>();
        this.times = new ArrayList<Byte>();
    }

    public ArrayList<StatusCondition> getEffects() {
        return effects;
    }

    public void setEffects(ArrayList<StatusCondition> effects) {
        this.effects = effects;
    }

    public ArrayList<Byte> getTime() {
        return times;
    }

    public void setTime(ArrayList<Byte> times) {
        this.times = times;
    }

    public void addStatus(StatusCondition effect, byte effectTime) {
        this.effects.add(effect);
        this.times.add(effectTime);
    }

    //public void castStatus(Pokemon pokemon) {
    //    // Adicionar a lógica de todas as condições aqui
    //}


    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String newString;

        if (!this.effects.isEmpty()) {
            for (int i = 0; i < this.effects.size(); i++) {
                stringBuilder.append(effects.get(i)).append("->").append(this.times.get(i)).append(" ");
            }
            newString = stringBuilder.toString();
        } else {
            newString = "NENHUM STATUS NO MOMENTO";
        }

        return newString;
    }
}
