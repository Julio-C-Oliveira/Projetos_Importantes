package pokemonSection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AttributesDefine {
    public AttributesDefine() {}

    public static Map<Type, AttributesWarehouse> takePokemonAttributes() {
        Map<Type, AttributesWarehouse> attributesDict = new HashMap<>();

        // Tipo NENHUM, os que ficarão no meio termo.
        attributesDict.put(Type.NORMAL, new AttributesWarehouse(
                (short) 450, // Máximo de vida.
                (short) 250, // Mínimo de vida.
                (short) 230, // Máximo de ataque.
                (short) 170, // Mínimo de ataque.
                (short) 300, // Máximo de defesa.
                (short) 200, // Mínimo de defesa.
                (short) 200, // Máximo de velocidade.
                (short) 150, // Mínimo de velocidade.
                (short) 200, // Máximo de destreza.
                (short) 150, // Mínimo de destreza.
                (short) 300, // Máximo de special.
                (short) 200  // Mínimo de special.
        ));

        // Tipo FIRE, ataque alto e Special alto, vida baixa.
        attributesDict.put(Type.FIRE, new AttributesWarehouse(
                (short) 350, // Máximo de vida.
                (short) 175, // Mínimo de vida.
                (short) 260, // Máximo de ataque.
                (short) 200, // Mínimo de ataque.
                (short) 300, // Máximo de defesa.
                (short) 200, // Mínimo de defesa.
                (short) 200, // Máximo de velocidade.
                (short) 150, // Mínimo de velocidade.
                (short) 200, // Máximo de destreza.
                (short) 150, // Mínimo de destreza.
                (short) 500, // Máximo de special.
                (short) 400
        ));

        // Tipo WATER, vida alta, e special alto.
        attributesDict.put(Type.WATER, new AttributesWarehouse(
                (short) 700, // Máximo de vida.
                (short) 500, // Mínimo de vida.
                (short) 230, // Máximo de ataque.
                (short) 170, // Mínimo de ataque.
                (short) 500, // Máximo de defesa.
                (short) 400, // Mínimo de defesa.
                (short) 200, // Máximo de velocidade.
                (short) 150, // Mínimo de velocidade.
                (short) 200, // Máximo de destreza.
                (short) 150, // Mínimo de destreza.
                (short) 500, // Máximo de special.
                (short) 400  // Mínimo de special.
        ));

        // Os que estão abaixo possuem estatisticas genericas só para não retornarem erro.
        attributesDict.put(Type.GRASS, new AttributesWarehouse(
                (short) 450, // Máximo de vida.
                (short) 250, // Mínimo de vida.
                (short) 230, // Máximo de ataque.
                (short) 170, // Mínimo de ataque.
                (short) 300, // Máximo de defesa.
                (short) 200, // Mínimo de defesa.
                (short) 200, // Máximo de velocidade.
                (short) 150, // Mínimo de velocidade.
                (short) 200, // Máximo de destreza.
                (short) 150, // Mínimo de destreza.
                (short) 300, // Máximo de special.
                (short) 200  // Mínimo de special.
        ));

        attributesDict.put(Type.ELETRIC, new AttributesWarehouse(
                (short) 450, // Máximo de vida.
                (short) 250, // Mínimo de vida.
                (short) 230, // Máximo de ataque.
                (short) 170, // Mínimo de ataque.
                (short) 300, // Máximo de defesa.
                (short) 200, // Mínimo de defesa.
                (short) 200, // Máximo de velocidade.
                (short) 150, // Mínimo de velocidade.
                (short) 200, // Máximo de destreza.
                (short) 150, // Mínimo de destreza.
                (short) 300, // Máximo de special.
                (short) 200  // Mínimo de special.
        ));

        attributesDict.put(Type.ICE, new AttributesWarehouse(
                (short) 450, // Máximo de vida.
                (short) 250, // Mínimo de vida.
                (short) 230, // Máximo de ataque.
                (short) 170, // Mínimo de ataque.
                (short) 300, // Máximo de defesa.
                (short) 200, // Mínimo de defesa.
                (short) 200, // Máximo de velocidade.
                (short) 150, // Mínimo de velocidade.
                (short) 200, // Máximo de destreza.
                (short) 150, // Mínimo de destreza.
                (short) 300, // Máximo de special.
                (short) 200  // Mínimo de special.
        ));

        attributesDict.put(Type.FIGHTING, new AttributesWarehouse(
                (short) 450, // Máximo de vida.
                (short) 250, // Mínimo de vida.
                (short) 230, // Máximo de ataque.
                (short) 170, // Mínimo de ataque.
                (short) 300, // Máximo de defesa.
                (short) 200, // Mínimo de defesa.
                (short) 200, // Máximo de velocidade.
                (short) 150, // Mínimo de velocidade.
                (short) 200, // Máximo de destreza.
                (short) 150, // Mínimo de destreza.
                (short) 300, // Máximo de special.
                (short) 200  // Mínimo de special.
        ));

        attributesDict.put(Type.POISON, new AttributesWarehouse(
                (short) 450, // Máximo de vida.
                (short) 250, // Mínimo de vida.
                (short) 230, // Máximo de ataque.
                (short) 170, // Mínimo de ataque.
                (short) 300, // Máximo de defesa.
                (short) 200, // Mínimo de defesa.
                (short) 200, // Máximo de velocidade.
                (short) 150, // Mínimo de velocidade.
                (short) 200, // Máximo de destreza.
                (short) 150, // Mínimo de destreza.
                (short) 300, // Máximo de special.
                (short) 200  // Mínimo de special.
        ));

        attributesDict.put(Type.GROUND, new AttributesWarehouse(
                (short) 450, // Máximo de vida.
                (short) 250, // Mínimo de vida.
                (short) 230, // Máximo de ataque.
                (short) 170, // Mínimo de ataque.
                (short) 300, // Máximo de defesa.
                (short) 200, // Mínimo de defesa.
                (short) 200, // Máximo de velocidade.
                (short) 150, // Mínimo de velocidade.
                (short) 200, // Máximo de destreza.
                (short) 150, // Mínimo de destreza.
                (short) 300, // Máximo de special.
                (short) 200  // Mínimo de special.
        ));

        attributesDict.put(Type.FLYING, new AttributesWarehouse(
                (short) 450, // Máximo de vida.
                (short) 250, // Mínimo de vida.
                (short) 230, // Máximo de ataque.
                (short) 170, // Mínimo de ataque.
                (short) 300, // Máximo de defesa.
                (short) 200, // Mínimo de defesa.
                (short) 200, // Máximo de velocidade.
                (short) 150, // Mínimo de velocidade.
                (short) 200, // Máximo de destreza.
                (short) 150, // Mínimo de destreza.
                (short) 300, // Máximo de special.
                (short) 200  // Mínimo de special.
        ));

        attributesDict.put(Type.PSYCHIC, new AttributesWarehouse(
                (short) 450, // Máximo de vida.
                (short) 250, // Mínimo de vida.
                (short) 230, // Máximo de ataque.
                (short) 170, // Mínimo de ataque.
                (short) 300, // Máximo de defesa.
                (short) 200, // Mínimo de defesa.
                (short) 200, // Máximo de velocidade.
                (short) 150, // Mínimo de velocidade.
                (short) 200, // Máximo de destreza.
                (short) 150, // Mínimo de destreza.
                (short) 300, // Máximo de special.
                (short) 200  // Mínimo de special.
        ));

        attributesDict.put(Type.BUG, new AttributesWarehouse(
                (short) 450, // Máximo de vida.
                (short) 250, // Mínimo de vida.
                (short) 230, // Máximo de ataque.
                (short) 170, // Mínimo de ataque.
                (short) 300, // Máximo de defesa.
                (short) 200, // Mínimo de defesa.
                (short) 200, // Máximo de velocidade.
                (short) 150, // Mínimo de velocidade.
                (short) 200, // Máximo de destreza.
                (short) 150, // Mínimo de destreza.
                (short) 300, // Máximo de special.
                (short) 200  // Mínimo de special.
        ));

        attributesDict.put(Type.ROCK, new AttributesWarehouse(
                (short) 450, // Máximo de vida.
                (short) 250, // Mínimo de vida.
                (short) 230, // Máximo de ataque.
                (short) 170, // Mínimo de ataque.
                (short) 300, // Máximo de defesa.
                (short) 200, // Mínimo de defesa.
                (short) 200, // Máximo de velocidade.
                (short) 150, // Mínimo de velocidade.
                (short) 200, // Máximo de destreza.
                (short) 150, // Mínimo de destreza.
                (short) 300, // Máximo de special.
                (short) 200  // Mínimo de special.
        ));

        attributesDict.put(Type.GHOST, new AttributesWarehouse(
                (short) 450, // Máximo de vida.
                (short) 250, // Mínimo de vida.
                (short) 230, // Máximo de ataque.
                (short) 170, // Mínimo de ataque.
                (short) 300, // Máximo de defesa.
                (short) 200, // Mínimo de defesa.
                (short) 200, // Máximo de velocidade.
                (short) 150, // Mínimo de velocidade.
                (short) 200, // Máximo de destreza.
                (short) 150, // Mínimo de destreza.
                (short) 300, // Máximo de special.
                (short) 200  // Mínimo de special.
        ));

        attributesDict.put(Type.DRAGON, new AttributesWarehouse(
                (short) 450, // Máximo de vida.
                (short) 250, // Mínimo de vida.
                (short) 230, // Máximo de ataque.
                (short) 170, // Mínimo de ataque.
                (short) 300, // Máximo de defesa.
                (short) 200, // Mínimo de defesa.
                (short) 200, // Máximo de velocidade.
                (short) 150, // Mínimo de velocidade.
                (short) 200, // Máximo de destreza.
                (short) 150, // Mínimo de destreza.
                (short) 300, // Máximo de special.
                (short) 200  // Mínimo de special.
        ));

        attributesDict.put(Type.DARK, new AttributesWarehouse(
                (short) 450, // Máximo de vida.
                (short) 250, // Mínimo de vida.
                (short) 230, // Máximo de ataque.
                (short) 170, // Mínimo de ataque.
                (short) 300, // Máximo de defesa.
                (short) 200, // Mínimo de defesa.
                (short) 200, // Máximo de velocidade.
                (short) 150, // Mínimo de velocidade.
                (short) 200, // Máximo de destreza.
                (short) 150, // Mínimo de destreza.
                (short) 300, // Máximo de special.
                (short) 200  // Mínimo de special.
        ));

        attributesDict.put(Type.STEEL, new AttributesWarehouse(
                (short) 450, // Máximo de vida.
                (short) 250, // Mínimo de vida.
                (short) 230, // Máximo de ataque.
                (short) 170, // Mínimo de ataque.
                (short) 300, // Máximo de defesa.
                (short) 200, // Mínimo de defesa.
                (short) 200, // Máximo de velocidade.
                (short) 150, // Mínimo de velocidade.
                (short) 200, // Máximo de destreza.
                (short) 150, // Mínimo de destreza.
                (short) 300, // Máximo de special.
                (short) 200  // Mínimo de special.
        ));

        return attributesDict;
    }
}