package logSection;

import pokemonSection.attributes.PokemonAttributes;


public class AttributeLog extends Log {
    public AttributeLog() {
        super();
    }

    public void recordCurrentBestAttributes(int turn){
        appendLog(String.format("## Pokémons com os melhores atributos em Campo no turno %d:", turn));
        appendLog(PokemonAttributes.pokemonBestAttributesInString());
    }
    
}

