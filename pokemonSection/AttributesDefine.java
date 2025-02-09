package pokemonSection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AttributesDefine {
    public AttributesDefine() {}

    public static Map<Type, AttributesWarehouse> takePokemonAttributes() {
        Map<Type, AttributesWarehouse> attributesDict = new HashMap<>();

        // Tipo NORMAL, os que ficarão no meio termo.
        attributesDict.put(Type.NORMAL, new AttributesWarehouse(
                (short) 450,
                (short) 250,
                (short) 230,
                (short) 170,
                (short) 300,
                (short) 200,
                (short) 200,
                (short) 150,
                (short) 300,
                (short) 200
        ));

        // Tipo FIRE, ataque alto e Special alto, vida baixa.
        attributesDict.put(Type.FIRE, new AttributesWarehouse(
                (short) 350,
                (short) 175,
                (short) 260,
                (short) 200,
                (short) 300,
                (short) 200,
                (short) 200,
                (short) 150,
                (short) 500,
                (short) 400
        ));

        // Tipo WATER, vida alta, e special alto.
        attributesDict.put(Type.WATER, new AttributesWarehouse(
                (short) 700,
                (short) 500,
                (short) 230,
                (short) 170,
                (short) 500,
                (short) 400,
                (short) 200,
                (short) 150,
                (short) 500,
                (short) 400
        ));

        /*
        attributesDict.put(Type., new AttributesWarehouse(
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short)
        ));

        attributesDict.put(Type., new AttributesWarehouse(
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short)
        ));

        attributesDict.put(Type., new AttributesWarehouse(
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short)
        ));

        attributesDict.put(Type., new AttributesWarehouse(
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short)
        ));

        attributesDict.put(Type., new AttributesWarehouse(
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short)
        ));

        attributesDict.put(Type., new AttributesWarehouse(
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short)
        ));

        attributesDict.put(Type., new AttributesWarehouse(
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short)
        ));

        attributesDict.put(Type., new AttributesWarehouse(
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short)
        ));

        attributesDict.put(Type., new AttributesWarehouse(
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short)
        ));

        attributesDict.put(Type., new AttributesWarehouse(
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short)
        ));

        attributesDict.put(Type., new AttributesWarehouse(
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short)
        ));

        attributesDict.put(Type., new AttributesWarehouse(
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short)
        ));

        attributesDict.put(Type., new AttributesWarehouse(
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short) ,
                (short)
        ));
        */

        return attributesDict;
    }
}